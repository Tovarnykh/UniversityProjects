package com.example.unilabsoop;

import java.io.FileWriter;
import java.io.IOException;

public class MyFileWriter extends SuperFile {
    private boolean append = false;

    public MyFileWriter(String path) {
        this(path, false);
    }

    public MyFileWriter(String path, boolean append) {
        super(path);
        this.append = append;
    }

    public void write(String text) {
        try {
            FileWriter writer = new FileWriter(path, append);
            writer.write(text);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}