package app.adt;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class IntegerLinkedListTest {

    @Test
    void shouldAddValues() {
        IntegerLinkedList list = new IntegerLinkedList();
        list.add(1);
        list.add(2);
        list.add(42);
    }

    @Test
    void shouldFindFirstOccurrence(){
        IntegerLinkedList list = new IntegerLinkedList();

        assertThat(list.getFirst(22)).isNull();

        list.add(31);
        list.add(14);
        list.add(10);
        list.add(6);

        assertThat(31).isEqualTo(list.getFirst(31));
        assertThat(10).isEqualTo(list.getFirst(10));
        assertThat(6).isEqualTo(list.getFirst(6));

        assertThat(list.getFirst(2)).isNull();
    }

    @Test
    void shouldDeleteFirstFounded() {
        IntegerLinkedList list = new IntegerLinkedList();

        assertThat(list.deleteFirst(6)).isFalse();

        list.add(31);
        assertThat(list.deleteFirst(31)).isTrue();

        list.add(31);
        list.add(14);
        assertThat(list.deleteFirst(31)).isTrue();
        assertThat(list.deleteFirst(14)).isTrue();

        list.add(31);
        list.add(14);
        list.add(10);
        assertThat(list.deleteFirst(31)).isTrue();
        assertThat(list.deleteFirst(14)).isTrue();
        assertThat(list.deleteFirst(10)).isTrue();

        list.add(31);
        list.add(14);
        list.add(10);
        list.add(6);
        assertThat(list.deleteFirst(6)).isTrue();
        assertThat(list.deleteFirst(10)).isTrue();
        assertThat(list.deleteFirst(31)).isTrue();
        assertThat(list.deleteFirst(6)).isFalse();
        assertThat(list.deleteFirst(14)).isTrue();
        assertThat(list.deleteFirst(1)).isFalse();
        assertThat(list.deleteFirst(2)).isFalse();
        assertThat(list.deleteFirst(42)).isFalse();
        assertThat(list.deleteFirst(6)).isFalse();
    }

    @Test
    void shouldReturnZeroByEmptyList() {
        assertThat(new IntegerLinkedList().getSize()).isEqualTo(0);
    }
}