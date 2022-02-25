package tpu.company;

import java.io.*;

public class Reader {
    //private fields
    private String name;
    private String description;

    Reader(String name, String description){
        this.name = name;
        this.description = description;
    }

    public String[] readFile() throws IOException {
        System.out.println(description);
        FileInputStream fileInputStream;
        try{ fileInputStream = new FileInputStream(name);
        }catch (FileNotFoundException exception){
            System.err.println("File not found");
            throw exception;
        }
        byte[] b = new byte[fileInputStream.available()];
        fileInputStream.read(b);
        String str = new String(b, "UTF-8");
        str = str.trim();
        String[] strokes = str.split("\n");
        //return statement
        return strokes;
    }
}
