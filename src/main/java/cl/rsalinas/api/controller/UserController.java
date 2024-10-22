package cl.rsalinas.api.controller;


import cl.rsalinas.api.model.UserDTO;
import cl.rsalinas.api.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/api/users")
@Tag(
        name = "User Controller All CRUD API",
        description = "En esta clase esta implementado todo el CRUD api" +
                "products management"
)
public class UserController {

    private UserService userService;

    public UserController(UserService userService){
        super();
        this.userService = userService;
    }

    @Operation(
            summary = "Guarda nuevos usuarios ",
            description = "Guarda nuevod usuarios en la base de datos"
    )
    @PostMapping()
    public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO userDTO){
        return new ResponseEntity<UserDTO>(userService.saveUser(userDTO), HttpStatus.CREATED);
    }

    @Operation(
            summary = "Mostrar todos los usuarios",
            description = "Muestra todos los usuarios en la base de datos"
    )
    @GetMapping
    public List<UserDTO> getAllUsers(){ return userService.getAllUsers(); }

    @Operation(
            summary = "Busqueda por id",
            description = "Busca usuarios por id"
    )
    @GetMapping("{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable("id") long userId){
        return new ResponseEntity<UserDTO>(userService.getUserById(userId), HttpStatus.OK);
    }

    @Operation(
            summary = "Actualiza usuarios por id",
            description = "Actualiza usuarios por id"
    )
    @PutMapping("{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable("id") long id
            ,@RequestBody UserDTO user){
        return new ResponseEntity<UserDTO>(userService.updateUser(user, id), HttpStatus.OK);
    }

    @Operation(
            summary = "Eliminar usuarios ",
            description = "Elimina usuarios por el id"
    )
    @DeleteMapping("{id}")
    public ResponseEntity<UserDTO> deleteUser(@PathVariable("id") long id){
        return new ResponseEntity<UserDTO>(userService.deleteUser(id), HttpStatus.OK);
    }
}
