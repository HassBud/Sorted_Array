public class Linear  {

    private int[] randArray;
    private int[] sortedArray;

    private Benchmark benchmark;

    public Linear(){
        this.randArray = new int[1000000]; // en ny array med storlek en miljon
        this.sortedArray = new int[1000000];
        benchmark = new Benchmark();
    }
    public static boolean searchLinear(int[] array, int key) {
        for (int index = 0; index < array.length ; index++) {
            if (array[index] == key) {
                return true;
            }
        }
        return false;
    }


}
