package com.apress.spring.config

import com.apress.spring.repository.JournalRepository
import org.springframework.beans.factory.InitializingBean
import org.springframework.boot.ResourceBanner
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.env.Environment
import org.springframework.core.io.DefaultResourceLoader
import org.springframework.data.rest.core.config.RepositoryRestConfiguration
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer
import org.springframework.util.ClassUtils
import org.springframework.web.servlet.ModelAndView
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping
import org.springframework.web.servlet.mvc.AbstractController
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Configuration
@ConditionalOnWebApplication
@ConditionalOnClass(JournalRepository::class)
@EnableConfigurationProperties(JournalProperties::class)
@ConditionalOnProperty(prefix = "journal", name = ["context-path", "banner"], matchIfMissing = true)
class JournalAutoConfiguration(
    private val ctx: ApplicationContext,
    private val environment: Environment,
    private val journal: JournalProperties
) : RepositoryRestConfigurer {
    companion object {
        const val BANNER = "/META-INF/banner/journal.txt"
        const val CONTROLLER_BEAN_NAME = "journalController"
    }

    @Bean
    fun simple() = InitializingBean {
        val loader = DefaultResourceLoader(ClassUtils.getDefaultClassLoader())
        var resource = loader.getResource(BANNER)

        journal.banner?.run {
            loader.getResource(this).run {
                if (this.exists()) resource = this
            }
        }

        ResourceBanner(resource).printBanner(environment, environment.javaClass, System.out)
    }


    @Bean(CONTROLLER_BEAN_NAME)
    fun journalController() = object : AbstractController() {
        override fun handleRequestInternal(request: HttpServletRequest, response: HttpServletResponse): ModelAndView {
            val repository = ctx.getBean(JournalRepository::class.java)
            return ModelAndView("journal", "journal", repository.findAll())
        }
    }

    override fun configureRepositoryRestConfiguration(config: RepositoryRestConfiguration, cors: CorsRegistry) {
        config.setBasePath(journal.apiPath)
    }

    @Bean
    fun urlHandler() = SimpleUrlHandlerMapping().apply {
        order = Int.MAX_VALUE - 2
        setMappings(mapOf(journal.contextPath to CONTROLLER_BEAN_NAME).toProperties())
    }

}
