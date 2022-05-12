package UAM.ModuloSeguridad.Controladores;

import UAM.ModuloSeguridad.Modelos.Curso;
import UAM.ModuloSeguridad.Modelos.Departamento;
import UAM.ModuloSeguridad.Modelos.Profesor;
import UAM.ModuloSeguridad.Repositorios.RepositorioCurso;
import UAM.ModuloSeguridad.Repositorios.RepositorioDepartamento;
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

    @Autowired
    private RepositorioDepartamento miRepositorioDepartamento;

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
    @GetMapping("departamento/{id_departamento}")
    public List<Curso> getCursosDepartamento(@PathVariable String id_departamento){
        System.out.println("id "+id_departamento);
        return this.miRepositorioCurso.getCursosEnDepartamento(id_departamento);
    }
    @PutMapping("{id_curso}/departamento/{id_departamento}")
    public Curso update(@PathVariable String id_curso, @PathVariable String id_departamento){
        Curso cursoActual =this.miRepositorioCurso
                .findById(id_curso)
                .orElseThrow(RuntimeException::new);
        Departamento departamentoActual =this.miRepositorioDepartamento
                .findById(id_departamento)
                .orElseThrow(RuntimeException::new);
        cursoActual.setDepartamento(departamentoActual);
        return this.miRepositorioCurso.save(cursoActual);
    }
}
