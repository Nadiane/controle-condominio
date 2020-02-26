package br.com.nwaa.controlecondominio.controle;

import br.com.nwaa.controlecondominio.dominio.Apartamento;
import br.com.nwaa.controlecondominio.servico.ApartamentoServico;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping({"/api/v1/apartamentos"})
public class ApartamentoControle {

    private final ApartamentoServico apartamentoServico;

    public ApartamentoControle(ApartamentoServico apartamentoServico) {
        this.apartamentoServico = apartamentoServico;
    }

    @GetMapping
    public ResponseEntity<List<Apartamento>> listarTodos(){
        return ResponseEntity.ok(apartamentoServico.listarTodos());
    }

    @PostMapping
    public ResponseEntity<?> inserirApartamento(@Valid @RequestBody Apartamento apartamento) {
        return new ResponseEntity<>(apartamentoServico.
                inserirApartamento(apartamento), HttpStatus.CREATED);
    }

    @GetMapping(path = {"/nome/{nome}"})
    public ResponseEntity<?> consultarApartamentoPorNome(@PathVariable(value = "nome") String nome){
        return new ResponseEntity<>(apartamentoServico.consultarApartamentoPorNome(nome), HttpStatus.OK);
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<?> consultarApartamentoPorId(@PathVariable(value = "id") Long id){
        Optional<Apartamento> apartamento = apartamentoServico.consultarApartamentoPorId(id);
        return new ResponseEntity<>(apartamento, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<?> removerApartamento(@RequestBody Apartamento apartamento) {
        apartamentoServico.removerApartamento(apartamento);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(path = {"/id/{id}"})
    public ResponseEntity<?> removerApartamentoPorId(@PathVariable Long id) {
        apartamentoServico.removerApartamentoPorId(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<Apartamento> altualizarProprietario(@RequestBody Apartamento apartamento){
        return new ResponseEntity<>(apartamentoServico.atualizarApartamento(apartamento), HttpStatus.OK);
    }
}
