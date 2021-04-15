package com.clayton.archive;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.clayton.archive.controllers.LoginController;
import com.clayton.archive.controllers.ProjectsController;
import com.clayton.archive.controllers.UsersController;

@SpringBootTest
class ArchiveApplicationTests {
	@Autowired
	private ProjectsController projectsController;
	@Autowired
	private LoginController loginController;
	@Autowired
	private UsersController usersController;
	
	@Test
	void contextLoads() {
		assertThat(projectsController).isNotNull();
		assertThat(loginController).isNotNull();
		assertThat(usersController).isNotNull();
	}
}
