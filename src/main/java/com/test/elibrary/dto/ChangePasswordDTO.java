package com.test.elibrary.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ChangePasswordDTO {
    private String oldPassword;
    private String newPassword;
}
