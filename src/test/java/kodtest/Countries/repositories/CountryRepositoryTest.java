package kodtest.Countries.repositories;

import kodtest.Countries.models.entities.Country;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CountryRepositoryTest {

    @Autowired
    private CountryRepository countryRepository;


    @BeforeEach
    void setup(){

    }

    @Test
    void getCountriesWithinRange() {
        var page = countryRepository.getCountriesWithinRange(1, 10);
        assertEquals(10, page.getSize());
        assertEquals(10, page.toList().size());
        System.out.println(page.toList().getFirst());
    }

    @Test
    void getCountriesSortedByName() {
        List<Country> list = countryRepository.getCountriesSortedByNameAsc();
        for(Country country : list) {
            System.out.println(country);
        }
    }

    @Test
    void filterByRegion(){
        Pageable page = PageRequest.of(1, 10, Sort.by(Sort.Direction.ASC, "name"));
        List<Country> list = countryRepository.getCountriesFilteredByRegion("Europe", page);
        assertEquals(10, list.size());
        for(var country : list){
            System.out.println(country.getName());
        }
    }

    @Test
    void filterByRegion_population(){
        Pageable page = PageRequest.of(0, 10, Sort.by(Sort.Direction.ASC, "population"));
        List<Country> list = countryRepository.getCountriesFilteredByRegion("Europe", page);
        assertEquals(10, list.size());
        for(var country : list){
            System.out.println(country.getName());
            System.out.println(country.getPopulation());
        }
    }
}