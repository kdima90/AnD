package app.adt;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class IntegerArrayQueueTest {

    @Test
    void isEmptyShouldBeInitiallyBeEmpty() {
        IntegerArrayQueue integerArrayQueue = new IntegerArrayQueue(1);

        assertThat(integerArrayQueue.isEmpty()).isTrue();
    }

    @Test
    void isEmptyShouldBeTrueAfterEnqueueAndDequeue() {
        IntegerArrayQueue integerArrayQueue = new IntegerArrayQueue(1);

        assertThat(integerArrayQueue.isEmpty()).isTrue();

        integerArrayQueue.enqueue(1);
        integerArrayQueue.dequeue();

        assertThat(integerArrayQueue.isEmpty()).isTrue();
    }

    @Test
    void enqueueDequeueShouldWork() {
        IntegerArrayQueue integerArrayQueue = new IntegerArrayQueue(3);
        integerArrayQueue.enqueue(1);
        integerArrayQueue.enqueue(3);

        assertThat(integerArrayQueue.dequeue()).isEqualTo(1);

        integerArrayQueue.enqueue(12);

        assertThat(integerArrayQueue.dequeue()).isEqualTo(3);
    }
}