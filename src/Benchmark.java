import java.util.Random;

public class Benchmark {
    Linear linear;

    public static void linear(int[] array, int[] indx) {
        for (int i = 0; i < indx.length ; i++) {
            Linear.searchLinear(array,indx[i]);
        }
    }


    public static void binary(int[] array, int[] indx) {
        for (int i = 0; i < indx.length ; i++) {
           Binary.binarySearch(array, indx[i]);
        }
    }


    public static int[] sorted(int n) {
        Random rnd = new Random();
        int[] array = new int[n];
        int nxt = rnd.nextInt(10);

        for (int i = 0; i < n ; i++) {
            array[i] = nxt;
            nxt += rnd.nextInt(10) + 1 ;
        }
        return array;
    }

    public static int[] unSorted(int n){
        Random rand = new Random();
        int [] array = new int[n];
            for(int i = 0; i < n; i++)
            {
                array [i] = rand.nextInt(n*5);
            }
            return array;
    }


    public static int[] keys(int loop, int n) {
        Random rnd = new Random();
        int[] indx = new int[loop];
        for (int i = 0; i < loop ; i++) {
            indx[i] = rnd.nextInt(n*5);
        }
        return indx;
    }

    public boolean findDuplicatesLinear(int[] array, int[] keys){

        for (int i = 0; i < keys.length; i++) {
                int key = keys[i];
                if(Linear.searchLinear(array,key)){
                    return true;
                }
        }
        return false;
    }

    public static boolean findDuplBinary(int[] array, int[] keys) {
        for (int i = 0; i < keys.length; i++) {
            int key = keys[i];
            if (Binary.binarySearch(array,key)){
                return true;
            }
        }
        return false;
    }


    public void bench(){

        int[] sizes = {100,200,400,800,1600,3200,6400,12800,};

        System.out.printf("# searching through an array of length n, time in ns\n");
        System.out.printf("#%7s%10s%9s%9s%10s%10s\n", "n", "lin unS", "lin S", "binary", "lin dupl.", " binary dupl.");
        for ( int n : sizes) {

            int loop = 10000;

            int[] arrayUnSort = unSorted(n);
            int[] keyArrayUnsort = unSorted(n);
            int[] arraySort = sorted(n);

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

            System.out.printf("%8.0f", (min/loop));

            min = Double.POSITIVE_INFINITY;

            for (int i = 0; i < k; i++) {
                long t0 = System.nanoTime();
                linear(arraySort, indx);
                long t1 = System.nanoTime();
                double t = (t1 - t0);
                if (t < min)
                    min = t;
            }

            System.out.printf("%8.0f" , (min/loop));

            min = Double.POSITIVE_INFINITY;

            for (int i = 0; i < k; i++) {
                long t0 = System.nanoTime();
                binary(arraySort, indx);
                long t1 = System.nanoTime();
                double t = (t1 - t0);
                if (t < min)
                    min = t;
            }

            System.out.printf("%9.0f" , (min/loop));

            min = Double.POSITIVE_INFINITY;
            for (int i = 0; i < rounds; i++) {
                long t0 = System.nanoTime();
                findDuplicatesLinear(arrayUnSort,keyArrayUnsort);
                long t1 = System.nanoTime();
                double t = (t1 - t0);
                if (t < min)
                    min = t;
            }

            System.out.printf("%10.0f" , min);

            min = Double.POSITIVE_INFINITY;
            for (int i = 0; i < rounds; i++) {
                long t0 = System.nanoTime();
                findDuplBinary(arraySort,keyArrayUnsort);
                long t1 = System.nanoTime();
                double t = (t1 - t0);
                if (t < min)
                    min = t;
            }

            System.out.printf("%10.0f\n" , min);



        }
    }

}
