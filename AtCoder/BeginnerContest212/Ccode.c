#include <stdio.h>
void swap(int *a, int b, int c){
	int tmp = a[b]; a[b] = a[c]; a[c] = tmp;
}
int part(int *a, int left, int right){
	int tmp, k = (left+right)/2;
	swap(a, k, right);
	int i=left, j=right-1;
	while(i<=j){
		while(a[i]<a[right]){i++;}
		while(j>=i && a[j]>=a[right]){j--;}
		if(i<j){swap(a, i, j);}
	}
	swap(a, i, right);
	return i;
}
void quicksort(int *a, int left, int right){
	if(left<right){
		int p=part(a, left, right);
		quicksort(a, left, p-1);
		quicksort(a, p+1, right);
	}
}
int main(void){
	int N, M;
	int max = 200000;
	if(scanf("%d", &N)==EOF){
		N=max;
	}
	if(scanf("%d", &M)==EOF){
		M=max;
	}
	int A[N];
	int B[M];
	int i, j;
	for(i=0; i<N; i++){
		if(scanf("%d", &A[i])==EOF){break;}
	}
	for(i=0; i<M; i++){
		if(scanf("%d", &B[i])==EOF){break;}
	}
	quicksort(A, 0, N-1);
	quicksort(B, 0, M-1);
	int min=100000000;
	i=0; j=0;
	while(i<N && j<M){
		if(A[i]>B[j]){
			if(min>A[i]-B[j]){
				min=A[i]-B[j];
			}
			j++;
		}else if(A[i]<B[j]){
			if(min>B[j]-A[i]){
				min=B[j]-A[i];
			}
			i++;
		} else{min=0; break;}
	}
	printf("%d", min);
	return 0;
}
