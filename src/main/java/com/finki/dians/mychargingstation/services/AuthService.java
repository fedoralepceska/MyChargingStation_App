package com.finki.dians.mychargingstation.services;

import com.finki.dians.mychargingstation.models.MCSUser;
import com.finki.dians.mychargingstation.models.exceptions.InvalidArgumentsException;
import com.finki.dians.mychargingstation.models.exceptions.InvalidCredentialsException;
import com.finki.dians.mychargingstation.repositories.UserRepository;
import com.finki.dians.mychargingstation.services.serviceinterfaces.AuthServiceInterface;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements AuthServiceInterface {

    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public MCSUser login(String email, String password) {
        if(email == null || email.isEmpty() || password == null || password.isEmpty()){
            throw new InvalidArgumentsException();
        }

        return userRepository.findByEmailAndPassword(email, password)
                .orElseThrow(InvalidCredentialsException::new);
    }

}
