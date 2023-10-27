package com.example.demo.service;

import com.example.demo.model.Post;
import com.example.demo.model.PostDto;
import com.example.demo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
  //  public String getAllPost() {
//    return "게시글 전체 가져오기 service가 호출되었습니다.";
//  }
  @Autowired
  private PostRepository postRepository;

  public List<Post> getAllPost() {
    return postRepository.selectAllPosts();
  }

  public Post setPost(Post post) {
    postRepository.insertPost(post);
//    postRepository.selectPostById();
    return post;
  }

  public Post updatePost(int postId, PostDto postDto) {
    Post orgPost = postRepository.selectPostById(postId);
    orgPost.setLikes(postDto.getLikes());
    postRepository.updatePost(orgPost);
    return orgPost;
  }

  public void deletePost(int postId) {
        postRepository.deletePost(postId);
    }
  }

