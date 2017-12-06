package com.viking.algorithms.sorting;

import com.viking.algorithms.util.BasicSorting;

/**
 * Author : Viking Den <vikingden7@gmail.com>
 * Date : 2017/12/6
 */
public class QuickSort extends BasicSorting {

    @Override
    public void sort(Comparable[] a) {
        realSort(a, 0, a.length - 1);
    }

    public static void realSort(Comparable[] a, int low, int height) {
        int i, j ;
        Comparable index;
        if (low > height) {
            return;
        }
        i = low;
        j = height;
        index = a[i]; // 用子表的第一个记录做基准
        while (i < j) { // 从表的两端交替向中间扫描
            while (i < j && less(index, a[j]))
                j--;
            if (i < j)
                a[i++] = a[j];// 用比基准小的记录替换低位记录
            while (i < j && less(a[i],index))
                i++;
            if (i < j) // 用比基准大的记录替换高位记录
                a[j--] = a[i];
        }
        a[i] = index;// 将基准数值替换回 a[i]
        realSort(a, low, i - 1); // 对低子表进行递归排序
        realSort(a, i + 1, height); // 对高子表进行递归排序
    }

    public static void main(String[] args){
        String[] nums = new String[]{"R" , "G" , "A" , "F" , "V" , "M"} ;
        QuickSort sSort = new QuickSort() ;
        System.out.println("Before Sort");
        show(nums);
        sSort.sort(nums);
        System.out.println("After Sort");
        show(nums);
    }
}
