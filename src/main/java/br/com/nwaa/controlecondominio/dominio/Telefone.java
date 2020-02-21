package br.com.nwaa.controlecondominio.dominio;

import br.com.nwaa.controlecondominio.enuns.TipoTelefoneEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "tb_telefone")
public class Telefone implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private TipoTelefoneEnum tipoTelefone;
    private String numero;

    @ManyToOne
    @JoinColumn(name = "proprietario_id")
    private Proprietario proprietario;

}
