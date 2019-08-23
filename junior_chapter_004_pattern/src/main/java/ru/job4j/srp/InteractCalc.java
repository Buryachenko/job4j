package ru.job4j.srp;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;

public class InteractCalc {
    private String operation = "+";
    private double result = 0.0;
    private Map<String, BinaryOperator<Double>> functions = new HashMap<>();
    private Calculator calc = new Calculator();

    public InteractCalc() {
        this.functions.put("+", (x, y)-> {this.calc.add(x, y); return this.calc.getResult();});
        this.functions.put("-", (x, y)-> {this.calc.subtract(x, y); return this.calc.getResult();});
        this.functions.put("*", (x, y)-> {this.calc.multiple(x, y); return this.calc.getResult();});
        this.functions.put("/", (x, y)-> {this.calc.div(x, y); return this.calc.getResult();});
        printInfo();
    }

    public InteractCalc(Map<String, BinaryOperator<Double>> functions) {
        this.functions = functions;
    }

    public void execute(Input input, StartUI ui) {
        double arg = 0.0;
        try {
            arg = Double.parseDouble(input.ask("Enter arg :"));
        } catch (NumberFormatException e) {
            System.out.println("Not available number.");
            return;
        }
        this.result = this.functions.get(this.operation).apply(this.result, arg);
        repeatOperation(input, ui);
    }

    private void repeatOperation(Input input, StartUI ui) {
        this.operation = "";
        while (!this.functions.keySet().stream().anyMatch(ch -> ch.equals(this.operation)) ) {
            this.operation = input.ask("Enter operation :");
            if ("=".equals(this.operation)) {
                System.out.println(this.result);
                this.operation = input.ask("Enter operation :");
            }
            if ("c".equals(this.operation)) {
                printInfo();
                this.result = 0.0;
                this.operation = "+";
                break;
            }
            if ("e".equals(operation)) {
                ui.stop();
                break;
            }
        }
    }

    public void addFunction(String name, BinaryOperator<Double> function) {
        this.functions.put(name, function);
    }

    public void printInfo() {
        System.out.println( String.format("%s %s %s %s",
                "Simple calculation. Available operations:",
                                "\"+\", \"-\", \"*\", \"/\", \"=\".",
                                "All clean \"c\".",
                                "Exit program \"e\".")
        );
    }
}
