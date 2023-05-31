package com.example.sending.controller.api;

import com.example.sending.controller.dto.UserRequest;
import com.example.sending.controller.dto.UserResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

@RequestMapping("/user")
public interface UserController {

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    void createUser (@RequestBody @Valid UserRequest user);

    @DeleteMapping("/del")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteUser (@RequestParam @NotBlank String telegramAccount);

    @PatchMapping("/{email}")
    @ResponseStatus(HttpStatus.CREATED)
    UserResponse softUpdateUserName (@PathVariable String email, @RequestParam @NotBlank String userName);
 }
