package com.viking.algorithms.search;

/**
 * Author : Viking Den<dengwj@gionee.com>
 * Time : 2/2/18 9:36 AM
 */
public class S03_JumpSearch implements BaseSearch {

    @Override
    public void search() {
        int[] items = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610} ;
        int target = 55 ;
        int result = -1 ;
        int step = (int) Math.floor(Math.sqrt(items.length));
        int prev = -1 ;
        while(items[Math.min(step, items.length) - 1] < target){
            prev = step ;
            step *= 2 ;
            if (prev >= items.length){
                break ;
            }
        }

        if (prev >= items.length){
            System.out.println("No jump search index with the given target.");
        }else{
            while(items[prev] <  target){
                prev ++ ;
                if (prev == Math.min(step, items.length)){
                    break ;
                }
            }
            if (prev < items.length && items[prev] == target){
                result = prev ;
            }
            if (result == -1){
                System.out.println("No jump search index with the given target.");
            }else{
                System.out.println("Number " + target +" is at index : " + result);
            }
        }
    }

    public static void main(String[] args) {
        S03_JumpSearch jumpSearch = new S03_JumpSearch() ;
        jumpSearch.search();
    }
}
