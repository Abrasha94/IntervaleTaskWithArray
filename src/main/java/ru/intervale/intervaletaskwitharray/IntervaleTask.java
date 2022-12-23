package ru.intervale.intervaletaskwitharray;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class IntervaleTask {

    public int[] calculateWithCycle(int[] args) {

        if (args == null || args.length == 0) {
            return new int[]{};
        }

        int positiveCount = 0;
        int negativeSum = 0;

        for (int i : args) {

            if (i > 0) {
                positiveCount++;
            } else if (i < 0) {
                negativeSum += i;
            }
        }

        return new int[]{positiveCount, negativeSum};
    }

    public int[] calculateWithTwoStreams(int[] args) {

        if (args == null || args.length == 0) {
            return new int[]{};
        }

        final int positiveCount = Math.toIntExact(Arrays.stream(args).filter(value -> value > 0).count());
        final int negativeSum = Arrays.stream(args).filter(value -> value < 0).sum();

        return new int[]{positiveCount, negativeSum};
    }

    public Integer[] calculateWithOneStream(int[] args) {

        if (args == null || args.length == 0) {
            return new Integer[]{};
        }

        final ArrayList<Integer> arrayListForSupplier = new ArrayList<>();
        arrayListForSupplier.add(0);
        arrayListForSupplier.add(0);

        final List<Integer> resultList = Arrays.stream(args).filter(value -> value != 0)
                .collect(() -> arrayListForSupplier,
                        (list, value) -> {
                            if (value > 0) {
                                Integer positiveCount = list.get(0);
                                list.set(0, ++positiveCount);
                            } else if (value < 0) {
                                Integer negativeSum = list.get(1);
                                negativeSum += value;
                                list.set(1, negativeSum);
                            }
                        },
                        (list1, list2) -> {
                            list1.set(0, list2.get(0));
                            list1.set(1, list2.get(1));
                        });

        Integer[] resultArray = new Integer[resultList.size()];
        return resultList.toArray(resultArray);
    }
}
