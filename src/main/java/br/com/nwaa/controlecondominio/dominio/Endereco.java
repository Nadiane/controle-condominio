package br.com.nwaa.controlecondominio.dominio;

import br.com.nwaa.controlecondominio.enuns.LogradouroEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tb_endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LogradouroEnum logradouro;
    private String endereco;
    private Integer numero;
    private String complemento;
    private String bairro;
    private String municipio;
    private String estado;
    private String cep;

}
