package com.mgz.authApi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AuthRequest {
//    @NotNull
//    @Email
//    @Length(min = 5, max = 50)
    private String email;

//    @NotNull
//    @Length(min = 5, max = 50)
    private String password;
}
