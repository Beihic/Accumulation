import java.util.Scanner;
public class Main{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int A = scan.nextInt();
		int B = scan.nextInt();
		String output = null;
		if(0<A && B==0){
			output = "Gold";
		}else if (A==0 && 0<B){
			output = "Silver";
		}else if(0<A && 0<B){
			output = "Alloy";
		}
		System.out.println(output);
	}
}
