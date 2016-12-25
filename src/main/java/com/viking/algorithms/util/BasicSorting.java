package com.viking.util;

/**
 * Author : Viking Den <vikingden7@gmail.com>
 * Date : 2016/12/25
 */
public abstract class BasicSorting {

    public abstract void sort(Comparable[] a) ;

    /**
     * 判断对象a是否小于对象b
     * @param a 对象a
     * @param b 对象b
     * @return 如果对象a小于对象b，返回true；否则，返回false
     */
    public static boolean less(Comparable a , Comparable b){
        return a.compareTo(b) < 0 ;
    }

    /**
     * 交换数组对象中的两个指定位置的对象
     * @param a 交换的数组对象
     * @param i 要交换的对象位置i
     * @param j 要交换的对象位置j
     */
    public static void exchange(Comparable[] a  , int i , int j){
        Comparable temp = a[i] ;
        a[i] = a[j] ;
        a[j] = temp ;
    }

    /**
     * 显示对象数组的元素
     * @param a 要显示的数组对象
     */
    public static void show(Comparable[] a){
        for (int i = 0 ; i < a.length ; i++){
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    /**
     * 判断对象数组中的元素是否已经排序
     * @param a 数组对象
     * @return 如果已经排序，返回true；否则，false
     */
    public static boolean isSorted(Comparable[] a){
        for (int i = 1 ; i < a.length ; i++){
            if (less(a[i] , a[i-1])) return false ;
        }
        return true ;
    }
}
