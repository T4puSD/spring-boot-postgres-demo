package com.tapusd.postgresdemo.service;


import com.tapusd.postgresdemo.domain.Post;
import com.tapusd.postgresdemo.dto.response.PostDTO;
import com.tapusd.postgresdemo.dto.response.UserDTO;

import java.util.List;

public interface UserService {

    List<UserDTO> getUsers();

    UserDTO getUser(Long userId);

    List<PostDTO> getPosts(Long userId);

    PostDTO getPost(Long userId, Long postId);
}
