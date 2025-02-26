# 🏦 Bancario

**Aplicación bancaria robusta y escalable**  
_Aplicación backend para la gestión de cuentas, transacciones y usuarios, desarrollada con Spring Boot, PostgreSQL y Docker._

[![Java](https://img.shields.io/badge/Java-17-%23ED8B00?logo=openjdk)](https://openjdk.java.net/)
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.1-green?logo=spring)](https://spring.io/projects/spring-boot)
[![Docker](https://img.shields.io/badge/Docker-Containers-%232496ED?logo=docker)](https://www.docker.com/)
[![License](https://img.shields.io/badge/License-MIT-blue)](LICENSE)
[![GitHub Repo](https://img.shields.io/badge/Repo-GitHub-%23121011?logo=github)](https://github.com/kruben84ec/bancario)

---

## 📋 Tabla de Contenidos

- [⚙️ Características](#-características)
- [🛠️ Tecnologías](#-tecnologías)
- [📦 Requisitos](#-requisitos)
- [⚙️ Configuración Inicial](#-configuración-inicial)
- [🛠️ Estructura del Proyecto](#-estructura-del-proyecto)
- [🛡️ Endpoints de la API](#-endpoints-de-la-api)
- [📊 Monitoreo y Logs](#-monitoreo-y-logs)
- [🔧 Contribución](#-contribución)
- [⚖️ Licencia](#-licencia)

---

## 🚀 Características

- Gestión completa de cuentas bancarias (creación, consulta, bloqueo).
- Transacciones seguras incluyendo transferencias, depósitos y retiros.
- Autenticación y autorización con JWT para usuarios y roles.
- Resiliencia integrada mediante **Circuit Breaker** (Resilience4j).
- Base de datos PostgreSQL con replicación y backups automáticos.
- Contenerización con Docker para un despliegue sencillo y escalable.

---

## 🛠 Tecnologías

### Backend
- ![Java 17](https://img.shields.io/badge/-Java%2017-%23ED8B00)
- ![Spring Boot](https://img.shields.io/badge/-Spring%20Boot%203.1-%236DB33F)
- ![Spring Data JPA](https://img.shields.io/badge/-Spring%20Data%20JPA-%236DB33F)
- ![Resilience4j](https://img.shields.io/badge/-Resilience4j-%23C21E56)

### Base de Datos
- ![PostgreSQL](https://img.shields.io/badge/-PostgreSQL%2013-%23336791?logo=postgresql)

### Infraestructura
- ![Docker](https://img.shields.io/badge/-Docker-%232496ED)
- ![Docker Compose](https://img.shields.io/badge/-Docker%20Compose-%232496ED)

### Monitoreo
- ![Prometheus](https://img.shields.io/badge/-Prometheus-%23E6522C?logo=prometheus)
- ![Grafana](https://img.shields.io/badge/-Grafana-%23F46800?logo=grafana)
- ![ELK Stack](https://img.shields.io/badge/-ELK%20Stack-%23005571?logo=elastic)

---

## 📦 Requisitos

Antes de iniciar, asegúrate de tener instalado:

- **Java 17** ([Descargar JDK](https://openjdk.java.net/projects/jdk/17/))
- **Docker** ([Instalar Docker Desktop](https://www.docker.com/get-started))
- **PostgreSQL 13** (opcional, ya que se ejecuta en un contenedor Docker)
- **Maven** (recomendado para desarrollo local)

---

## ⚙ Configuración Inicial

1. **Clona el repositorio**:
   ```bash
   git clone https://github.com/kruben84ec/bancario.git
   cd bancario
   ```
2. **Construye el proyecto con Maven**:
   ```bash
   mvn clean install
   ```
3. **Ejecuta la aplicación con Docker**:
   ```bash
   docker-compose up -d
   ```

---

## 📂 Estructura del Proyecto

```bash
bancario/
├── src/
│   ├── main/
│   │   ├── java/com/bancario/
│   │   │   ├── BancarioApplication.java   # Punto de entrada
│   │   │   ├── controller/                # Controladores REST
│   │   │   ├── service/                   # Lógica de negocio
│   │   │   ├── repository/                # Repositorios JPA
│   │   │   ├── model/                     # Entidades (Cuenta, Transacción, Usuario)
│   │   │   └── config/                    # Configuraciones (Seguridad, Circuit Breaker)
│   │   └── resources/
│   │       ├── application.yml            # Configuración de Spring Boot
│   │       ├── db/migration/              # Scripts de migración (Flyway/Liquibase)
│   │       └── static/                    # Documentación OpenAPI/Swagger
│   └── test/                               # Pruebas unitarias
│
├── docker/
│   ├── Dockerfile               # Configuración de la imagen Spring Boot
│   └── docker-compose.yml       # Orquestación de servicios (App, PostgreSQL, Prometheus)
│
├── scripts/                      # Scripts útiles para despliegue
├── data/postgres/                # Volúmenes de PostgreSQL
├── config/                       # Configuración de monitoreo
└── .github/                      # Workflows de GitHub Actions (CI/CD)
```

---

## 🔌 Endpoints de la API

| Método | Ruta                | Descripción |
|---------|---------------------|-------------|
| **POST** | `/api/auth/signup` | Registro de usuarios |
| **POST** | `/api/auth/login`  | Autenticación JWT |
| **GET**  | `/api/cuentas`     | Listar todas las cuentas |
| **POST** | `/api/cuentas`     | Crear una nueva cuenta |
| **POST** | `/api/transacciones` | Realizar una transacción |
| **GET**  | `/actuator/health` | Health Check de la aplicación |

---

## 📊 Monitoreo y Logs
- **Prometheus** y **Grafana** para métricas y dashboards.
- **ELK Stack** para recolección y visualización de logs.

---

## 🤝 Contribución
Las contribuciones son bienvenidas. Por favor, sigue las mejores prácticas de desarrollo y envía un Pull Request.

---

## 📜 Licencia

Este proyecto está bajo la licencia **MIT**.

