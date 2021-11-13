package pl.coderslab.SpringHibernateModul6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.coderslab.SpringHibernateModul6.entity.Author;
import pl.coderslab.SpringHibernateModul6.entity.Book;
import pl.coderslab.SpringHibernateModul6.entity.Category;
import pl.coderslab.SpringHibernateModul6.entity.Publisher;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    // zadanie 1 zapytania szczegółowe

    @Query("select b from Book b where b.title = :givenTitle")
    Optional<Book> methodToFindBookByTitle(@Param("givenTitle") String title);

    @Query("select b from Book b where b.category = :givenCategory")
    List<Book> methodToFindBookByCategoryObject(@Param("givenCategory") Category category);






    Optional<Book> findFirstByTitle(String title);

    List<Book> findAllByCategory(Category category);

    List<Book> findAllByCategory_Id(long categoryId);

    List<Book> findByAuthors(Author author);

    List<Book> findByPublisher(Publisher publisher);

    List<Book> findByRating(int rating);

    Book findTopByCategoryOrderByTitle(Category category);

}