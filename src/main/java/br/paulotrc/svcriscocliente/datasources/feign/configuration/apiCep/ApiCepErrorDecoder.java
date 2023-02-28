package br.paulotrc.svcriscocliente.datasources.feign.configuration.apiCep;

import br.paulotrc.svcriscocliente.entites.feign.ResponseApiCepData;
import br.paulotrc.svcriscocliente.exceptions.feign.GatewayResourceIntegrationRuntimeException;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.io.InputStream;

public class ApiCepErrorDecoder implements ErrorDecoder {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Exception decode(String s, Response response) {
        try {
            InputStream body = response.body().asInputStream();

            ResponseApiCepData responseGerarCcb = objectMapper.readValue(body, ResponseApiCepData.class);

            return new GatewayResourceIntegrationRuntimeException(
                    responseGerarCcb.getStatusText(),
                    responseGerarCcb.getStatus().toString(),
                    HttpStatus.valueOf(response.status()),
                    "INTERNAL");

        } catch (IOException e) {
            return new GatewayResourceIntegrationRuntimeException(response.reason(),
                    response.body().toString(),
                    HttpStatus.valueOf(response.status()),
                    "INTERNAL");
        }
    }

}
