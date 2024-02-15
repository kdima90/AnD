package app.adt;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class IntegerArrayStackTest {
    @Test
    void isEmpty() {
        Assertions.assertThat(new IntegerArrayStack(3).isEmpty()).isTrue();
    }
    @Test
    void pushPop(){
        IntegerArrayStack integerArrayStack = new IntegerArrayStack(3);

        integerArrayStack.push(1);
        integerArrayStack.push(13);
        integerArrayStack.push(21);
        Assertions.assertThat(integerArrayStack.pop()).isEqualTo(21);
        Assertions.assertThat(integerArrayStack.pop()).isEqualTo(13);
        Assertions.assertThat(integerArrayStack.pop()).isEqualTo(1);
        integerArrayStack.push(124);
        Assertions.assertThat(integerArrayStack.pop()).isEqualTo(124);
    }
}