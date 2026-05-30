package kodtest.Countries;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {
  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  CommandLineRunner initDatabase(VisitorRepository repository) {
    return args -> {
      log.info("Preloading " + repository.save(new Visitor("Selina Kyle")));
      log.info("Preloading " + repository.save(new Visitor("Basil Karlo")));
      log.info("Preloading " + repository.save(new Visitor("Jonathan Crane")));
      log.info("Preloading " + repository.save(new Visitor("Jack Napier")));
      log.info("Preloading " + repository.save(new Visitor("Pamela Isley")));
    };
  }
}