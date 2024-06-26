package cat.udl.eps.amp.jpa.h2.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "tutorials_tbl")
public class Book {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "author", nullable = false)
    private String author;

    public Book() {
    }

    public Book(String title, String author) {
        setTitle(title);
        setAuthor(author);
    }

    public Book(long id, String title, String author) {
        this(title, author);
        setId(id);
    }

    public Long getId() {
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

