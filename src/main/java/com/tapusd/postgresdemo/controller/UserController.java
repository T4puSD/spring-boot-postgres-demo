package com.tapusd.postgresdemo.controller;

import com.tapusd.postgresdemo.domain.Post;
import com.tapusd.postgresdemo.dto.response.PostDTO;
import com.tapusd.postgresdemo.dto.response.Response;
import com.tapusd.postgresdemo.dto.response.UserDTO;
import com.tapusd.postgresdemo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Response<Object>> handleIllegalArgumentException(IllegalArgumentException ex) {
        return ResponseEntity.badRequest()
                .body(Response.getIllegalArgumentResponse(ex));
    }

    @GetMapping("")
    public List<UserDTO> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{userId}")
    public Response<UserDTO> getUser(@PathVariable Long userId) {
        UserDTO user = userService.getUser(userId);
        return Response.getSuccessDataResponse(user);
    }

    @GetMapping("/{userId}/posts")
    public List<PostDTO> getUserPosts(@PathVariable Long userId) {
        return userService.getPosts(userId);
    }

    @GetMapping("/{userId}/posts/{postId}")
    public PostDTO getUserPost(@PathVariable Long userId, @PathVariable Long postId) {
        return userService.getPost(userId, postId);
    }
}
