package br.paulotrc.svcriscocliente.exceptions.bussiness;

import br.paulotrc.svcriscocliente.exceptions.ResourceException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CepInexistenteException extends ResourceException {
    private static final long serialVersionUID = 1L;
    private String code;
    private String message;
    private String developerMessage;
    private String origin;

    @Override
    public String toString() {
        return "CepInexistenteException{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", developerMessage='" + developerMessage + '\'' +
                ", origin='" + origin + '\'' +
                '}';
    }
}
