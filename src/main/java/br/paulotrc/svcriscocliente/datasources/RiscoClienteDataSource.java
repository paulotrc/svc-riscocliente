package br.paulotrc.svcriscocliente.datasources;

import br.paulotrc.svcriscocliente.entites.RiscoCliente;
import br.paulotrc.svcriscocliente.entites.feign.ResponseApiCepData;
import br.paulotrc.svcriscocliente.exceptions.bussiness.CepInexistenteException;
import br.paulotrc.svcriscocliente.exceptions.feign.GatewayResourceIntegrationRuntimeException;
import br.paulotrc.svcriscocliente.repositories.ApiCepRepository;
import br.paulotrc.svcriscocliente.repositories.RiscoClienteRepository;
import br.paulotrc.svcriscocliente.repositories.MongoRiscoClienteRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RiscoClienteDataSource implements RiscoClienteRepository {

    private final Logger log = LoggerFactory.getLogger(RiscoClienteDataSource.class);
    private MongoRiscoClienteRepository mongoRiscoClienteRepository;
    private ApiCepRepository apiCepRepository;

    public RiscoCliente save(RiscoCliente riscoCliente){
        ResponseApiCepData data = apiCepRepository.consultarPorCep(riscoCliente.getCep());
        if(null != data){
            atualizaDadosComDadosRecuperadosDaApi(riscoCliente, data);
            return this.mongoRiscoClienteRepository.save(riscoCliente);
        }else{
            throw new CepInexistenteException(HttpStatus.NOT_FOUND.toString(), "Cep Inexistente.", "Validar se API está correta.", MensagemDataSource.Origem.SERVICE_API_CEP);
        }
    }

    private void atualizaDadosComDadosRecuperadosDaApi(RiscoCliente riscoCliente, ResponseApiCepData data) {
        riscoCliente.setEstado(data.getState());
        riscoCliente.setCidade(data.getCity());
        riscoCliente.setBairro(data.getDistrict());
        riscoCliente.setEndereco(data.getAddress());
    }

    public List<RiscoCliente> findAll(){
        return this.mongoRiscoClienteRepository.findAll();
    }

    @Override
    public List<RiscoCliente> consultarPorCpf(String cpf) {
        return mongoRiscoClienteRepository.consultarPorCpf(cpf);
    }

    @Override
    public List<RiscoCliente> consultarPorCep(String cep) {
        try {
            ResponseApiCepData data = apiCepRepository.consultarPorCep(cep);
            if(null != data){
                return mongoRiscoClienteRepository.consultarPorCep(cep);
            }else{
                throw new CepInexistenteException(HttpStatus.NOT_FOUND.toString(), "Cep Inexistente.", "Validar se API está correta.", MensagemDataSource.Origem.SERVICE_API_CEP);
            }
        }catch (GatewayResourceIntegrationRuntimeException e){
            throw new CepInexistenteException(HttpStatus.NOT_FOUND.toString(), "Cep Inexistente.", "Validar se API está correta.", MensagemDataSource.Origem.SERVICE_API_CEP);
        }
    }
}
