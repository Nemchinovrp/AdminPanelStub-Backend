package com.nemchinovrp.serverproductmanagement.controller;

import com.nemchinovrp.serverproductmanagement.jwt.JwtTokenProvider;
import com.nemchinovrp.serverproductmanagement.model.Role;
import com.nemchinovrp.serverproductmanagement.service.ProductService;
import com.nemchinovrp.serverproductmanagement.model.Transaction;
import com.nemchinovrp.serverproductmanagement.model.User;
import com.nemchinovrp.serverproductmanagement.service.TransactionService;
import com.nemchinovrp.serverproductmanagement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {
    private final JwtTokenProvider tokenProvider;
    private final UserService userService;
    private final ProductService productService;
    private final TransactionService transactionService;

    @PostMapping("/api/user/registration")
    public ResponseEntity<?> register(@RequestBody User user) {
        if (userService.findByUsername(user.getUsername()) != null) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        user.setRole(Role.USER);
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/api/user/login")
    public ResponseEntity<?> getUser(Principal principal) {
        if (principal == null) {
            return ResponseEntity.ok(principal);
        }
        UsernamePasswordAuthenticationToken authenticationToken =
                (UsernamePasswordAuthenticationToken) principal;
        User user = userService.findByUsername(authenticationToken.getName());
        user.setToken(tokenProvider.generateToken(authenticationToken));
        return new ResponseEntity<>(user, HttpStatus.OK);
    }


    @PostMapping("/api/user/purchase")
    public ResponseEntity<?> purchaseProduct(@RequestBody Transaction transaction) {
        transaction.setPurchaseDate(LocalDateTime.now());
        transactionService.saveTransaction(transaction);
        return new ResponseEntity<>(transaction, HttpStatus.CREATED);
    }

    @GetMapping("/api/user/products")
    public ResponseEntity<?> getAllProducts() {
        return new ResponseEntity<>(productService.findAllProducts(), HttpStatus.OK);
    }
}
