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
    @GetMapping("/cedula/{cedula}")
    public Estudiante buscarPorCedula(@PathVariable String cedula){
        Estudiante estudianteActual=this.miRepositorioEstudiante.getEstudiantePorCedula(cedula);
        return estudianteActual;
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable String id){
        Estudiante estudianteActual=this.miRepositorioEstudiante
                .findById(id)
                .orElseThrow(RuntimeException::new);
        this.miRepositorioEstudiante.delete(estudianteActual);
    }
    @PutMapping("{id}")
    public Estudiante update(@PathVariable String id,@RequestBody  Estudiante infoEstudiante){
        Estudiante estudianteActual=this.miRepositorioEstudiante
                .findById(id)
                .orElseThrow(RuntimeException::new);
        estudianteActual.setNombre(infoEstudiante.getNombre());
        estudianteActual.setApellido(infoEstudiante.getApellido());
        estudianteActual.setEmail(infoEstudiante.getEmail());
        estudianteActual.setInicialesDepartamento(infoEstudiante.getInicialesDepartamento());
        estudianteActual.setMunicipioResidencia(infoEstudiante.getMunicipioResidencia());
        return this.miRepositorioEstudiante.save(estudianteActual);
    }
}
