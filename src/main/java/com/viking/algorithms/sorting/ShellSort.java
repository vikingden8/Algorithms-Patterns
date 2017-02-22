package com.viking.algorithms.sorting;

import com.viking.algorithms.util.BasicSorting;

/**
 * Author : Viking Den <vikingden7@gmail.com>
 * Date : 2017/2/22
 */
public class ShellSort extends BasicSorting {
    @Override
    public void sort(Comparable[] a) {
        int N = a.length ;

        int h = 1 ;

        while(h < N/3){
            h = 3*h + 1;
        }

        System.out.println("h : " + h);

        while( h>= 1){

            for (int i = h ; i < N ; i++){
                for (int j = i ; j >= h && less(a[j] , a[j-h]) ; j-=h){
                    exchange(a , j , j-h);
                }
            }
            show(a);
            h = h/3 ;
        }
    }

    public static void main(String[] args){
        Integer[] nums = new Integer[]{
                54,5,23,78,57,65,94,4,29,66
        } ;
        ShellSort shellSort = new ShellSort() ;
        shellSort.sort(nums);
    }
}
