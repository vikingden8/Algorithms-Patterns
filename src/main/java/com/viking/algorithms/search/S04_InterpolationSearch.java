package com.viking.algorithms.search;

/**
 * Author : Viking Den<dengwj@gionee.com>
 * Time : 2/5/18 2:39 PM
 */
public class S04_InterpolationSearch implements BaseSearch {

    @Override
    public void search() {
        int[] items = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610} ;
        int target = 144 ;

        int result = interpolationSearch(items, target) ;

        if (result == -1){
            System.out.println("Element not found.");
        }else{
            System.out.println("Element found at index " + result);
        }
    }

    private int interpolationSearch(int[] items, int target){
        int lo = 0, hi = items.length - 1 ;
        while(lo <= hi && target >= items[lo] && target <= items[hi]){
            int position = lo + (target - items[lo]) * (hi - lo) / (items[hi] - items[lo]) ;
            System.out.println("position : " + position);
            if (items[position] == target){
                return position ;
            }
            if (items[position] < target){
                lo = position + 1 ;
            }else{
                hi = position - 1 ;
            }
        }
        return -1 ;
    }

    public static void main(String[] args) {
        S04_InterpolationSearch interpolationSearch = new S04_InterpolationSearch() ;
        interpolationSearch.search();
    }
}
