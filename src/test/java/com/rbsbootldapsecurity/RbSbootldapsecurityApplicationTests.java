package com.rbsbootldapsecurity;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.unauthenticated;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.FormLoginRequestBuilder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.Base64Utils;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RbSbootldapsecurityApplicationTests {

	 @Autowired
	    private MockMvc mockMvc;

	    @Test
	    public void loginWithValidUserThenAuthenticated() throws Exception {
	        FormLoginRequestBuilder login = formLogin()
	            .user("ben")
	            .password("benspassword");

	        mockMvc.perform(login)
	            .andExpect(authenticated().withUsername("ben"));
	    }

	    @Test
	    public void loginWithInvalidUserThenUnauthenticated() throws Exception {
	        FormLoginRequestBuilder login = formLogin()
	            .user("invalid")
	            .password("invalidpassword");

	        mockMvc.perform(login)
	            .andExpect(unauthenticated());
	    }


	    @Test
	    public void testHttpBasicAuth() throws Exception{
	    	String url = "/ldapscurapp/user/services/user/1000";
	    	
	    	mockMvc.perform(get(url).with(httpBasic("ben", "benspassword"))).andExpect(authenticated());
	    }
	    
	   @Test
	    public void testHttpBasicAuthFailure() throws Exception{
	    	String url = "/ldapscurapp/user/services/user/1000";
	    	
	    	mockMvc.perform(get(url).with(httpBasic("hen", "password"))).andExpect(unauthenticated());
	    	
	    }
	    
	    @Test
	    @WithMockUser(username = "test", password = "test")//, roles = "USER")
	    public void withMockUser() throws Exception {
	    	String url = "/ldapscurapp/user/services/user/1000";
	        this.mockMvc.perform(get(url))
	        .andExpect(authenticated());
	        //.andExpect(status().isOk());
	    }
	    
	    @Test
	    public void basicAuth() throws Exception {
	    	String url = "/ldapscurapp/user/services/user/1000";
	        this.mockMvc
	                .perform(get(url).header(HttpHeaders.AUTHORIZATION,
	                        "Basic " + Base64Utils.encodeToString("ben:benspassword".getBytes())))
	                .andExpect(authenticated());
	                //.andExpect(status().isOk());
	    }
}
