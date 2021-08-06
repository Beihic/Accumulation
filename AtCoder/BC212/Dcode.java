import java.util.Scanner;
public class Main{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int Q = scan.nextInt();
		int[][] query = new int[Q][2];
		for(int i = 0; i<Q; i++){
			query[i][0] = scan.nextInt();
			if(query[i][0] == 3){
				query[i][1] = 0;
			}else if(query[i][0] == 1 || query[i][0] == 2){
				query[i][1] = scan.nextInt();
			}
		}
		long[] storage = new long[Q];
		int last = 0;
		for(int i = 0; i<Q; i++){
			if(query[i][0]==1){
				storage[last]=query[i][1];
				int j=last;
				while(j>0 && storage[j-1]<storage[j]){
					long tmp = storage[j-1]; storage[j-1] = storage[j]; storage[j] = tmp;	
					j--;
				}
				last++;
			} else if(query[i][0]==2){
				for(int j=0; j<last; j++){
					storage[j]+=query[i][1];
				}
			} else if(query[i][0]==3){
				System.out.println(storage[last-1]);
				last--;
			}
		}
	}
}
