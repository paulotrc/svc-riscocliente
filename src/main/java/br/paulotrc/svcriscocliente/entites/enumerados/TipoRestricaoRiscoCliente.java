package br.paulotrc.svcriscocliente.entites.enumerados;

public enum TipoRestricaoRiscoCliente {
    DIVIDA("Dívida"),
    SITUACAO_CADASTRAL("Situação Cadastral"),
    CPF_CANCELADO("CPF Cancelado"),
    CPF_PENDENTE("CPF Pendente"),
    CPF_NULO("CPF Nulo");

    private String descricao;

    TipoRestricaoRiscoCliente(String descricao) {
        this.descricao = descricao;
    }
}