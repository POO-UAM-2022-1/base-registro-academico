package UAM.ModuloSeguridad.Controladores;

import UAM.ModuloSeguridad.Modelos.Curso;
import UAM.ModuloSeguridad.Modelos.Estudiante;
import UAM.ModuloSeguridad.Modelos.Matricula;
import UAM.ModuloSeguridad.Modelos.Profesor;
import UAM.ModuloSeguridad.Repositorios.RepositorioCurso;
import UAM.ModuloSeguridad.Repositorios.RepositorioEstudiante;
import UAM.ModuloSeguridad.Repositorios.RepositorioMatricula;
import UAM.ModuloSeguridad.Repositorios.RepositorioProfesor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/matriculas")
public class ControladorMatricula {
    @Autowired
    private RepositorioMatricula miRepositorioMatricula;

    @Autowired
    private RepositorioCurso miRepositorioCurso;

    @Autowired
    private RepositorioEstudiante miRepositorioEstudiante;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("curso/{id_curso}/estudiante/{id_estudiante}")
    public Matricula create(@RequestBody Matricula infoMatricula,
                            @PathVariable String id_curso,
                            @PathVariable String id_estudiante ){
        Curso cursoActual =this.miRepositorioCurso
                .findById(id_curso)
                .orElseThrow(RuntimeException::new);
        Estudiante estudianteActual =this.miRepositorioEstudiante
                .findById(id_estudiante)
                .orElseThrow(RuntimeException::new);
        infoMatricula.setCurso(cursoActual);
        infoMatricula.setEstudiante(estudianteActual);
        return this.miRepositorioMatricula.save(infoMatricula);
    }
    @GetMapping("")
    public List<Matricula> index(){
        return this.miRepositorioMatricula.findAll();
    }
    @GetMapping("{id}")
    public Matricula show(@PathVariable String id){
        Matricula matriculaActual=this.miRepositorioMatricula
                .findById(id)
                .orElseThrow(RuntimeException::new);
        return matriculaActual;
    }
}
