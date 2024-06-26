package cat.udl.eps.amp.jdbc.h2.domain;

public class Book {
    private long id = -1; // -1 means not in database
    private String title;
    private String author;

    public Book() {
    }

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public Book(long id, String title, String author) {
        setId(id);
        setTitle(title);
        setAuthor(author);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title == null) throw new IllegalArgumentException("title cannot be null");
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if (author == null) throw new IllegalArgumentException("author cannot be null");
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title=" + title +
                ", author=" + author +
                '}';
    }

}
