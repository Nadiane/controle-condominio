package br.com.nwaa.controlecondominio.enuns;

public enum  SituacaoEnum {
    ATIVO(1), INATIVO(2);

    private final int codigo;

    SituacaoEnum(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }
}
