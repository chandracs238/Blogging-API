package com.pcs.blogging_api.Blog;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class BlogService implements CommandLineRunner {

	private BlogSpringDataJpaRepository repo;
	
	public BlogService(BlogSpringDataJpaRepository repo) {
		super();
		this.repo = repo;
	}
	
	private static long count = 0;

	@Override
	public void run(String... args) throws Exception {
		repo.save(new Blog(++count,
						"Learn React",
						"Learing react is a easy",
						"React",
						Arrays.asList("React", "JavaScript"),
						LocalDateTime.now(),
						LocalDateTime.now()
				));
		repo.save(new Blog(++count,
				"How to create Restful Api",
				"some content",
				"React",
				Arrays.asList("React", "JavaScript"),
				LocalDateTime.now(),
				LocalDateTime.now()
		));
		
	}

	public List<Blog> getAllBlogPosts() {
		return repo.findAll();
	}

	public Optional<Blog> getBlogPostById(int id) {
		return repo.findById((long) id);
	}

	public Blog addPost(String title, String content, String category, List<String> tags) {
		Blog newPost = repo.save(new Blog(++count,
				title, content, category, tags, 
				LocalDateTime.now(), LocalDateTime.now()));
		return newPost;
	}

	public void deleteBlogPostById(int id) {
		repo.deleteById((long) id);
	}

	public void updateBlogPostById(long id, Blog blog) {
		// TODO Auto-generated method stub
		repo.deleteById(blog.getId());
		blog.setId(id);
		repo.save(blog);
	}

}
