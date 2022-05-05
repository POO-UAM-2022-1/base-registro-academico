package UAM.ModuloSeguridad.Controladores;

import UAM.ModuloSeguridad.Modelos.Profesor;
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
}
