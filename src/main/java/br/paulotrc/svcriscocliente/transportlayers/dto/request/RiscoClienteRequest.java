package br.paulotrc.svcriscocliente.transportlayers.dto.request;

import br.paulotrc.svcriscocliente.entites.enumerados.TipoRiscoCliente;
import br.paulotrc.svcriscocliente.entites.enumerados.TipoRestricaoRiscoCliente;
import br.paulotrc.svcriscocliente.entites.validators.TipoRiscoClienteValidator;
import br.paulotrc.svcriscocliente.entites.validators.TipoRestricaoRiscoClienteValidator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class RiscoClienteRequest {

    private UUID id = UUID.randomUUID();

    @NotBlank(message = "CPF é obrigatório")
    private String cpf; //Documento de identificação do dono do imóvel

    @NotBlank(message = "Cep é obrigatório")
    @Pattern(regexp = "^\\d{1,5}-\\d{1,3}$", message = "Cep inválido, utilize o seguinte formato: 99999-99.")
    private String cep;
    private String estado;
    private String cidade;
    private String bairro;
    private String endereco;
    @NotBlank(message = "Número é obrigatório")
    private String numero;
    @NotBlank(message = "Complemento é obrigatório")
    private String complemento;
    private String referencia;
    @PastOrPresent(message = "DataCompra é obrigatório e não pode ser compra futura.")
    private LocalDate dataCompra;
    private LocalDate dataFimContrato;
    private LocalDate dataQuitacao;
    @Positive(message = "ParcelasTotais é obrigatório e deve ser maior que zero.")
    private Integer parcelasTotais;
    @PositiveOrZero(message = "ParcelasPagas é obrigatório, caso ainda não tenha nenhuma parcela paga, indicar como 0 (zero).")
    private Integer parcelasPagas;
    @TipoRestricaoRiscoClienteValidator(regexp = "DIVIDA|SITUACAO_CADASTRAL|CPF_CANCELADO|CPF_PENDENTE|CPF_NULO")
    private TipoRestricaoRiscoCliente restricaoCadastrorisco;
    @TipoRiscoClienteValidator(regexp = "CASA|APARTAMENTO|FLAT|KITNET|GALPAO")
    private TipoRiscoCliente tipoRiscoCliente;
}

