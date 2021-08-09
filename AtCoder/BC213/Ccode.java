import java.util.Scanner;
public class Main{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int h = scan.nextInt();
		int w = scan.nextInt();
		int n = scan.nextInt();
		int[] col = new int[n];
		int[] row = new int[n];
		int[] a = new int[n];
		int[] b = new int[n];
		for(int i=0; i<n; i++){
			col[i]=scan.nextInt();
			a[i] = col[i];
			row[i]=scan.nextInt();
			b[i] = row[i];
		}
		quick(a, 0, a.length-1);
		quick(b, 0, b.length-1);
		for(int i=0; i<n; i++){
			System.out.println((search(a, col[i])+1)+" "+(search(b, row[i])+1));
		}
	}
	private static int search(int[] d, int x){
		int left=0, right=d.length-1, mid=(left+right)/2;
		while(left<right){
			if(d[mid]==x){
				return mid;
			} else if(d[mid]<x){
				left=mid+1;
			} else {
				right=mid-1;
			}
			mid=(left+right)/2;
		}
		if(d[mid]==x){
			return mid;
		}else {
			return -1;
		}
	}
	private static void quick(int[] arr, int left, int right){
		if(left<right){
			int p = part(arr, left, right);
			quick(arr, left, p-1);
			quick(arr, p+1, right);
		}
	}
	private static int part(int[] arr, int left, int right){
		int tmp, k=(left+right)/2;
		swap(arr, k, right);
		int i=left, j=right-1;
		while(i<=j){
			while(arr[i]<arr[right]){i++;}
			while(j>=i && arr[j]>=arr[right]){j--;}
			if(i<j){
				swap(arr, i, j);
			}
		}
		swap(arr, i, right);
		return i;
	}
	private static void swap(int[] arr, int a, int b){
		int tmp = arr[a]; arr[a] = arr[b]; arr[b] = tmp;
	}
}
