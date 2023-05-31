package com.example.sending.repository;

import com.example.sending.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {

    UserEntity findByUserName(String userName);

    UserEntity findByTelegramAccount (String telegramAccount);

    UserEntity findByEmail (String email);
}
