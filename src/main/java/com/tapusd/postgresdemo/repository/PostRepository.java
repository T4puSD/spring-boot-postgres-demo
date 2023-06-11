package com.tapusd.postgresdemo.repository;

import com.tapusd.postgresdemo.domain.Post;
import com.tapusd.postgresdemo.dto.response.PostDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    @Query("""
    SELECT new com.tapusd.postgresdemo.dto.response.PostDTO(p.id, p.user.id, p.title, p.body) 
    FROM Post p WHERE p.user.id =:userId AND p.id = :postId
    """)
    PostDTO getPost(Long userId, Long postId);
}
