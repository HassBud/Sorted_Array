import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Linear linear = new Linear();
        Binary binary = new Binary();
        Benchmark benchmark = new Benchmark();

        benchmark.bench();
       // test();


    }






   /* public static void test() {
        int[] sizes = {10,100,200,400,800,1600,3200,6400,12800,};
        for (int n : sizes) {

            int loop = 10;

            int[] arrayUnSort = Benchmark.unSorted(n);
            int[] keyArrayUnsort = Benchmark.unSorted(n);
            int[] arraySort = Benchmark.sorted(n);

            int[] indx = Benchmark.keys(loop, n);

            System.out.printf("%8d", n);

            int k = 1000;


            double min = Double.POSITIVE_INFINITY;

            for (int i = 0; i < k; i++) {
                long t0 = System.nanoTime();
                findDuplBinary(arraySort,arrayUnSort);
                long t1 = System.nanoTime();
                double t = (t1 - t0);
                if (t < min)
                    min = t;
            }

            System.out.printf("%8.0f\n", (min / loop) );
        }
    }*/


}