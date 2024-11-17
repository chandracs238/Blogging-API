package com.pcs.blogging_api.Blog;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Blog {

	@Id
	private long id;
	
	private String title;
	private String content;
	private String category;
	private List<String> tags = new ArrayList<>();
	private String createdAt;
	private String updatedAt;
	
	public Blog() {}
	
	public Blog(long id, String title, String content, String category, List<String> tags, LocalDateTime createdAt,
			LocalDateTime updatedAt) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.category = category;
		this.tags = tags;
		this.createdAt = dateFormat(createdAt);
		this.updatedAt = dateFormat(updatedAt);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = dateFormat(createdAt);
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = dateFormat(updatedAt);
	}
	
	public String dateFormat(LocalDateTime now) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss a");
        String formattedDate = now.format(formatter);
        return formattedDate;
	}

	@Override
	public String toString() {
		return "Blog [id=" + id + ", title=" + title + ", content=" + content + ", category=" + category + ", tags="
				+ tags + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}
	
}
