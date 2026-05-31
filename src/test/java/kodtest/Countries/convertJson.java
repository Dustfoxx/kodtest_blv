package kodtest.Countries;

import java.io.IOException;

import kodtest.Countries.models.CountryJSON;
import org.junit.jupiter.api.Test;

import org.springframework.web.reactive.function.client.WebClient;
import tools.jackson.databind.ObjectMapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class convertJson {
    ObjectMapper om = new ObjectMapper();


    @Test
    void loadAllJson() throws IOException{

        var response = this.getClass().getResourceAsStream("/all.json").readAllBytes();

        CountryJSON[] countries = om.readValue(response, CountryJSON[].class);
        System.out.println(countries);
    }

    @Test
    void loadJson() throws IOException{

        var response = this.getClass().getResourceAsStream("/anguilla.json").readAllBytes();

        CountryJSON countries = om.readValue(response, CountryJSON.class);
        System.out.println(countries);
        assertEquals("Anguilla", countries.name().common());
    }

    @Test
    void loadFromAPI() throws IOException {
        WebClient client = WebClient.create("https://restcountries.com/v3.1/");

        CountryJSON[] response = client.get()
                .uri("all?fields=name,region,population")
                .retrieve()
                .bodyToMono(CountryJSON[].class).block();

        for(var country : response){
            System.out.println(country);
        }
    }

}
