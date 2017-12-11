package com.viking.algorithms.sorting;

import com.viking.algorithms.util.BasicSorting;

/**
 * Author : Viking Den <vikingden7@gmail.com>
 * Date : 2017/2/17
 *
 * 插入排序算法
 *
 * i   j      0    1   2   3   4   5
 *            R    G   A   F   V   M
 * 1   0     [G]   R   A   F   V   M
 * 2   0     [A]   G   R   F   V   M
 * 3   1      A   [F]  G   R   V   M
 * 4   4      A    F   G   R  [V]  M
 * 5   5      A    F   G   M   R  [V]
 *
 *            A    F   G   M   R   V
 */
public class InsertSort extends BasicSorting{


    @Override
    public void sort(Comparable[] a) {
        int N = a.length ;
        for (int i = 1 ; i < N ; i++){
            for (int j = i ; j > 0 && less(a[j] , a[j-1]) ; j--){
                exchange(a , j , j-1);
            }
        }
    }

    public void optimizedSort(Comparable[] a){
        int N = a.length ;
        for (int i = 1; i < N ; i++){
            Comparable insertNode = a[i] ;
            int j = i - 1 ;
            while (j >= 0 && less(insertNode, a[j])){
                a[j + 1] = a[j] ;
                j -- ;
            }
            a[j + 1] = insertNode ;
        }
    }

    public static void main(String[] args){
        String[] nums = new String[]{"R" , "G" , "A" , "F" , "V" , "M"} ;
        InsertSort sSort = new InsertSort() ;
        System.out.println("Before Sort");
        show(nums);
        sSort.optimizedSort(nums);
        System.out.println("After Sort");
        show(nums);
    }

}
