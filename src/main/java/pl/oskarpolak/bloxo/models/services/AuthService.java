package pl.oskarpolak.bloxo.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
        return !userRepository.existsByEmail(registerForm.getEmail());
    }
}
