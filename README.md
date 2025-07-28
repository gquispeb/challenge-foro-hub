# 🧠 Foro Hub - API REST con Spring Boot

Este es un proyecto de backend para gestionar un foro de discusión, desarrollado en **Java con Spring Boot 3**, siguiendo buenas prácticas como autenticación con JWT y migraciones con Flyway.

---

## 🚀 Funcionalidades
- Registro, listado, actualización y eliminación de tópicos (CRUD)
- Autenticación con **login y JWT**
- Validaciones y manejo de errores personalizados
- Persistencia con MySQL y JPA
- Migraciones con Flyway

---

## 🛠️ Tecnologías utilizadas
- Java 17
- Spring Boot 3
- Spring Security
- Spring Data JPA
- Flyway
- MySQL
- JWT (JSON Web Token)
- Maven

---

## 📦 Instalación

1. **Clona el repositorio:**
   ```bash
   git clone https://github.com/tu-usuario/foro-hub.git
   cd foro-hub

2. **Crea un archivo llamado application.properties**
   📌 Este archivo no viene incluido en el proyecto por seguridad. Usa application-template.properties como guía.
3. **Crea la base de datos en MySQL**
  CREATE DATABASE forohub;
4. **Ejecuta el proyecto desde IntelliJ o usando Maven**
   ./mvnw spring-boot:run

## 🔐 Autenticación
  Para acceder a los endpoints protegidos:

1. Envía un POST a /login con tu email y contraseña.
2. Recibirás un token JWT. Envíalo en los siguientes requests como: Authorization: Bearer TU_TOKEN

## **🧪 Pruebas**
  Puedes usar Insomnia o Postman con las siguientes rutas: 
  * POST /login → Login
  * POST /topicos → Crear tópico
  * GET /topicos → Listar
  * PUT /topicos → Actualizar
  * DELETE /topicos/{id} → Elimina

