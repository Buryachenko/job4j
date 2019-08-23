package ru.job4j.srp;
import java.util.Map;
import java.util.function.Consumer;

/**
 *  Class Класс точка входа в программу.
 *  @author Buryachenko
 *  @since 22.08.2019
 *  @version 1
 */
public class StartUI {
    private boolean exit = true;

    private final Input input;
    private final Consumer<String> output;
    private final InteractCalc calc;
    public StartUI(Input input, InteractCalc calc, Consumer<String> output) {
        this.input = input;
        this.calc = calc;
        this.output = output;
    }

    public void init() {
        do {
            calc.execute(this.input, this);
        } while (this.exit);
    }

    public void stop() {
        this.exit = false;
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        new StartUI(
                new ConsoleInput(),
                new InteractCalc(Map.of("+", (x, y)-> {calc.add(x, y); return calc.getResult();})),
                System.out :: println
        ).init();
    }
}
