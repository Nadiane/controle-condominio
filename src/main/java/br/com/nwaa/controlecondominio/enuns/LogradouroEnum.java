package br.com.nwaa.controlecondominio.enuns;

public enum LogradouroEnum {
    RUA(1), AVENIDA(2);

    private final int codigo;

    LogradouroEnum(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }
}
