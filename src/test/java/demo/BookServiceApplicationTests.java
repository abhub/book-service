package demo;

import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;

import junit.framework.Assert;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import demo.domain.Book;
import demo.repository.BookRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = BookServiceApplication.class)
@WebIntegrationTest({"management.port=0", "server.port=0"})
public class BookServiceApplicationTests {
	
	@Autowired
	private BookRepository bookRepository;
	
	
	RestTemplate rst = new  TestRestTemplate();
	
	
	@Value("${local.server.port}")
	private String port; 
	@Test
	public void testHello() {
		ResponseEntity<String> response = rst.getForEntity("http://localhost:"+ port + "/hello", String.class);
		Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
		Assert.assertEquals("Hello World", response.getBody());
		
	}
	
	@Test
	public void testData() {
		final List<Book> books = bookRepository.findByCategory("Java");
		assertThat(books, Matchers.hasSize(3));
	}

}
