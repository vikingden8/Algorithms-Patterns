package com.viking.algorithms.sorting;

import com.viking.algorithms.util.BasicSorting;

/**
 * Author : Viking Den <vikingden7@gmail.com>
 * Date : 2017/2/15
 *
 * 选择排序
 *
 * 通过查找最大值进行排序
 */
public class ReverseSelectionSort extends BasicSorting {

    @Override
    public void sort(Comparable[] a) {

        int N = a.length ;

        for (int i = N-1 ; i >=0 ; i--){
            int max = i ;
            for (int j = i-1 ; j >= 0 ; j--){
                if (less(a[max] , a[j])) max = j ;
            }
            if (max == i ) continue;
            exchange(a , i , max);
//            show(a);
        }

    }

    public static void main(String[] args){
        String[] nums = new String[]{"R" , "G" , "A" , "F" , "V" , "M"} ;
        BasicSorting sSort = new ReverseSelectionSort() ;
        System.out.println("Before Sort");
        show(nums);
        sSort.sort(nums);
        System.out.println("After Sort");
        show(nums);
    }
}
