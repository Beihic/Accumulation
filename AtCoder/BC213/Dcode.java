import java.util.Scanner;
public class Dcode{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[][] path = new int[n+1][n+1];
		int[] root = new int[n+1];
		int[] cityVisited = new int[n+1];
		int a, b;
		for(int i=0; i<path.length; i++){
			a=scan.nextInt();
			b=scan.nextInt();
			path[a][b]=1;
			path[b][a]=1;
		}
		int index = 0;
		root[index]=1;
		do{
			for(int i=1; i<n; i++){
				if(path[root[index]][i]==1){
					root[++index]=i;
				}
			}
		}while(root[here]==1)
	}
}
