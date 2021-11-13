package pl.coderslab.SpringHibernateModul6.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.SpringHibernateModul6.entity.Author;
import pl.coderslab.SpringHibernateModul6.entity.Book;
import pl.coderslab.SpringHibernateModul6.entity.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class BookDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void persist(Book book) {
        entityManager.persist(book);
    }

    public Book merge(Book book) {
        return entityManager.merge(book);
    }

    public Book findById(long id) {
        return entityManager.find(Book.class, id);
    }

    public void remove(long id) {
        Book book = findById(id);
        entityManager.remove(entityManager.contains(book) ? book : entityManager.merge(book));
    }

    /* zadanie 1 jpql */
    public List<Book> findAll() {
        Query query = entityManager.createQuery("SELECT b FROM Book b");
        return query.getResultList();
    }

    // zadanie 2 - jpql

    public List<Book> findAllByRating(int rating) {
        Query query = entityManager.createQuery("select b from Book b where b.rating = :givenRating");
        query.setParameter("givenRating", rating);
        return query.getResultList();
    }



    // zadanie 4.1 - jpql moje
    // Uzupełnij klasę BookDao o metodę do pobierania listy wszystkich książek, które mają jakiegokolwiek wydawcę.

// koncepcja 1 -ustawianie parametru dla publisher_id w books po którym będziemy wyszukiwać - moje ZLE

    /*Query queryp = entityManager.createQuery("SELECT b FROM books b where b.publisher_id =:publisher_id");
queryp.setParameter("publisher_id", " "); // pod parametrem 'rating' zostanie wstawiona liczba '4'
    List<Book> booksp = queryp.getResultList();
}*/

    // koncepcja 2 - wyszukiwanie przez po id publishera w tabeli books - moje ZLE

   /* public List<Book> findBookWithPublisher(){
        Query query = entityManager.createQuery("SELECT b FROM Book b where publisher_id );
        return query.getResultList();
    }*/

// koncepcja 3 - łączenie danych

// zadanie 4.1 - jpql Bartka
// Uzupełnij klasę BookDao o metodę do pobierania listy wszystkich książek, które mają jakiegokolwiek wydawcę.

    public List<Book> findAllWithPublisher() {
        Query query = entityManager.createQuery("SELECT b FROM Book b WHERE b.publisher is not null");
        return query.getResultList();
    }

// zadanie 4.2 - jpql Bartka
// Uzupełnij klasę BookDao o metodę do pobierania listy wszystkich książek, które mają określonego w parametrze wydawcę

    public List<Book> findAllByPublisher(Publisher publisher) {
        long publisherId = publisher.getId();

        Query query = entityManager.createQuery("SELECT b FROM Book b WHERE b.publisher = :pub");
        query.setParameter("pub", publisher);

        Query query1 = entityManager.createQuery("SELECT b FROM Book b WHERE b.publisher.id = :publisherId");
        query1.setParameter("publisherId", publisherId);

        return query1.getResultList();
    }

    // zadanie 4.3 - jpql Bartka
    // Uzupełnij klasę BookDao o metodę do pobierania listy wszystkich książek, które mają określonego w parametrze autora

    public List<Book> findAllByAuthor(Author author) {
        long authorId = author.getId();

        Query query = entityManager.createQuery("SELECT b from Book b join b.authors a where a = :auth");
        query.setParameter("auth", author);

        Query query1 = entityManager.createQuery("SELECT b from Book b join b.authors a where a.id = :authorId");
        query1.setParameter("authorId", authorId);

        return query1.getResultList();
    }

}



/*Zadanie 2

        Na podstawie przykładu z prezentacji utwórz klasę BookDao.
        Klasa ma realizować podstawowe operacje na encji:

        zapis encji
        edycja encji
        pobieranie po id
        usuwanie po id*/
