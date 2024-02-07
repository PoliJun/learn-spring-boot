# Spring Boot Security

## Add `spring-boot-starter-security` dependency

Start the application:

```terminal
WARN 61643 --- [  restartedMain] .s.s.UserDetailsServiceAutoConfiguration : 

Using generated security password: f8166e05-f855-4e5b-880f-ad43cf4c6903

This generated password is for development use only. Your security configuration must be updated before running your application in production.

2024-02-07 21:49:47.233  INFO 61643 --- [  restartedMain] o.s.s.web.DefaultSecurityFilterChain     : Will secure any request with [org.springframework.security.web.session.DisableEncodeUrlFilter@22538fbb, org.springframework.security.web.context.request.async.WebAsyncManagerIntegrationFilter@7e3c0b20, org.springframework.security.web.context.SecurityContextPersistenceFilter@5e203b18, org.springframework.security.web.header.HeaderWriterFilter@7d8634e6, org.springframework.security.web.csrf.CsrfFilter@66e77cfe, org.springframework.security.web.authentication.logout.LogoutFilter@3b40f4d1, org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter@6f775e75, org.springframework.security.web.authentication.ui.DefaultLoginPageGeneratingFilter@1444a9b5, org.springframework.security.web.authentication.ui.DefaultLogoutPageGeneratingFilter@1b4400a4, org.springframework.security.web.authentication.www.BasicAuthenticationFilter@392cb3f2, org.springframework.security.web.savedrequest.RequestCacheAwareFilter@4b90cb5a, org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestFilter@5e0180eb, org.springframework.security.web.authentication.AnonymousAuthenticationFilter@4bb6bea4, org.springframework.security.web.session.SessionManagementFilter@28b1a590, org.springframework.security.web.access.ExceptionTranslationFilter@6a00e72b, org.springframework.security.web.access.intercept.FilterSecurityInterceptor@40cafdde]
```

Start Browser:  
![login](image/login.png)

Default username is "user".  

- router "/login" to login
- router "/logout" to logout

