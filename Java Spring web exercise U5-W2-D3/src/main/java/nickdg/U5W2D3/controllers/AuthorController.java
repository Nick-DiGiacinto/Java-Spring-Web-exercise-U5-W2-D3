package nickdg.U5W2D3.controllers;

import nickdg.U5W2D3.entities.Author;
import nickdg.U5W2D3.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {


    @Autowired
    AuthorService authorService;


    @GetMapping
        public List<Author> getAllAuthors(){
            return this.authorService.getAuthorList();
        };

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    private Author saveAuthor(@RequestBody Author body){
        return this.authorService.saveAuthor(body);
    }

    @GetMapping("/{authorId}")
    private Author getSingleAuhtor(@PathVariable int authorId){
        return this.authorService.findAuthorById(authorId);
    }

    @PutMapping("/{authorId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    private Author findSingleAuthorAndUpdate(@PathVariable int authorId, @RequestBody Author body){
        return this.authorService.findAuthorByIdAndUpdate(authorId, body);
    }
    @DeleteMapping("/{authorId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void deleteAuthor(@PathVariable int authorId){
        this.authorService.findAuthorByIdAndDelete(authorId);
    }


}
