package br.com.nwaa.controlecondominio.dominio;

import br.com.nwaa.controlecondominio.enuns.SituacaoEnum;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tb_condominio")
public class Condominio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @OneToOne
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    private SituacaoEnum situacao;

    @Column(name = "quantidade_funcionario")
    private Integer quantidadeFuncionario;

    @Column(name = "total_unidades")
    private Integer totalUnidades;

    @OneToMany(mappedBy = "condominio")
    private List<Apartamento> apartamentos;

}
