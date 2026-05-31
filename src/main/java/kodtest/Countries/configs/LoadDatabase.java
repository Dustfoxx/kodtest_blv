package kodtest.Countries.configs;

import kodtest.Countries.models.entities.Visitor;
import kodtest.Countries.repositories.CountryRepository;
import kodtest.Countries.repositories.VisitorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {
  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  CommandLineRunner initDatabase(VisitorRepository visitorRepository, CountryRepository countryRepository) {
    return args -> {
      log.info("Preloading " + visitorRepository.save(new Visitor("Selina Kyle")));
      log.info("Preloading " + visitorRepository.save(new Visitor("Basil Karlo")));
      log.info("Preloading " + visitorRepository.save(new Visitor("Jonathan Crane")));
      log.info("Preloading " + visitorRepository.save(new Visitor("Jack Napier")));
      log.info("Preloading " + visitorRepository.save(new Visitor("Pamela Isley")));
    };
  }
}