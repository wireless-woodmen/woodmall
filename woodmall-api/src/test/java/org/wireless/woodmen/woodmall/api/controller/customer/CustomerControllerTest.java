package org.wireless.woodmen.woodmall.api.controller.customer;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockBeans;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.wireless.woodmen.woodmall.api.controller.customer.dto.request.CustomerRegisterDto;
import org.wireless.woodmen.woodmall.api.logging.HttpLogInterceptor;
import org.wireless.woodmen.woodmall.domain.customer.CustomerCommandService;
import org.wireless.woodmen.woodmall.domain.customer.CustomerQueryService;

import java.nio.charset.StandardCharsets;

@MockBeans(
    value = {@MockBean(classes = {CustomerCommandService.class}), @MockBean(classes = {CustomerQueryService.class}), @MockBean(classes = {HttpLogInterceptor.class})}
)
@WebMvcTest(controllers = {CustomerController.class})
class CustomerControllerTest {
	private MockMvc mockMvc;
	@Autowired
	private WebApplicationContext webApplicationContext;
	@Autowired
	private ObjectMapper objectMapper;
	
	@BeforeEach
	void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).dispatchOptions(false).build();
	}
	
	@Test
	@DisplayName(value = "계정은 사용자 이름없이 생성될 수 없다.")
	void testRegisterWithoutUserName() throws Exception {
		//given
		CustomerRegisterDto registerDto = CustomerRegisterDto.sample();
		
		// when
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/customers")
			.content(objectMapper.writeValueAsString(registerDto)).contentType(MediaType.APPLICATION_JSON)
		).andExpect(MockMvcResultMatchers.status().isBadRequest()).andReturn();
		
		// then
		Assertions.assertEquals(result.getResponse().getStatus(), HttpStatus.BAD_REQUEST.value());
		Assertions.assertTrue(result.getResponse().getContentAsString(StandardCharsets.UTF_8).contains("이름은 필수 입력값입니다."));
	}
}