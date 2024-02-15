package app.adt;

import static java.util.Objects.requireNonNull;

public class IntegerDictionary {
    private final Integer[] keys;
    private final int size = 17;
    private final boolean isLinearProbing;

    public IntegerDictionary(boolean isLinearProbing) {
        this.isLinearProbing = isLinearProbing;
        keys = new Integer[size];
    }

    private int multiplyKeyWithPrimNumber(int key){
        return 53 * key;
    }

    private int keyModulo(int key){
        return 1 + (key % (size - 1));
    }

    private int linearProbingHash(int key, int counter){
        return (multiplyKeyWithPrimNumber(key) + counter) % size;
    }

    private int doubleHash(int key, int counter){
        return (multiplyKeyWithPrimNumber(key) + keyModulo(key) * counter) % size;
    }

     public void insert(Integer key){
        int counter = 0;
        if(this.isLinearProbing){
            Integer currentKey = this.keys[linearProbingHash(key, counter)];
            if (currentKey != null && !currentKey.equals(key)) {
                counter++;
                while ((currentKey = this.keys[linearProbingHash(key, counter)])
                                != null && !currentKey.equals(key) && counter < size) {
                    counter++;
                }
            }
            this.keys[linearProbingHash(key, counter)] = key;
        }else {
            Integer currentKey = this.keys[doubleHash(key, counter)];
            if (currentKey != null) {
                counter++;
                while ((currentKey = this.keys[doubleHash(key, counter)])
                        != null && !currentKey.equals(key) && counter < size) {
                    counter++;
                }
            }
            this.keys[doubleHash(key, counter)] = key;
        }
    }

    public boolean find(Integer key){
        int counter = 0;
        if(isLinearProbing){
            while (this.keys[linearProbingHash(key, counter)] != null && counter < size) {
                if(this.keys[linearProbingHash(key, counter)].equals(key)){
                    return true;
                }
                counter++;
            }
        }else {
            while (this.keys[doubleHash(key, counter)] != null && counter < size) {
                if(this.keys[doubleHash(key, counter)].equals(key)){
                    return true;
                }
                counter++;
            }
        }
        return false;
    }

}
