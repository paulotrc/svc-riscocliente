package br.paulotrc.svcriscocliente.configs.properties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ConfigurationProperties("cep.api")
public class CepProperties {
    @NotNull(message = "A URL não deve ser nula")
    private String url;

}
