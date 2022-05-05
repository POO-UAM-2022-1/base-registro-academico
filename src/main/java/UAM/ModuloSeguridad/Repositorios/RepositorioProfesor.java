package UAM.ModuloSeguridad.Repositorios;


import UAM.ModuloSeguridad.Modelos.Profesor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepositorioProfesor extends MongoRepository<Profesor,String> {
}
