package nickdg.U5W2D3.repositories;

import nickdg.U5W2D3.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorsDAO extends JpaRepository<Author, Integer> {

}
