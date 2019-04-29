package ru.job4j.io.zip;

import ru.job4j.io.Search;
import java.io.*;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
/**
 *  Class Класс Zip
 *  @author Buryachenko
 *  @since 29.04.2019
 *  @version 1
 */
public class Zip {
    Args arguments;
    File source;
    File target;
    List<String> include;
    Search search = new Search();

    public Zip() {

    }

    public Zip(String[] args) {
        this.arguments = new Args(args);
        this.source = new File(this.arguments.directory());
        this.target = new File(this.arguments.output());
        this.include = arguments.include();
        System.out.println(arguments);
    }

    public void run() {
        pack(seekBy(this.source, this.include), this.target);
    }

    private List<File> seekBy(File source, List<String> exts) {
        return search.files(source.getAbsolutePath(), exts);
    }

    public void pack(File source, File target) {
        pack(List.of(source), target);
    }

    private void pack(List<File> filesInclude, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (File file : filesInclude) {
                zip.putNextEntry(new ZipEntry(file.getPath()));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(file))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Zip(args).run();
    }
}
