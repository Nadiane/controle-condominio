package br.com.nwaa.controlecondominio.repositorio;

import br.com.nwaa.controlecondominio.dominio.Proprietario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProprietarioRepositorio extends JpaRepository<Proprietario, Long> {

    public List<Proprietario> findByNomeIgnoreCaseContaining(String nome);
}
