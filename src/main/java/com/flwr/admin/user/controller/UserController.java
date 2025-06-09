package com.flwr.admin.user.controller;

import com.flwr.admin.user.dto.UserResponse;
import com.flwr.admin.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  @GetMapping("/me")
  public ResponseEntity<UserResponse> getMyInfo(Authentication authentication) {
    UserResponse user = (UserResponse) authentication.getPrincipal();

    return ResponseEntity.ok(user);
  }
}
