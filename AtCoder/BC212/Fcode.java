import java.util.Scanner;
public class Main{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		int q = scan.nextInt();
		int[][] bus = new int[m][4];
		int[][] query = new int[q][3];
		for(int i=0; i<bus.length; i++){
			for(int j=0; j<bus[0].length; j++){
				bus[i][j] = scan.nextInt();
			}
		}
		for(int i=0; i<query.length; i++){
			for(int j=0; j<query[0].length; j++)
				query[i][j] = scan.nextInt();
		}
		quick(bus, 0, bus.length-1);
		for(int i=0; i<query.length; i++){
			trip(bus, query[i]);
		}
	}
	private static void trip(int[][] bus, int[] query){
		double[][] root = new double[bus.length+1][3];
		root[0][0]=query[1];
		root[0][1]=query[0];
		int et = query[2];
		int rootIndex = 0, busIndex = 0;
		while(busIndex<bus.length){
			if(root[rootIndex][0]==bus[busIndex][0] && root[rootIndex][1]<=(bus[busIndex][2]+0.5)){
				root[rootIndex][2]=bus[busIndex][2]+0.5;
				rootIndex++;
				root[rootIndex][0]=bus[busIndex][1];
				root[rootIndex][1]=bus[busIndex][3]+0.5;
			} else {busIndex++;}
		}
		root[rootIndex][2]=1000000000;
		for(int i=0; i<=rootIndex; i++){
			if(root[i][1]<= et && et <= root[i][2]){
				System.out.println((int)root[i][0]);
				break;
			} else{
				if(root[i][2]< et && et < root[i+1][1]){
					System.out.println((int)root[i][0]+" "+(int)root[i+1][0]);
					break;
				}
			}
		}
	}
	private static void swapBus(int[][] bus, int a, int b){
		int tmp;
		for(int i=0; i<bus[0].length; i++){
			tmp = bus[a][i]; bus[a][i] = bus[b][i]; bus[b][i] = tmp;
		}
	}
	private static int part(int[][] bus, int left, int right){
		int k = (left+right)/2;
		swapBus(bus, k, right);
		int i = left, j = right -1;
		while(i<=j){
			while(bus[i][2]<bus[right][2]){i++;}
			while(j>=i && bus[j][2]>=bus[right][2]){j--;}
			if(i<j) swapBus(bus, i, j);
		}
		swapBus(bus, i, right);
		return i;
	}
	private static void quick(int[][] bus, int left, int right){
		if(left<right){
			int p = part(bus, left, right);
			quick(bus, left, p-1);
			quick(bus, p+1, right);
		}
	}
}
