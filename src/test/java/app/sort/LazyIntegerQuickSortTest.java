package app.sort;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LazyIntegerQuickSortTest {

    @Test
    void lazyQuickSortShouldSort() {
        int[] sort = new LazyIntegerQuickSort().sort(
                new int[]{23, 4, 56, 38, 23, 8, 12, 93, 7, 15, 25, 13, 42, 76, 10});

        assertThat(sort).isSorted().isEqualTo(
                new int[]{4, 7, 8, 10, 12, 13, 15, 23, 23, 25, 38, 42, 56, 76, 93});

    }

    @Test
    void lazyQuickSortShouldSortWithTreeNumbers() {
        int[] sort = new LazyIntegerQuickSort().sort(new int[]{30, 10, 20});

        assertThat(sort).isSorted().isEqualTo(new int[]{10, 20, 30});
    }
}