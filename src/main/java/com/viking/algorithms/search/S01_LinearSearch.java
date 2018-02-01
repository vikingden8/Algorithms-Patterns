package com.viking.algorithms.search;

/**
 * Author : Viking Den<dengwj@gionee.com>
 * Time : 2/1/18 2:08 PM
 */
public class S01_LinearSearch implements BaseSearch{

    @Override
    public void search() {
        int[] items = new int[]{56, 3, 249, 518, 7, 26, 94, 651, 23, 9} ;
        int   target = 9 ;
        int   result = -1 ;
        for (int i = 0; i < items.length ; i++ ){
            if (items[i] == target){
                result = i ;
                break ;
            }
        }
        if (result == -1){
            System.out.println("No search result with the given target.");
        }else{
            System.out.println("Search result index : " + result);
        }
    }

    public static void main(String[] args) {
        S01_LinearSearch linearSearch = new S01_LinearSearch() ;
        linearSearch.search();
    }
}
