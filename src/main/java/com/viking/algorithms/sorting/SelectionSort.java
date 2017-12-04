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

    public void optimizedSort(Comparable[] a){
        int left = 0 ;
        int right = a.length -1 ;
        int min ;
        int max ;
        while (left < right){
            min = left ;
            max = right ;

            for (int i = left ; i <= right ; i++){
                if (less(a[i], a[min])){
                    min = i ;
                }
                if (less(a[max], a[i])){
                    max = i ;
                }
            }

            if (min != left){
                exchange(a, min, left);
            }
            //in case left has exchanged
            if (max == left ) max = min ;
            if (max != right){
                exchange(a, max, right);
            }

            left ++;
            right --;

        }
    }

    public void reverseSort(Comparable[] a){
        int N = a.length ;
        for (int i = 0 ; i < N; i++){
            int max = i ;
            for (int j = i +1 ; j < N; j++){
                if (less(a[max], a[j])) max = j ;
            }
            if (max > i) exchange(a, i, max);
        }
    }

    public static void main(String[] args){
        String[] nums = new String[]{"R" , "G" , "A" , "T", "F" , "V" , "M"} ;
        SelectionSort sSort = new SelectionSort() ;
        System.out.println("Before Sort");
        show(nums);
        sSort.sort(nums);
        System.out.println("After Sort");
        show(nums);

        nums = new String[]{"R" , "G" , "A" , "F" , "V" , "M"} ;
//        nums = new String[]{"R" , "G" , "A" , "T", "F" , "V" , "M"} ;
        System.out.println("Before Sort");
        show(nums);
        System.out.println("After Sort");
        sSort.optimizedSort(nums);
        show(nums);

    }
}
