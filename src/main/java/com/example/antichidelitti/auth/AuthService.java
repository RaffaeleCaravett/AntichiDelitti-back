package com.example.antichidelitti.auth;


import com.example.antichidelitti.exception.BadRequestException;
import com.example.antichidelitti.exception.UnauthorizedException;
import com.example.antichidelitti.payloads.entities.Token;
import com.example.antichidelitti.payloads.entities.UserLoginDTO;
import com.example.antichidelitti.payloads.entities.UserRegistrationDTO;
import com.example.antichidelitti.security.JWTTools;
import com.example.antichidelitti.user.User;
import com.example.antichidelitti.user.UserRepository;
import com.example.antichidelitti.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class AuthService {
    @Autowired
    private UserService usersService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JWTTools jwtTools;

    @Autowired
    private PasswordEncoder bcrypt;


    public Token authenticateUser(UserLoginDTO body) throws Exception {
        // 1. Verifichiamo che l'email dell'utente sia nel db
        User user = usersService.findByEmail(body.email());
        // 2. In caso affermativo, verifichiamo se la password corrisponde a quella trovata nel db
        if(bcrypt.matches(body.password(), user.getPassword()))  {
            // 3. Se le credenziali sono OK --> Genero un JWT e lo restituisco
            return jwtTools.createToken(user);
        } else {
            // 4. Se le credenziali NON sono OK --> 401
            throw new UnauthorizedException("Credenziali non valide!");
        }
    }


    public User registerUser(UserRegistrationDTO body) throws IOException {

        // verifico se l'email è già utilizzata
        userRepository.findByEmail(body.email()).ifPresent( user -> {
            throw new BadRequestException("L'email " + user.getEmail() + " è già utilizzata!");
        });
        User newUser = new User();
        newUser.setPassword(bcrypt.encode(body.password()));
        newUser.setEmail(body.email());
        newUser.setNome(body.nome());
        newUser.setCognome(body.cognome());
        newUser.setRole(UserRoles.USER);
        userRepository.save(newUser);

        return newUser;
    }



}