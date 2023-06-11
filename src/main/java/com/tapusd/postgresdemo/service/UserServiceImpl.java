package com.tapusd.postgresdemo.service;

import com.tapusd.postgresdemo.domain.User;
import com.tapusd.postgresdemo.dto.response.PostDTO;
import com.tapusd.postgresdemo.dto.response.UserDTO;
import com.tapusd.postgresdemo.repository.PostRepository;
import com.tapusd.postgresdemo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public UserServiceImpl(UserRepository userRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    @Override
    public List<UserDTO> getUsers() {
        return userRepository.findAllDTO();
    }

    @Override
    public UserDTO getUser(Long userId) {
        return userRepository.findById(userId)
                .map(UserDTO::fromUser)
                .orElseThrow(() -> new IllegalArgumentException("User not found with provided id"));
    }

    @Override
    public List<PostDTO> getPosts(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found with provided id"));

        return user.getPosts()
                .stream()
                .map(PostDTO::fromPost)
                .toList();
    }

    @Override
    public PostDTO getPost(Long userId, Long postId) {
        return postRepository.getPost(userId, postId);
    }
}
