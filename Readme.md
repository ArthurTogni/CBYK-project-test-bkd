projeto está utilizando o jdk 1.11

comando maven: mvn clean install

startar o server a partir da classe DemoApplication.java

para solicitar o bearer token é necessario utilizar o postman
url token: localhost:8080/oauth/token
no authorization utilizar o Basic Auth
username: sa
password: sa 

body: form-data
    grant_type: password
    username: cbyk
    password: cbyk

{
    "access_token": "qxOnYrcWMfMssFxj5sTLdsiazCk",
    "token_type": "bearer",
    "refresh_token": "h06I0HCMLX0YPs5GU_ke9i3BoX4",
    "expires_in": 31036,
    "scope": "password"
}

nas requisições utilizar o beare token o "access_token".

link H2: http://localhost:8080/h2-console/login.jsp?jsessionid=73360f20ddaedd8c48cc91c8c2b7958f
JDBC URL: disponivel no Log da aplicação - example: H2 console available at '/h2-console'. Database available at 'jdbc:h2:mem:dd8fd8d4-3a28-439c-9fe4-caf50739d95b'

link documentação Swagger: http://localhost:8080/swagger-ui.html