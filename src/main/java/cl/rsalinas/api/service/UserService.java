package cl.rsalinas.api.service;

import cl.rsalinas.api.model.UserDTO;
import cl.rsalinas.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    public UserDTO saveUser(UserDTO userDTO);
    public List<UserDTO> getAllUsers();
    public UserDTO getUserById(long id);
    public UserDTO updateUser(UserDTO user, long id);
    public UserDTO deleteUser(long id);
}
