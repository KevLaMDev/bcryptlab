# Bcrypt 

## Bcrypt is a simple server side rendered website created using Java Spring MVC and Spring Boot. The site allows users to create accounts with passwords, hashes the user's password and saves their account info to a postgres sql database. The user can then sign into their account, and create posts via a form. The form then creates new posts and saves them to their account via association within SQL.

## How to run from Command Line: ./gradlew bootRun

## How to use site:
- go to: localhost:8080
- Upon landing on the landing page, click the 'signup' link, where you can create a new user account.
- After successfully creating a new user account, create a post by filling out and submitting the form
- Upon successful submission of the form, you will redirected to a new page which shows all of your posts.