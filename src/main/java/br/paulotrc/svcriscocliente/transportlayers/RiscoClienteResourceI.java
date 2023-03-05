package br.paulotrc.svcriscocliente.transportlayers;

import br.paulotrc.svcriscocliente.transportlayers.dto.request.RiscoClienteRequest;
import br.paulotrc.svcriscocliente.transportlayers.dto.response.RiscoClienteResponse;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.List;

@Tag(name = "Risco Cliente", description = "Operações de Risco Cliente")
@RequestMapping(value = "/api/v1")
public interface RiscoClienteResourceI {

    @Operation(summary = "Obter as informações de Risco Cliente pelo seu cpf")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Dados de Risco encontrado",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = RiscoClienteRequest.class))}),
            @ApiResponse(responseCode = "400", description = "Dados de Risco não encontrado",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = Void.class))}),
            @ApiResponse(responseCode = "404", description = "Erro",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = Void.class))}),
            @ApiResponse(responseCode = "500", description = "Erro interno",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = Void.class))}),
            @ApiResponse(responseCode = "501", description = "Ainda não implementado",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = Void.class))}),

    })
    @CircuitBreaker(name = "processServiceMongo", fallbackMethod = "fallback")
    @Retry(name = "default")
    @GetMapping (value = "/riscocliente/{cpf}", produces = {MediaType.APPLICATION_JSON_VALUE})
    @Valid
    ResponseEntity<List<RiscoClienteResponse>> get(
            @Parameter(name = "cpf", description = "Número do CPF do Cliente", required = true)
            @Valid @Size(min = 11, max = 11) @PathVariable("cpf") String cpf
    );


    @Operation(summary = "Salvar os dados de informação de Risco Cliente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Dados de Risco Cliente cadastrados",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = RiscoClienteResponse.class))}),
            @ApiResponse(responseCode = "500", description = "Erro interno",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = Void.class))}),
            @ApiResponse(responseCode = "501", description = "Ainda não implementado",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = Void.class))}),

    })
    @CircuitBreaker(name = "processServiceMongo", fallbackMethod = "fallback")
    @Retry(name = "default")
    @PostMapping (value = "/riscocliente/", produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<RiscoClienteResponse> post(@Valid @RequestBody RiscoClienteRequest riscoClienteRequest);

}
