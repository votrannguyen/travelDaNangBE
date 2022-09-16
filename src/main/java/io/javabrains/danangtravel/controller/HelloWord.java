package io.javabrains.danangtravel.controller;

import io.javabrains.danangtravel.MyUserDetailsService;
import io.javabrains.danangtravel.models.AuthenticationRequest;
import io.javabrains.danangtravel.models.AuthenticationResponse;
import io.javabrains.danangtravel.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWord {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @RequestMapping({ "/hello" })
    public String firstPage() {
        return "Hello World";
    }
    @RequestMapping({ "/login" })
    public String login() {
        return "Hello login";
    }
    @RequestMapping({ "/user" })
    public String user() {
        return "Hello user";
    }
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin() {
        return "Hello admin";
    }
    @RequestMapping(value = "/authenticate", method = RequestMethod.GET)
    public String admins() {
        return "Hello assdmin";
    }
    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        }
        catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }


        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        final String jwt = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
}
