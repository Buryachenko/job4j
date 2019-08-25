package ru.job4j.srp;

import java.util.function.BinaryOperator;
/**
 *  Class Класс функции в калькуляторе
 *  @author Buryachenko
 *  @since 25.08.2019
 *  @version 1
 */
public class FunctionCalc {
    private final int numberArgs;
    private final BinaryOperator<Double> function;
    public FunctionCalc(BinaryOperator<Double> function, int numberArgs) {
        this.function = function;
        this.numberArgs = numberArgs;
    }
    public BinaryOperator<Double> getFunction() {
        return this.function;
    }
    public int numberArgs() {
        return numberArgs;
    }
}
