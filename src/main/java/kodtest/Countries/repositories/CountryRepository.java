package kodtest.Countries.repositories;

import kodtest.Countries.models.entities.Country;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country, Long> {
    default Page<Country> getCountriesWithinRange(int page, int items_per_page){
        Pageable range = PageRequest.of(page, items_per_page, Sort.by(Sort.Direction.ASC, "name"));
        return this.findAll(range);
    }


    @Query("select c from Country c order by c.name asc")
    List<Country> getCountriesSortedByNameAsc();

    @Query("select c from Country c where c.region = :region")
    List<Country> getCountriesFilteredByRegion(String region, Pageable page);
}