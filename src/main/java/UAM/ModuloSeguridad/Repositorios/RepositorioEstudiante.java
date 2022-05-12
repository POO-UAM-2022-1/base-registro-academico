package UAM.ModuloSeguridad.Repositorios;


import UAM.ModuloSeguridad.Modelos.Curso;
import UAM.ModuloSeguridad.Modelos.Estudiante;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface RepositorioEstudiante extends MongoRepository<Estudiante,String> {
    @Query("{'cedula': ?0}")
    public Estudiante getEstudiantePorCedula(String cedula);
}
