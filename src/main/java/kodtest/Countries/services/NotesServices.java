package kodtest.Countries.services;

import kodtest.Countries.models.entities.Notes;
import org.springframework.stereotype.Service;

import java.util.List;

public interface NotesServices {
    List<Notes> getNotes(Long user_id);
    Notes addNote(Long user_id, Long country_id, String content);
    Notes update(Long note_id, String content);
    void delete(Long note_id);
}
