package com.balog.service.impl;

import com.balog.entity.Post;
import com.balog.exception.ResourceNotFoundException;
import com.balog.payload.PostDto;
import com.balog.repository.PostRepository;
import com.balog.service.PostService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepo;

    public PostServiceImpl(PostRepository postRepo) {
        this.postRepo = postRepo;
    }

    @Override
    public PostDto createPost(PostDto postDto) {

        Post post=new Post();
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());

        Post savePost = postRepo.save(post);

        PostDto dto=new PostDto();
        dto.setId(savePost.getId());
        dto.setTitle(savePost.getTitle());
        dto.setDescription(savePost.getDescription());
        dto.setContent(savePost.getContent());
        dto.setMessage("Post is created");

        return dto;
    }

    @Override
    public void deletePost(long id) {
      Post post =postRepo.findById(id).orElseThrow(
              ()->new ResourceNotFoundException("Post not found with id: "+id)

       );
        postRepo.deleteById(id);

    }
}
