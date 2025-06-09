package com.flwr.admin.user.repository;

public interface UserRepositoryCustom {
   long updateUserAgeByNameFromQueryDsl(String name, int age);
}
