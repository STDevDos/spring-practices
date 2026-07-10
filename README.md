# Spring Practices Ecosystem (Modernized Version)

Este repositorio contiene un ecosistema de micro-proyectos y prácticas desarrolladas con **Spring Boot**, ahora completamente modernizado para las últimas tecnologías de la plataforma Java.

## 🚀 Actualización Integral (Julio 2026)

Se ha realizado una actualización de gran alcance para llevar todo el codebase a los estándares más modernos de la industria:

- **Java 25 (LTS)**: Todo el proyecto compilado y ejecutado bajo la especificación Java 25 nativa (`maven.compiler.release=25`).
- **Spring Boot 3.5.3**: Actualización a la última versión estable real de Spring Boot 3, asegurando compatibilidad con Jakarta EE 10+ y eliminando dependencias obsoletas.
- **Hilos Virtuales de Java (Virtual Threads - JEP 444)**: Habilitados globalmente (`spring.threads.virtual.enabled=true`) en todos los submódulos configurados, logrando concurrencia ultra-ligera y óptima para operaciones asíncronas.
- **Java Records (Java 16+)**: Refactorización masiva de DTOs, Requests y Payloads a estructuras inmutables de tipo `record`, eliminando más de 500 líneas de código repetitivo (*boilerplate*) de getters, setters, constructores y métodos `equals`/`hashCode`/`toString`.
- **Maven Wrapper (`mvnw`)**: Añadido para estandarizar la compilación y dependencias del ecosistema sin necesidad de instalación previa del framework Maven.

## 🛠️ Requisitos del Sistema

- **JDK 25** (o superior): Necesario para compilar y ejecutar este proyecto.
- **Maven Wrapper**: Incluido en el directorio raíz como `./mvnw`.

## 📁 Módulos Principales y Logros

Este ecosistema cubre una amplia gama de escenarios, desde básicos hasta avanzados:

| Módulo | Descripción | Cambios en Modernización |
| :--- | :--- | :--- |
| `spring-mlt` | Microservicio complejo con Seguridad, Mensajería y Cache | Migración a Spring Security 6, Spring Cloud Stream 4 y Resilience4J 2. Hilos Virtuales activos. |
| `springboot-jpa-basic-junit5` | Pruebas unitarias de persistencia | Configurado para compatibilidad Mockito con Java 25. DTOs migrados a Records. |
| `springboot-h2database` | Servicios REST con base de datos en memoria | Inyección de dependencias moderna, DTOs y Requests migrados a Records. |
| `springboot-platzi` | Práctica sobre JPA y persistencia avanzada | Reemplazo de `@GenericGenerator` de Hibernate (obsoleto) a favor de la estrategia estándar de JPA `GenerationType.UUID`. |
| `spring-applicationcontext-jdbc` | Configuración clásica de Contexto de Spring | Refactorización de Bean lookups manuales a métodos genéricos auto-tipados `context.getBean(name, Class)`. DTOs migrados a Records. |

## ⚙️ Notas Técnicas de la Modernización

Durante este proceso se resolvieron retos clave de compatibilidad:

1. **JPA UUID Generation**: Eliminación de dependencias propietarias de Hibernate para la generación de claves primarias UUID, usando la propiedad nativa de Jakarta Persistence.
2. **Mockito y ByteBuddy**: Parámetros específicos en `maven-surefire-plugin` (`-Dnet.bytebuddy.experimental=true`) para permitir que las pruebas unitarias instrumenten clases en Java 25 sin conflictos de bytecode.
3. **Inyección por Constructor**: Remoción gradual de la inyección por campo (`@Autowired`) a favor de inyección basada en constructor para promover la inmutabilidad y pruebas más sencillas.

## 🏗️ Ejecución

Para construir y ejecutar tests en todo el ecosistema usando el wrapper de Maven:

```bash
./mvnw clean test
```

Para instalar y empaquetar todos los submódulos:

```bash
./mvnw clean install -DskipTests
```

---
*Desarrollado y mantenido bajo estándares modernos de ingeniería de software con soporte nativo para Hilos Virtuales y código inmutable.*
