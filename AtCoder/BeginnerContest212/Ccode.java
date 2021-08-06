import java.util.Scanner;
public class Main{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int M = scan.nextInt();
		int[] A = new int[N];
		int[] B = new int[M];
		for(int i=0; i<N; i++){
			A[i]=scan.nextInt();
		}
		for(int i=0; i<M; i++){
			B[i]=scan.nextInt();
		}
		quicksort(A, 0, N-1);
		quicksort(B, 0, M-1);
		int min=Integer.MAX_VALUE; 
		int i=0, j=0;
		while(i<N && j<M){
			if(A[i]>B[j]){
				if(min>A[i]-B[j]){
					min=A[i]-B[j];
				}
				j++;
			}else {
				if(min>B[j]-A[i]){
					min=B[j]-A[i];
				}
				i++;
			}
		}
		System.out.println(min);
	}
	private static int part(int[] a, int left, int right){
		int tmp, k = (left+right)/2;
		swap(a, k, right);
		int i=left, j=right-1;
		while(i<=j){
			while(a[i]<a[right]){i++;}
			while(j>=i && a[j]>=a[right]){j--;}
			if(i<j){
				swap(a, i, j);
			}
		}
		swap(a, i, right);
		return i;
	}
	private static void quicksort(int[] a, int left, int right){
		if(left<right){
			int p = part(a, left, right);
			quicksort(a, left, p-1);
			quicksort(a, p+1, right);
		}
	}
	private static void swap(int[] a, int b, int c){
		int tmp = a[b]; a[b] = a[c]; a[c] = tmp;
	}
}
