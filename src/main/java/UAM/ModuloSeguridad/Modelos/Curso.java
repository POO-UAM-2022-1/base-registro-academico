package UAM.ModuloSeguridad.Modelos;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document()
public class Curso {
    @Id
    String _id;
    String inicialesMateria;
    String descripcion;

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

}
