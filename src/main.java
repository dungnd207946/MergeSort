import java.util.Scanner;
public class main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int arr[] = new int[10];
        for(int i = 0; i < 5; i++){
            arr[i] = sc.nextInt();
        }
        divide(arr, 0, 4);
        for(int i = 0; i < 5; i++){
           System.out.print(arr[i] + " "); 
        }
    } 
    public static void divide(int arr[], int begin, int end){
        int m = begin +(end - begin)/2 ;
        if(begin == end){
            return;
        }
        divide(arr, begin, m);
        divide(arr, m+1, end);
        merge(arr,begin,m,end);
        
    }
    public static void merge(int arr[], int begin, int m, int end){
        int i,j,k;
        int leftSize = m - begin + 1, rightSize = end - m;
        int[] leftArr = new int [leftSize], rightArr = new int [rightSize];
        for( i = 0; i < leftSize; i++){
            leftArr[i] = arr[begin + i];
        }
        for ( j = 0; j < rightSize; j++){
            rightArr[j] = arr[m + 1 + j];
        }
        i = j = 0;
        k = begin;
        while(i<leftSize && j<rightSize){
            if(leftArr[i]<rightArr[j]){
                arr[k] = leftArr[i];             
                i++;
            }
            else{
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }
        while(i<leftSize){
            arr[k] = leftArr[i];
            i++;
            k++;
        }
        while(j<rightSize){
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }
}