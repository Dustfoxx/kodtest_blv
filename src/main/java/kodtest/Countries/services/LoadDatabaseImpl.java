package kodtest.Countries.services;

import jakarta.annotation.PostConstruct;
import kodtest.Countries.models.entities.Country;
import kodtest.Countries.models.CountryJSON;
import kodtest.Countries.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class LoadDatabaseImpl implements LoadDatabase {
    private CountryRepository countryRepository;
    @Autowired
    public LoadDatabaseImpl(CountryRepository countryrepository){
        this.countryRepository = countryrepository;
    }


    @Override
    @PostConstruct
    public void loadDatabaseFromRestCountries() {
        WebClient client = WebClient.create("https://restcountries.com/v3.1/");

        CountryJSON[] response = client.get()
                .uri("all?fields=name,region,population")
                .retrieve()
                .bodyToMono(CountryJSON[].class).block();

        for(var country : response){
            countryRepository.save(new Country(country.name().common(), country.region(), country.population()));
        }
    }
}
