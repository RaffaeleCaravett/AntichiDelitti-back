package com.example.antichidelitti.auth;

import com.example.unbreackable.continent.ContinentRepository;
import com.example.unbreackable.email.EmailService;
import com.example.unbreackable.enums.UserRoles;
import com.example.unbreackable.exception.BadRequestException;
import com.example.unbreackable.exception.UnauthorizedException;
import com.example.unbreackable.nations.NationRepository;
import com.example.unbreackable.payloads.entities.Token;
import com.example.unbreackable.payloads.entities.UserLoginDTO;
import com.example.unbreackable.payloads.entities.UserRegistrationDTO;
import com.example.unbreackable.security.JWTTools;
import com.example.unbreackable.user.User;
import com.example.unbreackable.user.UserRepository;
import com.example.unbreackable.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Autowired
    private EmailService emailService;

    @Autowired
    private ContinentRepository cityRepository;

    @Autowired
    private NationRepository nationRepository;

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
        newUser.setEtà(body.età());
        newUser.setContinent(cityRepository.findById(body.continente()).get());
        newUser.setNazione(nationRepository.findById(body.nazione()).get());
        newUser.setRole(UserRoles.USER);
        userRepository.save(newUser);


        String to = body.email();
        String subject = "Email di benvenuto";
        String text = "Complimenti! Registrazione su unbreakable avvenuta con successo!";

        emailService.sendEmail(to, subject, text);

        return newUser;
    }
    public Page<User> getUtenti(int page, int size, String orderBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(orderBy));

        return userRepository.findAll(pageable);
    }

    public Page<User> findByDynamicParams(String nome, String cognome, String nazione, String continent, String email, int eta, Pageable pageable) {
        return userRepository.findByDynamicParams(nome, cognome, nazione, continent, email, eta, pageable);
    }
}