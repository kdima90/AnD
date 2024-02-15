package app.adt;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class IntegerBinaryTreeTest {

    @Test
    void shouldInsertValues(){
        IntegerBinaryTree integerBinaryTree = new IntegerBinaryTree();
        integerBinaryTree.insert(new IntegerBinaryTree.KeyValue(15, 1));

        integerBinaryTree.insert(new IntegerBinaryTree.KeyValue(6, 2));
        integerBinaryTree.insert(new IntegerBinaryTree.KeyValue(18, 3));

        integerBinaryTree.insert(new IntegerBinaryTree.KeyValue(3, 4));
        integerBinaryTree.insert(new IntegerBinaryTree.KeyValue(7, 5));
        integerBinaryTree.insert(new IntegerBinaryTree.KeyValue(17, 6));
        integerBinaryTree.insert(new IntegerBinaryTree.KeyValue(20, 7));

        integerBinaryTree.insert(new IntegerBinaryTree.KeyValue(2, 8));
        integerBinaryTree.insert(new IntegerBinaryTree.KeyValue(4, 10));
        integerBinaryTree.insert(new IntegerBinaryTree.KeyValue(13, 11));

        integerBinaryTree.insert(new IntegerBinaryTree.KeyValue(9, 12));

    }

    @Test
    void shouldReturnMaxKey(){
        IntegerBinaryTree integerBinaryTree = new IntegerBinaryTree();
        integerBinaryTree.insert(new IntegerBinaryTree.KeyValue(15, 1));

        integerBinaryTree.insert(new IntegerBinaryTree.KeyValue(6, 2));
        integerBinaryTree.insert(new IntegerBinaryTree.KeyValue(18, 3));

        integerBinaryTree.insert(new IntegerBinaryTree.KeyValue(3, 4));
        integerBinaryTree.insert(new IntegerBinaryTree.KeyValue(7, 5));
        integerBinaryTree.insert(new IntegerBinaryTree.KeyValue(17, 6));
        integerBinaryTree.insert(new IntegerBinaryTree.KeyValue(20, 7));

        integerBinaryTree.insert(new IntegerBinaryTree.KeyValue(2, 8));
        integerBinaryTree.insert(new IntegerBinaryTree.KeyValue(4, 10));
        integerBinaryTree.insert(new IntegerBinaryTree.KeyValue(13, 11));

        integerBinaryTree.insert(new IntegerBinaryTree.KeyValue(9, 12));


        assertThat(integerBinaryTree.maxKey()).isEqualTo(20);
    }

    @Test
    void shouldReturnMinKey(){
        IntegerBinaryTree integerBinaryTree = new IntegerBinaryTree();
        integerBinaryTree.insert(new IntegerBinaryTree.KeyValue(15, 1));

        integerBinaryTree.insert(new IntegerBinaryTree.KeyValue(6, 2));
        integerBinaryTree.insert(new IntegerBinaryTree.KeyValue(18, 3));

        integerBinaryTree.insert(new IntegerBinaryTree.KeyValue(3, 4));
        integerBinaryTree.insert(new IntegerBinaryTree.KeyValue(7, 5));
        integerBinaryTree.insert(new IntegerBinaryTree.KeyValue(17, 6));
        integerBinaryTree.insert(new IntegerBinaryTree.KeyValue(20, 7));

        integerBinaryTree.insert(new IntegerBinaryTree.KeyValue(2, 8));
        integerBinaryTree.insert(new IntegerBinaryTree.KeyValue(4, 10));
        integerBinaryTree.insert(new IntegerBinaryTree.KeyValue(13, 11));

        integerBinaryTree.insert(new IntegerBinaryTree.KeyValue(9, 12));


        assertThat(integerBinaryTree.minKey()).isEqualTo(2);
    }

    @Test
    void shouldTraversalTreeWithPreOrder(){
        IntegerBinaryTree integerBinaryTree = new IntegerBinaryTree();
        integerBinaryTree.insert(new IntegerBinaryTree.KeyValue(15, 1));

        integerBinaryTree.insert(new IntegerBinaryTree.KeyValue(6, 2));
        integerBinaryTree.insert(new IntegerBinaryTree.KeyValue(18, 3));

        integerBinaryTree.insert(new IntegerBinaryTree.KeyValue(3, 4));
        integerBinaryTree.insert(new IntegerBinaryTree.KeyValue(7, 5));
        integerBinaryTree.insert(new IntegerBinaryTree.KeyValue(17, 6));
        integerBinaryTree.insert(new IntegerBinaryTree.KeyValue(20, 7));

        integerBinaryTree.insert(new IntegerBinaryTree.KeyValue(2, 8));
        integerBinaryTree.insert(new IntegerBinaryTree.KeyValue(4, 10));
        integerBinaryTree.insert(new IntegerBinaryTree.KeyValue(13, 11));

        integerBinaryTree.insert(new IntegerBinaryTree.KeyValue(9, 12));

        List<IntegerBinaryTree.KeyValue> keyValues = integerBinaryTree.traversalIntegerBinaryTree(IntegerBinaryTree.TraversalOrder.PRE_ORDER);

        List<Integer> expectedKeys = keyValues.stream().map(IntegerBinaryTree.KeyValue::getKey).collect(Collectors.toList());
        assertThat(expectedKeys).isEqualTo(Arrays.asList(15, 6, 3, 2, 4, 7, 13, 9, 18, 17, 20));
    }

    @Test
    void shouldTraversalTreeWithInOrder(){
        IntegerBinaryTree integerBinaryTree = new IntegerBinaryTree();
        integerBinaryTree.insert(new IntegerBinaryTree.KeyValue(15, 1));

        integerBinaryTree.insert(new IntegerBinaryTree.KeyValue(6, 2));
        integerBinaryTree.insert(new IntegerBinaryTree.KeyValue(18, 3));

        integerBinaryTree.insert(new IntegerBinaryTree.KeyValue(3, 4));
        integerBinaryTree.insert(new IntegerBinaryTree.KeyValue(7, 5));
        integerBinaryTree.insert(new IntegerBinaryTree.KeyValue(17, 6));
        integerBinaryTree.insert(new IntegerBinaryTree.KeyValue(20, 7));

        integerBinaryTree.insert(new IntegerBinaryTree.KeyValue(2, 8));
        integerBinaryTree.insert(new IntegerBinaryTree.KeyValue(4, 10));
        integerBinaryTree.insert(new IntegerBinaryTree.KeyValue(13, 11));

        integerBinaryTree.insert(new IntegerBinaryTree.KeyValue(9, 12));

        List<IntegerBinaryTree.KeyValue> keyValues = integerBinaryTree.traversalIntegerBinaryTree(IntegerBinaryTree.TraversalOrder.IN_ORDER);
        List<Integer> expectedKeys = keyValues.stream().map(IntegerBinaryTree.KeyValue::getKey).collect(Collectors.toList());

        assertThat(expectedKeys).isEqualTo(Arrays.asList(2, 3, 4, 6, 7, 9, 13, 15, 17, 18, 20));
    }

    @Test
    void shouldTraversalTreeWithPostOrder(){
        IntegerBinaryTree integerBinaryTree = new IntegerBinaryTree();
        integerBinaryTree.insert(new IntegerBinaryTree.KeyValue(15, 1));

        integerBinaryTree.insert(new IntegerBinaryTree.KeyValue(6, 2));
        integerBinaryTree.insert(new IntegerBinaryTree.KeyValue(18, 3));

        integerBinaryTree.insert(new IntegerBinaryTree.KeyValue(3, 4));
        integerBinaryTree.insert(new IntegerBinaryTree.KeyValue(7, 5));
        integerBinaryTree.insert(new IntegerBinaryTree.KeyValue(17, 6));
        integerBinaryTree.insert(new IntegerBinaryTree.KeyValue(20, 7));

        integerBinaryTree.insert(new IntegerBinaryTree.KeyValue(2, 8));
        integerBinaryTree.insert(new IntegerBinaryTree.KeyValue(4, 10));
        integerBinaryTree.insert(new IntegerBinaryTree.KeyValue(13, 11));

        integerBinaryTree.insert(new IntegerBinaryTree.KeyValue(9, 12));

        List<IntegerBinaryTree.KeyValue> keyValues = integerBinaryTree.traversalIntegerBinaryTree(IntegerBinaryTree.TraversalOrder.POST_ORDER);
        List<Integer> expectedKeys = keyValues.stream().map(IntegerBinaryTree.KeyValue::getKey).collect(Collectors.toList());

        assertThat(expectedKeys).isEqualTo(Arrays.asList(2, 4, 3, 9, 13, 7, 6, 17, 20, 18, 15));
    }

    @Test
    void shouldTraversalTreeWithBreadthFirstSearch(){
        IntegerBinaryTree integerBinaryTree = new IntegerBinaryTree();
        integerBinaryTree.insert(new IntegerBinaryTree.KeyValue(15, 1));

        integerBinaryTree.insert(new IntegerBinaryTree.KeyValue(6, 2));
        integerBinaryTree.insert(new IntegerBinaryTree.KeyValue(18, 3));

        integerBinaryTree.insert(new IntegerBinaryTree.KeyValue(3, 4));
        integerBinaryTree.insert(new IntegerBinaryTree.KeyValue(7, 5));
        integerBinaryTree.insert(new IntegerBinaryTree.KeyValue(17, 6));
        integerBinaryTree.insert(new IntegerBinaryTree.KeyValue(20, 7));

        integerBinaryTree.insert(new IntegerBinaryTree.KeyValue(2, 8));
        integerBinaryTree.insert(new IntegerBinaryTree.KeyValue(4, 10));
        integerBinaryTree.insert(new IntegerBinaryTree.KeyValue(13, 11));

        integerBinaryTree.insert(new IntegerBinaryTree.KeyValue(9, 12));

        List<IntegerBinaryTree.KeyValue> keyValues = integerBinaryTree.traversalIntegerBinaryTree(IntegerBinaryTree.TraversalOrder.BREADTH_FIRST_SEARCH);
        List<Integer> expectedKeys = keyValues.stream().map(IntegerBinaryTree.KeyValue::getKey).collect(Collectors.toList());

        assertThat(expectedKeys).isEqualTo(Arrays.asList(15, 6, 18, 3, 7, 17, 20, 2, 4, 13, 9));
    }
}