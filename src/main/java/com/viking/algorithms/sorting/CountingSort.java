package com.viking.algorithms.sorting;

import com.viking.algorithms.util.BasicSorting;

/**
 * Author : Viking Den <vikingden7@gmail.com>
 * Date : 2017/12/3
 */
public class CountingSort extends BasicSorting {


    @Override
    public void sort(Comparable[] a) {
        //do nothing
    }

    public void sortInteger(int[] array){
        int max = max(array);
        int min = min(array) ;
        System.out.println("min : " + min);
        System.out.println("max : " + max);
        int[] counting_array = new int[(max - min) + 1];

        for(int curr = 0; curr < array.length; curr ++){
            counting_array[array[curr] - min]++;
        }

        printArray(counting_array);

        int num = 0;
        int curr = 0;

        while(curr < array.length){
            while(counting_array[num] > 0){
                array[curr] = num + min;
                counting_array[num]--;
                curr++;
            }
            num++;
        }
    }

    public void printArray(int[] array){
        for (int i = 0; i < array.length ; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println("\n");
    }

    private int max(int[] array){
        int max = array[0];
        if (array.length > 1){
            for(int curr = 1; curr < array.length; curr++){
                if(array[curr] > max){ max = array[curr]; }
            }
        }
        return max;
    }

    private int min(int[] array){
        int min = array[0] ;
        if (array.length > 1){
            for (int curr = 1; curr < array.length; curr++){
                if (array[curr] < min){
                    min = array[curr] ;
                }
            }
        }
        return min ;
    }

    public static void main(String[] args) {
        int test1[] = {2, 6, 4, 3, 2, 3, 4, 6, 3, 4, 3, 5, 2, 6};
        CountingSort countingSort = new CountingSort() ;
        countingSort.printArray(test1);
        countingSort.sortInteger(test1);
        countingSort.printArray(test1);
    }
}
