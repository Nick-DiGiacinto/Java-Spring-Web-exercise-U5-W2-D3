package nickdg.U5W2D3.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
@Table(name = "authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private int id;
    private String name;
    private String surname;
    private String Email;
    private int birthdayYear;
    private String avatar;

    @OneToMany(mappedBy = "author", cascade = CascadeType.REMOVE)
    private List<BlogPost> blogPostList = new ArrayList<>();
}

