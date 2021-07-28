package com.codeup.springblog.controllers;

<<<<<<< HEAD

=======
>>>>>>> 9834c56d117670e66a39d4f1e880459ed991a6c2
import com.codeup.springblog.models.Post;
import com.codeup.springblog.models.PostRepository;
import com.codeup.springblog.models.User;
import com.codeup.springblog.models.UserRepository;
<<<<<<< HEAD
=======
import com.codeup.springblog.services.EmailService;
>>>>>>> 9834c56d117670e66a39d4f1e880459ed991a6c2
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {
    private final PostRepository postDao;
    private final UserRepository userDao;
<<<<<<< HEAD

    public PostController(PostRepository postDao, UserRepository userDao) {
        this.postDao = postDao;
        this.userDao = userDao;
    }

    @GetMapping("/posts")
=======
    private final EmailService emailService;

    public PostController(PostRepository postDao, UserRepository userDao, EmailService emailService) {
            this.postDao = postDao;
            this.userDao = userDao;
            this.emailService = emailService;
        }


        @GetMapping("/posts")
>>>>>>> 9834c56d117670e66a39d4f1e880459ed991a6c2
    public String viewPosts(Model model) {
        model.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String singlePost(@PathVariable long id, Model model) {
        model.addAttribute("post", postDao.getById(id));
        return "posts/show";
    }

    @GetMapping("/posts/edit/{id}")
    public String editForm(@PathVariable long id, Model model) {
        model.addAttribute("post", postDao.getById(id));
<<<<<<< HEAD
        model.addAttribute("userId", postDao.getById(id).getUser().getId());
        return "posts/edit";
    }

    @PostMapping("/posts/edit/{id}")
    public String editPost(@PathVariable long id, @ModelAttribute Post post) {
        User postUser = postDao.getById(post.getId()).getUser();
        post.setUser(postUser);
        postDao.save(post);
        return "redirect:/posts/" + id;
    }

    @PostMapping("/posts/delete/{id}")
    public String deletePost(@PathVariable long id) {
        postDao.delete(postDao.getById(id));
        return "redirect:/posts";
    }

    @GetMapping("/posts/create")
    public String showCreateForm(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String createPost(@ModelAttribute Post post) {
        User postUser = userDao.getById(1L);
        post.setUser(postUser);
        postDao.save(post);
        int index = postDao.findAll().size() - 1;
        long postId = postDao.findAll().get(index).getId();
        return "redirect:/posts/" + postId;
=======
        return "posts/edit";
    }

    @PostMapping("/posts/edit/{id}")
    public String editPost(@PathVariable long id, @RequestParam String title, @RequestParam String body) {
        Post post = postDao.getById(id);
        post.setTitle(title);
        post.setBody(body);
        postDao.save(post);
        return "redirect:/posts/" + id;
    }

    @PostMapping("/posts/delete/{id}")
    public String deletePost(@PathVariable long id) {
        postDao.delete(postDao.getById(id));
        return "redirect:/posts";
    }

    @GetMapping("/posts/create")
    public String showCreateForm(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";

    }

    @PostMapping("/posts/create")
    public String createPost(@ModelAttribute Post post) {
        User user = userDao.getById(1L);
        post.setUser(user);
        postDao.save(post);
        emailService.prepareAndSend(post, "You created: " + post.getTitle(), post.getBody());

        return "redirect:/posts";
>>>>>>> 9834c56d117670e66a39d4f1e880459ed991a6c2