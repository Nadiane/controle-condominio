package br.com.nwaa.controlecondominio.repositorio;

import br.com.nwaa.controlecondominio.dominio.Despesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDespesaRepositorio extends JpaRepository<Despesa, Long> {


}
