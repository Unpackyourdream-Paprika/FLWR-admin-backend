package com.flwr.admin.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoginResponse {
  private Long userId;
  private String accessToken;
}
