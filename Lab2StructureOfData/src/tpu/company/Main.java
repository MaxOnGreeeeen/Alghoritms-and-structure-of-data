package tpu.company;

import java.util.Arrays;

public class Main {

    public int[] zap_to_point(){

    }
    public static void main(String[] args) {
        float[] array = new float[]{58.02, 54.52, 57,06, 61,24, 52,94, 50,02, 55,41,
                53,38, 53,74, 54,68, 56,58, 57,39, 54,56, 54,01, 54,68, 55,57, 58,40,
                57,15, 58,02, 60,68, 56,10, 58,14, 55,41, 58,32, 58,25, 58,69, 58,13,
                53,49, 57,34, 54,83, 56,76, 58,03, 52,33, 53,48, 54,60, 56,58, 54,36, 57,71, 54,30, 56,62};
        int temp = 0;
        for(int i = 0; i < array.length; i++){
            for ( int j = 1; j < array.length - 1;  j++){
                if (array[j-1] > array[j]){
                    temp = array[j-1];
                    array[j-1] = array[j];
                    array[j] = temp;
                }
            }
        }
        print_array(array);
    }
    public static void print_array(int[] array){
        System.out.println(Arrays.toString(array));
    }
}
