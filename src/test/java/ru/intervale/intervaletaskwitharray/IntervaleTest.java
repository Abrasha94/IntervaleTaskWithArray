package ru.intervale.intervaletaskwitharray;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class IntervaleTest {

    private final IntervaleTask task = new IntervaleTask();

    int[] args = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -11, -12, -13, -14, -15};
    int[] expectedResult = {10, -65};
    int[] secondArgs = {0, 2, 3, 0, 5, 6, 7, 8, 9, 10, -11, -12, -13, -14};
    int[] secondExpectedResult = {8, -50};

    @Test
    public void testCycle() {

        final int[] result = task.calculateWithCycle(args);
        final int[] secondResult = task.calculateWithCycle(secondArgs);
        final int[] emptyResult = task.calculateWithCycle(null);
        final int[] secondEmptyResult = task.calculateWithCycle(new int[]{});

        assertThat(result).isEqualTo(expectedResult);
        assertThat(secondResult).isEqualTo(secondExpectedResult);
        assertThat(emptyResult).isEqualTo(new int[]{});
        assertThat(secondEmptyResult).isEqualTo(new int[]{});
    }

    @Test
    public void testTwoStreams() {

        final int[] result = task.calculateWithTwoStreams(args);
        final int[] secondResult = task.calculateWithTwoStreams(secondArgs);

        assertThat(result).isEqualTo(expectedResult);
        assertThat(secondResult).isEqualTo(secondExpectedResult);
    }

    @Test
    public void testOneStream() {
        final Integer[] result = task.calculateWithOneStream(args);
        final Integer[] secondResult = task.calculateWithOneStream(secondArgs);

        assertThat(result).isEqualTo(new Integer[]{10, -65});
        assertThat(secondResult).isEqualTo(new Integer[]{8, -50});
    }
}
