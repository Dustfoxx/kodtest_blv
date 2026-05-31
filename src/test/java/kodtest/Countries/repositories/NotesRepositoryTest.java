package kodtest.Countries.repositories;

import kodtest.Countries.models.entities.Country;
import kodtest.Countries.models.entities.Notes;
import kodtest.Countries.models.entities.Visitor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class NotesRepositoryTest {
    @Autowired
    private NotesRepository notesRepository;
    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private VisitorRepository visitorRepository;

    @Test
    void addNote(){

        List<Visitor> visitors = visitorRepository.findAll();
        List<Country> countries = countryRepository.findAll();

        notesRepository.save(new Notes("Was a great time", visitors.getFirst(), countries.getFirst()));

        List<Notes> notes = notesRepository.findAll();

        assertEquals("Was a great time", notes.getFirst().getNote());
        assertEquals(visitors.getFirst().getId(), notes.getFirst().getUserId().getId());
        assertEquals(countries.getFirst().getId(), notes.getFirst().getCountryId().getId());
    }

    @Test
    void updateNote(){
        List<Visitor> visitors = visitorRepository.findAll();
        List<Country> countries = countryRepository.findAll();

        notesRepository.save(new Notes("Was a great time", visitors.getFirst(), countries.getFirst()));
    }
}