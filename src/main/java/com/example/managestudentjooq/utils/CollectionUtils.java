package com.example.managestudentjooq.utils;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectionUtils {

    public static <K, V> List<K> extractField(Collection<V> list , Function<V, K> fieldFunction){
            return list.stream()
                    .map(fieldFunction)
                    .filter(Objects::nonNull)
                    .distinct()
                    .collect(Collectors.toList());
    }
}
