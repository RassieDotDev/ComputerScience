import java.io.*;
import java.util.*;
public class testLongestCommonSubsequence{

    public static void main(String args[]){
        try{
            File fileX = new new File("/export/home/ds/xDNA.txt");
            File fileY = new new File("/export/home/ds/yDNA.txt");
            Scanner x = new Scanner(fileX); Scanner y = new Scanner(fileY);
            String xStr = "", yStr = "";
            while(fileX.hasNext()){
                xStr = xStr + x.nextLine().trim();}
            while(fileY.hasNext()){
                yStr = yStr + y.nextLine().trim();}
        }catch(Exception e){System.out.println(e.getMessage());}
        
        int result = lcsDP(xStr.toCharArray(), yStr.toCharArray());
        System.out.print(result);}

    

    public static int lcsDP(char stringA[],char stringB[]){
    int lcsArray[][] = new int[stringA.length + 1][stringB.length + 1];
    int max = 0;
    int n = lcsArray.length;
        for(int i=1; i < n; i++){
            for(int j=1; j < lcsArray[i].length; j++){
                if(stringA[i-1] == stringB[j-1]) {
                    lcsArray[i][j] = lcsArray[i - 1][j - 1] + 1;}
                else{
                    lcsArray[i][j] = Math.max(lcsArray[i-1][j],lcsArray[i][j-1]);}
                if(lcsArray[i][j] > max){
                    max = lcsArray[i][j];}}}
    return max;}}