package app.search;

import app.sort.LazyIntegerQuickSort;

import static java.util.Objects.requireNonNull;

/**
 * This is simple implementation of the binary search for the integers.
 * */
public class IntegerBinarySearch {

    /**
     * <p>This methods will search via binary search algorithm in the given array for desired value.</p>
     *
     * @param array to be searched in
     * @param isSorted true, if array should be sorted, otherwise it assume array is sorted
     * @param value to be search in the given array
     * @return {@code Result} of the search will be return, if nothing was found, {@code null} be returned
     * @exception NullPointerException will be thrown, when array is null
     * */
    public Result search(int[] array, int value, boolean isSorted){
        requireNonNull(array, "Array should not be null!");

        if(!isSorted){
            new LazyIntegerQuickSort().sort(array);
        }
        int left = 0;
        int right = array.length - 1;
        while(right > left){
            int middle = (left + right) / 2;
            if(array[middle] < value){
                left = middle + 1;
            }else if(array[middle] > value){
                right = middle - 1;
            }else {
                left = middle;
                right = middle;
            }
            if(array[left] == value) {
                Result result = new Result();
                result.position = left;
                result.value = array[left];
                return result;
            }
        }

        return null;
    }

    /**
     * Simple class to get the founded value and its position in the given array.
     * */
    public static class Result{
        private int value;
        private int position;

        public int getValue() {
            return value;
        }
        public int getPosition() {
            return position;
        }
    }
}
