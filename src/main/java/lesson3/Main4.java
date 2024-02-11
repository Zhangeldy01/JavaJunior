package lesson3;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main4 {
    public static void main(String[] args) throws Exception {
        ArrayList<String> list = null;
        list = (ArrayList<String>) deserialObj("ser");
        System.out.println(list);
    }
    public static void serialObj(Object o, String file) throws IOException{
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(o);
        objectOutputStream.close();
    }
    public static Object deserialObj(String file) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        return objectInputStream.readObject();
    }
}
