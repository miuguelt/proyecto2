package backend.proyecto2;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository // Esta anotación indica que esta interfaz es un repositorio de Spring
// Esta interfaz se utiliza para acceder a la base de datos MongoDB
public interface vistaMotos extends MongoRepository<modeloMotos, String> {
    // Esta interfaz extiende MongoRepository para proporcionar operaciones CRUD
    // para el modelo de datos 'modeloMotos'
    // No es necesario implementar métodos adicionales, ya que MongoRepository
    // proporciona métodos predefinidos para operaciones comunes

}
