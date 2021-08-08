import java.util.Scanner;
public class Main{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] A = new int[n+1];
		for(int i=1; i<=n; i++){
			A[i]=scan.nextInt();
		}
		int max1, max2, max1in = 0, max2in = 0;
		max1 = max2 = 0;
		for(int i=1; i<=n; i++){
			if(max1<A[i]){
				max1 = A[i];
				max1in = i;
			}
		}
		for(int i=1; i<=n; i++){
			if(max1in == i){
				continue;
			}else if(max2<A[i]){
				max2 = A[i];
				max2in = i;
			}
		}
		System.out.println(max2in);
	}
}
