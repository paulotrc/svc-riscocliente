package br.paulotrc.svcriscocliente.datasources;

public final class MensagemDataSource {

    private MensagemDataSource(){
    }

    public static class Erro {
        private Erro(){
        }

        public static final String LOG = " Erro messsage : {} , cause: {}, stacktrace : {}";
    }

    public static class Origem {
        private Origem(){
        }

        public static final String SERVICE_RISCO_CLIENTE = "SERVICE RISCO CLIENTE";
    }

    public static class MessageDataSource {

        private MessageDataSource() {
        }

        public static final String ERRO_CONSULTA_IMOVEL = "Erro ao consultar o Dados de Risco Cliente";
        public static final String INTERNAL_ERROR_EXCEPTION = "ERRO AO EXECUTAR UMA OPERAÇÃO";
        public static final String JSON_ERROR_EXCEPTION = "ERRO AO EFETUAR UMA OPERAÇÃO COM JSON";

    }
}
