package UAM.ModuloSeguridad.Modelos;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document()
public class Estudiante extends Persona{
    String apellido;
    String inicialesDepartamento;
    String municipioResidencia;


    public Estudiante(String cedula, String nombre, String email, String apellido, String inicialesDepartamento, String municipioResidencia) {
        super(cedula, nombre, email);
        this.apellido = apellido;
        this.inicialesDepartamento = inicialesDepartamento;
        this.municipioResidencia = municipioResidencia;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getInicialesDepartamento() {
        return inicialesDepartamento;
    }

    public void setInicialesDepartamento(String inicialesDepartamento) {
        this.inicialesDepartamento = inicialesDepartamento;
    }

    public String getMunicipioResidencia() {
        return municipioResidencia;
    }

    public void setMunicipioResidencia(String municipioResidencia) {
        this.municipioResidencia = municipioResidencia;
    }
}
