
public class MergeSort {

    public void sort(int input[]){
        sort(input, 0, input.length-1);
    }
    
    private void sort(int input[], int low, int high){
        if(low > high){
            return;
        }
        
        int eighth = (low + high)/8;
        int quarter = (low+high)/4;
        int half = (low+high)/2;
        int threequarters = half+eighth;
        sort(input, low, eighth);
        sort(input, eighth+1, quarter);
        sort(input, quarter+1, half);
        sort(input, half+1, threequarters);
        sort(input, threequarters+1, high);

        sortedMerge(input,low,high);
   }}