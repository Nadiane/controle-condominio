package br.com.nwaa.controlecondominio.repositorio;

import br.com.nwaa.controlecondominio.dominio.TipoDespesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface ITipoDespesaRepositorio extends JpaRepository<TipoDespesa, Long> {

    public List<TipoDespesa> findByNomeIgnoreCaseContaining(String nome);
}
