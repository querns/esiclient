package gbsio.esiclient.internal.util;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;

import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class ImmutableListCollector<T> implements Collector<T, ImmutableList.Builder<T>, ImmutableList<T>> {
    @Override
    public Supplier<ImmutableList.Builder<T>> supplier() {
        return ImmutableList::builder;
    }

    @Override
    public BiConsumer<ImmutableList.Builder<T>, T> accumulator() {
        return ImmutableList.Builder::add;
    }

    @Override
    public BinaryOperator<ImmutableList.Builder<T>> combiner() {
        return (tBuilder, tBuilder2) -> tBuilder.addAll(tBuilder2.build());
    }

    @Override
    public Function<ImmutableList.Builder<T>, ImmutableList<T>> finisher() {
        return ImmutableList.Builder::build;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return ImmutableSet.of();
    }
}
