package com.ats.remotetimemanager.Controller;

import com.ats.remotetimemanager.Security.TokenProvider;
import com.ats.remotetimemanager.Service.UserServiceDetails;
import com.ats.remotetimemanager.utill.JwtRespone;
import com.ats.remotetimemanager.utill.LoginModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/auth/")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenProvider tokenProvider;

    @Autowired
    private UserServiceDetails userDetailsService;

    @PostMapping("login")
    public ResponseEntity<?> authenticate(@RequestBody LoginModel loginModel){
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginModel.getCin(),
                        loginModel.getPassword()
                )
        );

        UserDetails userDetails = userDetailsService.loadUserByUsername(loginModel.getCin());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final String token = tokenProvider.generateToken(userDetails);
        return ResponseEntity.ok(new JwtRespone(token));
    }

}
