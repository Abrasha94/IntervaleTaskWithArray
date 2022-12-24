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

    public Integer[] calculateWithOneStreamHardWay(int[] args) {

        if (args == null || args.length == 0) {
            return new Integer[]{};
        }

        final ArrayList<Integer> arrayListForSupplier = new ArrayList<>();
        arrayListForSupplier.add(0);
        arrayListForSupplier.add(0);

        final List<Integer> resultList = Arrays.stream(args)
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

    public int[] calculateWithOneStreamEasyWay(int[] args) {

        if (args == null || args.length == 0) {
            return new int[]{};
        }

        int[] result = new int[2];

        final int sum = Arrays.stream(args).map(
                value -> {
                    if (value > 0) {
                        result[0] = result[0] + 1;
                        return 0;
                    } else {
                        return value;
                    }
                }
        ).sum();
        result[1] = sum;
        return result;
    }
}
