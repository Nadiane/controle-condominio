package br.com.nwaa.controlecondominio.repositorio;

import br.com.nwaa.controlecondominio.dominio.Condominio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICondominioRepositorio extends JpaRepository<Condominio, Long> {

}
