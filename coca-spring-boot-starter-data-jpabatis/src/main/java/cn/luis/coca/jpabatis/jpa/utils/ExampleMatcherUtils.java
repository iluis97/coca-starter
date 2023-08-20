package cn.luis.coca.jpabatis.jpa.utils;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

public class ExampleMatcherUtils {

    public static <T> Example<T> includeNullValuesOf(T probe) {
        return Example.of(probe, ExampleMatcher.matchingAll().withIncludeNullValues());
    }

    public static <T> Example<T> ignoreNullValuesOf(T probe) {
        return Example.of(probe, ExampleMatcher.matchingAll().withIgnoreNullValues());
    }

    public static <T> Example<T> matcher(T probe, ExampleMatcher exampleMatcher) {
        return Example.of(probe, exampleMatcher);
    }

}