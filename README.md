# 🏦 Bancario

**Aplicación bancaria robusta y escalable**  
_Aplicación backend para gestión de cuentas, transacciones y usuarios, desarrollada con Spring Boot, PostgreSQL y Docker._

[![Java](https://img.shields.io/badge/Java-17-%23ED8B00?logo=openjdk)](https://openjdk.java.net/)
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.1-green?logo=spring)](https://spring.io/projects/spring-boot)
[![Docker](https://img.shields.io/badge/Docker-Containers-%232496ED?logo=docker)](https://www.docker.com/)
[![License](https://img.shields.io/badge/License-MIT-blue)](LICENSE)
[![GitHub Repo](https://img.shields.io/badge/Repo-GitHub-%23121011?logo=github)](https://github.com/kruben84ec/bancario)

## 📋 Tabla de Contenidos

- [Características](#-características)
- [Tecnologías](#-tecnologías)
- [Requisitos](#-requisitos)
- [Configuración Inicial](#-configuración-inicial)
- [Ejecución con Docker](#-ejecución-con-docker)
- [Estructura del Proyecto](#-estructura-del-proyecto)
- [Endpoints de la API](#-endpoints-de-la-api)
- [Monitoreo y Logs](#-monitoreo-y-logs)
- [Contribución](#-contribución)
- [Licencia](#-licencia)

---

## 🚀 Características

- Gestión de cuentas bancarias (creación, consulta, bloqueo).
- Transacciones seguras (transferencias, depósitos, retiros).
- Autenticación JWT para usuarios y roles.
- Resiliencia integrada con **Circuit Breaker** (Resilience4j).
- Base de datos PostgreSQL con replicación y backups.
- Contenerización con Docker para despliegue en cualquier entorno.

---

## 🛠 Tecnologías

- **Backend**:  
  ![Java 17](https://img.shields.io/badge/-Java%2017-%23ED8B00)  
  ![Spring Boot](https://img.shields.io/badge/-Spring%20Boot%203.1-%236DB33F)  
  ![Spring Data JPA](https://img.shields.io/badge/-Spring%20Data%20JPA-%236DB33F)  
  ![Resilience4j](https://img.shields.io/badge/-Resilience4j-%23C21E56)

- **Base de Datos**:  
  ![PostgreSQL](https://img.shields.io/badge/-PostgreSQL%2013-%23336791?logo=postgresql)

- **Infraestructura**:  
  ![Docker](https://img.shields.io/badge/-Docker-%232496ED)  
  ![Docker Compose](https://img.shields.io/badge/-Docker%20Compose-%232496ED)

- **Monitoreo**:  
  ![Prometheus](https://img.shields.io/badge/-Prometheus-%23E6522C?logo=prometheus)  
  ![Grafana](https://img.shields.io/badge/-Grafana-%23F46800?logo=grafana)  
  ![ELK Stack](https://img.shields.io/badge/-ELK%20Stack-%23005571?logo=elastic)

---

## 📦 Requisitos

- **Java 17** ([Descargar JDK](https://openjdk.java.net/projects/jdk/17/))
- **Docker** ([Instalar Docker Desktop](https://www.docker.com/get-started))
- **PostgreSQL 13** (opcional, ya que se ejecuta en contenedor).
- **Maven** (recomendado para desarrollo local).

---

## ⚙ Configuración Inicial

1. **Clona el repositorio**:

   ```bash
   git clone https://github.com/kruben84ec/bancario.git
   cd bancario