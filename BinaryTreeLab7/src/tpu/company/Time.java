package tpu.company;

public class Time {
    private long start;
    private long finish;
    private long elapsed;

    public void start() {
        this.start = System.nanoTime();
    }

    public void finish() {
        this.finish = System.nanoTime();
        this.elapsed = finish - start;
        System.out.println("Time passed: " + elapsed + " nanoseconds");
    }
}
