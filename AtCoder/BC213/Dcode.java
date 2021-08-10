import java.util.Scanner;
public class Dcode{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[][] path = new int[n][2];
		int[] root = new int[n+1];
		root[0]=1;
		int a, b;
		for(int i=0; i<path.length; i++){
			a=scan.nextInt();
			b=scan.nextInt();
			if(a>b){
				path[i][0]=a;
				path[i][1]=b;
			}else{
				path[i][0]=b;
				path[i][1]=a;
			}
		}
	}
}
