package UAM.ModuloSeguridad.Controladores;

import UAM.ModuloSeguridad.Modelos.Estudiante;
import UAM.ModuloSeguridad.Repositorios.RepositorioEstudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/estudiantes")
public class ControladorEstudiante {
    @Autowired
    private RepositorioEstudiante miRepositorioEstudiante;


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Estudiante create(@RequestBody Estudiante infoEstudiante){
        return this.miRepositorioEstudiante.save(infoEstudiante);
    }
    @GetMapping("")
    public List<Estudiante> index(){
        return this.miRepositorioEstudiante.findAll();
    }
    @GetMapping("{id}")
    public Estudiante show(@PathVariable String id){
        Estudiante estudianteActual=this.miRepositorioEstudiante
                .findById(id)
                .orElseThrow(RuntimeException::new);
        return estudianteActual;
    }
}
