package com.viking.algorithms.sorting;

import com.viking.algorithms.util.BasicSorting;

/**
 * Author : Viking Den <vikingden7@gmail.com>
 * Date : 2017/11/29
 */
public class BubbleSort extends BasicSorting {


    @Override
    public void sort(Comparable[] a) {
        int N = a.length ;
        for (int i = 0 ; i < N ; i++){
            for (int j = 0 ; j < N - i - 1 ; j++){
                if (more(a[j] , a[j+1])) {
                    exchange(a, j, j+1);
                }
            }
        }
    }

    public void optiSort(Comparable[] a) {
        int N = a.length ;
        for (int i = 0 ; i < N ; i++){
            System.out.println("---------" + i + "-----------");
            show(a);
            boolean exchanged = false ;
            for (int j = 0 ; j < N - i - 1 ; j++){
                if (more(a[j] , a[j+1])) {
                    exchange(a, j, j+1);
                    exchanged = true ;
                }
            }
            if (!exchanged){
                break ;
            }
        }
    }

    public static void main(String[] args){
        String[] nums = new String[]{"R" , "G" , "A" , "F" , "V" , "M"} ;
        BubbleSort sSort = new BubbleSort() ;
        System.out.println("Before Sort");
        show(nums);
        sSort.sort(nums);
        System.out.println("After Sort");
        show(nums);

        nums = new String[]{"R" , "A" , "F" , "G" , "V" , "M"} ;
        System.out.println("Before Sort");
        show(nums);
        sSort.optiSort(nums);
        System.out.println("After Sort");
        show(nums);
    }
}
