package org.gbfgit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class GbfgitApplication {

	@Autowired
	private HelloServer helloServer;

	@RequestMapping(value = "/test", produces = "text/plain;charset=UTF-8")
	public String index(){
		System.out.println("programer running ...");
		System.out.println(helloServer == null);
		return helloServer.sayHello();
	}

//	@Bean
//	public EmbeddedServletContainerCustomizer containerCustomizer(){
//		return new EmbeddedServletContainerCustomizer() {
//			@Override
//			public void customize(ConfigurableEmbeddedServletContainer container) {
//				System.out.println("create escc...");
//				ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/error.html");
//				container.addErrorPages(error404Page);
//			}
//		};
//	}
	public static void main(String[] args) {
		SpringApplication.run(GbfgitApplication.class, args);
	}
}
