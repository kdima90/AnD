package app.adt;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static java.util.Objects.requireNonNull;

public class IntegerBinaryTree {
    public enum TraversalOrder {
        PRE_ORDER,
        IN_ORDER,
        POST_ORDER,
        BREADTH_FIRST_SEARCH
    }

    public static class KeyValue{
        private Integer key;
        private Integer value;

        public KeyValue(Integer key, Integer value) {
            requireNonNull(key, "Key should not be null!");

            this.key = key;
            this.value = value;
        }

        public Integer getKey() {
            return key;
        }
        public Integer getValue() {
            return value;
        }

    }

    private static class Element{
        private KeyValue keyValue;
        private Element parent;
        private Element left;
        private Element right;

        public Element(KeyValue keyValue, Element parent, Element left, Element right) {
            this.keyValue = keyValue;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }

        public Element() {
        }
    }

    private Element root;

    private Element getMinKeyElement(){
        if(root == null){
            return null;
        }
        Element element = root;
        Element lastElement = root;
        while (element != null){
            if(element.left == null){
                lastElement = element;
            }
            element = element.left;
        }
        return lastElement;
    }

    private Element successor(Element element){
        if(element.right != null){
            Element tmp = element.right;
            while (tmp.left != null)
                tmp = tmp.left;
            return tmp;
        }else {
            Element tmp = element;
            Element parent = tmp.parent;
            while(parent != null && tmp == parent.right){
                tmp = parent;
                parent = tmp.parent;
            }
            return parent;
        }
    }

    private Element predecessor(){
        return null;
    }

    private void preOrder(Element element, List<KeyValue> keyValues) {
        if(element != null){
            keyValues.add(element.keyValue);
            preOrder(element.left, keyValues);
            preOrder(element.right, keyValues);
        }
    }

    private List<KeyValue> preOrder() {
        List<KeyValue> keyValues = new ArrayList<>();
        preOrder(root, keyValues);
        return keyValues;
    }

    private void inOrder(Element element, List<KeyValue> keyValues) {
        if(element != null){
            inOrder(element.left, keyValues);
            keyValues.add(element.keyValue);
            inOrder(element.right, keyValues);
        }
    }

    private List<KeyValue> inOrder() {
        List<KeyValue> keyValues = new ArrayList<>();
        inOrder(root, keyValues);
        return keyValues;
    }

    private void postOrder(Element element, List<KeyValue> keyValues) {
        if(element != null){
            postOrder(element.left, keyValues);
            postOrder(element.right, keyValues);
            keyValues.add(element.keyValue);
        }
    }

    private List<KeyValue> postOrder() {
        List<KeyValue> keyValues = new ArrayList<>();
        postOrder(root, keyValues);
        return keyValues;
    }

    private List<KeyValue> breadthFirstSearch(){
        List<KeyValue> keyValues = new ArrayList<>();
        Queue<Element> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Element element = queue.poll();
            keyValues.add(element.keyValue);
            if(element.left != null){
                queue.add(element.left);
            }
            if(element.right != null){
                queue.add(element.right);
            }
        }
        return keyValues;
    }

    public List<KeyValue> traversalIntegerBinaryTree(TraversalOrder traversalOrder){
        if(traversalOrder == TraversalOrder.PRE_ORDER){
            return preOrder();
        } else if (traversalOrder == TraversalOrder.IN_ORDER) {
            return inOrder();
        } else if (traversalOrder == TraversalOrder.POST_ORDER) {
            return postOrder();
        }else {
            return breadthFirstSearch();
        }
    }

    public boolean delete(Integer key){

        return false;
    }

    public void insert(KeyValue keyValue){
        if(root == null){
            root = new Element(keyValue, null, null, null);
        }else {
            Element current = root;
            Element parent = null;
            while (current != null && !current.keyValue.key.equals(keyValue.key)){
                parent = current;
                if(keyValue.key < parent.keyValue.key){
                    current = current.left;
                }
                else{
                    current = current.right;
                }
            }
            if(current == null){
                if(keyValue.key < parent.keyValue.key){
                    current = new Element(keyValue, parent, null, null);
                    parent.left = current;
                }else {
                    current = new Element(keyValue, parent, null, null);
                    parent.right = current;
                }

            }else {
                current.keyValue.value = keyValue.value;
            }
        }
    }

    public Integer minKey(){
        return getMinKeyElement().keyValue.key;
    }

    public Integer maxKey(){
        if(root == null){
            return null;
        }
        Element element = root;
        Element lastElement = root;
        while (element != null){
            if(element.right == null){
                lastElement = element;
            }
            element = element.right;
        }
        return lastElement.keyValue.key;
    }

    public KeyValue search(Integer key){
        if(root == null){
            return null;
        }
        Element element = root;
        while (element != null && !element.keyValue.key.equals(key)){
            if(key > element.keyValue.key){
                element = element.right;
            } else{
                element = element.left;
            }
        }
        return element.keyValue;
    }
}
