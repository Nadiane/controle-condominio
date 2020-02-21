package br.com.nwaa.controlecondominio.service;

import br.com.nwaa.controlecondominio.dominio.Proprietario;
import br.com.nwaa.controlecondominio.servico.ProprietarioServico;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ProprietarioServicoTest {

    @Autowired
    ProprietarioServico proprietarioServico;

    @Test
    public void consultarProprietarioTest(){
        List<Proprietario> proprietarios = proprietarioServico.listarTodos();
        Assert.assertTrue(!proprietarios.isEmpty());
    }

}
