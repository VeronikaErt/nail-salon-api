package com.example.nailsalon.config;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import org.springframework.context.annotation.Configuration;
@Configuration
@OpenAPIDefinition(info=@Info(title="Nail Salon REST API",version="1.0",description="Учебный RESTful API салона маникюра. Swagger содержит описание методов, валидацию и JWT-авторизацию."))
@SecurityScheme(name="bearerAuth",type=SecuritySchemeType.HTTP,scheme="bearer",bearerFormat="JWT",in=SecuritySchemeIn.HEADER,description="Введите JWT-токен, полученный через POST /api/auth/login")
public class OpenApiConfig {}
