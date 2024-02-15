package app.adt;

import static app.ValidateUtils.isGreaterThanOne;

/**
 * This is simple ring queue implementation based on the array.
 * To not overwhelming the class with the generics and co, it will be based on data type Integer for the value(s).
 * */
public class IntegerArrayQueue {
    private final Integer[] array;
    private final int size;
    private int head;
    private int currentSize;

    /**
     * <p>Since this is the ring queue, it will hold only so much elements it will be set through the size.</p>
     *
     * @param size of the ring queue, should be greater than 1
     * @exception IllegalArgumentException when size is lower than 1
     * */
    public IntegerArrayQueue(int size) {
        isGreaterThanOne(size);

        array = new Integer[size];
        this.size = size;
        head = 0;
        currentSize = 0;
    }

    /**
     * <p>When maximum size is reached, propagated value will not be stored in the queue.</p>
     *
     * @param value to store in the queue
     * */
    public void enqueue(Integer value){
        if(currentSize < size){
            array[(head + currentSize++) % size] = value;
        }
    }

    /**
     * <p>Method to fetch the value from the queue. If the queue is empty {@code null} will be returned.</p>
     * */
    public Integer dequeue(){
        if(currentSize == 0){
            return null;
        }
        Integer result = array[head];
        head = (head + 1) % size;
        currentSize--;
        return result;
    }

    /**
     * <p>Check if the queue is empty.</p>
     * */
    public boolean isEmpty(){
        return currentSize == 0;
    }
}
