package br.paulotrc.svcriscocliente.transportlayers.mappers;

import br.paulotrc.svcriscocliente.entites.RiscoCliente;
import br.paulotrc.svcriscocliente.transportlayers.dto.request.RiscoClienteRequest;
import br.paulotrc.svcriscocliente.transportlayers.dto.response.RiscoClienteResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface RiscoClienteMapper {

    RiscoClienteMapper INSTANCE = Mappers.getMapper(RiscoClienteMapper.class);

    RiscoCliente map(RiscoClienteRequest riscoClienteRequest);

    RiscoClienteResponse mapResponse(RiscoCliente riscoCliente);

    default List<RiscoClienteResponse> mapListResponse(List<RiscoCliente> riscoClientes){
        final List<RiscoClienteResponse> riscoClienteResponseList = new ArrayList<>();
        for (RiscoCliente riscoCliente : riscoClientes) {
            RiscoClienteResponse cadastroriscoResp = RiscoClienteMapper.INSTANCE.mapResponse(riscoCliente);
            riscoClienteResponseList.add(cadastroriscoResp);
        }
        return riscoClienteResponseList;
    }
}

