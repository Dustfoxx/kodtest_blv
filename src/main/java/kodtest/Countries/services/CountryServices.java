package kodtest.Countries.services;

import kodtest.Countries.models.CountryRequest;
import kodtest.Countries.models.entities.Country;

import java.util.List;

public interface CountryServices {
    List<Country> getCountriesFromRequest(CountryRequest req);
}
