package app.adt;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class IntegerDictionaryTest {

    @Test
    void insertAndFindShouldWorkWhenLinearProbingIsTrue() {
        IntegerDictionary integerDictionary = new IntegerDictionary(true);
        integerDictionary.insert(0);
        integerDictionary.insert(1);
        integerDictionary.insert(1);
        integerDictionary.insert(1);
        integerDictionary.insert(2);
        integerDictionary.insert(2);

        assertThat(integerDictionary.find(11)).isFalse();
        assertThat(integerDictionary.find(0)).isTrue();
        assertThat(integerDictionary.find(1)).isTrue();
        assertThat(integerDictionary.find(2)).isTrue();
    }

    @Test
    void insertAndFindShouldWorkWhenLinearProbingIsFalse() {
        IntegerDictionary integerDictionary = new IntegerDictionary(false);
        integerDictionary.insert(0);
        integerDictionary.insert(1);
        integerDictionary.insert(1);
        integerDictionary.insert(1);
        integerDictionary.insert(2);
        integerDictionary.insert(2);

        assertThat(integerDictionary.find(11)).isFalse();
        assertThat(integerDictionary.find(0)).isTrue();
        assertThat(integerDictionary.find(1)).isTrue();
        assertThat(integerDictionary.find(2)).isTrue();
    }
}