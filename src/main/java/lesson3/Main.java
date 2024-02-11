package lesson3;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Main {
    public static void main(String[] args) throws Exception{
        String str = "Всем привет!";
        FileOutputStream fileOutputStream = new FileOutputStream("ser.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(str);
        objectOutputStream.close();


    }
}
