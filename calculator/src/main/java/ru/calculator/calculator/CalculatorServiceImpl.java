package ru.calculator.calculator;

import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {
    public int sum(int num1, int num2) {
        return num1 + num2;
    }

    public int sub(int num1, int num2) {
        return num1 - num2;
    }

    public int mul(int num1, int num2) {
        return num1 * num2;
    }

    public int div(int num1, int num2) {
        if (num2 == 0) {
            return 0;
        }

        return num1 / num2;
    }
}
