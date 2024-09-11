# CTAC Mini Spring Project: Securing APIs

## Running the project

- Clone the repository onto your local machine
    - This can be done by either downloading the repo as a .zip file and unpacking it or if using IntelliJ/VSCode
      into your desired directory via command line: ```gh repo clone EastonA01/CTAC-MiniSpring-SecuringAPIs```
- Navigate to the Main class (named CtacMiniSpringSecuringApisApplication)
    - (If running through IntelliJ) you can right click the class in the project files and select "Run".
    - (Command Line Option) in the root of our project folder you can run ```mvn spring-boot:run``` if all dependencies
      are properly installed

## Testing the endpoints

- /login endpoint
    - Using a POST request in postman, for an administrator entry (which is provided for you) include this raw JSON in
      the
      body: ``` {
      "username" : "admin",
      "password" : "admin"
      }```
    - The response should give you not just the returned user but the token associated with it.
- /register endpoint
    - Similar to the login route, but include rather this body:
    - ``{
      "username" : "TestUser",
      "password" : "TestPassword",
      "roles" :["ADMIN","USER"]
      }``
    - The response should be similar, with a token already generated for you.

## Additional Routes

- /details route
    - Able to be accessed by Users and Administrators alike.
        - To access this route in a POST request, include in the authorization field a bearer token (this will be the
          token you were generated on login/regsitry).
    - The response is as follows:
    - ```"All users can see this"```
- /admin/details
    - Similar route to /details but should only be accessed by administrator accounts
    - Response is as follows:
        - ```"Only admins can see this"```