package com.codeup.springblog.controllers;

import org.springframework.web.bind.annotation.*;

public class PostController {
    @GetMapping("/posts")
    @ResponseBody
    public String viewPosts() {
        return "<h1>Posts Index Page</h1>";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String userPosts(Long id) {
        return "user " + id + " post";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String postCreation(){
        return "<h1>Post Creation Here</h1>";
    }


    //when you submit form on postcreation  the info will post in the same url
//    @RequestMapping(path = "/posts/create", method = RequestMethod.POST)
    @ResponseBody
    public String createPost(){
        return "create post";
    }

}
