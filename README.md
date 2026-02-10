Descripcion
# ForoDeMusicos
API REST desarrollada con Spring Boot para la gestión de un foro de músicos. Implementa autenticación con JWT, control de acceso mediante Spring Security y operaciones CRUD para la administración de tópicos y usuarios.

# Características

- API RESTful
- Autenticación con JSON Web Token (JWT)
- Gestión de usuarios
- CRUD completo de tópicos
- Seguridad con Spring Security
- Validación de datos
- Arquitectura por capas (Controller, Service, Repository)

# Tecnologías utilizadas

- Java 21+
- Spring Boot 3.2.2
- Spring Security
- JWT
- Maven
- JPA / Hibernate
- Base de datos (configurable)
- insomnia

# Acontinuacion se evidencia el funcionamiento creando test con insomnia del funcionamiento de la aplicacion.

- La aplicacion no arranca si no se autentica primero como se ve enesta imagen:
   ![](https://github.com/FabioTochoy/ForoDeMusicos/blob/main/APIRestReto/imagenes/autenticacionfail.jpg)

- La aplicacion comienza con un login que al ser ingresado correctamente genera un token
   ![](https://github.com/FabioTochoy/ForoDeMusicos/blob/main/APIRestReto/imagenes/autenticacion.jpg)

-Una vez generado el toquen en cada uno de los topicos agrega ese token generado y dara aceeso a los sigientes items:
    1.listar
    2.registrar
    3.actualizar
    4.borrar
  ![](https://github.com/FabioTochoy/ForoDeMusicos/blob/main/APIRestReto/imagenes/listar.jpg)
  ![](https://github.com/FabioTochoy/ForoDeMusicos/blob/main/APIRestReto/imagenes/registrar.jpg)
  ![](https://github.com/FabioTochoy/ForoDeMusicos/blob/main/APIRestReto/imagenes/actualizar.jpg)
  ![](https://github.com/FabioTochoy/ForoDeMusicos/blob/main/APIRestReto/imagenes/borrar.jpg)

# Consideraciones
- Para fines prácticos, se utilizó **pgAdmin** para crear y administrar el servidor SQL donde se almacenan los datos registrados por la aplicación.
- Por motivos de compatibilidad, se trabajó con **Spring Boot versión 3.2.2**, ya que versiones más recientes presentaban fallos durante el desarrollo del proyecto.

#Licencia
-Este proyecto fue creado con fines educativos como parte de la formación de ONE con Alura Latam.
  






