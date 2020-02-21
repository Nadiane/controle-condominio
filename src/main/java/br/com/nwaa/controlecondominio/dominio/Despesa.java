package br.com.nwaa.controlecondominio.dominio;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tb_despesa")
public class Despesa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "codigo_documento")
    private Long codigoDocumento;

    private String descricao;
    private Double valor;

    @Column(name = "data_lancamento")
    private Date dataLancamento;

    @Column(name = "data_vencimento")
    private Date dataVencimento;

    private Double desconto;
    private Double juros;
    private String obs;

    @ManyToOne
    @JoinColumn(name = "tipo_despesa_id")
    private TipoDespesa tipoDespesa;

    @ManyToOne
    @JoinColumn(name = "apartamento_id")
    private Apartamento apartamento;
}
