package com.viking.algorithms.search;

/**
 * Author : Viking Den<dengwj@gionee.com>
 * Time : 2/6/18 9:39 AM
 */
public class S05_FibonacciSearch implements BaseSearch {

    private static final int MAX_FABONACCI_SIZE = 20 ;

    private static int[] fibonacci(){
        int[] fibonacci = new int[MAX_FABONACCI_SIZE] ;
        fibonacci[0] = 1 ;
        fibonacci[1] = 1 ;
        for (int i = 2 ; i < MAX_FABONACCI_SIZE ; i++){
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2] ;
        }
        return fibonacci ;
    }

    @Override
    public void search() {
        int[] data = { 1, 5, 15, 22, 25, 31, 39, 42, 47, 49, 59, 68, 88, 186};
        int target = 39 ;
        int index = fibonacciSearch(data, target) ;
        if (index != -1){
            System.out.println("Element found at index : " + index);
        } else{
            System.out.println("Element not found.");
        }
    }

    private void printArray(int[] data){
        for (int data_ : data){
            System.out.print(data_ + "  ");
        }
        System.out.println();
    }

    private int fibonacciSearch(int[] data, int target){
        int lo = 0 ;
        int hi = data.length - 1 ;

        int mid = 0 ;

        int[] f = fibonacci() ;

        printArray(f) ;

        int k = 0 ;
        while(data.length >= f[k]){
            k ++ ;
        }

        System.out.println("fibonacci k : " + k);

        //create temp array
        int[] temp = new int[f[k]] ;
        System.arraycopy(data, 0, temp, 0, data.length);

        for (int i = data.length ; i < f[k]; i++){
            temp[i] = data[data.length - 1] ;
        }

        printArray(temp);

        while(lo <= hi){
            mid = lo + f[k-1] - 1 ;
            if (temp[mid] > target){
                hi = mid - 1 ;
                k = k - 1 ;
            }else if (temp[mid] < target){
                lo = mid + 1 ;
                k = k -2 ;
            }else{
                if (mid <= data.length - 1){
                    return mid ;
                }else{
                    return data.length - 1 ;
                }
            }
        }
        return -1 ;
    }

    public static void main(String[] args) {
        S05_FibonacciSearch fibonacciSearch = new S05_FibonacciSearch() ;
        fibonacciSearch.search();
    }
}
