package tpu.company;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    //for the first two bunch of data
    public static int[] test_data = new int[]{500,1000,1500,
            2000,2500,3000,3500,4000, 4500};
    public void groupMethod(){

    }
    public static void delete(String path){
        try {
            FileWriter fstream1 = new FileWriter(path);// конструктор с одним параметром - для перезаписи
            BufferedWriter out1 = new BufferedWriter(fstream1); //  создаём буферезированный поток
            out1.write(""); // очищаем, перезаписав поверх пустую строку
            out1.close(); // закрываем
        } catch (Exception e)
        {System.err.println("Error in file cleaning: " + e.getMessage());}

    }
    //for the last point
    public static int[] test_data1 = new int[]{5000,10000,
            15000,20000, 25000,30000,35000,40000,45000};

        public static int getRandomNumber(int min, int max) {
            return (int) ((Math.random() * (max - min)) + min);
        }

    //main method
    public static void main(String[] args) throws IOException {


        String fileName1 = "C:\\Users\\User\\OneDrive\\Рабочий стол\\" +
                "Алгоритмы и структуры данных\\Lab4File1.txt";
        String fileName2 = "C:\\Users\\User\\OneDrive\\Рабочий стол\\" +
                "Алгоритмы и структуры данных\\Lab4File2.txt";
        String fileName3 = "C:\\Users\\User\\OneDrive\\Рабочий стол\\" +
                "Алгоритмы и структуры данных\\Lab4File3.txt";
        String fileName4 = "C:\\Users\\User\\OneDrive\\Рабочий стол\\" +
                "Алгоритмы и структуры данных\\Lab4File4.txt";

        //create a files
        File file1 = new File(fileName1);
        File file2 = new File(fileName2);
        File file3 = new File(fileName3);
        File file4 = new File(fileName4);

        Scanner in = new Scanner(System.in);
        System.out.println("Input a number:" + "\n" + " 1 - remove last data from file and complete the program " +
                "\n" + " -1 - update file with a new data and complete the program" );
        switch (in.nextInt()){
            case 1:
                delete(fileName1);
                delete(fileName2);
                delete(fileName3);
                break;
            case -1:
                System.out.println("Выход из программы...");
                break;
            default:
                break;
        }

        for (int data : test_data) {
            Solution solution = new Solution(data, file1,
                    file2, file3);
            if (data ==  4500) solution.setTheOperationLast(true);
            //first method

            for ( int i = 0; i < 50; i++){
                solution.setSearchedElement(getRandomNumber(-100,100));
                solution.setIteration(i);
                solution.linearSearch();
            }
        }
        for (int data : test_data) {
            Solution solution = new Solution(data + 1, file1,
                    file2, file3);
            if (data ==  4500) solution.setTheOperationLast(true);
            //first method
            for ( int i = 0; i < 50; i++){
                solution.setSearchedElement(getRandomNumber(-100,100));
                solution.setIteration(i);
                solution.fastLinearSearch();
            }
        }
        for (int data : test_data) {
            Solution solution = new Solution(data, file1,
                    file2, file3);
            if (data ==  4500) solution.setTheOperationLast(true);
            //first method
            for ( int i = 0; i < 50; i++){
                solution.setSearchedElement(getRandomNumber(-100,100));
                solution.setIteration(i);
                solution.secondfastlinearSearch();
            }
        }
        for (int data : test_data) {
            Solution solution = new Solution(data, file1,
                    file2, file3);
            if (data ==  4500) solution.setTheOperationLast(true);
            //first method
            for ( int i = 0; i < 50; i++){
                solution.setSearchedElement(getRandomNumber(-100,100));
                solution.setIteration(i);
                solution.binarySearch();
            }
        }
        for (int data : test_data) {
            Solution solution = new Solution(data, file1,
                    file2, file3);
            if (data ==  4500) solution.setTheOperationLast(true);
            //first method
            for ( int i = 0; i < 50; i++){
                solution.setSearchedElement(getRandomNumber(-100,100));
                solution.setIteration(i);
                solution.solve();
            }
        }


    }
}
