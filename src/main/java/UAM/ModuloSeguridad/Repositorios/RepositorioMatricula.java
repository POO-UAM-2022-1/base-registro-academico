package UAM.ModuloSeguridad.Repositorios;


import UAM.ModuloSeguridad.Modelos.Matricula;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepositorioMatricula extends MongoRepository<Matricula,String> {
}
