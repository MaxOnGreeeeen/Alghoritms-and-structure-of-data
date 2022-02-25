package tpu.company;
import java.io.*;

public class InputReader {

    static String inString() throws IOException {

        byte b[] = new byte[100];
        System.in.read(b);
        String s = new String(b);
        try {
            s = s.trim();
        } catch (NumberFormatException ex) {
            System.err.println("Ошибка: нулевая строка");
        }
        return s;
    }

    static int inInt() throws IOException{
        byte b[] = new byte[100];
        System.in.read(b);
        String string = new String(b);
        int a = 0;
        try {
            string = string.trim();
            a = Integer.parseInt(string);
        } catch (NumberFormatException ex) {
            System.err.println("Ошибка: некорректное значение числа ");
        } catch (NullPointerException ex) {
            System.err.println("Ошибка: строка равняется нулю");
        }
        return a;
    }
}

