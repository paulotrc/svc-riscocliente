package br.paulotrc.svcriscocliente.entites.feign;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Status {
    @JsonProperty("codigo")
    private String codigo;
    @JsonProperty("erros")
    private Erros erros;
}
