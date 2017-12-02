package com.viking.algorithms.sorting;

import com.viking.algorithms.util.BasicSorting;

/**
 * Author : Viking Den <vikingden7@gmail.com>
 * Date : 2017/11/29
 */
public class BubbleSort extends BasicSorting {

    public void originSort(Comparable[] a){
        while(true) {
            int N = a.length ;
            boolean  hasSwaped = false ;
            for (int i = 0 ; i < N - 1 ; i ++){
                if (less(a[i + 1], a[i])){
                    exchange(a, i, i + 1);
                    hasSwaped = true ;
                }
            }
            if (!hasSwaped){
                break ;
            }
        };
    }

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

    public void optimizedSort(Comparable[] a) {
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

    public void bestSort(Comparable[] a){
        int N = a.length ;
        int lastExchanged = N ;
        int k ;
        while (lastExchanged > 0){
            show(a);
            k = lastExchanged ;
            lastExchanged = 0 ;
            for (int j = 0 ; j < k -1  ; j++){
                if (less(a[j + 1] , a[j])) {
                    exchange(a, j, j + 1);
                    lastExchanged = (j + 1)  ;
                }
            }
            System.out.println("lastExchanged : " + lastExchanged);
        }
    }


    public static void main(String[] args){
        String[] nums = new String[]{"R" , "G" , "A" , "F" , "V" , "M"} ;
        BubbleSort sSort = new BubbleSort() ;
        System.out.println("Before Sort");
        show(nums);
        sSort.originSort(nums);
        System.out.println("After Sort");
        show(nums);

        System.out.println("Before Sort");
        show(nums);
        sSort.sort(nums);
        System.out.println("After Sort");
        show(nums);

        nums = new String[]{"R" , "A" , "F" , "G" , "V" , "M"} ;
        System.out.println("Before Sort");
        show(nums);
        sSort.optimizedSort(nums);
        System.out.println("After Sort");
        show(nums);

        nums = new String[]{"R" , "F" , "G" , "A" , "V" , "M"} ;
        System.out.println("Before Sort");
        show(nums);
        sSort.bestSort(nums);
        System.out.println("After Sort");
        show(nums);
    }
}
