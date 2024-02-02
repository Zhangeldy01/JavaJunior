package lesson1.task1;

public class Main {
    public static void main(String[] args) {
//        PlainInterface plainInterface = new PlainInterface() {
//            @Override
//            public String action(int x, int y) {
//                return String.valueOf(x + y);
//            }
//        };

//        2 вариант решения
//        PlainInterface plainInterface = (x, y) -> String.valueOf(x + y);
//        PlainInterface plainInterface1 = (x, y) -> String.valueOf(Integer.compare(x, y));
//
//        System.out.println(plainInterface.action(5,3));
//        System.out.println(plainInterface1.action(1, 5));

        //решение с типом int метода action
        PlainInterface plainInterface = Integer::sum;
        PlainInterface plainInterface1 = Integer::compare;

        System.out.println(plainInterface.action(5,3));
        System.out.println(plainInterface1.action(1, 5));




    }
}