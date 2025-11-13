# club-de-futbol

Proyecto entregable para la asignatura: sistema de gestión de clubes con relaciones JPA, interfaz web y ejecutable.

## Ejecutar localmente

1. Compilar:
```
mvn clean package
```

2. Ejecutar:
```
mvn spring-boot:run
```

Abrir en el navegador:
- Interfaz: http://localhost:8107/
- Consola H2: http://localhost:8107/h2-console  (JDBC URL: jdbc:h2:mem:clubdb, user: sa)

## Notas para entrega / Render
- El proyecto usa H2 en memoria por defecto (ideal para pruebas locales). En un despliegue en Render los datos en memoria se perderán si el contenedor se reinicia.
- Si deseas usar PostgreSQL en Render, modifica `application.properties` para leer variables de entorno y agrega la dependencia de PostgreSQL al `pom.xml`.
