package br.com.nwaa.controlecondominio.controle;

import br.com.nwaa.controlecondominio.dominio.Proprietario;
import br.com.nwaa.controlecondominio.dominio.TipoDespesa;
import br.com.nwaa.controlecondominio.servico.TipoDespesaServico;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping({"/api/v1/tipodespesas"})
public class TipoDespesaControle {

    private TipoDespesaServico tipoDespesaServico;

    public TipoDespesaControle(TipoDespesaServico tipoDespesaServico){
        this.tipoDespesaServico = tipoDespesaServico;
    }

    @GetMapping
    public ResponseEntity<List<TipoDespesa>> listarTodos(){
        return ResponseEntity.ok(tipoDespesaServico.listarTodos());
    }

    @PostMapping
    public ResponseEntity<?> inserirTipoDespesa(@Valid @RequestBody TipoDespesa tipoDespesa) {
        return new ResponseEntity<>(tipoDespesaServico.inserirTipoDespesa(tipoDespesa), HttpStatus.CREATED);
    }

    @GetMapping(path = {"/nome/{nome}"})
    public ResponseEntity<?> consultarTipoDespesaPorNome(@PathVariable(value = "nome") String nome){
        return new ResponseEntity<>(tipoDespesaServico.consultarTipoDespesaPorNome(nome), HttpStatus.OK);
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<?> consultarTipoDespesaPorId(@PathVariable(value = "id") Long id){
        return new ResponseEntity<>(tipoDespesaServico.consultarTipoDespesaPorId(id), HttpStatus.OK);
    }

    @DeleteMapping(path = {"/{id}"})
    public ResponseEntity<?> removerTipoDespesa(@PathVariable Long id) {
        tipoDespesaServico.removerTipoDespesaPorId(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<?> removerTipoDespesa(@RequestBody TipoDespesa tipoDespesa) {
        tipoDespesaServico.removerTipoDespesa(tipoDespesa);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<TipoDespesa> altualizarTipoDespesa(@RequestBody TipoDespesa tipoDespesa){
        return new ResponseEntity<>(tipoDespesaServico.atualizarTipoDespesa(tipoDespesa), HttpStatus.OK);
    }

}
