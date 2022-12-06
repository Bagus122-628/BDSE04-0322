package com.lithan.a5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = SecurityConfigTest.class)
@WebAppConfiguration
class SecurityTest {

	@Autowired
	private WebApplicationContext context;

	private MockMvc mvc;

	@BeforeEach
	public void setup() {
		mvc = MockMvcBuilders
				.webAppContextSetup(context)
				.apply(springSecurity())
				.build();
	}

	@Test
	@WithMockUser(value = "user")
	public void testHomeWithUser() throws Exception {
		mvc.perform(get("/"));
	}

	@Test
	@WithMockUser(value = "viewstore", roles = "VIEW_STORE")
	public void testViewStoreRole() throws Exception {
		mvc.perform(get("/stores"));
	}

	@Test
	@WithMockUser(value = "addstore", roles = "ADD_STORE")
	public void testAddStoreRole() throws Exception {
		mvc.perform(get("/addStore"));
	}

	@Test
	@WithMockUser()
	public void testNotFoundURL() throws Exception {
		mvc.perform(get("/bad-url")).andExpect(status().isNotFound());
	}

	@Test
	public void testWithCSRF() throws Exception {
		mvc.perform(post("/").with(csrf()));
	}

}
