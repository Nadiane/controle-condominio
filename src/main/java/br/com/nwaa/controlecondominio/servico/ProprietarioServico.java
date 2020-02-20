package br.com.nwaa.controlecondominio.servico;

import br.com.nwaa.controlecondominio.dominio.Proprietario;
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
        return proprietarioRepositorio.findAll();
    }

    public Proprietario consultarProprietarioPorNome(String nome) {
        return proprietarioRepositorio.findByNome(nome);
    }

    public Optional<Proprietario> consultarProprietarioPorId(Long id) {
        return proprietarioRepositorio.findById(id);
    }

    public Proprietario inserirProprietario(Proprietario proprietario) {
        return proprietarioRepositorio.save(proprietario);
    }

    public void removerProprietarioPorId(Long id) {
        proprietarioRepositorio.deleteById(id);
    }

    public void removerProprietario(Proprietario proprietario) {
        proprietarioRepositorio.delete(proprietario);
    }

}
