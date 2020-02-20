package br.com.nwaa.controlecondominio.controle;

import br.com.nwaa.controlecondominio.dominio.Proprietario;
import br.com.nwaa.controlecondominio.servico.ProprietarioServico;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@SuppressWarnings("ALL")
@RestController
@RequestMapping({"/api/v1/proprietarios"})
public class ProprietarioControle {

    /*@Autowired*/
    private final ProprietarioServico proprietarioServico;

    public ProprietarioControle(ProprietarioServico proprietarioServico) {
        this.proprietarioServico = proprietarioServico;
    }

    @GetMapping
    public ResponseEntity<List<Proprietario>> listarTodos(){
        return ResponseEntity.ok(proprietarioServico.listarTodos());
    }

    @PostMapping
    public ResponseEntity<?> inserirProprietario(@Valid @RequestBody Proprietario proprietario) {
        return new ResponseEntity<>(proprietarioServico.inserirProprietario(proprietario), HttpStatus.CREATED);
    }

    @GetMapping(path = {"/{nome}"})
    public ResponseEntity<?> consultarProprietarioPorNome(@PathVariable(value = "nome") String nome){
        Proprietario proprietario = proprietarioServico.consultarProprietarioPorNome(nome);
        return new ResponseEntity<>(proprietario, HttpStatus.OK);
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<?> consultarProprietarioPorId(@PathVariable(value = "id") Long id){
        Optional<Proprietario> proprietario = proprietarioServico.consultarProprietarioPorId(id);
        return new ResponseEntity<>(proprietario, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<?> removerProprietario(@RequestBody Proprietario proprietario) {
        proprietarioServico.removerProprietario(proprietario);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<Proprietario> altualizarProprietario(@RequestBody Proprietario proprietario){
        return new ResponseEntity<>(proprietarioServico.atualizarProprietario(proprietario), HttpStatus.OK);
    }

}
