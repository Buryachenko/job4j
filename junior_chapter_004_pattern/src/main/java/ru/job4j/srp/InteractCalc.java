package ru.job4j.srp;
import java.util.Map;

/**
 *  Class Класс обеспечивает пользовательский ввод для калькулятора
 *  @author Buryachenko
 *  @since 25.08.2019
 *  @version 1
 */
public class InteractCalc {
    private String operation = "";
    private double result = 0.0;
    private int numberArgs = 2;
    private final Map<String, FunctionCalc> config;

    public InteractCalc(ConfigCalc config) {
        this.config = config.functions();
        printInfo();
    }

    public void execute(Input input, StartUI ui) {
        double arg = 0.0;
        try {
            if (numberArgs > 1) {
                arg = Double.parseDouble(input.ask("Enter arg :"));
            }
        } catch (NumberFormatException e) {
            System.out.println("Not available number.");
            return;
        }
        this.result = "".equals(this.operation) ? arg : this.config.get(this.operation).getFunction().apply(this.result, arg);
        repeatOperation(input, ui);
    }

    private void repeatOperation(Input input, StartUI ui) {
        this.operation = "";
        this.numberArgs = 2;
        while ("".equals(this.operation)) {
            this.operation = input.ask("Enter operation :");
            if ("=".equals(this.operation)) {
                System.out.println(this.result);
                this.operation = input.ask("Enter operation :");
            }
            if ("c".equals(this.operation)) {
                printInfo();
                this.result = 0.0;
                this.operation = "";
                break;
            }
            if ("e".equals(operation)) {
                ui.stop();
                break;
            }
            if (this.config.keySet().stream().anyMatch(this.operation :: equals)) {
                this.numberArgs = this.config.get(this.operation).numberArgs();
            } else {
                this.operation = "";
            }
        }
    }

    public void printInfo() {
        System.out.println( String.format("%s %s %s %s %s",
                "Simple calculation.",
                "All clean \"c\".",
                "Exit program \"e\".",
                "Available operations:",
                String.join(", ", this.config.keySet().toArray(new String[0])))
        );
    }
}
