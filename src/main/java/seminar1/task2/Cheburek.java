package seminar1.task2;

/**
 * Класс Cheburek представляет собой чебурек, который является полуфабрикатом.
 * Реализует интерфейсы SemiFinishedFood и Food, предоставляя информацию о пищевой ценности.
 */
public class Cheburek implements SemiFinishedFood {

    /**
     * Конструктор класса Cheburek.
     */
    public Cheburek() {
        super(); // Вызов конструктора родительского класса (если есть)
    }

    /**
     * Возвращает информацию о наличии белков в чебуреке.
     * @return false, так как в чебуреке мало белков.
     */
    @Override
    public boolean getProteins() {
        return false;  // Чебурек не содержит значительного количества белков
    }

    /**
     * Возвращает информацию о наличии жиров в чебуреке.
     * @return true, так как чебурек жарится в масле и содержит много жиров.
     */
    @Override
    public boolean getFats() {
        return true;  // Чебурек содержит много жиров
    }

    /**
     * Возвращает информацию о наличии углеводов в чебуреке.
     * @return false, так как в чебуреке мало углеводов.
     */
    @Override
    public boolean getCarbohydrates() {
        return false;  // Чебурек не содержит значительного количества углеводов
    }

    /**
     * Возвращает название чебурека.
     * @return "Чебурек" - название данного продукта.
     */
    @Override
    public String getName() {
        return "Чебурек";  // Возвращаем название продукта
    }
}
