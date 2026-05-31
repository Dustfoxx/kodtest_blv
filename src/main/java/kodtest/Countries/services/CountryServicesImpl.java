package kodtest.Countries.services;

import kodtest.Countries.models.CountryRequest;
import kodtest.Countries.models.entities.Country;
import kodtest.Countries.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServicesImpl implements CountryServices {
    private CountryRepository countryRepository;
    @Autowired
    public CountryServicesImpl(CountryRepository countryRepository){
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> getCountriesFromRequest(CountryRequest req) {
        Pageable page = PageRequest.of(req.page(), req.items_per_page()
                , Sort.by(req.asc() ? Sort.Direction.ASC : Sort.Direction.DESC,
                        req.population() ? "population" : "name"));

        return countryRepository.getCountriesFilteredByRegion(req.region(), page);
    }
}
