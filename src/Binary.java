public class Binary {
        private int[] randArray;
        private int[] sortedArray;

        public Binary(){
            this.randArray = new int[1000000]; // en ny array med storlek en miljon
            this.sortedArray = new int[1000000];
        }
    public static boolean binarySearch(int[] array, int key) {
        int first = 0;
        int last = array.length - 1;

        while (true) {
            int index = ((first + last)/2);
            if (array[index] == key) {
                return true;
            }
            if (array[index] < key && index < last) {
                first = index + 1;
                continue;
            }
            if (array[index] > key && index > first) {
                last = index -1;
                continue;
            }
                return false;
        }
    }
}
