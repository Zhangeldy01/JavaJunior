package lesson2;

// Урок 2. Reflection API

public class Car {
   public String name;
   public String price;
   public String engType;
   public String engPower;
   public int maxSpeed;

    public Car(String name) {
        this.name = name;
        this.engType = "V8";
        this.engPower = "198";
        this.maxSpeed = 180;
        this.price = "100000";
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", maxSpeed=" + maxSpeed +
                '}' ;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
}

