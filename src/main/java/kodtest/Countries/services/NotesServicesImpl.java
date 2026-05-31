package kodtest.Countries.services;

import kodtest.Countries.models.entities.Country;
import kodtest.Countries.models.entities.Notes;
import kodtest.Countries.models.entities.Visitor;
import kodtest.Countries.repositories.CountryRepository;
import kodtest.Countries.repositories.NotesRepository;
import kodtest.Countries.repositories.VisitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotesServicesImpl implements NotesServices {
    private NotesRepository notesRepository;
    private CountryRepository countryRepository;
    private VisitorRepository visitorRepository;

    public NotesServicesImpl(NotesRepository notes, CountryRepository countries, VisitorRepository visitors){
        this.notesRepository = notes;
        this.countryRepository = countries;
        this.visitorRepository = visitors;
    }

    @Override
    public List<Notes> getNotes(Long user_id) {
        Visitor visitor = visitorRepository.getReferenceById(user_id);

        return notesRepository.findByVisitor(visitor);
    }

    @Override
    public Notes addNote(Long user_id, Long country_id, String content){
        Country country = countryRepository.getReferenceById(country_id);
        Visitor visitor = visitorRepository.getReferenceById(user_id);

        Notes note = new Notes(content, visitor, country);

        return notesRepository.save(note);
    }

    @Override
    public Notes update(Long note_id, String content){
        Notes note = notesRepository.getReferenceById(note_id);
        note.setNote(content);
        return notesRepository.save(note);
    }

    @Override
    public void delete(Long note_id) {
        notesRepository.deleteById(note_id);
    }
}
