package com.example.demo.controller;

import com.example.demo.model.Post;
import com.example.demo.model.PostDto;
import com.example.demo.repository.PostRepository;
import com.example.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {
  //  외부에서 변경할 수없도록 final로 선언
  private final PostService postService;

  @Autowired
//  생성자가 1개일 때는 @Autowired 생략가능
  public PostController(PostService postService) {
    this.postService = postService;
  }

  //  방법 1 ) 생성자 주입
  @GetMapping("/posts")
  public List<Post> viewAllPost() {
    List<Post> allPost = postService.getAllPost();
    return allPost;
  }


//  방법 2 ) setter 주입
//  사용빈도 낮음, 보안 위험이 있기 때문
//  @GetMapping("/posts")
//  public List<Post> viewAllPost() {
//    List<Post> allPost = postService.getAllPost();
//    return allPost;
//  }

//  방법 3 ) 생성자 주입


  @PostMapping("/posts")
  public Post registPost(@RequestBody Post post) {
    System.out.println("before ==> " + post);
    postService.setPost(post);
    System.out.println("after ==> " + post);
    return post;
  }

  @PutMapping("/posts/{postId}")
  public String updatePost(@PathVariable("postId") int postId,
                         @RequestBody PostDto postDto) {
    System.out.println("before ==> " + postDto);
    postService.updatePost(postId, postDto);
    System.out.println("after ==> " + postDto);
    return "update 완료";
  }

  @DeleteMapping("/posts/delete/{postId}")
  public void deletePost(@PathVariable("postId") int postId) {
    postService.deletePost(postId);
  }
}
