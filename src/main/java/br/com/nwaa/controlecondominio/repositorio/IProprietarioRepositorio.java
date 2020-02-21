package br.com.nwaa.controlecondominio.repositorio;

import br.com.nwaa.controlecondominio.dominio.Proprietario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProprietarioRepositorio extends JpaRepository<Proprietario, Long> {

    public Proprietario findByNomeIgnoreCaseContaining(String nome);
}
