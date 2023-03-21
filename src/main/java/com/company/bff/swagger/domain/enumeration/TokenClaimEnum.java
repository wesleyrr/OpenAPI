package com.company.bff.swagger.domain.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TokenClaimEnum {

    @Deprecated
    CPF_CNPJ(Header.CPF_CNPJ),
    CPF(Header.CPF),
    CNPJ(Header.CNPJ),
    BRANCH(Header.BRANCH),
    ACCOUNT_NUMBER(Header.ACCOUNT_NUMBER),
    ACCOUNT_TYPE(Header.ACCOUNT_TYPE),
    ACCOUNT_REASON(Header.ACCOUNT_REASON),
    ACCOUNT_OPENING_DATE(Header.ACCOUNT_OPENING_DATE),
    PERIFERICO(Header.PERIFERICO),
    UUID(Header.UUID),
    CANAL(Header.CANAL),
    DEPENDENCIA(Header.DEPENDENCIA),
    EMPRESA(Header.EMPRESA),
    IDIOMA(Header.IDIOMA),
    ID_SESSAO(Header.ID_SESSAO),
    TICKET(Header.TICKET),
    TIPO_USUARIO(Header.TIPO_USUARIO),
    USUARIO(Header.USUARIO),
    VALIDATED_OTP(Header.VALIDATED_OTP),
    ACCOUNT_HOLDER(Header.ACCOUNT_HOLDER);

    private final String header;

    public static class Header {

        /**
         * @deprecated Usar os campos separados  CPF e CNPJ
         */
        @Deprecated
        public static final String CPF_CNPJ = "cpf-cnpj";
        public static final String CPF = "cpf";
        public static final String CNPJ = "cnpj";
        public static final String BRANCH = "branch";
        public static final String ACCOUNT_NUMBER = "account-number";
        public static final String ACCOUNT_TYPE = "account-type";
        public static final String ACCOUNT_REASON = "account-reason";
        public static final String ACCOUNT_OPENING_DATE = "account-opening-date";
        public static final String PERIFERICO = "periferico";
        public static final String UUID = "uuid";
        public static final String CANAL = "canal";
        public static final String DEPENDENCIA = "dependencia";
        public static final String EMPRESA = "empresa";
        public static final String IDIOMA = "idioma";
        public static final String ID_SESSAO = "id-sessao";
        public static final String TICKET = "ticket";
        public static final String TIPO_USUARIO = "tipo-usuario";
        public static final String USUARIO = "usuario";
        public static final String VALIDATED_OTP = "validated-otp";
        public static final String ACCOUNT_HOLDER = "account-holder";

        private Header() { }
    }
}
