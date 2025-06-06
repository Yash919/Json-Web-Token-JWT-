# JSON Web Token (JWT) Authentication System

This project demonstrates how to implement secure authentication using **JSON Web Tokens (JWT)** in a Spring Boot application. It includes login, token generation, validation, and protected endpoints.

---

## 🚀 Features

- User login with JWT token generation
- Token-based authentication
- Stateless session management


---

## 🛠️ Tech Stack

- Java 17+
- Spring Boot
- Spring Security
- JWT (jjwt library)
- Maven
- H2
- Postman for API testing

---


## 🔐 How JWT Works

1. User logs in with credentials.
2. Server validates credentials and generates a JWT.
3. JWT is sent back and stored on client side (e.g., localStorage).
4. For every protected request, the JWT is sent via the `Authorization` header.
5. Server validates JWT and authorizes access.

---

## 🧪 Sample API Endpoints

| Method | Endpoint             | Description                  |
|--------|----------------------|------------------------------|
| POST   | `/api/auth/create`   | Create User |
| POST   | `/api/auth/login`    | Verify user in DB and generate JWT Token |
| GET    | `/api/dashboard`     | Verify JWT token and show Dashboard |
| GET    | `/weather/{city}`    | External weather API call via RestTemplate |

Use the JWT token in headers like:
Authorization: Bearer <header.payload.signature>

---
## Screenshots
- To create User: /api/auth/create
![image](https://github.com/user-attachments/assets/30fa78bc-5705-45b4-a788-1dfd6a4c8fd3)

- Generate JWT Token: /api/auth/login
![image](https://github.com/user-attachments/assets/1d4cd2e8-6521-4a15-92f7-63632254160c)

- Dashboard: /api/dashboard
![image](https://github.com/user-attachments/assets/b61c2afa-bfde-4f30-9296-01eef10f6a43)

- RestTemplate Impl: 
![image](https://github.com/user-attachments/assets/66a366b8-a320-43f6-8b79-fed0421a9d13)


---
## Credits
This project was created by Yash Mehta 🚀


