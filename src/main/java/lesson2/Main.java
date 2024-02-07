package lesson2;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {
//        Car car = new Car("BMW");
//        System.out.println(car.name);
        Class<?> car = Class.forName("lesson2.Car");
        Constructor<?>[] constructors = car.getConstructors();
        //System.out.println(constructors);

        Object gaz = constructors[0].newInstance("Газ");
        System.out.println(gaz);

        Field[] fields = gaz.getClass().getFields();
        int tmp = fields[fields.length-1].getInt(gaz);
        fields[fields.length-1].setInt(gaz,tmp * 2);
        System.out.println(gaz);

        Method[] methods = gaz.getClass().getDeclaredMethods();
        for (int i = 0; i < methods.length; i++) {
            System.out.println(methods[i]);
        }
    }
}
