package UAM.ModuloSeguridad.Modelos;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document()
public class Curso {
    @Id
    String _id;
    String inicialesMateria;
    String descripcion;
    @DBRef
    Departamento departamento;

    public Curso(String inicialesMateria, String descripcion) {
        this.inicialesMateria = inicialesMateria;
        this.descripcion = descripcion;
    }

    public String get_id() {
        return _id;
    }

    public String getInicialesMateria() {
        return inicialesMateria;
    }

    public void setInicialesMateria(String inicialesMateria) {
        this.inicialesMateria = inicialesMateria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
}
