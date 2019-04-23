package ru.job4j.io;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Search {
    public List<File> files(String parent, List<String> exts) {
        List<File> result = new ArrayList<>();
        Queue<File> queue = new LinkedList<>();
        queue.offer(new File(parent));
        while (!queue.isEmpty()) {
            File[] children = queue.poll().listFiles();
            for (File child : children) {
                if (child.isDirectory()) {
                    queue.offer(child);
                } else {
                    for (String ext : exts) {
                        if (child.getName().endsWith(ext)) {
                            result.add(child);
                        }
                    }
                }
            }
        }
        return result;
    }
}
