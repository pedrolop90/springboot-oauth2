# SpringBoot-oauth2
Proyecto para el manejo de autenticación y autorización de recursos de un servicio.

![Imagen del flujo de oauth2](https://uploads.toptal.io/blog/image/129096/toptal-blog-image-1549493352154-d8593c1d09444018667fd89566010f57.png)

### Ejecución
Podemos iniciar la ejecución del proyecto de dos maneras:
- Podemos usar docker, ya tengo preparado un
  docker-compose para ejecutar el proyecto de
  manera facil con el comando **docker-compose -d up**.
- Tambien podemos ejecutarlo directamente con gradle
  con el comando "gradle run".
  
### Pruebas

- #### Dependencias
    Para poder probar el funcionamiento correcto de oauth2
    debemos tener postman o algun client http disponible.

- #### Guia de Pruebas
    1.  Authenticación:
       <http://localhost:8080/oauth/token?grant_type=client_credentials&client_id=client_read&client_secret=1234567890>
       y la accion **POST** obtendremos el token para acceder a los recursos
       que hemos definido para ese scope, la salida seria
       muy similar a la siguiente:
        ```json
        {
        "access_token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsic2VydmljZSJdLCJzY29wZSI6WyJyZWFkIl0sImV4cCI6MTYxMTkyNzY2NCwiYXV0aG9yaXRpZXMiOlsiQ0xJRU5UX1JFQUQiXSwianRpIjoiYjEzOWE1MTctNjM2Ni00YzViLWI4ZDAtZTJiYmIwMDQ1MTVkIiwiY2xpZW50X2lkIjoiY2xpZW50X3JlYWQifQ.KiqoFiuIRh8Iz6EjuP64MgKp7H9If7bR-ZALnp7g15M",
        "token_type": "bearer",
        "expires_in": 43199,
        "scope": "read",
        "jti": "b139a517-6366-4c5b-b8d0-e2bbb004515d"
        }
        
        ```
    2. Authorización:
        - 200: Vamos a probar el acceso a un recurso que si
          tenemos acceso, entramos a la siguiente 
          url <localhost:8080/personas> y la accion **GET**,
          en este caso la salida deberia ser:
            ```json
            Hola Persona!!
            ```
          Correcto, esta funcionando bien.
        - 403: Vamos a probar el acceso a un recurso que no
          tenemos acceso, entramos a la siguiente 
          url <localhost:8080/personas/admin> y la accion **GET**,
          en este caso la salida deberia ser:
            ```json
            {
              "error": "access_denied",
              "error_description": "Access is denied"
             }
            ```
          Correcto esta funcionando bien.

Como pudemos comprobar podemos tener acceso a ciertos
recursos y a otros no, por medio de la especificacion oauth2
implementada en SpringBoot.
>> "Todo se puede aprender con la suficiente disciplina y dedicación"
