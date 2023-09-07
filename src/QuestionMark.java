public class QuestionMark {
    /* public void linearBench(){
        int[] sizes = {100,200,300,400,500,600,700,800,900,1000,1100,1200,1300,1400,1500,1600};
        sortedArray = sortedArray();
        randArray = randomizedArray();
        int loop = 1000;
        double min = Double.POSITIVE_INFINITY;
        for (int i = 0; i < loop; i++) {
            long startTime = System.nanoTime();
            search_unsorted(randArray, rand.nextInt(10));
            long stopTime = System.nanoTime();
            float time = (stopTime - startTime);
            if ((time < min)) {
                min = time;
            }
        }

        System.out.println("fastest time is " + min + " nanoseconds" );
    }*/

      /*   int loop = 1000000000000000000000;
            double min = Double.POSITIVE_INFINITY;

            for (int i = 0; i < loop; i++) {
                long startTime = System.nanoTime();
                boolean b = search_unsorted(array, rand.nextInt(1000000));
                long stopTime = System.nanoTime();
                double time = (stopTime - startTime);
                if ((time < min) && b) {
                    min = time;
                }
            }

            System.out.println("min time " + min + " nanoseconds" );

        for (int i = 0; i < loop; i++) {
            long startTime = System.nanoTime();
            sorted(5);
            long stopTime = System.nanoTime();
            double time = (stopTime - startTime);
            if (time < min) {
                min = time;
            }
        }

        System.out.println("min time " + min + " nanoseconds");
    }

    public static boolean search_unsorted(int[] array, int key) {
            for (int index = 0; index < array.length ; index++) {
                if (array[index] == key) {
                    return true;
                }
            }
        return false;
    }
    private static int[] sorted(int n) {
        Random rnd = new Random();
        int[] array = new int[n];
        int nxt = 0;
        for (int i = 0; i < n ; i++) {
            nxt += rnd.nextInt(10) + 1;
            array[i] = nxt;
        }
        return array; */

}
