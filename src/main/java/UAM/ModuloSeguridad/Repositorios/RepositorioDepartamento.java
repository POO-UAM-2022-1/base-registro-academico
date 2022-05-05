package UAM.ModuloSeguridad.Repositorios;

import UAM.ModuloSeguridad.Modelos.Departamento;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepositorioDepartamento extends MongoRepository<Departamento,String> {

}
