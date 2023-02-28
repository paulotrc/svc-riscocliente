package br.paulotrc.svcriscocliente.repositories;

import br.paulotrc.svcriscocliente.entites.RiscoCliente;

import java.util.List;

public interface RiscoClienteRepository {

        RiscoCliente save(RiscoCliente riscoCliente);
        List<RiscoCliente> findAll();
        List<RiscoCliente> consultarPorCpf(String cpf);
        List<RiscoCliente> consultarPorCep(String cep);

    }

