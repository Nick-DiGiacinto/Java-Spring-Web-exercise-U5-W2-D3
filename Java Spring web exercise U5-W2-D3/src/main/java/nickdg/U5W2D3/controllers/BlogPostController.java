package nickdg.U5W2D3.controllers;

import nickdg.U5W2D3.entities.BlogPost;
import nickdg.U5W2D3.payloads.PayloadBlogPost;
import nickdg.U5W2D3.services.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blog-posts")
public class BlogPostController {

    @Autowired
    BlogPostService blogPostService;

    @GetMapping
    private List<BlogPost> getAllBlogPosts(){
        return this.blogPostService.getBlogPostList();
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    private BlogPost saveBlogPost(@RequestBody PayloadBlogPost payload){
        BlogPost blogPost = new BlogPost();
        blogPost.setAuthor(payload.getName());
        blogPost.setTitle(payload.getTitle());
        blogPost.setContent(payload.getContent());
        blogPost.setCategory(payload.getCategory());
        blogPost.setReadingTime(payload.getReadingTime());

        return this.blogPostService.saveBlogPost(blogPost);
    }

    @GetMapping("/{blogPostId}")
    private BlogPost getSingleBlogPost(@PathVariable int blogPostId){
    return this.blogPostService.findById(blogPostId);
    }

    @PutMapping("/{blogPostId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    private BlogPost findSinglePostAndUpdate(@PathVariable int blogPostId, @RequestBody BlogPost body){
        return this.blogPostService.findByIdAndUpdate(blogPostId, body);
    }
    @DeleteMapping("/{blogPostId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void deleteBlogPost(@PathVariable int blogPostId){
        this.blogPostService.findByIdAndDelete(blogPostId);
    }

}
