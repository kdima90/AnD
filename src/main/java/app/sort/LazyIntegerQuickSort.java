package app.sort;

import static java.util.Objects.requireNonNull;

/**
 * This is simple implementation of the quick sort for the integer array.
 * If you ask yourself, why lazy, then have a look pivot and how it will be set.
 * */
public class LazyIntegerQuickSort {

    /**
     * <p>This method will sort your array via quick sort.</p>
     *
     * @param array to be sorted
     * @exception NullPointerException will be thrown, if array is null
     * */
    public int[] sort(int[] array){
        requireNonNull(array, "Array should not be null!");

        sort(array,0, array.length-1);
        return array;
    }

    private int[] sort(int[] array, int left, int right){
        int l = left;
        int r = right;
        int pivot = array[l];
        while (l<=r) {
            while (array[l] < pivot){
                l++;
            }
            while (array[r] > pivot){
                r--;
            }
            if(l<=r){
                int tmp = array[l];
                array[l] = array[r];
                array[r] = tmp;
                r--;
                l++;
            }

        }
        if(left<r){
            sort(array, left, r);
        }
        if(right>l){
            sort(array, l, right);
        }
        return array;
    }





}
