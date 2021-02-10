package IOPractice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class IOPractice {
    public static void main(String[] args) {
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream("C:\\Users\\user\\Desktop\\tic\\java_core_practice\\src\\main\\java\\data.txt");
            while(inputStream.read()!= -1){
                System.out.println(inputStream.read());
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(inputStream != null){
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
