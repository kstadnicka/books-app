package org.ks.yourbooks.domain.book;

import org.ks.yourbooks.domain.book.dto.BookDto;
import org.ks.yourbooks.domain.book.dto.BookSaveDto;
import org.ks.yourbooks.domain.category.Category;
import org.ks.yourbooks.domain.category.CategoryRepository;
import org.ks.yourbooks.storage.FileStorageService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final CategoryRepository categoryRepository;
    private final FileStorageService fileStorageService;

    public BookService(BookRepository bookRepository, CategoryRepository categoryRepository, FileStorageService fileStorageService) {
        this.bookRepository = bookRepository;
        this.categoryRepository = categoryRepository;
        this.fileStorageService = fileStorageService;
    }

    public List<BookDto> findAllPromotedBooks() {
        return bookRepository.findAllByPromotedIsTrue().stream()
                .map(BookDtoMapper::map)
                .toList();
    }

    public Optional<BookDto> findBookById(Long id) {
        return bookRepository.findById(id).map(BookDtoMapper::map);
    }

    public List<BookDto> findBookByCategoryName(String category){
        return bookRepository.findAllByCategory_NameIgnoreCase(category).stream().
                map(BookDtoMapper::map)
                .toList();
    }

    public void addBook(BookSaveDto bookToSave){
        Book book = new Book();
        book.setTitle(bookToSave.getTitle());
        book.setAuthor(bookToSave.getAuthor());
        book.setPublisher(bookToSave.getPublisher());
        book.setReleaseYear(bookToSave.getReleaseYear());
        Category category = categoryRepository.findByNameIgnoreCase(bookToSave.getCategory()).orElseThrow();
        book.setCategory(category);
        book.setPromoted(bookToSave.getPromoted());
        book.setDescription(bookToSave.getDescription());
        book.setShortDescription(bookToSave.getShortDescription());
        if (bookToSave.getPoster() != null && !bookToSave.getPoster().isEmpty()){
            String savedFileName = fileStorageService.saveImage(bookToSave.getPoster());
            book.setPoster(savedFileName);
        }
        bookRepository.save(book);
    }
}
