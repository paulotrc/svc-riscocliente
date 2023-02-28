package br.paulotrc.svcriscocliente.entites.feign;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class ResponseApiCepData {

        private String code;
        private String state;
        private String city;
        private String district;
        private String address;
        private Integer status;
        private Boolean ok;
        private String statusText;

}
