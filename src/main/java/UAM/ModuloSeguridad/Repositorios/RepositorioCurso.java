package UAM.ModuloSeguridad.Repositorios;


import UAM.ModuloSeguridad.Modelos.Curso;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepositorioCurso extends MongoRepository<Curso,String> {
}
