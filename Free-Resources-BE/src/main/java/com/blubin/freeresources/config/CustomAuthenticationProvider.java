//package com.blubin.freeresources.config;
//
//import com.blubin.freeresources.model.User;
//import com.blubin.freeresources.repository.UserRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//
//import java.util.Collections;
//import java.util.Optional;
//
//@Component
//@RequiredArgsConstructor
//public class CustomAuthenticationProvider implements AuthenticationProvider {
//
//    private final UserRepository userRepository;
//    private final PasswordEncoder passwordEncoder;
//
//
//    @Override
//    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//        String username = authentication.getName();
//        String password = authentication.getCredentials().toString();
//
//        // Authenticate user from the database
//        User user = userRepository.findByEmail(username)
//                .orElseThrow(() -> new BadCredentialsException("Invalid username or password"));
//
//        // Check if the password matches
//        if (passwordEncoder.matches(password, user.getPassword())) {
//            return new UsernamePasswordAuthenticationToken(username, password, Collections.emptyList());
//        } else {
//            throw new BadCredentialsException("Invalid username or password");
//        }
//    }
//
//    @Override
//    public boolean supports(Class<?> authentication) {
//        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
//    }
//
//
//}
