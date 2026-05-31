package kodtest.Countries.controllers;

import kodtest.Countries.models.NoteRequest;
import kodtest.Countries.models.entities.Notes;
import kodtest.Countries.services.NotesServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NotesController {
    private final NotesServices notesService;

    NotesController(NotesServices notesService){
        this.notesService = notesService;
    }

    @GetMapping("/notes/{id}")
    public List<Notes> userNotes(@PathVariable Long id){
        return notesService.getNotes(id);
    }

    @PostMapping("/notes")
    public Notes newNote(@RequestBody NoteRequest noteRequest){
        return notesService.addNote(noteRequest.user_id(), noteRequest.country_id(), noteRequest.content());
    }

    @PutMapping("/notes/{id}/{content}")
    public Notes updateNote(@PathVariable Long id, @PathVariable String content){
        return notesService.update(id, content);
    }

    @DeleteMapping("/notes/{id}")
    public void deleteNote(@PathVariable Long id) {
        notesService.delete(id);
    }
}
