package com.example.demo.service;

import com.example.demo.model.Post;
import com.example.demo.model.PostDto;
import com.example.demo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
  @Autowired
  private PostRepository postRepository;
  public List<Post> getAllPosts() {
    return postRepository.selectAllPosts();
  }

  public Post setPost(Post post) {
    postRepository.insertPost(post);
    return post;
  }

  public Post updatePost(int postId, PostDto postDto) {
    Post orgPost = postRepository.selectPostById(postId);
    orgPost.setLikes(postDto.getLikes());
    postRepository.updatePost(orgPost);
    return orgPost;
  }

  public Post getPostById(int postId){
    return postRepository.selectPostById(postId);
  }

  public void removePost(int postId){
    postRepository.deletePost(postId);
  }
}