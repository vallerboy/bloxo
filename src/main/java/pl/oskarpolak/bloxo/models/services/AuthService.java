package pl.oskarpolak.bloxo.models.services;

import org.springframework.stereotype.Service;
import pl.oskarpolak.bloxo.models.forms.RegisterForm;

@Service
public class AuthService {
    //todo dodać klasy odpowiedzialen za baze danych

    public boolean tryLogin(String email, String password){
        return false; //todo zrobić logike do logowania
    }

    public boolean tryToRegister(RegisterForm registerForm){
        return true;  //todo zrobic logike rejestracji
    }
}
