package com.tapusd.postgresdemo.dto.response;

import com.tapusd.postgresdemo.domain.User;

public record UserDTO(Long id, String name, String email, Integer age) {

    public static UserDTO fromUser(User user) {
        return new UserDTO(user.getId(), user.getName(), user.getEmail(), user.getAge());
    }
}
