package UAM.ModuloSeguridad.Repositorios;


import UAM.ModuloSeguridad.Modelos.Estudiante;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepositorioEstudiante extends MongoRepository<Estudiante,String> {
}
