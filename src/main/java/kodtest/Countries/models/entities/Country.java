package kodtest.Countries.models.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.util.Objects;

@Entity
public class Country {
  private @Id
  @GeneratedValue Long id;
  private String name;
  private String region;
  private int population;

  public Country(){}

  public Country(String name, String region, int population) {
    this.name = name;
    this.region = region;
    this.population = population;
}

  public Long getId() { return this.id; }

  public String getName() { return this.name; }

  public String getRegion() { return this.region; }
  
  public int getPopulation() { return this.population; }

  public void setId(Long id) { this.id = id; }

  public void setName(String name) { this.name = name; }

  public void setRegion(String region) { this.region = region; }

  public void setPopulation(int population) { this.population = population; }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (!(object instanceof Country)) {
      return false;
    }
    Country country = (Country) object;
    return Objects.equals(this.id, country.id) && Objects.equals(this.name, country.name)
    && Objects.equals(this.region, country.region)
    && Objects.equals(this.population, country.population);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.id, this.name, this.region, this.population);
  }

  @Override
  public String toString() {
    return "Country{"
        + "id=" + this.id + ", name=" + this.name + 
        ", region=" + this.region + ", population=" + this.population + "}";
  }
}