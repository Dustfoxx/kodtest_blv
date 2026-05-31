package kodtest.Countries.controllers;

import java.util.List;
import java.util.stream.Collectors;

import kodtest.Countries.exceptions.VisitorNotFoundException;
import kodtest.Countries.models.entities.Visitor;
import kodtest.Countries.repositories.VisitorRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.CollectionModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
public class VisitorController {
    private final VisitorRepository repository;

    private EntityModel<Visitor> createEntityModelFromVisitor(Visitor visitor){
        return EntityModel.of(visitor,
          linkTo(methodOn(VisitorController.class).getFromId(visitor.getId())).withSelfRel(),
          linkTo(methodOn(VisitorController.class).all()).withRel("visitors"));
    }

    VisitorController(VisitorRepository repository){
        this.repository = repository;
    }

    @GetMapping("/visitors")
    CollectionModel<EntityModel<Visitor>> all(){
        List<EntityModel<Visitor>> visitors = repository.findAll().stream()
        .map(visitor -> createEntityModelFromVisitor(visitor)).collect(Collectors.toList());

        return CollectionModel.of(visitors, linkTo(methodOn(VisitorController.class).all()).withSelfRel());
    }

    @PostMapping("/visitors")
    Visitor newVisitor(@RequestBody Visitor newVisitor){
        return repository.save(newVisitor);
    }

    @GetMapping("/visitors/{id}")
    EntityModel<Visitor> getFromId(@PathVariable Long id){
        Visitor  visitor = repository.findById(id).orElseThrow(() -> new VisitorNotFoundException(id));
        return createEntityModelFromVisitor(visitor);
    }

    @PutMapping("/visitors/{id}")
    Visitor replaceVisitor(@RequestBody Visitor newVisitor, @PathVariable Long id){
        return repository.findById(id)
        .map(visitor -> {
            visitor.setName(newVisitor.getName());
            return repository.save(visitor);
        }).orElseGet(() -> {
            return repository.save(newVisitor);
        });
    }

    @DeleteMapping("/visitors/{id}")
    void deleteVisitor(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
