public class testCoinChanging{
	public static void main(String[] args){
		int[] coin = {1,2,5,10,20,50};
		int total = 100;
		System.out.println("Number of coin changes: "+coinChange(coin, total));
	}

	public static int coinChange(int[] coinList, int total){
		//int totalCounter = 0;
		int [][] totalTable = new int[coinList.length+1][total+1];
		for(int k = 0; k<= coinList.length; k++)
			totalTable[k][0] = 1;

		for(int i =1 ; i<= coinList.length; i++)
			for(int j = 1; j<=total; j++ ){
				if(coinList[i-1]>j){
					totalTable[i][j] = totalTable[i-1][j];
				}
				else{
					totalTable[i][j] = totalTable[i-1][j] + totalTable[i][j-coinList[i-1]];
				}
			}

			/*for(int i = 0; i<=coinList.length;i++)
				{	for(int j = 0; j<= total; j++){
					System.out.print(totalTable[i][j]+" ");
				}
					System.out.println();
			}*/
			return totalTable[coinList.length][total];
	}
}