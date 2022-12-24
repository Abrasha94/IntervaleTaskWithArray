package ru.intervale.intervaletaskwitharray;

import org.junit.jupiter.api.Test;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class BenchmarkTest {

    private final IntervaleTask task = new IntervaleTask();

    final int[] args = IntStream.range(-500000, 500000).toArray();

    @Benchmark
    public void calculateWithCycle() {
        task.calculateWithCycle(args);
    }

    @Benchmark
    public void calculateWithOneStreamHardWay() {
        task.calculateWithOneStreamHardWay(args);
    }

    @Benchmark
    public void calculateWithOneStreamEasyWay() {
        task.calculateWithOneStreamEasyWay(args);
    }
    @Test
    public void runBenchmarks() throws Exception {
        Options opts = new OptionsBuilder()
                .include("\\." + this.getClass().getSimpleName() + "\\.")
                .warmupIterations(3)
                .measurementIterations(3)
                .forks(0)
                .threads(1)
                .shouldDoGC(true)
                .shouldFailOnError(true)
                .jvmArgs("-server")
                .build();

        new Runner(opts).run();
    }
}
