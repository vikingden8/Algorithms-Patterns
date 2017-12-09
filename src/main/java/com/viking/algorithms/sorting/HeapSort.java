package com.viking.algorithms.sorting;

import com.viking.algorithms.util.BasicSorting;

/**
 * Author : Viking Den <vikingden7@gmail.com>
 * Date : 2017/12/10
 */
public class HeapSort extends BasicSorting {

    @Override
    public void sort(Comparable[] arr) {
        int n = arr.length;

        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Heap sort
        for (int i=n-1; i>=0; i--)
        {
            Comparable temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Heapify root element
            heapify(arr, i, 0);
        }
    }

    void heapify(Comparable[] arr, int n, int i)
    {
        // Find largest among root, left child and right child
        int largest = i;
        int l = 2*i + 1;
        int r = 2*i + 2;

        if (l < n && less(arr[largest], arr[l]))
            largest = l;

        if (r < n && less(arr[largest], arr[r]))
            largest = r;

        // Swap and continue heapifying if root is not largest
        if (largest != i)
        {
            exchange(arr, i, largest);
            heapify(arr, n, largest);
        }
    }

    public static void main(String args[])
    {
        String[] nums = new String[]{"R" , "G" , "A" , "F" , "V" , "M"} ;

        HeapSort hs = new HeapSort();
        hs.sort(nums);

        System.out.println("Sorted array is");
        show(nums);
    }
}
