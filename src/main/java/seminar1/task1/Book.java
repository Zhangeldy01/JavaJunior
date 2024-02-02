package seminar1.task1;

import java.util.Locale;

public class Book {
    // Поля
    private final String title;
    private final String author;
    private final int year;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return String.format(Locale.getDefault(), "Книга: \n\tНаименование: %s\n\tАвтор: %s\n\tГод выпуска: %s\n",
                title, author, year);
    }
}
