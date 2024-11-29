package com.pcs.blogging_api.Blog;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlogController {

	private BlogService service;

	public BlogController(BlogService service) {
		super();
		this.service = service;
	}
	
	@GetMapping("/blogposts")
	public List<Blog> retrieveAllPosts(@RequestParam(value = "search", required = false) String searchTerm){
		return service.getFilteredBlogPosts(searchTerm);
	}
	
	@GetMapping("/blogposts/{id}")
	public Blog retrivePostById(@PathVariable int id) {
		return service.getBlogPostById(id).orElse(null);
	}
	
	@PostMapping("/blogposts/newpost")
	public Blog createPost(@RequestBody Blog blog) {
		Blog newPost = service.addPost(blog.getTitle()
				,blog.getContent()
				,blog.getCategory()
				,blog.getTags());
		return newPost;
	}
	
	@DeleteMapping("/blogposts/{id}")
	public void DeletePostById(@PathVariable int id) {
		service.deleteBlogPostById(id);
	}
	
	@PutMapping("/blogposts/{id}")
	public void UpdatePostById(@PathVariable long id, @RequestBody Blog blog) {
		service.updateBlogPostById(id, blog);
	}

	
}
