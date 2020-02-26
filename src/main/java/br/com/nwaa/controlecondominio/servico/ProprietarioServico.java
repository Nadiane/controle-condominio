package br.com.nwaa.controlecondominio.servico;

import br.com.nwaa.controlecondominio.dominio.Proprietario;
import br.com.nwaa.controlecondominio.excecao.DadoNaoCadastradoExcecao;
import br.com.nwaa.controlecondominio.excecao.DadoNaoEncontradoExcecao;
import br.com.nwaa.controlecondominio.repositorio.IProprietarioRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProprietarioServico {

    private final IProprietarioRepositorio proprietarioRepositorio;

    ProprietarioServico(IProprietarioRepositorio proprietarioRepositorio){
        this.proprietarioRepositorio = proprietarioRepositorio;
    }

    public List<Proprietario> listarTodos() {
        List<Proprietario> proprietarios = proprietarioRepositorio.findAll();
        if(proprietarios.isEmpty())
            throw new DadoNaoEncontradoExcecao();
        return proprietarios;
    }

    public List<Proprietario> consultarProprietarioPorNome(String nome) {
        List<Proprietario> proprietarios = proprietarioRepositorio.findByNomeIgnoreCaseContaining(nome);
        if(proprietarios.isEmpty())
            throw new DadoNaoEncontradoExcecao();
        return proprietarios;
    }

    public Optional<Proprietario> consultarProprietarioPorId(Long id) {
        Optional<Proprietario> proprietarios = proprietarioRepositorio.findById(id);
        if(!proprietarios.isPresent())
            throw new DadoNaoEncontradoExcecao();
        return proprietarios;
    }

    public Proprietario inserirProprietario(Proprietario proprietario) {
        Proprietario proprietarioSalvo = proprietarioRepositorio.save(proprietario);
        if(proprietarioSalvo.getId() == null)
            throw new DadoNaoCadastradoExcecao();
        return proprietario;
    }

    public void removerProprietario(Proprietario proprietario) {
        proprietarioRepositorio.delete(proprietario);
    }

    public void removerProprietario(Long id) {
        Optional<Proprietario> proprietario = proprietarioRepositorio.findById(id);
        proprietarioRepositorio.delete(proprietario.get());
    }

    public Proprietario atualizarProprietario(Proprietario proprietario) {
        return proprietarioRepositorio.save(proprietario);
    }
}
