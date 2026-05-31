package kodtest.Countries.models;

public record CountryRequest(int page, int items_per_page, String region, boolean population, boolean asc) {
}
