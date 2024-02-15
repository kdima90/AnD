package app.adt;

/**
 * This is simple linked list implementation.
 * To not overwhelming the class with the generics and co, it will be based on data type Integer for the value(s).
 * */
public class IntegerLinkedList {
    private int size;
    private Element currentElement;
    private Element headElement;

    private static class Element {
        private Integer value;
        private Element next;
    }

    /**
     * @param value to add in the list
     * */
    public void add(Integer value) {
        while (currentElement != null) {
            currentElement = currentElement.next;
        }
        if(headElement == null){
            headElement = new Element();
            headElement.value = value;
            currentElement = headElement;
        } else {
            currentElement = new Element();
            currentElement.value = value;

            Element tmp = headElement;
            while (tmp.next != null){
                tmp = tmp.next;
            }
            tmp.next = currentElement;

        }
        size++;
    }

    /**
     * <p>First found value in the current list will be returned. If no value exists, {@code null} will be returned.</p>
     *
     * @param value to find
     * */
    public Integer getFirst(Integer value){
        if(headElement == null){
            return null;
        }
        if(currentElement.value.equals(value)){
            return currentElement.value;
        }
        Element tmp = headElement;
        while (tmp!= currentElement){
            if(tmp.value.equals(value)) return tmp.value;
            tmp = tmp.next;
        }
        return null;
    }

    /**
     * <p>First founded value in the list will be deleted.</p>
     *
     * @param value to be deleted in the list
     * */
    public boolean deleteFirst(Integer value) {
        if(currentElement == null){
            return false;
        }
        if(headElement != null && headElement.value.equals(value)){
            if(headElement == currentElement){
                headElement = null;
                currentElement = null;
                size --;
                return true;
            }
            headElement = headElement.next;
            size--;
            return true;
        }
        Element element = headElement;
        while (element!= currentElement && !element.value.equals(value)){
            element = element.next;
        }
        if(element.next == null && element.value.equals(value)) {
            Element tmp = headElement;
            while (tmp.next!= currentElement){
                tmp = tmp.next;
            }
            currentElement = tmp;
            currentElement.next = null;
            size--;
            return true;
        } else if(element.next != null && element.value.equals(value)) {
            element = headElement;
            while (element.next.next != currentElement){
                element = element.next;
            }
            element.next = currentElement;
            size--;
            return true;
        }
        return false;
    }

    /**
     * <p>Returns size of the list.</p>
     * */
    public int getSize() {
        return size;
    }
}
