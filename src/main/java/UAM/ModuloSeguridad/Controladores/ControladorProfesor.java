package UAM.ModuloSeguridad.Controladores;

import UAM.ModuloSeguridad.Modelos.Curso;
import UAM.ModuloSeguridad.Modelos.Departamento;
import UAM.ModuloSeguridad.Modelos.Profesor;
import UAM.ModuloSeguridad.Repositorios.RepositorioCurso;
import UAM.ModuloSeguridad.Repositorios.RepositorioProfesor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/profesores")
public class ControladorProfesor {
    @Autowired
    private RepositorioProfesor miRepositorioProfesor;

    @Autowired
    private RepositorioCurso miRepositorioCurso;


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Profesor create(@RequestBody Profesor infoProfesor){
        return this.miRepositorioProfesor.save(infoProfesor);
    }
    @GetMapping("")
    public List<Profesor> index(){
        return this.miRepositorioProfesor.findAll();
    }
    @GetMapping("{id}")
    public Profesor show(@PathVariable String id){
        Profesor profesorActual=this.miRepositorioProfesor
                .findById(id)
                .orElseThrow(RuntimeException::new);
        return profesorActual;
    }
    @PutMapping("{id_profesor}/curso/{id_curso}")
    public Profesor update(@PathVariable String id_profesor,@PathVariable String id_curso){
        Profesor profesorActual=this.miRepositorioProfesor
                .findById(id_profesor)
                .orElseThrow(RuntimeException::new);
        Curso cursoActual =this.miRepositorioCurso
                .findById(id_curso)
                .orElseThrow(RuntimeException::new);
        profesorActual.setCurso(cursoActual);
        return this.miRepositorioProfesor.save(profesorActual);
    }
}
