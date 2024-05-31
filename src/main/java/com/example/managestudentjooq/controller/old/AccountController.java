//package com.example.managestudentjooq.controller.old;
//
//import com.example.managestudentjooq.ServiceResult;
//import com.example.managestudentjooq.dto.request.AuthRequest;
//import com.example.managestudentjooq.dto.request.RefreshTokenRequest;
//import com.example.managestudentjooq.dto.response.AccountResponse;
//import com.example.managestudentjooq.dto.response.TokenResponse;
//import com.example.managestudentjooq.service.old.AuthService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("api/v1/account")
//public class AccountController {
//
//    @Autowired
//    private AuthService authService;
//
//    @PostMapping("/login")
//    ResponseEntity<ServiceResult<TokenResponse>> login(@RequestBody AuthRequest authRequest) {
//        return ResponseEntity.status(HttpStatus.OK).body(
//                authService.login(authRequest.getUsername(), authRequest.getPassword()));
//    }
//
//    @PostMapping("/register")
//    ResponseEntity<ServiceResult<AccountResponse>> register(@RequestBody AuthRequest authRequest) throws Exception {
//        return ResponseEntity.status(HttpStatus.OK).body(
//                authService.register(authRequest));
//    }
//
//    @PostMapping("/refresh-token")
//    ResponseEntity<ServiceResult<TokenResponse>> refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest) throws Exception {
//        return ResponseEntity.status(HttpStatus.OK).body(
//                authService.refreshToken(refreshTokenRequest.getToken()));
//    }
//}
