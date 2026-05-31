package kodtest.Countries.repositories;

import kodtest.Countries.models.entities.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitorRepository extends JpaRepository<Visitor, Long> {}