package kodtest.Countries.controllers;

import kodtest.Countries.exceptions.CountryNotFoundException;
import kodtest.Countries.models.CountryRequest;
import kodtest.Countries.models.entities.Country;
import kodtest.Countries.repositories.CountryRepository;
import kodtest.Countries.services.CountryServices;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.data.domain.Page;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class CountryController {
    private final CountryRepository repository;
    private final CountryServices countryServices;

    private EntityModel<Country> createEntityModelFromCountry(Country country){
        return EntityModel.of(country,
          linkTo(methodOn(CountryController.class).getFromId(country.getId())).withSelfRel(),
          linkTo(methodOn(CountryController.class).all()).withRel("countries"));
    }

    public CountryController(CountryRepository repository, CountryServices countryServices){
        this.repository = repository;
        this.countryServices = countryServices;
    }

    @GetMapping("/country/{id}")
    public EntityModel<Country> getFromId(@PathVariable Long id){
        Country  country = repository.findById(id).orElseThrow(() -> new CountryNotFoundException(id));
        return createEntityModelFromCountry(country);
    }

    @GetMapping("/countries/all")
    public CollectionModel<EntityModel<Country>> all(){
        List<EntityModel<Country>> countries = repository.findAll().stream()
        .map(this::createEntityModelFromCountry).collect(Collectors.toList());

        return CollectionModel.of(countries, linkTo(methodOn(CountryController.class).all()).withSelfRel());
    }

    @GetMapping("/countries/{page}/{items_per_page}")
    public Page<Country> getWithPagination(@PathVariable @DefaultValue("0") int page, @PathVariable @DefaultValue("10") int items_per_page){
        return repository.getCountriesWithinRange(page, items_per_page);
    }

    @PostMapping("/countries")
    public List<Country> getCountriesWithFiltering(@RequestBody CountryRequest req){
        return countryServices.getCountriesFromRequest(req);
    }

}
