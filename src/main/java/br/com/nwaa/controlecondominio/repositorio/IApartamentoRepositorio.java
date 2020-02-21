package br.com.nwaa.controlecondominio.repositorio;

import br.com.nwaa.controlecondominio.dominio.Apartamento;
import br.com.nwaa.controlecondominio.dominio.Proprietario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IApartamentoRepositorio extends JpaRepository<Apartamento, Long> {

    public List<Apartamento> findByNomeIgnoreCaseContaining(String nome);

    public List<Apartamento> findByProprietario(Proprietario proprietario);

}
