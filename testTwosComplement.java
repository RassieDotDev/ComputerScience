
public class testTwosComplement{
	public static void main(String[] args){
		getTwosComplement(777);
		
		getTwosComplement(-777);
	}

	public static void getTwosComplement(int n){
		if(n>0)
			System.out.println(n+": "+String.format("%16s", Integer.toBinaryString(n)).replace(' ', '0'));
		else{
			int m = n*-1;
			String binNum = String.format("%16s", Integer.toBinaryString(m)).replace(' ', '0');
			for(int i = 0; i<binNum.length(); i++){
				char c = binNum.charAt(i);
				if(c=='0'){
					char [] chars = binNum.toCharArray();
					chars[i] = '1';
					binNum = String.valueOf(chars);}
				else{
					char [] chars = binNum.toCharArray();
					chars[i] = '0';
					binNum = String.valueOf(chars);}}
			int j = Integer.parseInt(binNum,2);
			j = j+1;
			System.out.println(n +": "+ String.format("%16s", Integer.toBinaryString(j)).replace(' ', '1'));
		}
	}
}
