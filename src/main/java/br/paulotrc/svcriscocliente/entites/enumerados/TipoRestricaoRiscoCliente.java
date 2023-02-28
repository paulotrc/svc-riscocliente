package br.paulotrc.svcriscocliente.entites.enumerados;

public enum TipoRestricaoRiscoCliente {
    SPC("Spc"),
    SERASA("Serasa"),
    BACEN("Bacen"),
    INFO_IMOVEL_IRREGULAR("Informações de Imóvel Irregulares"),
    INFO_AUTOMOVEL_IRREGULAR("Informações de Automóvel Irregulares"),
    SUSPEITA_FRAUDE("Suspeita de Fraude");

    private String descricao;

    TipoRestricaoRiscoCliente(String descricao) {
        this.descricao = descricao;
    }
}