# 실전 스프링 부트 워크북

![](https://i.imgur.com/Fvxg0I7.jpg)

https://hanbit.co.kr/store/books/look.php?p_code=B2433442478

`Kotlin 1.4.x` + `Spring Boot 2.4.x`로 작성한다.

## Spring CLI

Kotlin 프로젝트 생성 예제

```
spring init \
    --build=gradle \
    --java-version=1.8 \
    --language=kotlin \
    -d=web,thymeleaf,data-jpa,data-rest,h2,security \
    -g=com.apress.spring \
    -a=spring-boot-journal-secure \
    --package-name=com.apress.spring \
    -name=spring-boot-journal-secure \
    -x 
```

## Spring Boot JMS

Starter for JMS messaging using HornetQ. Deprecated as of 1.4 in favor of [spring-boot-starter-artemis](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-artemis)

## 스프링 부트 앱 확장

* [Publishing a project as module](https://docs.gradle.org/current/userguide/publishing_setup.html)
* [Spring Boot multi module project with Gradle doesn't build](https://stackoverflow.com/questions/47598848/spring-boot-multi-module-project-with-gradle-doesnt-build) 
* [Gradle - Maven Publish Plugin](https://docs.gradle.org/current/userguide/publishing_maven.html#publishing_maven)

### 이슈

`JournalRepository`를 주입 받아서 사용하면 다른 자동 설정들이 적용되지 않는다...

왜 그럴까? ㅠㅠ Auto Configuration 단계에서 `Repository`를 사용하려고 해서 그런가?

```kotlin
class JournalAutoConfiguration(
    private val repository: JournalRepository, // 다른 자동 설정들이 적용되지 않음
    private val environment: Environment,
    private val journal: JournalProperties
) : RepositoryRestConfigurer {
    
}
```

아래는 정상 동작하도록 억지로(?) 만든 코드이다..

```kotlin
class JournalAutoConfiguration(
    private val ctx: ApplicationContext, // 우회
    private val environment: Environment,
    private val journal: JournalProperties
) : RepositoryRestConfigurer {
    
    @Bean(CONTROLLER_BEAN_NAME)
    fun journalController() = object : AbstractController() {
        override fun handleRequestInternal(request: HttpServletRequest, response: HttpServletResponse): ModelAndView {
            val repository = ctx.getBean(JournalRepository::class.java)
            return ModelAndView("journal", "journal", repository.findAll())
        }
    }
}
```

## References

* [OAuth 2.0 Migration Guide](https://github.com/spring-projects/spring-security/wiki/OAuth-2.0-Migration-Guide)
* [Immutable @ConfigurationProperties Binding](https://www.baeldung.com/configuration-properties-in-spring-boot#immutable-configurationproperties-binding)
* [Messaging with JMS](https://spring.io/guides/gs/messaging-jms/)
* [Redis on Windows](https://github.com/microsoftarchive/redis)
