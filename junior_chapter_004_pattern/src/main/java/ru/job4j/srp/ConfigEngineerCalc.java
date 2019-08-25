package ru.job4j.srp;

/**
 *  Class Класс расширяет простой калькулятор
 *  @author Buryachenko
 *  @since 25.08.2019
 *  @version 1
 */
public class ConfigEngineerCalc  extends ConfigSimpleCalc {
    public ConfigEngineerCalc() {
        super();
        this.functions().put("sin", new FunctionCalc((x, y) -> Math.sin(x + y), 1));
        this.functions().put("cos", new FunctionCalc((x,y) -> Math.cos(x + y), 1));
        this.functions().put("tan", new FunctionCalc((x,y) -> Math.tan(x + y), 1));
    }
}
