package com.pcs.blogging_api.Blog;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogSpringDataJpaRepository extends JpaRepository<Blog, Long>{

}
