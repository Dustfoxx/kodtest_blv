package Countries;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {
  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  CommandLineRunner initDatabase(UserRepository repository) {
    return args -> {
      log.info("Preloading " + repository.save(new User("Selina Kyle")));
      log.info("Preloading " + repository.save(new User("Basil Karlo")));
      log.info("Preloading " + repository.save(new User("Jonathan Crane")));
      log.info("Preloading " + repository.save(new User("Jack Napier")));
      log.info("Preloading " + repository.save(new User("Pamela Isley")));
    };
  }
}