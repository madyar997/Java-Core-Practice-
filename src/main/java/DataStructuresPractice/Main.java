package DataStructuresPractice;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Processor processor = new Processor();
        int [] array = {0, 74 , 59 , 69 ,99 ,8 ,57 ,3 ,11};
        int result = processor.findSecondMinElement(array);
        System.out.println(result);
    }

}
class Processor {
    public int findSecondMinElement(int [] array){
        int[] arrayCopy = Arrays.copyOf(array, array.length);
        Arrays.sort(arrayCopy);
        if(arrayCopy.length >= 2){
            return arrayCopy[1];
        }
        return 0;
    }
}