package br.com.nwaa.controlecondominio.servico;

import br.com.nwaa.controlecondominio.dominio.Apartamento;
import br.com.nwaa.controlecondominio.dominio.Proprietario;
import br.com.nwaa.controlecondominio.excecao.DadoNaoCadastradoExcecao;
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
        List<Apartamento> apartamentos = apartamentoRepositorio.findByNomeIgnoreCaseContaining(nome);
        if(apartamentos.isEmpty())
            throw new DadoNaoEncontradoExcecao();
        return apartamentos;
    }

    public Optional<Apartamento> consultarApartamentoPorId(Long id) {
        Optional<Apartamento> apartamentos = apartamentoRepositorio.findById(id);
        if(!apartamentos.isPresent())
            throw new DadoNaoEncontradoExcecao();
        return apartamentos;
    }

    public Apartamento inserirApartamento(Apartamento apartamento) {
        Apartamento apartamentoSalvo = apartamentoRepositorio.save(apartamento);
        if(apartamentoSalvo.getId() == null)
            throw new DadoNaoCadastradoExcecao();
        return apartamentoSalvo;
    }

    public void removerApartamentoPorId(Long id) {
        Optional<Apartamento> apartamento = apartamentoRepositorio.findById(id);
        apartamentoRepositorio.delete(apartamento.get());
    }

    public void removerApartamento(Apartamento apartamento) {
        apartamentoRepositorio.delete(apartamento);
    }

    public Apartamento atualizarApartamento(Apartamento apartamento) {
        return apartamentoRepositorio.save(apartamento);
    }

    public List<Apartamento> consultarApartamentoPorPropietario(Proprietario proprietario){
        return apartamentoRepositorio.findByProprietario(proprietario);
    }
}
