package IOPractice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileStreamExample {
    public static void main(String[] args) {
        byte[] bytesToWrite = {1, 2, 3};
        byte[] bytesReaded = new byte[10];
        String fileName = "C:\\Users\\user\\Desktop\\tic\\java_core_practice\\src\\main\\java\\data1.txt";
        FileOutputStream outFile = null;
        FileInputStream inFile = null;
        try {
            outFile = new FileOutputStream(fileName);
            System.out.println("File is ready to write");
            outFile.write(bytesToWrite);
            outFile.close();
            System.out.println("Выходной поток закрыт");
            inFile = new FileInputStream(fileName);
            int bytesAvailable = inFile.available();
            int count = inFile.read(bytesReaded, 0, bytesAvailable);
            inFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                inFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
