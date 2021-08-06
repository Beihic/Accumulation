import java.util.Scanner;
public class Ecode{
	static int n, m, k, count=0;
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		m = scan.nextInt();
		k = scan.nextInt();
		int[][] path = new int[n+1][n+1];
		int[] A = new int[k+1];
		A[0] = A[k] =1;
		for(int i=0; i<m; i++){
			path[scan.nextInt()][scan.nextInt()]=1;
		}
		search(path, 0, A);
		System.out.println(count);
	}
	private static void search(int[][] path, int day, int[] A){
		if(day>=k-1){
			if(A[day]!=1 && path[A[day]][1]!=1){
				count++;
				System.out.println("count!");
			}
			return;
		} else {
			for(int i=1; i<n; i++){
				if(A[day]==i){ 
					continue;
				}else if(path[A[day]][i]==1){
					day--;
				} else{
					System.out.println("preCity:"+A[day]+" nextCity:"+i+", day:"+day);
					A[day+1]=i;
					search(path, day+1, A);
				}
			}
		}
	}
}
