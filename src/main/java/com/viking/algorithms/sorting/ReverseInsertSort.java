package com.viking.algorithms.sorting;

import com.viking.algorithms.util.BasicSorting;

/**
 * Author : Viking Den <vikingden7@gmail.com>
 * Date : 2017/2/17
 *
 * i   j      0    1   2   3   4   5
 *            R    G   A   F   V   M
 * 4   5      R    G   A   F   M  [V]
 * 3   3      R    G   A  [F]  M   V
 * 2   2      R    G  [A]  F   M   V
 * 1   3      R    A   F  [G]  M   V
 * 0   4      A    F   G   M  [R]  V
 *
 *            A    F   G   M   R   V
 */
public class ReverseInsertSort extends BasicSorting{

    @Override
    public void sort(Comparable[] a) {
        int N = a.length ;
        if (N <= 1) return;
        for (int i = N-2 ; i >= 0 ; i--){
            for (int j = i  ; j < N-1 && less(a[j+1] , a[j]) ; j++){
                exchange(a , j , j+1);
            }
        }
    }

    public static void main(String[] args){
        String[] nums = new String[]{"R" , "G" , "A" , "F" , "V" , "M"} ;
        BasicSorting sSort = new ReverseInsertSort() ;
        System.out.println("Before Sort");
        show(nums);
        sSort.sort(nums);
        System.out.println("After Sort");
        show(nums);
    }
}
