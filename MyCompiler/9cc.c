#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <stdarg.h>
#include <stdbool.h>
#include <string.h>

typedef enum{
	TK_RESERVED,
	TK_NUM,
	TK_EOF,
} TokenKind;
typedef enum{
	ND_ADD,
	ND_SUB,
	ND_MUL,
	ND_DIV,
	ND_NUM, 
} Nodekind;

typedef struct Token Token;
typedef struct Node Node;

struct Token{
	TokenKind kind;
	Token *next;
	int val;
	char *str;
};
struct Node{
	Nodekind kind;
	Node *lhs;
	Node *rhs;
	int val;
};

char *user_input;
Token *token;
FILE *fp;

Node *new_node(Nodekind kind, Node *lhs, Node *rhs);
Node *new_node_num(int val);
bool consume(char op);
Node *expr();
Node *mul();
Node *primary();
void gen(Node *node);
void error(char *fmt, ...);
void error_at(char *loc, char *fmt, ...);
void expect(char op);
int expect_number();
bool at_eof();
Token *new_token(TokenKind kind, Token *cur, char *str);
Token *tokenize();

Node *new_node(Nodekind kind, Node *lhs, Node *rhs){
	Node *node = calloc(1, sizeof(Node));
	node->kind = kind;
	node->lhs = lhs;
	node->rhs = rhs;
	return node;
}

Node *new_node_num(int val){
	Node *node = calloc(1, sizeof(Node));
	node->kind = ND_NUM;
	node->val = val;
	return node;
}

bool consume(char op){
	if(token->kind != TK_RESERVED || token->str[0] != op) return false;
	token = token->next;
	return true;
}

Node *expr(){
	Node *node = mul();
	for(;;){
		if(consume('+')) node=new_node(ND_ADD, node, mul());
		else if(consume('-')) node=new_node(ND_SUB, node, mul());
		else return node;
	}
}

Node *mul(){
	Node *node = primary();
	for(;;){
		if(consume('*')) node=new_node(ND_MUL, node, primary());
		else if(consume('/')) node=new_node(ND_DIV, node, primary());
		else return node;
	}
}

Node *primary() {
	if(consume('(')){
		Node *node=expr();
		expect(')');
		return node;
	}
	return new_node_num(expect_number());
}

void gen(Node *node){
	if(node->kind == ND_NUM){
		fprintf(fp, " push %d\n", node->val);
		return;
	}
		gen(node->lhs);
		gen(node->rhs);
		fprintf(fp, " pop rdi\n");
		fprintf(fp, " pop rax\n");
		switch(node->kind){
			case ND_ADD:
				fprintf(fp, " add rax, rdi\n");
				break;
			case ND_SUB:
				fprintf(fp, " sub rax, rdi\n");
				break;
			case ND_MUL:
				fprintf(fp, " imul rax, rdi\n");
				break;
			case ND_DIV:
				fprintf(fp, " cqo\n");
				fprintf(fp, " idiv rdi\n");
				break;
		}
		fprintf(fp, " push rax\n");
}

void error(char *fmt, ...){
	va_list ap;
	va_start(ap, fmt);
	vfprintf(stderr, fmt, ap);
	fprintf(stderr, "\n");
	exit(1);
}

void error_at(char *loc, char *fmt, ...){
	va_list ap;
	va_start(ap, fmt);

	int pos = loc - user_input;
	fprintf(stderr, "%s\n", user_input);
	fprintf(stderr, "%*s", pos, "");
	fprintf(stderr, "^ ");
	vfprintf(stderr, fmt, ap);
	fprintf(stderr, "\n");
	exit(1);
}

void expect(char op){
	if(token->kind != TK_RESERVED || token->str[0] != op) 
		error_at(token->str, "expected '%c'", op);
	token = token->next;
}

int expect_number() {
	if(token->kind != TK_NUM) 
		error_at(token->str, "expected a number");
	int val = token->val;
	token = token->next;
	return val;
}

bool at_eof() {
	return token->kind == TK_EOF;
}

Token *new_token(TokenKind kind, Token *cur, char *str){
	Token *tok = calloc(1, sizeof(Token));
	tok->kind = kind;
	tok->str = str;
	cur->next = tok;
	return tok;
}

Token *tokenize(){
	char *p = user_input;
	Token head;
	head.next = NULL;
	Token *cur =  &head;
	
	while(*p){
		if(isspace(*p)){
			p++;
			continue;
		}

		if(strchr("+-*/()", *p)){
			cur = new_token(TK_RESERVED, cur, p++);
			continue;
		}

		if(isdigit(*p)){
			cur = new_token(TK_NUM, cur, p);
			cur->val = strtol(p, &p, 10);
			continue;
		}

		error_at(p, "invalid token");
	}

	new_token(TK_EOF, cur, p);
	return head.next;

}
int main(int argc, char **argv) {
	if(argc != 3) fprintf(stderr, "Error:Need correct number of argv\n");
	user_input = argv[1];
	token = tokenize();
	Node *node = expr();

       	fp = fopen(argv[2], "w");	

	fprintf(fp, ".intel_syntax noprefix\n");
	fprintf(fp, ".globl main\n");
	fprintf(fp, "main:\n");

	gen(node);
	
	fprintf(fp, " pop rax\n");
	fprintf(fp, " ret\n");
	fclose(fp);
	return 0;
}
