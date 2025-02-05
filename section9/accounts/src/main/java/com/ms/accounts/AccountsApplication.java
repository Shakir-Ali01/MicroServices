package com.ms.accounts;

import com.ms.accounts.dto.AccountContactInfoDto;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableFeignClients
@EnableJpaAuditing(auditorAwareRef = "auditAwareImp")//Enabling jpa auditing
@EnableConfigurationProperties(value={AccountContactInfoDto.class})
@OpenAPIDefinition(
		info = @Info(
				title = "Accounts microservice REST API Documentation",
				description = "MsBank Accounts microservice REST API Documentation",
				version = "v1",
				contact = @Contact(
						name = "Shakir Ali",
						email = "learner@msbank.com",
						url = "https://www.msbank.com"
				),
				license = @License(
						name = "Apache 2.0",
						url = "https://www.msbank.com"
				)
		),
		externalDocs = @ExternalDocumentation(
				description =  "MsBank Accounts microservice REST API Documentation",
				url = "https://https://www.msbank.com/swagger-ui.html"
		)
)

public class AccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}

}
