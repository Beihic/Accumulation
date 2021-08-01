#include <stdio.h>
#include <stdlib.h>

int main(int argc, char **argv) {
	if(argc != 3) {
		fprintf(stderr, "Error:Need correct number of argv\n");
		return 1;
	}
	char *p = argv[1];
	FILE *fp;

       	fp = fopen(argv[2], "w");	
	fprintf(fp, ".intel_syntax noprefix\n");
	fprintf(fp, ".globl main\n");
	fprintf(fp, "main:\n");
	fprintf(fp, "	mov rax, %ld\n", strtol(p, &p, 10));

	while (*p){
		if(*p == '+'){
			p++;
			fprintf(fp, "	add rax, %ld\n", strtol(p, &p, 10));
			continue;
		}

		if(*p == '-'){
			p++;
			fprintf(fp, "	sub rax, %ld\n", strtol(p, &p, 10));
			continue;
		}

		fprintf(stderr, "Not expected Character '%c'\n", *p);
		return 1;
	}
	fprintf(fp, "  ret\n");
	fclose(fp);
	return 0;
}
