#include <stdio.h>
#include <stdlib.h>

int main(int argc, char **argv) {
	if(argc != 3) {
		fprintf(stderr, "引数の個数が正しくありません\n");
		return 1;
	}
	FILE *fp;
       	fp = fopen(argv[2], "w");	
	fprintf(fp, ".intel_syntax noprefix\n");
	fprintf(fp, ".globl main\n");
	fprintf(fp, "main:\n");
	fprintf(fp, "  mov rax, %d\n", atoi(argv[1]));
	fprintf(fp, "  ret\n");
	fclose(fp);
	return 0;
}
