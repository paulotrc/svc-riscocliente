package br.paulotrc.svcriscocliente;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
@EnableConfigurationProperties
@EnableFeignClients
public class SvcRiscoClienteApplication {

    public static void main(String[] args) {
        SpringApplication.run(SvcRiscoClienteApplication.class, args);
    }

}
