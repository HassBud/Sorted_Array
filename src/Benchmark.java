import java.util.Random;

import static java.lang.Math.log;

public class Benchmark {

    public static void linear(int[] array, int[] indx) {
        for (int i = 0; i < indx.length; i++) {
            Linear.searchLinear(array, indx[i]);
        }
    }


    public static void binary(int[] array, int[] indx) {
        for (int i = 0; i < indx.length; i++) {
            Binary.binarySearch(array, indx[i]);
        }
    }


    public static int[] sorted(int n) {
        Random rnd = new Random();
        int[] array = new int[n];
        int nxt = rnd.nextInt(10);

        for (int i = 0; i < n; i++) {
            array[i] = nxt;
            nxt += rnd.nextInt(10) + 1;
        }
        return array;
    }

    public static int[] unSorted(int n) {
        Random rand = new Random();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = rand.nextInt(n * 5);
        }
        return array;
    }


    public static int[] keys(int loop, int n) {
        Random rnd = new Random();
        int[] indx = new int[loop];
        for (int i = 0; i < loop; i++) {
            indx[i] = rnd.nextInt(n * 5);
        }
        return indx;
    }

    public static double findDuplicatesLinear(int[] array, int[] keys, int rounds) {

        double min = Double.POSITIVE_INFINITY;

        for (int i = 0; i < rounds; i++) {
            int log = 0;
            long t0 = System.nanoTime();
            for (int j = 0; j < keys.length; j++) {
                int key = keys[j];
                if (Linear.searchLinear(array, key)) {
                    log++; // bara för att köra något, används ej i sökningen.
                }
            }
            long t1 = System.nanoTime();
            double t = (t1 - t0);
            if (t < min)
                min = t;
        }

        return min;
    }

    public static double findDuplBinary(int[] keys, int[] array, int rounds) {

        double min = Double.POSITIVE_INFINITY;

        for (int i = 0; i < rounds; i++) {
            int log = 0;
            long t0 = System.nanoTime();
            for (int j = 0; j < keys.length; j++) {
                int key = keys[j];
                if (Binary.binarySearch(array, key)) {
                    log++; // bara för att köra något, används ej i sökningen.
                }
            }
            long t1 = System.nanoTime();
            double t = (t1 - t0);
            if (t < min)
                min = t;
        }
        return min;
    }

    public static double findDuplPointer(int[] keys, int[] array, int rounds) {
        double min = Double.POSITIVE_INFINITY;
        for (int i = 0; i < rounds; i++) {
            long t0 = System.nanoTime();
            Pointer.pointerSearch(array, keys);
            long t1 = System.nanoTime();
            double t = (t1 - t0);
            if (t < min)
                min = t;
        }
        return min;
    }


    public void bench() {

        int[] sizes = {5,100, 200, 400, 800, 1600, 3200, 6400, 12800,};

        System.out.printf("# searching through an array of length n, time in ns\n");
        System.out.printf("#%7s%10s%9s%10s%9s%10s%10s%10s%11s%11s%11s\n", "n", "lin unS", "lin S", "binary", " binary/log(n)", " lin dupl.", "  lin dup. /n", "  binary dupl.", "  binary dup./n*log(n)", "pointer", " pointer/n");
        for (int n : sizes) {

            int loop = 10000;

            int[] arrayUnSort = unSorted(n);
            int[] arraySort = sorted(n);
            int[] arraySort2 = sorted(n);


            int[] indx = keys(loop, n);

            System.out.printf("%8d", n);

            int k = 1000;

            int rounds = 1000;


            double min = Double.POSITIVE_INFINITY;

            for (int i = 0; i < k; i++) {
                long t0 = System.nanoTime();
                linear(arrayUnSort, indx);
                long t1 = System.nanoTime();
                double t = (t1 - t0);
                if (t < min)
                    min = t;
            }

            System.out.printf("%8.0f", (min / loop));

            min = Double.POSITIVE_INFINITY;

            for (int i = 0; i < k; i++) {
                long t0 = System.nanoTime();
                linear(arraySort, indx);
                long t1 = System.nanoTime();
                double t = (t1 - t0);
                if (t < min)
                    min = t;
            }

            System.out.printf("%8.0f", (min / loop));

            min = Double.POSITIVE_INFINITY;

            for (int i = 0; i < k; i++) {
                long t0 = System.nanoTime();
                binary(arraySort, indx);
                long t1 = System.nanoTime();
                double t = (t1 - t0);
                if (t < min)
                    min = t;
            }

            System.out.printf("%9.0f", (min / loop));
            System.out.printf("%9.2f", (min / loop) / (log(n)));

            System.out.printf("%15.0f", findDuplicatesLinear(arrayUnSort, arraySort2, rounds));
            System.out.printf("%15.0f", findDuplicatesLinear(arrayUnSort, arraySort2, rounds) / (n));

            System.out.printf("%15.0f", findDuplBinary(arraySort, arrayUnSort, rounds));
            System.out.printf("%15.2f", findDuplBinary(arraySort, arrayUnSort, rounds) / (log(n)));

            System.out.printf("%15.0f", findDuplPointer(arraySort, arraySort2, rounds));
            System.out.printf("%15.0f\n", findDuplPointer(arraySort, arraySort2, rounds) / n);


        }
    }
}
