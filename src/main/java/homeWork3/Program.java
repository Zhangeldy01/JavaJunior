package homeWork3;

import java.io.*;
import homeWork3.Student;

/**
 * Разработайте класс Student с полями String name, int age, transient double GPA (средний балл).
 * Обеспечьте поддержку сериализации для этого класса.
 * Создайте объект класса Student и инициализируйте его данными.
 * Сериализуйте этот объект в файл.
 * Десериализуйте объект обратно в программу из файла.
 * Выведите все поля объекта, включая GPA, и ответьте на вопрос,
 * почему значение GPA не было сохранено/восстановлено.
 * 2. * Выполнить задачу 1 используя другие типы сериализаторов (в xml и json документы).
 */
public class Program {

    /*
    Значение GPA не было сохранено/восстановлено, потому что поле GPA было помечено как transient.
    При сериализации объекта все поля, помеченные как transient, не участвуют в процессе сериализации
    и не сохраняются в файле. В данном случае, при десериализации объекта, значение GPA будет равно 0.0,
    так как тип данных double по умолчанию инициализируется нулевым значением.
     */
    public static void main(String[] args) {

        Student student = new Student("Alice", 20, 3.5);

        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("student.ser"));
            out.writeObject(student);
            out.close();

            ObjectInputStream in = new ObjectInputStream(new FileInputStream("student.ser"));
            Student student2 = (Student) in.readObject();
            in.close();

            System.out.println("Name: " + student2.getName());
            System.out.println("Age: " + student2.getAge());
            System.out.println("GPA: " + student2.getGPA());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

