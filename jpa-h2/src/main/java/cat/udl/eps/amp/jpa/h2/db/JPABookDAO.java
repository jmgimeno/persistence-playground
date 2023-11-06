package cat.udl.eps.amp.jpa.h2.db;

import cat.udl.eps.amp.jpa.h2.domain.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;
import java.util.Optional;

public class JPABookDAO implements BookDAO {

    private final EntityManager entityManager;

    public JPABookDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Book> allBoks() {
        String query = "SELECT b FROM Book b";
        return entityManager.createQuery(query, Book.class).getResultList();
    }

    @Override
    public long addBook(Book book) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(book);
        transaction.commit();
        return book.getId();
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
        entityManager.merge(book);
    }
}
