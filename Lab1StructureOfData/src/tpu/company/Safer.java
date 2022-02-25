package tpu.company;
import java.io.*;
import java.util.Arrays;

public class Safer {
    private String filename;
    private long start;
    private long finish;
    private long elapsed;
    private int iterations;
    private File file;
    private int n;

    public Safer(File file, long start, long finish, long elapsed, int iterations, int n) {
        this.n = n;
        this.file = file;
        this.start = start;
        this.finish = finish;
        this.elapsed = elapsed;
        this.iterations = iterations;
    }
    public void safer() throws FileNotFoundException,IOException{

        FileWriter fileWriter = new FileWriter(file, true);
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(Long.toString(elapsed));
            bufferedWriter.write(" ");
            bufferedWriter.write(String.valueOf(iterations));
            bufferedWriter.write(" ");
            bufferedWriter.write(String.valueOf(n));
            bufferedWriter.write("\n");
            bufferedWriter.close();
        }catch (IOException ex){
            ex.printStackTrace();
        }finally {
            fileWriter.close();
        }

    }
}
