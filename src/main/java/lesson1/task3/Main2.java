package lesson1.task3;

import java.util.Arrays;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        List<User> list = Arrays.asList(new User("Pavel", 23), new User("Bob", 45), new User("Kate", 34));

        list.stream().map(user -> new User(user.name, user.age - 5)).forEach(System.out::println);

        System.out.println("\nfilter by age");

        list.stream().map(user -> new User(user.name, user.age - 5)).filter(user -> user.age <= 25).forEach(System.out::println);
    }
}
