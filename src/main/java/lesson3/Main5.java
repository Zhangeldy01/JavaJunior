package lesson3;

import java.io.*;

public class Main5 {
    public static void main(String[] args) throws Exception{
        MyFCs myFCs = (MyFCs) deserialObj("ser.txt");
        System.out.println(myFCs);

    }

    public static void serialObj(Object o, String file) throws IOException {
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

    static class MyFCs implements Serializable {
        public String lName;
        public String fName;
        public String patronymic;

        private static final long serialVersionUID = 1L;

        public MyFCs(String lName, String fName, String patronymic) {
            this.lName = lName;
            this.fName = fName;
            this.patronymic = patronymic;
        }

        @Override
        public String toString() {
            return String.format("%s %s.%s.",
                    fName,
                    lName.toUpperCase().charAt(0),
                    patronymic.toUpperCase().charAt(0));
        }
    }
}
