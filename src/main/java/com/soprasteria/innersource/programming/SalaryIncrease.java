package com.soprasteria.innersource.programming;

@FunctionalInterface
public interface SalaryIncrease {
    Integer increase(Employee employee, Integer amount);
}
