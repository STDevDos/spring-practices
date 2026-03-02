# Spring Practices Ecosystem (Modernized Version)

Este repositorio contiene un ecosistema de micro-proyectos y prácticas desarrolladas con **Spring Boot**, ahora completamente modernizado para las últimas tecnologías de la plataforma Java.

## 🚀 Actualización Reciente (Marzo 2026)

Se ha realizado una actualización integral para llevar todo el codebase a los estándares más modernos:

- **Java 25 (LTS)**: Todo el proyecto ha sido actualizado para aprovechar las funcionalidades y el rendimiento de la versión 25 de Java.
- **Spring Boot 3.4.3**: Actualización a la última versión estable de Spring Boot 3, asegurando compatibilidad con Jakarta EE y eliminando dependencias obsoletas.
- **Spring Framework 6.2.3**: Núcleo actualizado para el máximo rendimiento y soporte de nuevas APIs.
- **Spring Cloud 4.2.0**: Modernización de los sistemas de mensajería (StreamBridge) y resiliencia.

## 🛠️ Requisitos del Sistema

- **JDK 25**: Es necesario tener instalado el JDK 25 para compilar y ejecutar este proyecto.
- **Maven 3.9+**: Para la gestión de dependencias y construcción del proyecto.

## 📁 Módulos Principales y Logros

Este ecosistema cubre una amplia gama de escenarios, desde básicos hasta avanzados:

| Módulo | Descripción | Cambios en Modernización |
| :--- | :--- | :--- |
| `spring-mlt` | Microservicio complejo con Seguridad, Mensajería y Cache | Migración a Spring Security 6, Spring Cloud Stream 4 y Resilience4J 2. |
| `springboot-jpa-basic-junit5` | Pruebas unitarias de persistencia | Configurado para compatibilidad Mockito con Java 25. |
| `springboot-h2database` | Servicios REST con base de datos en memoria | Optimizado para inyección de dependencias moderna. |
| `springboot-exercises` | Ejercicios de controladores y lógica espacial | Corrección de aserciones y compatibilidad con Spring Data. |
| `springboot-cron` | Servicios programados y mensajería | Refactorización de servicios de mail y procesos batch. |

## ⚙️ Notas Técnicas de la Modernización

Durante este proceso se resolvieron retos clave de compatibilidad:

1.  **Compatibilidad de Bytecode**: Debido a que Java 25 es extremadamente nuevo, se configuró el plugin de compilación para generar bytecode compatible con Java 24 (`maven.compiler.release=24`), permitiendo que las herramientas de análisis de Spring operen correctamente.
2.  **Spring Security 6**: Se eliminó el uso de `WebSecurityConfigurerAdapter` (removido en SB3) a favor de la configuración basada en componentes `SecurityFilterChain`.
3.  **Mockito y ByteBuddy**: Se añadieron parámetros específicos en `maven-surefire-plugin` (`-Dnet.bytebuddy.experimental=true`) para permitir que Mockito pueda instrumentar clases en el entorno de Java 25.
4.  **Spring Cloud Stream**: Se migró el modelo de `@EnableBinding` al modelo funcional usando `StreamBridge`, permitiendo mayor flexibilidad y eliminando el acoplamiento con interfaces internas de Spring Cloud.

## 🏗️ Ejecución

Para construir y ejecutar tests en todo el ecosistema:

```bash
mvn clean install
```

Para ejecutar un módulo específico:

```bash
mvn spring-boot:run -pl :nombre-del-modulo
```

---
*Desarrollado y mantenido bajo estándares modernos de ingeniería de software.*
