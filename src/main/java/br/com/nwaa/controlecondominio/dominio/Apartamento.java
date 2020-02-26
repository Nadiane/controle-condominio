package br.com.nwaa.controlecondominio.dominio;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tb_apartamento")
public class Apartamento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "proprietario_id")
    private Proprietario proprietario;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "condominio_id")
    private Condominio condominio;

    @Column(name = "quantidade_garagem")
    private Integer quantidadeGaragem;

    @OneToMany(mappedBy = "apartamento")
    private List<Despesa> despesas;

}
