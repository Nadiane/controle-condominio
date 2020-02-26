package br.com.nwaa.controlecondominio.controle;

import br.com.nwaa.controlecondominio.dominio.Apartamento;
import br.com.nwaa.controlecondominio.dominio.Despesa;
import br.com.nwaa.controlecondominio.servico.ApartamentoServico;
import br.com.nwaa.controlecondominio.servico.DespesaServico;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sun.security.krb5.internal.crypto.Des;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping({"/api/v1/despesas"})
public class DespesaControle {

    private final DespesaServico despesaServico;

    public DespesaControle(DespesaServico despesa) {
        this.despesaServico = despesa;
    }

    @GetMapping
    public ResponseEntity<List<Despesa>> listarTodos() {
        return ResponseEntity.ok(despesaServico.listarTodos());
    }

    @PostMapping
    public ResponseEntity<?> inserirDespesa(@Valid @RequestBody Despesa despesa) {
        return new ResponseEntity<>(despesaServico.
                inserirDespesa(despesa), HttpStatus.CREATED);
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<?> consultarDespesaPorId(@PathVariable(value = "id") Long id) {
        Optional<Despesa> despesa = despesaServico.consultarDespesaPorId(id);
        return new ResponseEntity<>(despesa, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<?> removerDespesa(@RequestBody Despesa despesa) {
        despesaServico.removerDespesa(despesa);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(path = {"/id/{id}"})
    public ResponseEntity<?> removerDespesaPorId(@PathVariable Long id) {
        despesaServico.removerDespesa(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<Despesa> altualizarDespesa(@RequestBody Despesa despesa) {
        return new ResponseEntity<>(despesaServico.atualizarDespesa(despesa), HttpStatus.OK);
    }
}
