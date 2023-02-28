package br.paulotrc.svcriscocliente.transportlayers.impl;

import br.paulotrc.svcriscocliente.entites.RiscoCliente;
import br.paulotrc.svcriscocliente.exceptions.ExceptionUtil;
import br.paulotrc.svcriscocliente.exceptions.ResourceException;
import br.paulotrc.svcriscocliente.iteractors.RiscoClienteUseCase;
import br.paulotrc.svcriscocliente.transportlayers.RiscoClienteResourceI;
import br.paulotrc.svcriscocliente.transportlayers.dto.request.RiscoClienteRequest;
import br.paulotrc.svcriscocliente.transportlayers.dto.response.RiscoClienteResponse;
import br.paulotrc.svcriscocliente.transportlayers.mappers.RiscoClienteMapper;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
public class RiscoClienteResource implements RiscoClienteResourceI {

    private RiscoClienteUseCase riscoClienteUseCase;

    public RiscoClienteResource(RiscoClienteUseCase riscoClienteUseCase) {
        this.riscoClienteUseCase = riscoClienteUseCase;
    }

    @Override
    public ResponseEntity<List<RiscoClienteResponse>> get(
            @Parameter(name = "cpf", description = "Número do CPF do Cliente", required = true)
            @PathVariable("cpf") String cpf
    ) {
        List<RiscoCliente> riscoClientes = null;
        try {
            riscoClientes = riscoClienteUseCase.consultarPorCpf(cpf);
        }catch (ResourceException e){
            ExceptionUtil.throwException(e);
        }
        return ResponseEntity.ok(RiscoClienteMapper.INSTANCE.mapListResponse(riscoClientes));
    }

    @Override
    public ResponseEntity<List<RiscoClienteResponse>> getPorCep(
            @Parameter(name = "cep", description = "Cep do imóvel", required = true)
            @PathVariable("cep") String cep
    ) {
        List<RiscoCliente> riscoClientes = null;
        try {
            riscoClientes = riscoClienteUseCase.consultarPorCep(cep);
        }catch (ResourceException e){
            ExceptionUtil.throwException(e);
        }
        return ResponseEntity.ok(RiscoClienteMapper.INSTANCE.mapListResponse(riscoClientes));
    }

    @Override
    public ResponseEntity<List<RiscoClienteResponse>> getAll() {
        List<RiscoCliente> riscoClientes = null;
        try {
            riscoClientes = riscoClienteUseCase.consultaTodos();
        }catch (ResourceException e){
            ExceptionUtil.throwException(e);
        }
        return ResponseEntity.ok(RiscoClienteMapper.INSTANCE.mapListResponse(riscoClientes));
    }

    @Override
    public ResponseEntity<RiscoClienteResponse> post(@Valid @RequestBody RiscoClienteRequest riscoClienteRequest) {
        RiscoCliente riscoCliente = null;
        try {
            riscoCliente = riscoClienteUseCase.gravarCadastrorisco(RiscoClienteMapper.INSTANCE.map(riscoClienteRequest));
        }catch (ResourceException e){
            ExceptionUtil.throwException(e);
        }
        return ResponseEntity.ok(RiscoClienteMapper.INSTANCE.mapResponse(riscoCliente));
    }
}
