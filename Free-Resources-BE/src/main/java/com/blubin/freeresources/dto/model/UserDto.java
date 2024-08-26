package com.blubin.freeresources.dto.model;

import com.blubin.freeresources.model.Role;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {
    private Integer id;

    private String email;

    private String password;

    private String firstName;

    private String lastName;

    private String mobileNumber;

    private String avatar;

    private Role role;
    public String getfullName(){
        return lastName != null ? lastName.concat(" ").concat(firstName) : " ";
    }
}
