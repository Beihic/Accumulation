import java.util.Scanner;
public class Main{
	static int k, n, count = 0;
	static int[][] path;
	static int[] A;
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		int m = scan.nextInt();
		k = scan.nextInt();
		path = new int[n+1][n+1];
		A = new int[k+1];
		A[0] = A[k] = 1;
		for(int i=0; i<m; i++){
			int u = scan.nextInt();
			int v = scan.nextInt();
			path[u][v] = path[v][u] = 1;
		}
		search(1);
		System.out.println(count);
	}
	private static void search(int today){
		if(today>=k){
			if(path[A[today]][1]==0 && A[today]!=1){
				count++;
			}
		} else if(today<0){
		} else {
			for(int i=1; i<n+1; i++){
				if(path[A[today]][i]==0 && A[today]!= i){
					A[today+1]=i;
					search(today+1);
				}
			}
		}
	}
}
