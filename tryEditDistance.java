import java.io.*;
import java.util.*;
public class tryEditDistance{

    public static void main(String args[]){
        String xStr = "", yStr = "";
        try{
            File fileX = new File("/export/home/notes/ds/xDNA.txt");
            File fileY = new File("/export/home/notes/ds/yDNA.txt");
            Scanner x = new Scanner(fileX); Scanner y = new Scanner(fileY);
            while(x.hasNext()){
                xStr = xStr + x.nextLine().trim();}
            while(y.hasNext()){
                yStr = yStr + y.nextLine().trim();}
        }catch(Exception e){System.out.println(e.getMessage());}
        
        int result = sedDP(xStr.toCharArray(), yStr.toCharArray());
        System.out.print(result);}

    

    public static int sedDP(char stringA[],char stringB[]){
    int sedArray[][] = new int[stringA.length + 1][stringB.length + 1];
    int max = 0;
    int n = stringA.length + 1;
    for(int i =0; i<=stringB.length; i++)
        sedArray[0][i] = i;

    for(int j = 0; j<=stringA.length; j++)
        sedArray[j][0]=j;


        for(int i=1; i <=stringA.length; i++){
            for(int j=1; j <=stringB.length; j++){
                if(stringA[i-1] == stringB[j-1]) {
                    sedArray[i][j] = sedArray[i - 1][j - 1];}
                else{
                    sedArray[i][j] = Math.min(Math.min(sedArray[i-1][j],sedArray[i][j-1]), sedArray[i-1][j-1])+1;}}}
    return sedArray[stringA.length][stringB.length];}}