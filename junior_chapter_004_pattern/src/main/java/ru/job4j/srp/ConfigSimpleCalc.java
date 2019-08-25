package ru.job4j.srp;

import java.util.HashMap;
import java.util.Map;
/**
 *  Class Класс конфигурвции простого калькулятора
 *  @author Buryachenko
 *  @since 25.08.2019
 *  @version 1
 */
public class ConfigSimpleCalc implements ConfigCalc {
    private Map<String, FunctionCalc> functions = new HashMap<>();
    private final Calculator calc = new Calculator();

    public ConfigSimpleCalc() {
        this.functions.put("+", new FunctionCalc((x, y)-> {calc.add(x, y); return this.calc.getResult();}, 2));
        this.functions.put("-", new FunctionCalc((x, y)-> {calc.subtract(x, y); return this.calc.getResult();}, 2));
        this.functions.put("*", new FunctionCalc((x, y)-> {calc.multiple(x, y); return this.calc.getResult();}, 2));
        this.functions.put("/", new FunctionCalc((x, y)-> {calc.div(x, y); return this.calc.getResult();}, 2));
    }
    @Override
    public Map<String, FunctionCalc> functions() {
        return this.functions;
    }
}
