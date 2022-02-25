package tpu.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Solution {

    //private fields

    private String fileName = "C:\\Users\\User\\OneDrive\\Рабочий стол\\Алгоритмы и структуры данных";
    private long start;
    private long finish;
    private long elapsed;
    private  int[][] matrix;
    private boolean bool;
    private int n;
    private int m;
    private int[] first_vector;
    private int[] second_vector;
    private File file;

    public Solution(){

    }
    public String getFileName() {
        return fileName;
    }

    public boolean is_the_matrix_full(){
        return bool;
    }

    public void start(){
        this.start = System.nanoTime();
    }

    public void finish(){
        this.finish = System.nanoTime();
        this.elapsed = finish - start;
        System.out.println("Time passed: " + elapsed + " nanoseconds");
    }

    public Solution(File file,int length) {
        this.n = length;
        this.m = length;
        this.file = file;
        this.matrix = new int[length][length];
    }

    public void solve() throws IOException {

       // Scanner in = new Scanner(System.in);
        //System.out.println("Введите название файла отчёта: ");

        this.fileName += "Report1.txt";
        //this.fileName += in.nextLine() + ".txt";
        if (!is_the_matrix_full()) fill_the_matrix();
        int number = 3;

        show_description();
        System.out.println("Введите номер задания: ");
        try{
            switch (number){
                case 1:
                    first_exercise();
                    break;
                case 2:
                    second_exercise();
                    break;
                case 3:
                    fill_the_vector();
                    third_exercise();
                    break;
                default:
                    break;
            }
        }catch (InputMismatchException ex){
            System.err.println("Введено неверное значение" + ex.getMessage());
        }
    }

   public Solution(int length1, int length2){
        this.n = length1;
        this.m = length2;
        matrix = new int[n][m];
    }

    public void show_description(){
        System.out.println("\n"+ "1.Найти сумму элементов" +
                " главной  диагонали  квадратной  матрицы  и сравнить с \n" +
                "суммой элементов первой строки.\n" + "2." + "Найти  местоположение " +
                "(номер  строки  и  столбца)  второго  по  величине  \n" +
                "максимального  элемента  матрицы(M*N).\n" +
                "3." + "По вектору С ( С1, ... , Сn ) получить вектор Х ( Х1, ... " +
                ", Хn ) по правилу :     Х1=С1; " +
                "Х2=С3;  ...  ;  Х(n/2)=С(n\n" + "-" + "1),  Х(n/2+1)=Сn,  Х(n/2+2)=С(n" +
                "-" + "2),  ...  ,  Хn=С Первая \n" + "половина " +
                "-"  + "нечетные , вторая " + "-" + " " + "четные элементы исходного в обратном порядке. \n" +
                "Если размерность C " + "-" + " " + "нечетная, то середина : C( trunc(n/2)) \n"

        );
    }

    public void first_exercise() throws IOException{
        start();
        boolean first_element_is_bigger = false;
        boolean second_element_is_bigger = false;
        boolean elements_are_equal = false;
        int iterations = 0;
        int sum = 0;
        int sum2 = 0;
        int counter = 0;
        for( int i = 0 ; i < n; i ++ ){
            counter++;
            sum += matrix[i][i];
            sum2 += matrix[0][i];
            iterations+= 2;

        }
        iterations+=3;
        if ( sum > sum2){ first_element_is_bigger = true;
        }else if(sum2 > sum) { second_element_is_bigger = true;
        }else { elements_are_equal = true;}
        finish();
        Safer safer = new Safer(file,start,finish,elapsed,iterations,n);
        safer.safer();
    }
    public void second_exercise(){
        start();
        int iterations = 0;
        int i_index = 0;
        int j_index = 0;
        int needed_element;
        int max_value = -1000;

        int new_length = n*m;
        int[] max_values = new int[new_length];
        int[] i_indexes = new int[new_length];
        int[] j_indexes = new int[new_length];
        iterations += 3;
        int counter  = 0;
        for ( int i = 0; i < n; i++){
            for (int j = 0; j < m; j ++){
                iterations++;
                if (matrix[i][j] > max_value){
                    iterations++;
                    counter ++;
                    i_index = i;
                    j_index = j;
                    max_value = matrix[i][j];
                    max_values[counter] = matrix[i][j];
                    i_indexes[counter] = i_index;
                    j_indexes[counter] = j_index;
                }
            }
        }
        // finally
        try{
            int second_max_value = max_values[counter - 1];
            int second_i_index = i_indexes[ counter - 1 ];
            int second_j_index = j_indexes[counter - 1];
            //second_prog_is_done
            finish();
            System.out.println("Второй максимальный элемент = " + second_max_value +
                    " Находится в строке " + second_i_index + " В столбце " + second_j_index);
            System.out.println(iterations);
            Safer safer = new Safer(file,start,finish,elapsed,iterations,n);
            safer.safer();
        }catch (IndexOutOfBoundsException ex){
            System.err.println("You're lucky or there are" +
                    "only one max element! " + ex.getMessage());
            throw ex;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void third_exercise() throws IOException{
        start();
        int iterations = 0;
        int average = Math.round(n/2);
        iterations+=2;
        int[] second_vector = new int[n];
        for(int i = 0; i < average; i++){
            second_vector[i] = first_vector[i*2];
            iterations++;
        }
        int counter = n;
        for ( int i = average + 1 ; i < n; i++){
            second_vector[i] = first_vector[counter - 2];
            iterations+=2;
            counter -= 2;
        }
        finish();
        System.out.println("ПОлученный вектор: " +Arrays.toString(second_vector)+
                "\n"+ Arrays.toString(first_vector));
        Safer safer = new Safer(file,start,finish,elapsed,iterations,n);
        safer.safer();
    }

    public void fill_the_matrix(){
        this.bool = true;
        for (int i = 0; i < n ; i++){
            for( int j = 0; j < m ; j++ ){
                matrix[i][j] = getRandomNumber(-100,100);
            }
        }
    }
    public void fill_the_vector(){
        first_vector = new int[n];
        for( int i = 0; i < n; i ++ ){
            first_vector[i] = getRandomNumber(-100,100);
        }
    }

    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
