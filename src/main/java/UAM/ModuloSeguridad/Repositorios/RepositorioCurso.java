package UAM.ModuloSeguridad.Repositorios;


import UAM.ModuloSeguridad.Modelos.Curso;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface RepositorioCurso extends MongoRepository<Curso,String> {
    @Query("{'departamento.$id': ObjectId(?0)}")
    List<Curso> getCursosEnDepartamento(String idDepartamento);
}
