package com.pluralsight.beanvalidation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pluralsight.beanvalidation.web.BookController;
import com.pluralsight.beanvalidation.dto.BookDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = BookController.class)
class ControllerTest {
	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	void invalidInput() throws Exception {
		BookDTO book = new BookDTO();
		String body = objectMapper.writeValueAsString(book);

		mvc.perform(post("/book")
				.contentType("application/json")
				.content(body))
				.andExpect(status().isBadRequest());
	}

	@Test
	void validInput() throws Exception {
		BookDTO book = new BookDTO();
		book.setAuthor("author");
		book.setTitle("title");
		String body = objectMapper.writeValueAsString(book);

		mvc.perform(post("/book")
				.contentType("application/json")
				.content(body))
				.andExpect(status().isOk());
	}

    @Test
    void invalidListInput() throws Exception {
        BookDTO book = new BookDTO();
        book.setAuthor("author");
        book.setTitle("title");
        List<String> tags = Arrays.asList("tag1", "tag2", null);
        book.setTags(tags);

        String body = objectMapper.writeValueAsString(book);

        mvc.perform(post("/book")
                .contentType("application/json")
                .content(body))
                .andExpect(status().isBadRequest());
    }

}
