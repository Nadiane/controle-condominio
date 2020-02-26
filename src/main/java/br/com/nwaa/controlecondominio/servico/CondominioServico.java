package br.com.nwaa.controlecondominio.servico;

import br.com.nwaa.controlecondominio.dominio.Apartamento;
import br.com.nwaa.controlecondominio.dominio.Condominio;
import br.com.nwaa.controlecondominio.dominio.Proprietario;
import br.com.nwaa.controlecondominio.excecao.DadoNaoCadastradoExcecao;
import br.com.nwaa.controlecondominio.excecao.DadoNaoEncontradoExcecao;
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
        List<Condominio> condominios = condominioRepositorio.findAll();
        if(condominios.isEmpty())
            throw new DadoNaoEncontradoExcecao();
        return condominios;
    }

    public Optional<Condominio> consultarCondominioPorId(Long id) {
        Optional<Condominio> condominios = condominioRepositorio.findById(id);
        if(!condominios.isPresent())
            throw new DadoNaoEncontradoExcecao();
        return condominios;
    }

    public Condominio inserirCondominio(Condominio condominio) {
        Condominio condominioSalvo = condominioRepositorio.save(condominio);
        if(condominioSalvo.getId() == null)
            throw new DadoNaoCadastradoExcecao();
        return condominioSalvo;
    }

    public void removerCondominio(Condominio condominio) {
        condominioRepositorio.delete(condominio);
    }

    public Condominio atualizarCondominio(Condominio condominio) {
        return condominioRepositorio.save(condominio);
    }
}
