package seminar3.task2;

import java.io.Serializable;

public class ToDo implements Serializable {

    /**
     * Наименование задачи
     */
    private String title;

    /**
     * Статус задачи
     */
    private boolean isDone;

    public ToDo(){
    }

    public ToDo(String title) {
        this.title = title;
        isDone = false;
    }

    /**
     * Получить наименование задачи
     * @retern наименование задачи
     */
    public String getTitle() {
        return title;
    }

    /**
     * Получить статус выполнения задачи
     * @return статус выполнения задачи
     */
    public boolean isDone() {
        return  isDone;
    }

    /**
     * Изменить статус выполнения задачи
     * @param done новый статус задачи
     */
    public void setDone(boolean done) {
        isDone = done;
    }
}
