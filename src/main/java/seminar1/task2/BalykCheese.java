package seminar1.task2;

/**
 * Класс BalykCheese представляет собой Сыр (Балык), который является полуфабрикатом.
 * Реализует интерфейсы Snack и Food, предоставляя информацию о пищевой ценности.
 */
public class BalykCheese implements Snack {

    /**
     * Возвращает информацию о наличии белков в сыре.
     * @return true, так как в сыре много белков.
     */
    @Override
    public boolean getProteins() {
        return true; // Сыр содержит много белков
    }

    /**
     * Возвращает информацию о наличии жиров в сыре.
     * @return false, так как в сыре мало жиров.
     */
    @Override
    public boolean getFats() {
        return false;  // Сыр не содержит значительного количества жиров
    }

    /**
     * Возвращает информацию о наличии углеводов в сыре.
     * @return false, так как в сыре мало углеводов.
     */
    @Override
    public boolean getCarbohydrates() {
        return false; // Сыр не содержит значительного количества углеводов
    }

    /**
     * Возвращает название сыра.
     * @return "Сыр (Балык)" - название данного продукта.
     */
    @Override
    public String getName() {
        return "Сыр (Балык)";
    }
}
