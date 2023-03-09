# creditos-invested

Procedimiento para levantamiento y uso del servicio:

Tener el archivo .jar creditosinvested-0.0.1-SNAPSHOT.jar (Este JAR fue creado usando la version de Java 17)

La base de datos que se usa es MySQL.
Ejecutar los comandos que contiene el archivo sql "mydb script.sql", los cuales sirven para crear la db de nombre "mydb" y las tablas "client" y "loan" con algunos datos ya pre-añadidos.
Además el script crea un usuario de conexion usado por la API para poder accesar a la base de datos.
Usuario: creditos_user_api
Password: CredInvesApi102-
El puerto que utiliza la API para la conexion a la base de datos es 3306 (localhost:3306).

Abrir consola y posicionarse dentro de la carpeta que contenga el archivo .jar.
Correr el comando "java -jar creditosinvested-0.0.1-SNAPSHOT.jar"

Se utilizó la aplicacion Postman para probar la funcionalidad de la API con los diferentes metodos HTTP;
Para poder realizar los request a la API se debe configurar una llave valor en el header;
application_token = mypassword.

Una vez realizada la configuracion se pueden realizar los request con los siguientes paths:

Para clientes;

POST: http://localhost:8080/api/v1/cliente/ - Crea un cliente nuevo.

PUT: http://localhost:8080/api/v1/cliente/:idCliente - Modifica la informacion de un cliente.

GET: http://localhost:8080/api/v1/cliente/ - Lista de los clientes existentes.

GET: http://localhost:8080/api/v1/cliente/:idCliente - Muestra la informacion de un cliente en especifico.

DELETE: http://localhost:8080/api/v1/cliente/:idCliente - Elimina un cliente de la DB.

Para creditos;

POST: http://localhost:8080/api/v1/cliente/:idCliente/credito/ - Crea un credito nuevo para el respectivo cliente.

PUT: http://localhost:8080/api/v1/cliente/:idCliente/credito/:idCredito - Modifica la informacion de un credito.

GET: http://localhost:8080/api/v1/cliente/:idCliente/credito - Muestra los creditos pertenecientes a un cliente.

GET: http://localhost:8080/api/v1/cliente/:idCliente/credito/:idCredito - Muestra la informacion de un credito en especifico.

DELETE: http://localhost:8080/api/v1/cliente/:idCliente/credito/:idCredito - Elimina un credito de la DB.

Nota: Para poder implementar el uso de los metodo @POST y @PUT para la tabla "Client" (cliente) se debe de utilizar el siguiente formato;

Body para crear o actualizar un cliente

{  
  "name": "Javier Eduardo",
  "lastName":"Gonzalez",
  "phoneNumber":"546584",
  "email":"jav.gonzalez@hotmail.com",
  "address":"av conchitas 1252",
  "birthdate":"1977-10-06"   
}
Para poder implementar el uso de los metodo @POST y @PUT para la tabla "Loan"(credito) se debe de utilizar el siguiente formato;

Body para crear o actualizar un credito

{
  "amount": "1800",
  "paymentPlan":"6",
  "creationDate":"2023-01-06"
}
