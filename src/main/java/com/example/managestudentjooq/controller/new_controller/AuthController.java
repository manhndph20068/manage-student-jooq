package com.example.managestudentjooq.controller.new_controller;

import com.example.managestudentjooq.dto.request.AuthRequest;
import com.example.managestudentjooq.dto.request.StudentReqest;
import com.example.managestudentjooq.service.new_service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/findByUserName")
    ResponseEntity<?> findByUserName(@RequestBody AuthRequest authRequest) {
        return ResponseEntity.ok(authService.findAccountRoleByUsername(authRequest.getUsername()));
    }
}
