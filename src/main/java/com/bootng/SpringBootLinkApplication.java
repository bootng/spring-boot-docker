package com.bootng;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ComponentScan({"com.bootng"})
@SpringBootApplication
public class SpringBootLinkApplication {

  private static final Logger log = LoggerFactory.getLogger(SpringBootLinkApplication.class);

  public static void main(String args[]) {
    log.info("about to call RestApplication.run()");
    SpringApplication.run(SpringBootLinkApplication.class, args);
    log.info("completed executing RestApplication.run()");
  }

  @Bean
  public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
    return args -> {

      log.info("Let's inspect the beans provided by Spring Boot:");
      String[] beanNames = ctx.getBeanDefinitionNames();
      Arrays.sort(beanNames);
      for (String beanName : beanNames) {
        log.info(beanName);
      }
    };
  }
}
