package br.paulotrc.svcriscocliente.entites;

import br.paulotrc.svcriscocliente.entites.enumerados.TipoRiscoCliente;
import br.paulotrc.svcriscocliente.entites.enumerados.TipoRestricaoRiscoCliente;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Builder
@Setter
@AllArgsConstructor
@Document //Anotação mongo para mapeamento do document.
public class RiscoCliente {

    @Id
    private UUID id = UUID.randomUUID();
    private String cpf; //Documento de identificação do dono do imóvel
    private LocalDate dataInclusao;
    private Integer validadeEmMeses;
    private TipoRiscoCliente tipoRiscoCliente;
    private TipoRestricaoRiscoCliente restricaoCadastrorisco;
    private Boolean riscoAtivo;
}

