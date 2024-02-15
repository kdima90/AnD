package app.search;

import app.search.IntegerBinarySearch.Result;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class IntegerBinarySearchTest {

    @Test
    void binarySearchShouldReturnResult() {
        IntegerBinarySearch search = new IntegerBinarySearch();

        Result result = search.search(new int[]{1, 3, 4, 5, 6, 7, 11, 13, 25}, 6, true);

        assertThat(result).isNotNull();
        assertThat(result.getValue()).isEqualTo(6);
        assertThat(result.getPosition()).isEqualTo(4);

    }
    
    @Test
    void binarySearchShouldReturnResultAndSearchedValueIsFirst(){
        IntegerBinarySearch search = new IntegerBinarySearch();

        Result result = search.search(new int[]{1, 3, 4, 5, 6, 7, 11, 13, 25}, 1, true);

        assertThat(result).isNotNull();
        assertThat(result.getValue()).isEqualTo(1);
        assertThat(result.getPosition()).isEqualTo(0);
    }

    @Test
    void binarySearchShouldReturnResultAndSearchedValueIsLast(){
        IntegerBinarySearch search = new IntegerBinarySearch();

        Result result = search.search(new int[]{1, 3, 4, 5, 6, 7, 11, 13, 25}, 25, true);

        assertThat(result).isNotNull();
        assertThat(result.getValue()).isEqualTo(25);
        assertThat(result.getPosition()).isEqualTo(8);
    }

    @Test
    void binarySearchShouldReturnResultAndSearchedValueIsThird(){
        IntegerBinarySearch search = new IntegerBinarySearch();

        Result result = search.search(new int[]{1, 3, 4, 5, 6, 7, 11, 13, 25}, 4, true);

        assertThat(result).isNotNull();
        assertThat(result.getValue()).isEqualTo(4);
        assertThat(result.getPosition()).isEqualTo(2);
    }
}