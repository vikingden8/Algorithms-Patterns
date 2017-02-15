package com.viking.algorithms.sorting;

import com.viking.algorithms.util.BasicSorting;

/**
 * Author : Viking Den <vikingden7@gmail.com>
 * Date : 2016/12/25
 *
 *
 * 选择排序：不断在选择剩余元素之中的最小者
 *
 * 首先找到数组中最小的元素，其次，将它和数组中的第一个元素交换位置。再次，在剩下的元素中找到最小的元素，
 * 将它与数组的第二个元素交换位置。如此往复，直到将整个数组排序。
 *
 *
 * i   min    0    1   2   3   4   5
 *            R    G   A   F   V   M
 * 0   2      R    G  [A]  F   V   M
 * 1   3      A    G   R  [F]  V   M
 * 2   3      A    F   R  [G]  V   M
 * 3   5      A    F   G   R   V  [M]
 * 4   5      A    F   G   M   V  [R]
 * 5   3      A    F   G   M   R   V
 *
 *            A    F   G   M   R   V
 *
 *
 */
public class SelectionSort extends BasicSorting {

    @Override
    public void sort(Comparable[] a) {
        int N = a.length ;
        for (int i = 0 ; i < N ; i++){
            int min = i ;
            for (int j = i+1 ; j < N ; j++){
                if (less(a[j] , a[min])) min = j ;
            }
            if (i == min) continue;
            exchange(a , i , min);
        }
    }

    public static void main(String[] args){
        String[] nums = new String[]{"R" , "G" , "A" , "F" , "V" , "M"} ;
        BasicSorting sSort = new SelectionSort() ;
        System.out.println("Before Sort");
        show(nums);
        sSort.sort(nums);
        System.out.println("After Sort");
        show(nums);
    }
}
