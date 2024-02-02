package seminar1.task2;

public class DumplingsMeat implements SemiFinishedFood {
    public DumplingsMeat() {
        super();
    }

    @Override
    public boolean getProteins() {
        return true;
    }

    @Override
    public boolean getFats() {
        return false;
    }

    @Override
    public boolean getCarbohydrates() {
        return false;
    }

    @Override
    public String getName() {
        return "Пельмени";
    }
}
