import java.util.Scanner;
public class Main{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int h = scan.nextInt();
		int w = scan.nextInt();
		int n = scan.nextInt();
		int[][] col = new int[n][2];
		int[][] row = new int[n][2];
		for(int i=0; i<n; i++){
			col[i][0]=scan.nextInt();
			col[i][1]=i;
			row[i][0]=scan.nextInt();
			row[i][1]=i;
		}
		quick(col, 0, col.length-1, 0);
		quick(row, 0, row.length-1, 0);
		for(int i=0; i<n; i++){
			col[i][0]=i+1;
			row[i][0]=i+1;
		}
		quick(col, 0, col.length-1, 1);
		quick(row, 0, row.length-1, 1);
		for(int i=0; i<n; i++){
			System.out.println(col[i][0]+" "+row[i][0]);
		}
	}
	private static void quick(int[][] arr, int left, int right, int index){
		if(left<right){
			int p = part(arr, left, right, index);
			quick(arr, left, p-1, index);
			quick(arr, p+1, right, index);
		}
	}
	private static int part(int[][] arr, int left, int right, int index){
		int tmp, k=(left+right)/2;
		swap(arr, k, right);
		int i=left, j=right-1;
		while(i<=j){
			while(arr[i][index]<arr[right][index]){i++;}
			while(j>=i && arr[j][index]>=arr[right][index]){j--;}
			if(i<j){
				swap(arr, i, j);
			}
		}
		swap(arr, i, right);
		return i;
	}
	private static void swap(int[][] arr, int a, int b){
		int tmp;
		for(int i=0; i<arr[0].length; i++){
			tmp = arr[a][i];
			arr[a][i] = arr[b][i];
			arr[b][i] = tmp;
		}
	}
}
