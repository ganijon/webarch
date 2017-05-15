package lab7.bookstore;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@Controller
public class BookController {

    @Resource
    IBookDao bookDao;

    @GetMapping("/books")
    public String getAll(Model model) {
        model.addAttribute("books", bookDao.getAll());
        return "/bookList";
    }

    @PostMapping("/books")
    public String addBook(Book book) {
        bookDao.add(book);
        return "redirect:/books";
    }

    @GetMapping("/books/{id}")
    public String get(@PathVariable int id, Model model) {
        model.addAttribute("book", bookDao.get(id));
        return "/bookDetail";
    }

    @PostMapping("/books/{id}")
    public String update(@PathVariable int id, Book book) {
        bookDao.update(id, book);
        return "redirect:/books";
    }

    @PostMapping("/books/delete")
    public String delete(@RequestParam int bookId, Model model) {
        bookDao.delete(bookId);
        return "redirect:/books";
    }

}
