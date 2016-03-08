package test;

public class array {
	public static void main(String []args){
		
		int [][]a = {{1,2,3},{4,5,6},{7,8,9}};
		printArray(a);
		
		int [][]b = new int[a.length][a[0].length];
		for(int i=0;i<a.length;i++)
			for(int j=0;j<a[0].length;j++)
				b[i][j] = a[j][i];
		printArray(b);
	}

	public static void printArray(int [][]a){
		for(int i=0;i<a.length;i++){
			for(int j=0;j<a[i].length;j++)
				System.out.print(a[i][j]+" ");
			System.out.println();
		}
		
	}
}
