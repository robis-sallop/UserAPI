package cl.rsalinas.api.service.impl;

import cl.rsalinas.api.exception.UserNotFoundException;
import cl.rsalinas.api.model.MensajeDTO;
import cl.rsalinas.api.model.PhoneDTO;
import cl.rsalinas.api.model.UserDTO;
import cl.rsalinas.api.persistence.entities.PhoneEntity;
import cl.rsalinas.api.persistence.entities.UserEntity;
import cl.rsalinas.api.repository.PhoneRepository;
import cl.rsalinas.api.repository.UserRepository;
import cl.rsalinas.api.service.UserService;
import cl.rsalinas.api.util.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PhoneRepository phoneRepository;

    public UserServiceImpl(UserRepository userRepository){
        super();
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO saveUser(UserDTO userDTO){
        UserEntity entity = new UserEntity();
        entity.setName(userDTO.getName());
        entity.setEmail(userDTO.getEmail());
        entity.setPassword(userDTO.getPassword());
        entity.setCreateDate(new Date());
        entity.setModifieDate(new Date());
        entity.setPhones(iteratePhonesAndReturnEntity(userDTO.getPhones()));
        entity.setActive(userDTO.getActive());

        UserEntity entityFind = userRepository.findByEmail(userDTO.getEmail());

        if((entityFind!=null) && (entityFind.getEmail() != null)){
            userDTO = new UserDTO();
            userDTO.setMensaje(new MensajeDTO("Email already registered: "+entity.getEmail()));
            return userDTO;
        }else if(!Validator.validateEmail(userDTO.getEmail())){
            userDTO = new UserDTO();
            userDTO.setMensaje(new MensajeDTO("Ivalid Email: Example= aaa@domain.com"));
            return userDTO;
        }else if(!Validator.validatePassword(userDTO.getPassword())){
            userDTO = new UserDTO();
            userDTO.setMensaje(new MensajeDTO("Ivalid password: Conditions: " +
                    "Min 1 uppercase letter." +
                    "Min 1 lowercase letter." +
                    "Min 1 special character." +
                    "Min 1 number." +
                    "Min 8 characters." +
                    "Max 20 characters."));
            return userDTO;
        }else {
            userRepository.save(entity);
        }



        return new UserDTO(
                entity.getUser_id(),
                entity.getName(),
                entity.getEmail(),
                entity.getPassword(),
                iteratePhonesAndReturnDTO(entity.getPhones()),
                entity.getCreateDate(),
                entity.getModifieDate(),
                entity.getLastLogin(),
                entity.isActive(),
                "token",
                new MensajeDTO("User saved successfully!."));
    }

    @Override
    public List<UserDTO> getAllUsers(){
        List<UserDTO> dtoList = new ArrayList<>();

        List<UserEntity> entityList = StreamSupport.stream(userRepository.findAll().spliterator(), false)
                                                        .collect(Collectors.toList());

        for(UserEntity entity : entityList){
            UserDTO dto = new UserDTO(
                    entity.getUser_id(),
                    entity.getName(),
                    entity.getEmail(),
                    entity.getPassword(),
                    iteratePhonesAndReturnDTO(entity.getPhones()),
                    entity.getCreateDate(),
                    entity.getModifieDate(),
                    entity.getLastLogin(),
                    entity.isActive(),
                    "token",
                    null);
            dtoList.add(dto);
        }

        return dtoList;
    }

    private List<PhoneDTO> iteratePhonesAndReturnDTO(List<PhoneEntity> phoneEntityList){
        List<PhoneDTO> dtoList = new ArrayList<>();

        for(PhoneEntity entity : phoneEntityList){
            PhoneDTO dto = new PhoneDTO(
                    entity.getPhone_id(),
                    entity.getNumber(),
                    entity.getCitycode(),
                    entity.getCountrycode());
            dtoList.add(dto);
        }
        return dtoList;
    }

    private List<PhoneEntity> iteratePhonesAndReturnEntity(List<PhoneDTO> phoneDTOList){
        List<PhoneEntity> entityList = new ArrayList<>();

        for(PhoneDTO dto : phoneDTOList){
            PhoneEntity entity = new PhoneEntity();
            entity.setPhone_id(dto.getPhone_id());
            entity.setNumber(dto.getNumber());
            entity.setCitycode(dto.getCitycode());
            entity.setCountrycode(dto.getCountrycode());
            entityList.add(entity);
        }
        return entityList;
    }

    @Override
    public UserDTO getUserById(long id){
        UserEntity entity = userRepository.findById(id).orElseThrow(() ->
                new UserNotFoundException("User", "user_id", id));

         return new UserDTO(
                entity.getUser_id(),
                entity.getName(),
                entity.getEmail(),
                entity.getPassword(),
                iteratePhonesAndReturnDTO(entity.getPhones()),
                entity.getCreateDate(),
                entity.getModifieDate(),
                entity.getLastLogin(),
                entity.isActive(),
                 "token",
                 null);
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO, long id){
        UserEntity existingUser = userRepository.findById(id).orElseThrow(
                () -> new UserNotFoundException("User", "user_id", id));

        existingUser.setName(userDTO.getName());
        existingUser.setEmail(userDTO.getEmail());
        existingUser.setPassword(userDTO.getPassword());
        existingUser.setModifieDate(new Date());
        existingUser.setActive(userDTO.getActive());
        existingUser.setPhones(iteratePhonesAndReturnEntity(userDTO.getPhones()));

        UserEntity entity = userRepository.findByEmail(userDTO.getEmail());

        if((entity != null) && (entity.getEmail() != null)){
            userDTO = new UserDTO();
            userDTO.setMensaje(new MensajeDTO("Email already registered: "+entity.getEmail()));
            return userDTO;
        }else if(!Validator.validateEmail(userDTO.getEmail())){
            userDTO = new UserDTO();
            userDTO.setMensaje(new MensajeDTO("Ivalid Email: Example= aaa@domain.com"));
            return userDTO;
        }else if(!Validator.validatePassword(userDTO.getPassword())){
            userDTO = new UserDTO();
            userDTO.setMensaje(new MensajeDTO("Ivalid password: Conditions: " +
                    "Min 1 uppercase letter." +
                    "Min 1 lowercase letter." +
                    "Min 1 special character." +
                    "Min 1 number." +
                    "Min 8 characters." +
                    "Max 20 characters."));
            return userDTO;
        }else {
            userRepository.save(existingUser);
        }

        userDTO = getUserById(id);

        userDTO.setMensaje(new MensajeDTO("User updated successfully!."));

        return userDTO;
    }

    @Override
    public UserDTO deleteUser(long id) {
        UserDTO userDTO = getUserById(id);
        userRepository.deleteById(id);
        userDTO.setMensaje(new MensajeDTO("User deleted successfully!."));
        return userDTO;
    }
}
