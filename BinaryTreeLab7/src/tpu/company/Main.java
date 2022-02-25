package tpu.company;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {

        //////////////////////////////////////////////////
        ArrayList<Integer> arrayList = new ArrayList<>();//создаем дерево
        BinaryTree binaryTree = new BinaryTree();//создаем список
        Time time = new Time();
        String filename = "C:\\Users\\User\\OneDrive\\Рабочий стол\\Алгоритмы и структуры данных\\";
        Scanner scan = new Scanner(System.in);

        System.out.println("Inter the source of text => ");
        filename = filename + scan.nextLine() + ".txt";

        Reader reader = new Reader(filename);
        String[] lines = reader.readFile();
 ;
        int value;
        for (String string : lines) {
            System.out.println(string);
            String[] newString = string.split(" ");
        try {
            for (int i = 0; i < newString.length; i++) {
                int value1 = Integer.parseInt(newString[i]);
                System.out.println(value1);
                binaryTree.insert(value1);
                arrayList.add(value1);
            }
        }catch (NumberFormatException ex){
            System.out.println("Неверный тип данных "
                    + ex.getMessage());
            throw ex;
        }
        }
        //inorder обход дерева

        System.out.println("\n");
        System.out.println("Прямой обход дерева\n ");
        binaryTree.inOrder(binaryTree);
        System.out.println("\n");
        /////////////////////////////
        //Обратный обход дерева

        System.out.println("\n");
        System.out.println("Обратный обход дерева\n ");
        binaryTree.postOrder(binaryTree);
        System.out.println("\n");
        boolean brek = false;
        while (!brek) {
            System.out.print("Enter first letter of show, ");
            System.out.print("insert, find, delete, or traverse or press \"x\" : ");
            int choice = getChar();
            switch (choice) {
                case 's':
                    binaryTree.displayTree();
                    break;
                case 'i':
                    System.out.print("Enter value to insert: ");
                    value = getInt();binaryTree.insert(value);
                    break;
                case 'f':
                    System.out.print("Enter value to find: ");
                    value = getInt();System.out.println("Time for linear search ");
                    linearSearch(time,arrayList,value);
                    System.out.println("Time for binary tree search ");
                    Node found = binaryTree.find(time,value);
                    System.out.print("\n");
                    break;
                case 'x':
                    System.err.println("The program is done successfully!");
                    brek  = true;
                    break;

            }
        }
    }

        public static String getString() throws IOException {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            return br.readLine();
        }

        public static char getChar() throws IOException {
            String s = getString();
            return s.charAt(0);
        }

        public static int getInt() throws IOException {
            String s = getString();
            return Integer.parseInt(s);
        }

        public static byte[] convertToByte( String string){
            return string.getBytes(StandardCharsets.US_ASCII);
        }
        public static String decoder(){return "";}

        public static boolean linearSearch(Time time, ArrayList<Integer> arrayList , Integer searchedElement){
        time.start();
            boolean found = false;
            for (int i = 0; i < arrayList.size(); i ++ ){
                if (arrayList.get(i).equals(searchedElement)){
                    System.out.println("The element was foound in " +
                            i + " position");
                    time.finish();
                    return true;
                }
            }if (!found) System.out.println("The element was not found ");
         time.finish();
            return false;

        }
}
