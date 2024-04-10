package nickdg.U5W2D3.services;

import nickdg.U5W2D3.entities.BlogPost;
import nickdg.U5W2D3.exceptions.NotFoundException;
import nickdg.U5W2D3.repositories.AuthorsDAO;
import nickdg.U5W2D3.repositories.BlogPostDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BlogPostService {

    @Autowired
    BlogPostDAO blogPostDAO;
    private List<BlogPost> blogPostList = new ArrayList<>();
    private AuthorsDAO authorsDAO;

    public List<BlogPost> getBlogPostList(){
        return this.blogPostDAO.findAll();
    }

    public BlogPost saveBlogPost(BlogPost body) {
       return this.blogPostDAO.save(new BlogPost());
    }

    public BlogPost findById(int id){
        return blogPostDAO.findById(id).orElseThrow(() -> new NotFoundException(id));

    }
    public BlogPost findByIdAndUpdate(int id, BlogPost updatedBlogPost){
        Optional<BlogPost> optionalBlogPost = blogPostDAO.findById(id);

        if (optionalBlogPost.isPresent()) {
            BlogPost found = optionalBlogPost.get();
            found.setAuthor(optionalBlogPost.get().getAuthor());
            found.setTitle(optionalBlogPost.get().getTitle());
            found.setCategory(optionalBlogPost.get().getCategory());
            found.setContent(optionalBlogPost.get().getContent());
            return this.blogPostDAO.save(found);
        } else {
            throw new NotFoundException(id);
        }
    }

    public void findByIdAndDelete(int id){
        Optional<BlogPost> optionalBlogPost = blogPostDAO.findById(id);
        if (optionalBlogPost.isPresent()) {
            BlogPost found = optionalBlogPost.get();
            this.blogPostDAO.delete(found);
        } else {
            throw new NotFoundException(id);
        }

    }

}
