package seminar1.task2;

public class Fruit implements HealthyFood {
    public Fruit() {
        super();
    }

    @Override
    public boolean getProteins() {
        return false;
    }

    @Override
    public boolean getFats() {
        return false;
    }

    @Override
    public boolean getCarbohydrates() {
        return true;
    }

    @Override
    public String getName() {
        return "Фрукты";
    }
}
