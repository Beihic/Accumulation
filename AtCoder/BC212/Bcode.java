import java.util.Scanner;
public class Main{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int pass = scan.nextInt();
		int[] number = new int[4];
		String output = "Weak";
		for(int i = 0; i<number.length; i++){
			number[number.length-(i+1)] = pass % 10; 
			pass /= 10;
		}
		if(number[0] != number[1] || number[0] != number[2] || number[0] != number[3]){
			int sum = 0;
			for(int i = 0; i<number.length-1; i++){
				if((number[i]+1)%10==number[i+1]){
					sum++;
				}
			}
			if(sum!=number.length-1){
				output="Strong";
			}
		} 
		System.out.println(output);
	}
}
