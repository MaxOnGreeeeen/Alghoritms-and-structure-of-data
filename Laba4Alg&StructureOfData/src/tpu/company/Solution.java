package tpu.company;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import static java.lang.Math.round;

public class Solution {
    private long start;
    private long elapsed; private int[] array;
    private int length; private boolean isTheVectorFull = false;
    private int searchedElement;private File file;
    private int average = 0;
    private File file1; private File file2;
    private  int[] iterationsArray = new int[50];
    private int max = 0;
    private int iteration = 0;
    private int counter = 0;
    private boolean isTheOperationLast = false;

    public void setTheOperationLast(boolean theOperationLast) {
        isTheOperationLast = theOperationLast;
    }

    public void setIteration(int iteration) {
        this.iteration = iteration;
    }

    public void setSearchedElement(int searchedElement) {
        this.searchedElement = searchedElement;
    }

    Solution(int length, File file,
             File file1, File file2){
        this.length = length;
        this.array = new int[length];
        this.file = file;
        this.file1 = file1;
        this.file2 = file2;
    }
    public void searchOfAverage(){
        int sum = 0;
        for (int i = 0; i < 50; i ++){
            sum += iterationsArray[i];
        }
        average = round(sum / 50);
    }
    public void searchOfMax(){
        int maximum = -1000000000;
        for (int i = 0; i < 50; i ++){
            if (iterationsArray[i] > maximum ) maximum = iterationsArray[i];
        }
        max = maximum;
    }
    public void start(){ this.start = System.nanoTime(); }

    public void finish(){
        long finish = System.nanoTime();
        this.elapsed = finish - start;
    }
    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public void fillTheVector(){

        for( int i = 0; i < length-1; i ++ ) array[i] = getRandomNumber(-100, 100);
        isTheVectorFull = true;
    }

    public void fillTheSortedVector(){
        if ( !isTheVectorFull) fillTheVector();
        Arrays.sort(array);
    }
    public void safer () throws IOException {
        searchOfAverage();
        searchOfMax();
        Safe safe = new Safe(elapsed, average, max, isTheOperationLast);
        safe.saferOfFirstFile(file);
        safe.saferOfSecondFile(file1);
    }

    //first method
    public  boolean linearSearch() throws IOException {
        if (!isTheVectorFull) fillTheVector();

        start();
        int iterations = 0;
        for ( int i = 0; i < length; i++){
            if (array[i] == searchedElement){
                end(iterations);
                return true; }
            iterations++;
        }
        finish();
        if ( this.iteration == 49) safer();
        return false;
    }
    public boolean fastLinearSearch() throws IOException {
        if (!isTheVectorFull) fillTheVector(); start();
        array[length - 1] = searchedElement;
        int i = 0;
        int iterations = 0;
        while (array[i] !=searchedElement) {
            i++;
            iterations++;
        }
        end(iterations);
        if (i!= length -1){
            finish();
            return true;}
        finish();
        if ( this.iteration == 49) safer();
        return false;

    }
    public boolean secondfastlinearSearch() throws IOException {
        if (!isTheVectorFull) fillTheSortedVector(); start();
        int i = 0;
        int iterations = 0;
        while ( array[i] <= searchedElement){
            if ( array[i] == searchedElement) {
                break; }
            i++;
            iterations++; }
        end(iterations);
        if (i!= length -1){
            finish();
            return true;}
        finish();
        if(this.iteration == 49) safer();
        return false;
    }

    public  boolean binarySearch() throws IOException {
        if (!isTheVectorFull) fillTheSortedVector(); start();
        int first = 0;
        int item = searchedElement;
        int last = array.length - 1;
        int position;
        int iterations = 0;
        position = (first + last) / 2;

        while ((array[position] != item) && (first <= last)) {
            if (array[position] > item) {
                last = position - 1;
            } else {
                first = position + 1;
            }iterations++;
            position = (first + last) / 2;
        }
        end(iterations);
        if (first > last) return false;
        else return true;
    }
    public boolean newlinearSearch(int[] newArray, int searchedElement, int iterations) throws IOException {
        for( int i = 0; i < newArray.length; i++){
            if( newArray[i] == searchedElement){
                end(iterations);
                return true;
            }
            iterations++;
        }
        return false;
    }
   public void solve() throws IOException {
        blockSearch(array, 0);
    }
    public void end(int iterations) throws IOException {
        finish();iterationsArray[counter] = iterations;
        ++counter;if ( this.iteration == 49) {
            safer();
        }
    }
    public boolean blockSearch(int [] array, int iterations) throws IOException {
        if (!isTheVectorFull) fillTheSortedVector(); start();
        int div = 4;
        int int_amount = array.length / div;
        int rem = array.length % div;
        if (int_amount == 0) {
            return newlinearSearch(array, searchedElement, iterations);
        }
        for (int i = 0; i < div; i++) {
            if (array[int_amount * i + int_amount - 1] == searchedElement ){
                iterations++;
                end(iterations);
                return true;
            }
            if (array[int_amount * i + int_amount - 1] > searchedElement) {
                iterations++;
                int[] newArray = Arrays.copyOf(Arrays.copyOfRange(array, int_amount * i, array.length), int_amount);
                return blockSearch(newArray, iterations);
            }
            if (rem != 0) {
                iterations++;
                int[] newArray = Arrays.copyOf(Arrays.copyOfRange(array, div * int_amount,
                        array.length), rem);
                if (blockSearch(newArray, iterations)) {
                    iterations++;
                    return true;
                }
            }
        }end(iterations);
        return false;
    }
}
