package br.com.nwaa.controlecondominio.enuns;

public enum TipoTelefoneEnum {
    RESIDENCIAL(1), CELULAR(2), COMERCIAL(3);

    private final int codigo;

    TipoTelefoneEnum(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }
}
