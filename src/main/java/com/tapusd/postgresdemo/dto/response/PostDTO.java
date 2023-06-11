package com.tapusd.postgresdemo.dto.response;

import com.tapusd.postgresdemo.domain.Post;

public record PostDTO(Long id, Long userId, String title, String body) {

    public static PostDTO fromPost(Post post) {
        return new PostDTO(post.getId(),
                post.getUser().getId(),
                post.getTitle(),
                post.getBody());
    }
}
