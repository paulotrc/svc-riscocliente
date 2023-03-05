package br.paulotrc.svcriscocliente.datasources;

import br.paulotrc.svcriscocliente.entites.RiscoCliente;
import br.paulotrc.svcriscocliente.repositories.RiscoClienteRepository;
import br.paulotrc.svcriscocliente.repositories.MongoRiscoClienteRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class RiscoClienteDataSource implements RiscoClienteRepository {

    private final Logger log = LoggerFactory.getLogger(RiscoClienteDataSource.class);
    private MongoRiscoClienteRepository mongoRiscoClienteRepository;

    public RiscoCliente save(RiscoCliente riscoCliente){
        riscoCliente.setId(UUID.randomUUID());
        return this.mongoRiscoClienteRepository.save(riscoCliente);
    }

    @Override
    public List<RiscoCliente> consultarPorCpf(String cpf) {
        return mongoRiscoClienteRepository.consultarPorCpf(cpf);
    }

}
