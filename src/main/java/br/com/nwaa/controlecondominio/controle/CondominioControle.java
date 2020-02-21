package br.com.nwaa.controlecondominio.controle;

import br.com.nwaa.controlecondominio.dominio.Condominio;
import br.com.nwaa.controlecondominio.dominio.Proprietario;
import br.com.nwaa.controlecondominio.servico.CondominioServico;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping({"/api/v1/condominios"})
public class CondominioControle {

    private final CondominioServico condominioServico;

    public CondominioControle(CondominioServico condominioServico) {
        this.condominioServico = condominioServico;
    }

    @GetMapping
    public ResponseEntity<List<Condominio>> listarTodos(){
        return ResponseEntity.ok(condominioServico.listarTodos());
    }

    @PostMapping
    public ResponseEntity<?> inserirCondominio(@Valid @RequestBody Condominio condominio) {
        return new ResponseEntity<>(condominioServico.inserirCondominio(condominio), HttpStatus.CREATED);
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<?> consultarCondominioPorId(@PathVariable(value = "id") Long id){
        return new ResponseEntity<>(condominioServico.consultarCondominioPorId(id), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<?> removerCondominio(@RequestBody Condominio condominio) {
        condominioServico.removerCondominio(condominio);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<Condominio> altualizarCondominio(@RequestBody Condominio condominio){
        return new ResponseEntity<>(condominioServico.atualizarCondominio(condominio), HttpStatus.OK);
    }
}
