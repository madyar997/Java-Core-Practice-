package IOPractice;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class ByteArrayStreamExample {
    public static void main(String[] args) {
        byte[] bytes = {1, -1, 0};
        ByteArrayInputStream in = new ByteArrayInputStream(bytes);
        int readedInt = in.read();
        readedInt = in.read();
        readedInt = in.read();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        out.write(10);
        out.write(11);
        byte[] bytes1 = out.toByteArray();
    }
}
