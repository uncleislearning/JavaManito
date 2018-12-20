package com.xiao.JAVAManito.designpattern.adapter;

/**
 * Created by unclexiao on 2017/12/21.
 */
public class OperationAdapter implements ScoreOpertations {
    private BinarySearch search;
    private QuickSort sort;

    public OperationAdapter() {
        this.search = new BinarySearch();
        this.sort = new QuickSort();
    }

    @Override
    public int[] sort(int[] array) {
        return sort.quickSort(array);
    }

    @Override
    public int search(int[] array, int key) {
        return search.binarySearch(array,key);
    }
}
