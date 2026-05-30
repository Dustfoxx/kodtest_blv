package kodtest.Countries;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VisitorController {
    private final VisitorRepository repository;

    VisitorController(VisitorRepository repository){
        this.repository = repository;
    }

    @GetMapping("/visitor")
    List<Visitor> all(){
        return repository.findAll();
    }

    @PostMapping("/visitor")
    Visitor newVisitor(@RequestBody Visitor newVisitor){
        return repository.save(newVisitor);
    }

    @GetMapping("/visitor/{id}")
    Visitor getFromId(@PathVariable Long id){
        return repository.findById(id).orElseThrow(() -> new VisitorNotFoundException(id));
    }

    @PutMapping("/visitor/{id}")
    Visitor replaceVisitor(@RequestBody Visitor newVisitor, @PathVariable Long id){
        return repository.findById(id)
        .map(visitor -> {
            visitor.setName(newVisitor.getName());
            return repository.save(visitor);
        }).orElseGet(() -> {
            return repository.save(newVisitor);
        });
    }

    @DeleteMapping("/visitor/{id}")
    void deleteVisitor(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
