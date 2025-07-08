# MapStruct - `QuizMapper` Bean Not Found

**Date:** July 8, 2025

**Error Message:**
Parameter 4 of constructor in com.gbueno.app.services.QuizService required a bean of type 'com.gbueno.app.mappers.QuizMapper' that could not be found.

## What Happened
I tried to use MapStruct to map between entities and DTOs.
Even though my `QuizMapper` interface was correctly annotated with `@Mapper(componentModel = "spring"), Spring Boot threw a runtime error when trying to inject it.

## Diagnosis
- Confirmed annotation was correct on `QuizMapper` (`@Mapper(componentModel = "spring")`)
- Checked `target/generated-sources/...` `QuizMapperImpl.java` was missing
- Googled the error: I found this usually means MapStruct isn't running
- Opened `pom.xml` and found a custom `maven-compiler-plugin` block
- Noticed it only included Lombok under `<annotationProcessorPaths>` no `mapstruct-processor`
- Realized this was **overriding** Maven's default processor discovery
- Removed the broken config and let Maven use default annotation processor

## Root Cause
My custom `<annotationProcessorPaths>` config only included Lombok, so Maven didn't run MapStruct's annotation processor. This caused the implementation class `QuizMapperImpl` to never be generated.

## Fix
- Removed `annotationProcessorPaths` from `pom.xml`
- Rebuilt project
- Verified `QuizMapperImpl` was generated

  ## Verification
  - `QuizService` now injects `QuizMapper` correctly
  - `target/generated-sources/.../QuizMapperImpl.java` exists
 
  
