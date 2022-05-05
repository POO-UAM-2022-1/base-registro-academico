package UAM.ModuloSeguridad.Controladores;

import UAM.ModuloSeguridad.Modelos.Curso;
import UAM.ModuloSeguridad.Repositorios.RepositorioCurso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/cursos")
public class ControladorCurso {
    @Autowired
    private RepositorioCurso miRepositorioCurso;


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Curso create(@RequestBody Curso infoCurso){
        return this.miRepositorioCurso.save(infoCurso);
    }
    @GetMapping("")
    public List<Curso> index(){
        return this.miRepositorioCurso.findAll();
    }
    @GetMapping("{id}")
    public Curso show(@PathVariable String id){
        Curso cursoActual=this.miRepositorioCurso
                .findById(id)
                .orElseThrow(RuntimeException::new);
        return cursoActual;
    }
}
