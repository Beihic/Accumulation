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

typedef struct Token Token;

struct Token{
	TokenKind kind;
	Token *next;
	int val;
	char *str;
};

Token *token;

void error(char *fmt, ...){
	va_list ap;
	va_start(ap, fmt);
	vfprintf(stderr, fmt, ap);
	fprintf(stderr, "\n");
	exit(1);
}

bool consume(char op){
	if(token->kind != TK_RESERVED || token->str[0] != op) return false;
	token = token->next;
	return true;
}

void expect(char op){
	if(token->kind != TK_RESERVED || token->str[0] != op) error("This is not '%c'", op);
	token = token->next;
}

int expect_number() {
	if(token->kind != TK_NUM) error("Not number");
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

Token *tokenize(char *p){
	Token head;
	head.next = NULL;
	Token *cur =  &head;
	
	while(*p){
		if(isspace(*p)){
			p++;
			continue;
		}

		if(*p == '+' || *p == '-'){
			cur = new_token(TK_RESERVED, cur, p++);
			continue;
		}

		if(isdigit(*p)){
			cur = new_token(TK_NUM, cur, p);
			cur->val = strtol(p, &p, 10);
			continue;
		}

		error("Do not be able to tokenize");
	}

	new_token(TK_EOF, cur, p);
	return head.next;

}
int main(int argc, char **argv) {
	if(argc != 3) {
		fprintf(stderr, "Error:Need correct number of argv\n");
		return 1;
	}
	token = tokenize(argv[1]);

	FILE *fp;
       	fp = fopen(argv[2], "w");	

	fprintf(fp, ".intel_syntax noprefix\n");
	fprintf(fp, ".globl main\n");
	fprintf(fp, "main:\n");
	fprintf(fp, "	mov rax, %d\n", expect_number());

	while (!at_eof()){
		if(consume('+')){
			fprintf(fp, "	add rax, %d\n", expect_number());
			continue;
		}

		expect('-');	
		fprintf(fp, "	sub rax, %d\n", expect_number());
	}
	fprintf(fp, "  ret\n");
	fclose(fp);
	return 0;
}
