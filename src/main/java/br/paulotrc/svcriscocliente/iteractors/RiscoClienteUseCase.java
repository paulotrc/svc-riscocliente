package br.paulotrc.svcriscocliente.iteractors;

import br.paulotrc.svcriscocliente.entites.RiscoCliente;
import br.paulotrc.svcriscocliente.repositories.RiscoClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RiscoClienteUseCase {

    private RiscoClienteRepository riscoClienteRepository;

    public RiscoClienteUseCase(RiscoClienteRepository riscoClienteRepository) {
        this.riscoClienteRepository = riscoClienteRepository;
    }

    public RiscoCliente gravarRiscoCliente(RiscoCliente riscoCliente) {
        return riscoClienteRepository.save(riscoCliente);
    }

    public List<RiscoCliente> consultarPorCpf(String cpf) {
        return riscoClienteRepository.consultarPorCpf(cpf);
    }

}
