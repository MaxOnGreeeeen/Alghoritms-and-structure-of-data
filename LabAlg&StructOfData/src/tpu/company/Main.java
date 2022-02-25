package tpu.company;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class Main {

    //method for defining the amount of words in line
    public static int amountOfWords(String string){
        int counter = 0;
        String[] string1 = new String[string.length()];

        for ( String stringer : string.split(" ")){
            if (!stringer.equals('—')){
                string1[counter] = stringer;
                counter++;
            }
        }return counter;
    }

    public static void main(String[] args) throws IOException {

        String nameOfFile= "C:\\Users\\User\\OneDrive\\Рабочий стол\\Алгоритмы и структуры данных\\";
        System.out.println("Enter the name of FILE:");
        //the name of source file
        nameOfFile = nameOfFile + InputReader.inString() + ".txt";

        String nameOfFile1 = nameOfFile.substring(0, nameOfFile.length() - 4 ) + 1 + ".txt";
        System.out.println(nameOfFile1);

        //there is a moment when when the program get started
        Reader reader = new Reader( nameOfFile);
        String[] strokes = reader.readFile();
        System.out.println("Содержимое файла :");
        int length = strokes.length;
        //creation of stacks
        Stack stack1 = new Stack(length);
        Stack stack2 = new Stack(length);
        Stack stack3 = new Stack(length);

        for (String stroke : strokes) { //filling the stacks
            stack1.push(stroke.substring(0,stroke.length() - 1 ));//strings
            stack2.push(stroke.length());//lengths
            stack3.push(amountOfWords(stroke));//amount of words
        }
        for(int i = 0; i < strokes.length; i++)//print the information
            System.out.println(stack1.pop() + " " + stack2.pop() + " " + stack3.pop());
        //verify if stacks are empty or not
        System.out.println("Is the stack1 empty?" + " " +
                stack1.isEmpty());
        System.out.println("Is the stack2 empty?" + " " +
                stack2.isEmpty());
        System.out.println("Is the stack3 empty?" + " " +
                stack3.isEmpty());
    }
}
