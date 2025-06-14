package com.flwr.admin.user.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.flwr.admin.global.jwt.JwtProvider;
import com.flwr.admin.user.domain.User;
import com.flwr.admin.user.dto.LoginRequest;
import com.flwr.admin.user.dto.LoginResponse;
import com.flwr.admin.user.dto.SignupRequest;
import com.flwr.admin.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthService {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;
  private final JwtProvider jwtProvider;
  private final ObjectMapper objectMapper;

  public LoginResponse signup(SignupRequest request) {

    if (userRepository.existsByEmail(request.getEmail())) {
      throw new IllegalArgumentException("Email is Already exist.");
    }

    String encodedPassword = passwordEncoder.encode(request.getPassword());

    System.out.println("PWD: " + encodedPassword);

    User user = User.builder()
            .email(request.getEmail())
            .password(encodedPassword)
            .firstName(request.getFirstName())
            .firstNameKana(request.getFirstNameKana())
            .lastName(request.getLastName())
            .lastNameKana(request.getLastNameKana())
            .phone(request.getPhone())
            .postalCode(request.getPostalCode())
            .prefecture(request.getPrefecture())
            .address1(request.getAddress1())
            .address2(request.getAddress2())
            .birthday(request.getBirthday())
            .gender(request.getGender())
            .acceptTerms(request.isAcceptTerms())
            .role(User.UserRole.USER)
            .build();

    userRepository.save(user);
    System.out.println("USER: " + user);

    String accessToken = jwtProvider.createToken(user.getId().toString());

    return new LoginResponse(user.getId(), accessToken);
  }

  public LoginResponse login(LoginRequest request) {
    User user = userRepository.findByEmail(request.getEmail())
            .orElseThrow(() -> new IllegalArgumentException("Not exist user"));

    if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
      throw new IllegalArgumentException("Password not correct");
    }

    if (user.getRole() != User.UserRole.ADMIN) {
      throw new IllegalArgumentException("Invalid Access.");
    }

    try {
      String json = objectMapper.writeValueAsString(user);
      System.out.println(json);
    } catch (JsonProcessingException e) {
      throw new RuntimeException("Object Mapper Error: ", e);
    }

    String accessToken = jwtProvider.createToken(user.getId().toString());

    return new LoginResponse(user.getId(), accessToken);
  }
}
