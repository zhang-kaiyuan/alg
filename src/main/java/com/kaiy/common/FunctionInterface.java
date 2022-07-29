package com.kaiy.common;

@FunctionalInterface
public interface FunctionInterface<T, R> {
    R fun(T t);
}
