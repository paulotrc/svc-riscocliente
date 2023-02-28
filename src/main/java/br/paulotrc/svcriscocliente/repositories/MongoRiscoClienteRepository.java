package br.paulotrc.svcriscocliente.repositories;

import br.paulotrc.svcriscocliente.entites.RiscoCliente;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.UUID;

public interface MongoRiscoClienteRepository extends MongoRepository<RiscoCliente, UUID> {

    @Query("{cpf: { $regex: ?0 } })")
    List<RiscoCliente> consultarPorCpf(String cpf);

    @Query("{cep: { $regex: ?0 } })")
    List<RiscoCliente> consultarPorCep(String cep);
}
