package app.adt;

import static app.ValidateUtils.isGreaterThanOne;

/**
 * This is simple stack implementation based on the array.
 * To not overwhelming the class with the generics and co, it will be based on data type Integer for the value(s).
 **/
public class IntegerArrayStack {
    private final Integer[] array;
    private final int size;
    private int currentSize;

    /**
     * <p>Since this stack is based on the array, it will hold only so much elements it will be set through the size.</p>
     *
     * @param size of the stack, should be greater than 1
     * @exception IllegalArgumentException when size is lower than 1
     * */
    public IntegerArrayStack(int size) {
        isGreaterThanOne(size);

        array = new Integer[size];
        this.size = size;
        currentSize = 0;
    }

    /**
     * <p>When maximum size is reached, propagated value will not be stored in the stack.</p>
     *
     * @param value to store in the stack
     * */
    public void push(Integer value){
        if(currentSize<size){
            array[currentSize++]=value;
        }
    }
    /**
     * <p>Method to fetch the value from the stack. If the stack is empty {@code null} will be returned.</p>
     * */
    public Integer pop(){
        if(currentSize==0){
            return null;
        }
        return array[--currentSize];
    }

    /**
     * <p>Check if the stack is empty.</p>
     * */
    public boolean isEmpty(){
        return currentSize==0;
    }
}
