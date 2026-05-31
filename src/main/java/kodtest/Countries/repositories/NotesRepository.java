package kodtest.Countries.repositories;

import kodtest.Countries.models.entities.Notes;
import kodtest.Countries.models.entities.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NotesRepository extends JpaRepository<Notes, Long> {
    @Query("select n from Notes n where n.user = :visitor")
    List<Notes> findByVisitor(Visitor visitor);
}