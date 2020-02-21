package br.com.nwaa.controlecondominio.servico;

import br.com.nwaa.controlecondominio.dominio.Condominio;
import br.com.nwaa.controlecondominio.dominio.Proprietario;
import br.com.nwaa.controlecondominio.repositorio.ICondominioRepositorio;
import br.com.nwaa.controlecondominio.repositorio.IProprietarioRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CondominioServico {

    private final ICondominioRepositorio condominioRepositorio;

    CondominioServico(ICondominioRepositorio condominioRepositorio){
        this.condominioRepositorio = condominioRepositorio;
    }

    public List<Condominio> listarTodos() {
        return condominioRepositorio.findAll();
    }

    public Optional<Condominio> consultarCondominioPorId(Long id) {
        return condominioRepositorio.findById(id);
    }

    public Condominio inserirCondominio(Condominio condominio) {
        return condominioRepositorio.save(condominio);
    }

    public void removerCondominio(Condominio condominio) {
        condominioRepositorio.delete(condominio);
    }

    public Condominio atualizarCondominio(Condominio condominio) {
        return condominioRepositorio.save(condominio);
    }
}
