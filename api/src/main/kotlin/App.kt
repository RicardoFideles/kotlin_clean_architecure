import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.http.HttpMethod
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@SpringBootApplication(scanBasePackages = [
    "br.com.rf"
])
class App {

    @Bean
    fun corsConfigurer(): WebMvcConfigurer {
        return object : WebMvcConfigurer {
            override fun addCorsMappings(registry: CorsRegistry) {
//                registry.addMapping("/**")
//                    //.allowedOriginPatterns("https://*.petrobras.com.br")
//                    .allowedMethods(
//                        HttpMethod.GET.name(), HttpMethod.POST.name(), HttpMethod.PUT.name(),
//                        HttpMethod.DELETE.name(), HttpMethod.OPTIONS.name())
//                    .allowCredentials(true)
//                    .maxAge(3600)
            }
        }
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(App::class.java, *args)
}