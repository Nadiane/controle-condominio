package br.com.nwaa.controlecondominio.service;

import br.com.nwaa.controlecondominio.servico.ProprietarioServico;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProprietarioServicoTest {

    @Autowired
    ProprietarioServico proprietarioServico;

    @Test
    public void consultarProprietarioTest(){
        proprietarioServico.listarTodos();
    }

}
