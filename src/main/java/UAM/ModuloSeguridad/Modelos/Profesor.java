package UAM.ModuloSeguridad.Modelos;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document()
public class Profesor extends Persona{
    String profesion;
    int anosExperiencia;

    public Profesor(String cedula, String nombre, String email, String profesion, int anosExperiencia) {
        super(cedula, nombre, email);
        this.profesion = profesion;
        this.anosExperiencia = anosExperiencia;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public int getAnosExperiencia() {
        return anosExperiencia;
    }

    public void setAnosExperiencia(int anosExperiencia) {
        this.anosExperiencia = anosExperiencia;
    }
}
