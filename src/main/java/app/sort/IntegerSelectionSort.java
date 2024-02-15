package app.sort;

import static java.util.Objects.requireNonNull;

/**
 * This is simple implementation of the selection sort for the integer array.
 * */
public class IntegerSelectionSort {

    /**
     * <p>This method will sort your array via selection sort.</p>
     *
     * @param array to be sorted
     * @exception NullPointerException will be thrown, if array is null
     * */
    public int[] sort(int[] array){
        requireNonNull(array, "Array should not be null!");

        int i = 1;
        int j;
        while (i<array.length){
            j=i-1;
            int value = array[i];
            while(j>=0 && array[j] > value){
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = value;
            i++;
        }
        return array;
    }
}
