package br.com.nwaa.controlecondominio.enuns;

public enum SexoEnum {
    MASCULINO(1), FEMININO(2);

    private final int codigo;

    SexoEnum(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }
}
