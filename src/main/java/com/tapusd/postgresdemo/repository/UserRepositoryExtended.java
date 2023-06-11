package com.tapusd.postgresdemo.repository;

import com.tapusd.postgresdemo.dto.response.UserDTO;

import java.util.List;

public interface UserRepositoryExtended {

    List<UserDTO> findAllDTO();
}
