package nl.vintik.sample.spring.resource

import io.swagger.v3.oas.annotations.Operation
import mu.KotlinLogging
import org.springframework.http.HttpStatus
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.*
import org.springframework.web.reactive.function.client.*


@RestController
@RequestMapping("/v1")
class HelloController : Api {

    @Operation(summary = "Get Hello")
    @GetMapping("/hello")
    @PreAuthorize("isAuthenticated()")
    suspend fun hello(): String {
        log.debug { "Hello World!" }
        return "Hello World!"
    }

    @ExceptionHandler(org.springframework.security.access.AccessDeniedException::class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    fun handleException(accessDenied: org.springframework.security.access.AccessDeniedException) {
        log.info ("API call failed", accessDenied)
    }
    companion object {
        val log = KotlinLogging.logger {}
    }
}