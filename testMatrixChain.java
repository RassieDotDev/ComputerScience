import java.util.*;
public class testMatrixChain{
	/**This program figures out the quickest way to multiply several matrices 
		and gives the total amount of operations
		Reference: http://www.geeksforgeeks.org/dynamic-programming-set-8-matrix-chain-multiplication/
	**/
	public static void main(String[] args){
		int n = 1203;
		int [] matrices= new int[n];
		for(int i = 0; i<n;i++)
				matrices[i]= (int) (Math.random()*99) ;
		long start, finish;
		start = System.currentTimeMillis();
		matrixChain(matrices);
		finish = System.currentTimeMillis();
		double time = (double) ((finish - start)/1000.0);
		System.out.println("Time for "+(n-1)+" Matrices "+time);
	}


	public static void matrixChain(int[] S){
	int n = S.length;
	int N[][] = new int[n][n];
	int i=0,j=0,k=0,b=0, q=0;

	for (i = 1; i < n-1; i++)
       N[i][i] = 0;


    for (b=1; b<=n-1; b++){
        for (i=1; i<=n-b-1; i++){
             j = i+b;
             if(j!=n)
             	N[i][j] = Integer.MAX_VALUE;
             for (k=i; k<=j-1; k++){
                  q = N[i][k] + N[k+1][j] + S[i-1]*S[k]*S[j];
                  if (q < N[i][j])
                       N[i][j] = q;}}}

    System.out.println("Number of ops "+q);}}

