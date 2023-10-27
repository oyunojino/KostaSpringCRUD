package com.example.demo.repository;

import com.example.demo.model.Post;

import java.util.List;

public interface PostRepository {
  List<Post> selectAllPosts();
  Post selectPostById(int postId);
  void deletePost(int postId);
  int insertPost(Post post);
  void updatePost(Post post);
}
