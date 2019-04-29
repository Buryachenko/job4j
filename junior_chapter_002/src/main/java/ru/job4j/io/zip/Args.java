package ru.job4j.io.zip;
import java.util.*;
/**
 *  Class Класс Args
 *  @author Buryachenko
 *  @since 29.04.2019
 *  @version 1
 */
public final class Args {

    private final Map<String, List<String>> options = new HashMap<>();

    public Args(String[] args) {
        this.options.put("-d", new ArrayList<>());
        this.options.put("-e", new ArrayList<>());
        this.options.put("-o", new ArrayList<>());
        load(Arrays.stream(args).iterator());
    }

    private void load(Iterator<String> args) {
        String arg = "";
        while (args.hasNext()) {
            arg = arg.isEmpty() ? args.next() : arg;
            for (String key : this.options.keySet()) {
                if (arg.equals(key)) {
                    while (args.hasNext() && !(arg = args.next()).startsWith("-")) {
                        this.options.get(key).add(arg);
                    }
                }
            }
        }
    }

    public String directory() {
        return this.options.get("-d").get(0);
    }

    public List<String> include() {
        return this.options.get("-e");
    }

    public String output() {
        return this.options.get("-o").get(0);
    }

    @Override
    public String toString() {
        return directory() + " " + include() + " " + output();
    }
}
