package tpu.company;
import java.io.*;
import java.util.Arrays;

public class Safe {
    private long elapsed;
    private int iterations;
    private int max;
    private int average;
    private boolean isTheOperationLast;
   //Constructor
    public Safe(long elapsed, int average, int max, boolean isTheOperationLast) {

        this.elapsed = elapsed;
        this.max = max;
        this.average = average;
        this.isTheOperationLast = isTheOperationLast;
    }

    public void saferOfFirstFile(File file) throws FileNotFoundException,IOException{
        try (FileWriter fileWriter = new FileWriter(file, true)) {
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(Integer.toString(max));
            if (isTheOperationLast) bufferedWriter.write("\n");
            else bufferedWriter.write(" ");
            bufferedWriter.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public void saferOfSecondFile(File file) throws FileNotFoundException,IOException {
        try (FileWriter fileWriter = new FileWriter(file, true)) {
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(Integer.toString(average));
            if (isTheOperationLast) bufferedWriter.write("\n");
            else bufferedWriter.write(" ");
            bufferedWriter.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
