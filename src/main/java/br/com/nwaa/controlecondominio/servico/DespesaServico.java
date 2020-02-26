package br.com.nwaa.controlecondominio.servico;

import br.com.nwaa.controlecondominio.dominio.Despesa;
import br.com.nwaa.controlecondominio.dominio.Proprietario;
import br.com.nwaa.controlecondominio.excecao.DadoNaoCadastradoExcecao;
import br.com.nwaa.controlecondominio.excecao.DadoNaoEncontradoExcecao;
import br.com.nwaa.controlecondominio.repositorio.IDespesaRepositorio;
import br.com.nwaa.controlecondominio.repositorio.IProprietarioRepositorio;
import org.springframework.stereotype.Service;
import sun.security.krb5.internal.crypto.Des;

import java.util.List;
import java.util.Optional;

@Service
public class DespesaServico {

    private final IDespesaRepositorio despesaRepositorio;


    DespesaServico(IDespesaRepositorio despesaRepositorio){
        this.despesaRepositorio = despesaRepositorio;
    }

    public List<Despesa> listarTodos() {
        List<Despesa> despesas = despesaRepositorio.findAll();
        if(despesas.isEmpty())
            throw new DadoNaoEncontradoExcecao();
        return despesas;
    }

    public Optional<Despesa> consultarDespesaPorId(Long id) {
        Optional<Despesa> despesas = despesaRepositorio.findById(id);
        if(!despesas.isPresent())
            throw new DadoNaoEncontradoExcecao();
        return despesas;
    }

    public Despesa inserirDespesa(Despesa despesa) {
        Despesa despesaSalva = despesaRepositorio.save(despesa);
        if(despesaSalva.getId() == null)
            throw new DadoNaoCadastradoExcecao();
        return despesaSalva;
    }

    public void removerDespesa(Despesa despesa) {
        despesaRepositorio.delete(despesa);
    }

    public void removerDespesa(Long id) {
        Optional<Despesa> despesa = despesaRepositorio.findById(id);
        despesaRepositorio.delete(despesa.get());
    }

    public Despesa atualizarDespesa(Despesa despesa) {
        return despesaRepositorio.save(despesa);
    }
}
