package ru.calculator.calculator;

import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping
    public String CalculatorGreeting() {
        return "Добро пожаловать в калькулятор";
    }

    @GetMapping(path = "/plus")
    public String CalculatorSum(@RequestParam("num1") int num1, @RequestParam("num2") int num2) {
        return num1 + " + " + num2 + " = " + calculatorService.sum(num1, num2);
    }

    @GetMapping(path = "/minus")
    public String CalculatorSub(@RequestParam("num1") int num1, @RequestParam("num2") int num2) {
        return num1 + " - " + num2 + " = " + calculatorService.sub(num1, num2);
    }

    @GetMapping(path = "/multiply")
    public String CalculatorMul(@RequestParam("num1") int num1, @RequestParam("num2") int num2) {
        return num1 + " * " + num2 + " = " + calculatorService.mul(num1, num2);
    }

    @GetMapping(path = "/divide")
    public String CalculatorDiv(@RequestParam("num1") int num1, @RequestParam("num2") int num2) {
        return num1 + " / " + num2 + " = " + calculatorService.div(num1, num2);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public String handleMissingParams(MissingServletRequestParameterException ex) {
        return (ex.getParameterName() + " is missing");
    }
}
