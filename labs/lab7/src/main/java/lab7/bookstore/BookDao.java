package lab7.bookstore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lab7.carshop.NoSuchResourceException;

public class BookDao implements IBookDao {
	private static int idCount = 1;
	private Map<Integer, Book> books = new HashMap<Integer, Book>();

	public BookDao() {
		add(new Book("Harry Potter and the Philosopher's Stone", "000-111-11", "J.K. Rowling", 25.00));
		add(new Book("Harry Potter and the Cursed Child", "000-111-22", "J.K. Rowling", 24.00));
		add(new Book("Harry Potter and the Chamber of Secrets", "000-111-33", "J.K. Rowling", 28.00));
		add(new Book("Harry Potter and the Prisoner of Azkaban", "000-111-44", "J.K. Rowling", 27.00));
		add(new Book("Harry Potter and the Goblet of Fire", "000-111-55", "J.K. Rowling", 30.00));
		add(new Book("Harry Potter and the Order of the Phoenix", "000-111-66", "J.K. Rowling", 34.00));
		add(new Book("Harry Potter and the Half Blood Prince", "000-111-77", "J.K. Rowling", 33.00));
		add(new Book("Harry Potter and the Deathly Hallows", "000-111-88", "J.K. Rowling", 32.00));
	}

	public List<Book> getAll() {
		return new ArrayList<Book>(books.values());
	}

	public void add(Book book) {
		book.setId(idCount);
		books.put(idCount, book);
		idCount++;
	}

	public Book get(int id) {
		Book result = books.get(id);

		if (result == null) {
			throw new NoSuchResourceException("Book", id);
		}

		return result;
	}

	public void update(int bookId, Book book) {
		books.put(bookId, book);
	}

	public void delete(int bookId) {
		Book removed = books.remove(bookId);
		if (removed == null) {
			throw new NoSuchResourceException("Book", bookId);
		}
	}
}
