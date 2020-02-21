package br.com.nwaa.controlecondominio.servico;

import br.com.nwaa.controlecondominio.dominio.Apartamento;
import br.com.nwaa.controlecondominio.dominio.Proprietario;
import br.com.nwaa.controlecondominio.excecao.DadoNaoEncontradoExcecao;
import br.com.nwaa.controlecondominio.repositorio.IApartamentoRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApartamentoServico {

    private final IApartamentoRepositorio apartamentoRepositorio;

    ApartamentoServico(IApartamentoRepositorio apartamentoRepositorio){
        this.apartamentoRepositorio = apartamentoRepositorio;
    }

    public List<Apartamento> listarTodos() {
        List<Apartamento> apartamentos = apartamentoRepositorio.findAll();
        if(apartamentos.isEmpty())
            throw new DadoNaoEncontradoExcecao();
        return apartamentos;
    }

    public List<Apartamento> consultarApartamentoPorNome(String nome) {
        return apartamentoRepositorio.findByNomeIgnoreCaseContaining(nome);
    }

    public Optional<Apartamento> consultarApartamentoPorId(Long id) {
        return apartamentoRepositorio.findById(id);
    }

    public Apartamento inserirApartamento(Apartamento apartamento) {
        return apartamentoRepositorio.save(apartamento);
    }

    public void removerProprietario(Apartamento apartamento) {
        apartamentoRepositorio.delete(apartamento);
    }

    public Apartamento atualizarApartamento(Apartamento apartamento) {
        return apartamentoRepositorio.save(apartamento);
    }
}
