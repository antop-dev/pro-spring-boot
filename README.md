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

## References

* [OAuth 2.0 Migration Guide](https://github.com/spring-projects/spring-security/wiki/OAuth-2.0-Migration-Guide)
