package cl.rsalinas.api.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.responses.ApiResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI apiInfo() {
        return new OpenAPI().info(new Info()
        .title("User API")
                .version("1.0.0")
                .contact(new Contact()
                        .name("Roberto Salinas")
                        .email("roberto.ismael90@gmail.com")));
    }

    @Bean
    public ApiResponse apiResponse() {
        return new ApiResponse();
    }
}
