package pl.oskarpolak.bloxo.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.oskarpolak.bloxo.models.UserEntity;
import pl.oskarpolak.bloxo.models.forms.RegisterForm;
import pl.oskarpolak.bloxo.models.repositories.UserRepository;

@Service
public class AuthService {
    final UserRepository userRepository;

    @Autowired
    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean tryLogin(String email, String password){
        return false; //todo zrobić logike do logowania
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
