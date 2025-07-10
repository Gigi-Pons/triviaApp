# HTTP - `403 Forbidden`

**Date:** July 10, 2025

**Error Message:**
In Postman: 403 Forbidden

## What Happened
I I created a UserController with a POST/users endpoint to allow public user registration.  The DTO validation worked properly (producing 400 errors for bad input),
**but valid input requests still resulted in 403 Forbidden**, and the controller method was never reached.

## Diagnosis
- Confirmed the request was `POST /users`
- Saw that validation passed and control never reached the controller
- Realized 403 is thrown by Spring Security when a request is not permitted
- Checked my SecurityConfig and found: `requestMatchers("/users").permitAll()`
- Discovered that this only matches **GET /users** by default, not **POST**
- Verified by testing curl and different request methods

## Root Cause
Spring Security does not match HTTP methods unless specified.

## Fix
Updated SecurityConfig to explicitly allow POST requests:
`.requestMatchers(HttpMethod.POST, "/users").permitAll()`

## Verification
  - Restarted the server
  - Re-tested `POST /users` in Postman
  - Received `200 OK` with response body as expected
  - Controller was hit; user persisted successfully
 
## Related Commit 
[fix: 403 forbidden on user registration by permitting POST /users in SecurityConfig](https://github.com/Gigi-Pons/triviaApp/commit/c1e0e030f2cd1704a1e43eb2e22020696090f081)

## What I Learned
- Spring Security matches **method + path**, ot just the path
- Use `HttpMethod.POST` when allowing unathenticated access to `POST` endpoints
- a `403` that happens after validation but **before hitting the controller** is usually Spring Security
- Always test protected and unprotected routes separately
 
  
