package nickdg.U5W2D3.payloads;

import nickdg.U5W2D3.entities.Author;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PayloadBlogPost {
    private Author name;
    private String category;
    private String title;
    private String cover;
    private String content;
    private int readingTime;
}
