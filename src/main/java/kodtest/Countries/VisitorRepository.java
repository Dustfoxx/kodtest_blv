package kodtest.Countries;

import org.springframework.data.jpa.repository.JpaRepository;

interface VisitorRepository extends JpaRepository<Visitor, Long> {}