package com.soprasteria.innersource.programming;

import lombok.extern.slf4j.Slf4j;

import java.util.function.BiFunction;

@Slf4j
public class Lab2 {

    public static void main(String[] args) {
        // BiFunction<String, Integer, Employee> EmployeeFactory = Employee::new; #Avantages d'une interface pour ne pas réécrire Bifunction à chaque fois
        EmployeeFactory employeeFactory = Employee::new;
        log.info("Employee 1: {}", employeeFactory.apply("Jean", 5000));
        log.info("Employee 1: {}", employeeFactory.apply("Marie", 62000));

        // Il est interdit de modifier les objets passé en paramètre
        SalaryIncrease salaryIncrease = (Employee employee, Integer amount) -> employee.getSalary() + amount;

        log.info("Augmentation dd 2000 -> {}",
                salaryIncrease.increase(employeeFactory.apply("Mireille",5000), 2000));

    }
}
