package cl.rsalinas.api.controller;


import cl.rsalinas.api.model.UserDTO;
import cl.rsalinas.api.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService){
        super();
        this.userService = userService;
    }

    @PostMapping()
    public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO userDTO){
        return new ResponseEntity<UserDTO>(userService.saveUser(userDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public List<UserDTO> getAllUsers(){ return userService.getAllUsers(); }

    @GetMapping("{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable("id") long userId){
        return new ResponseEntity<UserDTO>(userService.getUserById(userId), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable("id") long id
            ,@RequestBody UserDTO user){
        return new ResponseEntity<UserDTO>(userService.updateUser(user, id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<UserDTO> deleteUser(@PathVariable("id") long id){
        return new ResponseEntity<UserDTO>(userService.deleteUser(id), HttpStatus.OK);
    }
}
