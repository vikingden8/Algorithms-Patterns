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
        int max = maximum(array);
        System.out.println("max : " + max);
        int[] counting_array = new int[max + 1]; // Zeros out the array

        for(int curr = 0; curr < array.length; curr ++){
            counting_array[array[curr]]++;
        }

        printArray(counting_array);

        int num = 0;
        int curr = 0;

        while(curr < array.length){
            while(counting_array[num] > 0){
                array[curr] = num;
                counting_array[num]--;
                curr++;
                if(curr > array.length){
                    break;
                }
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

    private int maximum(int[] array){
        int max = array[0];
        if (array.length > 1){
            for(int curr = 1; curr < array.length; curr++){
                if(array[curr] > max){ max = array[curr]; }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int test1[] = {2, 6, 4, 3, 2, 3, 4, 6, 3, 4, 3, 5, 2, 6, 0};
        CountingSort countingSort = new CountingSort() ;
        countingSort.printArray(test1);
        countingSort.sortInteger(test1);
        countingSort.printArray(test1);
    }
}
