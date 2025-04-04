package backend.proyecto2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
        RequestMethod.DELETE }) // Permite solicitudes de origen cruzado desde
// cualquier dominio
// Esta anotación se utiliza para habilitar CORS (Cross-Origin Resource Sharing)
// Permite solicitudes de origen cruzado desde cualquier dominio
// Esta anotación se utiliza para habilitar CORS (Cross-Origin Resource Sharing)
// en la aplicación, lo que permite que el frontend acceda a los recursos del
// backend desde diferentes dominios
@RestController // Esta anotación indica que esta clase es un controlador REST
// y que manejará solicitudes HTTP
public class controladorMotos {

    @Autowired // Esta anotación indica que Spring debe inyectar una instancia de la clase
    private vistaMotos v; // Instancia de la interfaz vistaMotos para acceder a la base de datos

    @GetMapping("/MotosGenerales")
    public List todos() {
        // Este método maneja una solicitud GET para obtener todos los registros de
        // motos
        // en la base de datos y devolverlos como una lista
        // La anotación @GetMapping indica que este método maneja solicitudes GET
        // La ruta "/MotosGenerales" se utiliza para acceder a este método
        // La lista de motos se obtiene llamando al método findAll() del repositorio
        // y se devuelve como respuesta a la solicitud
        return v.findAll();
    }

    @GetMapping("/ConsultarMotoIndividual/{id}")
    public List COnsultarIndividual(@PathVariable String id) {
        // Este método maneja una solicitud GET para obtener un registro de moto
        // específico de la base de datos utilizando su ID
        // La anotación @GetMapping indica que este método maneja solicitudes GET
        // La ruta "/ConsultarMotoIndividual/{id}" se utiliza para acceder a este método
        return List.of(v.findById(id));
    }

    @DeleteMapping("/EliminarMoto/{id}")
    public void Eliminarindividual(@PathVariable String id) {
        // Este método maneja una solicitud DELETE para eliminar un registro de moto
        // específico de la base de datos utilizando su ID
        // La anotación @DeleteMapping indica que este método maneja solicitudes DELETE
        v.deleteById(id);
    }

    @PostMapping("/guardarMoto")
    public void guardarModelo(@RequestBody modeloMotos entity) {
        // Aquí puedes agregar la lógica para procesar el objeto entity antes de
        // guardarlo en la base de datos
        // Por ejemplo, puedes validar los datos o realizar alguna transformación

        // Si necesitas procesar un POST request, puedes hacerlo aquí
        // Por ejemplo, puedes validar los datos del objeto entity antes de guardarlo
        // en la base de datos
        // La anotación @PostMapping indica que este método maneja solicitudes POST

        v.save(entity);
    }
}
