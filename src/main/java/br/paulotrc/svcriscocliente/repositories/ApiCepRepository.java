package br.paulotrc.svcriscocliente.repositories;

import br.paulotrc.svcriscocliente.entites.feign.ResponseApiCepData;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

public interface ApiCepRepository {

    @CircuitBreaker(name = "processServiceApiCep", fallbackMethod = "fallback")
    @Retry(name = "default")
    ResponseApiCepData consultarPorCep(String cep);
}
