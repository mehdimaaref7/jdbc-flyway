package com.soprasteria.innersource.programming;

import java.util.function.BiFunction;

@FunctionalInterface
public interface EmployeeFactory extends BiFunction<String, Integer, Employee> {
}
