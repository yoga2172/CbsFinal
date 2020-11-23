package com.cbs.capbrandingstore;
import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/** Swagger 
 * 
 * @author Yoga's, Reshma's and AbhiRams's
 *
 */


@Configuration
@EnableSwagger2
public class CapBrandingSwagger {

	
	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(metadata()).select().paths(regex("/api/v0.*")).build();
	}

	@SuppressWarnings("deprecation")
	private ApiInfo metadata() {
		return new ApiInfoBuilder().title("Cap Branding Store").description("An E-Commerce Website For an Organition Employees").contact("Yoga, Reshma, Abhi").version("2.0").build();	
	}
}


