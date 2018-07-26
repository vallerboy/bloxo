package pl.oskarpolak.bloxo.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.oskarpolak.bloxo.models.UserEntity;
import pl.oskarpolak.bloxo.models.forms.RegisterForm;
import pl.oskarpolak.bloxo.models.repositories.UserRepository;

import java.util.Optional;

@Service
public class AuthService {
    final UserRepository userRepository;
    final SessionService sessionService;


    @Autowired
    public AuthService(UserRepository userRepository, SessionService sessionService) {
        this.userRepository = userRepository;
        this.sessionService = sessionService;
    }

    public boolean tryLogin(String email, String password){
        Optional<UserEntity> userEntity
                = userRepository.findByEmailAndPassword(email, password);
        if(userEntity.isPresent()){
            sessionService.setLogin(true);
            sessionService.setUserEntity(userEntity.get());
        }
        return userEntity.isPresent();
    }

    public boolean tryToRegister(RegisterForm registerForm){
        if(userRepository.existsByEmail(registerForm.getEmail())){
            return false;
        }

        UserEntity userEntity = createEntityFromForm(registerForm);
        userRepository.save(userEntity);
        return true;
    }

    private UserEntity createEntityFromForm(RegisterForm registerForm) {
        UserEntity userEntity = new UserEntity();
        userEntity.setAge(registerForm.getAge());
        userEntity.setEmail(registerForm.getEmail());
        userEntity.setPassword(registerForm.getPassword());
        userEntity.setUsername(registerForm.getUsername());
        return userEntity;
    }
}
