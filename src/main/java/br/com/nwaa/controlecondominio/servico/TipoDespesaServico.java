package br.com.nwaa.controlecondominio.servico;

import br.com.nwaa.controlecondominio.dominio.Proprietario;
import br.com.nwaa.controlecondominio.dominio.TipoDespesa;
import br.com.nwaa.controlecondominio.excecao.DadoNaoCadastradoExcecao;
import br.com.nwaa.controlecondominio.excecao.DadoNaoEncontradoExcecao;
import br.com.nwaa.controlecondominio.repositorio.ITipoDespesaRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoDespesaServico {

    private ITipoDespesaRepositorio tipoDespesaRepositorio;

    public TipoDespesaServico(ITipoDespesaRepositorio tipoDespesaRepositorio){
        this.tipoDespesaRepositorio = tipoDespesaRepositorio;
    }

    public List<TipoDespesa> listarTodos() {
        List<TipoDespesa> tipoDespesas = tipoDespesaRepositorio.findAll();
        if(tipoDespesas.isEmpty())
            throw new DadoNaoEncontradoExcecao();
        return tipoDespesas;
    }

    public List<TipoDespesa> consultarTipoDespesaPorNome(String nome) {
        List<TipoDespesa> tipoDespesas = tipoDespesaRepositorio.findByNomeIgnoreCaseContaining(nome);
        if(tipoDespesas.isEmpty())
            throw new DadoNaoEncontradoExcecao();
        return tipoDespesas;
    }

    public Optional<TipoDespesa> consultarTipoDespesaPorId(Long id) {
        Optional<TipoDespesa> tipoDespesas = tipoDespesaRepositorio.findById(id);
        if(!tipoDespesas.isPresent())
            throw new DadoNaoEncontradoExcecao();
        return tipoDespesas;
    }

    public TipoDespesa inserirTipoDespesa(TipoDespesa tipoDespesa) {
        TipoDespesa tipoDespesaSalva = tipoDespesaRepositorio.save(tipoDespesa);
        if(tipoDespesaSalva.getId() == null)
            throw new DadoNaoCadastradoExcecao();
        return tipoDespesaSalva;
    }

    public void removerTipoDespesa(TipoDespesa tipoDespesa) {
        tipoDespesaRepositorio.delete(tipoDespesa);
    }

    public void removerTipoDespesaPorId(Long id) {
        Optional<TipoDespesa> tipoDespesa = tipoDespesaRepositorio.findById(id);
        tipoDespesaRepositorio.delete(tipoDespesa.get());
    }

    public TipoDespesa atualizarTipoDespesa(TipoDespesa tipoDespesa) {
        return tipoDespesaRepositorio.save(tipoDespesa);
    }
}
