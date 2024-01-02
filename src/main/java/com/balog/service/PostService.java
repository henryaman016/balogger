package com.balog.service;

import com.balog.payload.PostDto;

public interface PostService {
    public PostDto createPost(PostDto postDto);

    void deletePost(long id);
}
