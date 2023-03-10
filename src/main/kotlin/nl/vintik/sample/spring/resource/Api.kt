package nl.vintik.sample.spring.resource

import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import io.swagger.v3.oas.annotations.security.SecurityScheme

@SecurityRequirement(name = SECURITY_NAME)
@SecurityScheme(
    type = SecuritySchemeType.HTTP,
    name = SECURITY_NAME,
    scheme = "bearer",
    bearerFormat = "jwt",
    description = "Bearer JWT",
    `in` = SecuritySchemeIn.HEADER
)
interface Api

const val SECURITY_NAME = "jwt"