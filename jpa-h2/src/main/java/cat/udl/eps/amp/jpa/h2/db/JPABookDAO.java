package cat.udl.eps.amp.jpa.h2.db;

import cat.udl.eps.amp.jpa.h2.domain.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.FlushModeType;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class JPABookDAO implements BookDAO {

    private final EntityManager entityManager;

    public JPABookDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.entityManager.setFlushMode(FlushModeType.AUTO);
    }

    @Override
    public List<Book> allBoks() {
        String query = "SELECT b FROM Book b";
        return entityManager.createQuery(query, Book.class).getResultList();
    }

    @Override
    public Long addBook(Book book) {
        if (book.getId() != null)
            throw new IllegalArgumentException("Book already has an id");
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(book);
        Long newId = book.getId();
        transaction.commit();
        return newId;
    }

    @Override
    public Optional<Book> findById(long id) {
        String query = "SELECT b FROM Book b WHERE b.id = :id";
        return entityManager.createQuery(query, Book.class)
                .setParameter("id", id)
                .getResultStream()
                .findFirst();
    }

    @Override
    public void updateBook(Book book) {
        Objects.requireNonNull(book.getId(), "Book id cannot be null");
        entityManager.merge(book);
    }
}
