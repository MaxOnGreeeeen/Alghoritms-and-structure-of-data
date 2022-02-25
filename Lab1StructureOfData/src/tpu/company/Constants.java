package tpu.company;

import java.util.ArrayList;

public class Constants {
    private int[][] matrix;
    private ArrayList<int[][]> matrix_amounts = new ArrayList<>();

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }
    public void addMatrix(int[][] matrix) {
        this.matrix_amounts.add(matrix) ;
    }
    public ArrayList<int[][]> getMatrixs(){return matrix_amounts;}
}
