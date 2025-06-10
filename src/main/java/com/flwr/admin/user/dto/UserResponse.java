package com.flwr.admin.user.dto;

import com.flwr.admin.user.domain.User;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserResponse {
  private Long id;
  private String email;

  public static UserResponse of(User user) {
    return UserResponse.builder().id(user.getId()).email(user.getEmail()).build();
  }
}
