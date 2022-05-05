package UAM.ModuloSeguridad.Controladores;

import UAM.ModuloSeguridad.Modelos.Departamento;
import UAM.ModuloSeguridad.Repositorios.RepositorioDepartamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/departamentos")
public class ControladorDepartamento {
    @Autowired
    private RepositorioDepartamento miRepositorioDepartamento;


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Departamento create(@RequestBody Departamento infoDepartamento){
        return this.miRepositorioDepartamento.save(infoDepartamento);
    }
    @GetMapping("")
    public List<Departamento> index(){
        return this.miRepositorioDepartamento.findAll();
    }
    @GetMapping("{id}")
    public Departamento show(@PathVariable String id){
        Departamento departamentoActual=this.miRepositorioDepartamento
                .findById(id)
                .orElseThrow(RuntimeException::new);
        return departamentoActual;
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable String id){
        Departamento departamentoActual=this.miRepositorioDepartamento
                .findById(id)
                .orElseThrow(RuntimeException::new);
        this.miRepositorioDepartamento.delete(departamentoActual);
    }
    @PutMapping("{id}")
    public Departamento update(@PathVariable String id,@RequestBody  Departamento infoDepartamento){
        Departamento departamentoActual=this.miRepositorioDepartamento
                .findById(id)
                .orElseThrow(RuntimeException::new);
        departamentoActual.setNombre(infoDepartamento.getNombre());
        departamentoActual.setDescripcion(infoDepartamento.getDescripcion());
        return this.miRepositorioDepartamento.save(departamentoActual);
    }



}
