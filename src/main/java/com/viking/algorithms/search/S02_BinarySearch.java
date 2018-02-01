package com.viking.algorithms.search;

/**
 * Author : Viking Den<dengwj@gionee.com>
 * Time : 2/1/18 3:01 PM
 */
public class S02_BinarySearch implements BaseSearch {

    @Override
    public void search() {
        int[] items = new int[]{2, 5, 8, 12, 16, 23, 38, 56, 72, 91} ;
        int   target = 23 ;
        int   result = -1 ;
        int   low = 0, high = items.length - 1 ;
        int   median ;
        while (low <= high){
            median = (low + high) / 2 ;
            if (items[median] == target){
                result = median ;
                break ;
            }
            if (items[median] > target){
                high = median - 1 ;
            }else{
                low = median + 1 ;
            }
        }
        if (result == -1){
            System.out.println("No binary search result with the given target.");
        }else{
            System.out.println("binary search result : " + result);
        }
    }

    public static void main(String[] args) {
        S02_BinarySearch binarySearch = new S02_BinarySearch() ;
        binarySearch.search();
    }
}
