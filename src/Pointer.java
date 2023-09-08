import java.util.ArrayList;

public class Pointer {

    public static boolean pointerSearch(int[] array, int[] keys){
        int indexArray = 0;
        int indexKey = 0;
        while(indexArray < array.length && indexKey < keys.length){
            if(array[indexArray] == keys[indexKey]){
                indexArray++;
            }
            if (array[indexArray] < keys[indexKey]) {
                indexArray++;
                continue;
            }
            if (array[indexArray] > keys[indexKey] ) {
                indexKey++;

            }
        }
        return false;
    }
}
