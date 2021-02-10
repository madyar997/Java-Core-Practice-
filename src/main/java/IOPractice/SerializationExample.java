package IOPractice;

import java.io.*;

public class SerializationExample {
    public static void main(String[] args) {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        Object objSave = 1;
        try {
            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeObject(objSave);
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] bArray = os.toByteArray();
        for(byte b: bArray){
            System.out.println((char) b);
        }
        System.out.println();
        ByteArrayInputStream is = new ByteArrayInputStream(bArray);
        try {
            ObjectInputStream ois = new ObjectInputStream(is);
            Object objRead = ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
