# 🚀 InsureFlow

> **A microservices-based commercial insurance platform built with Spring Boot, Kafka, React, MySQL, Docker, and Kubernetes.**

InsureFlow is a **commercial insurance application** that allows users to create quotes, generate policies, calculate premiums based on Lines of Business (LOB) and coverage, and receive automated email notifications after successful policy creation.

The project is designed around a **microservices architecture** with synchronous communication using **OpenFeign** and asynchronous event-driven communication using **Apache Kafka**.

---

## 🌐 Live Demo

🔗 **[Live Demo](#)**

---

# 📌 Overview

InsureFlow simulates a real-world commercial insurance workflow:

```text
Customer
   │
   ▼
Create Quote
   │
   ▼
Calculate Premium
   │
   ▼
Bind Policy
   │
   ▼
Publish Policy Event
   │
   ▼
Apache Kafka
   │
   ├──────────────► Customer Service
   │
   └──────────────► Notification Service
                          │
                          ▼
                     Email Notification
```

The application demonstrates how multiple microservices can work together using both **REST APIs** and **event-driven architecture**.

---

# ✨ Features

### 📄 Quote Management

* Create commercial insurance quotes
* Calculate premium based on:

  * Line of Business (LOB)
  * Coverage
  * Risk information

### 🛡️ Policy Management

* Convert quotes into policies
* Store policy information
* Generate policy details after successful binding

### 👤 Customer Management

* Manage customer information
* Retrieve customer information using REST APIs
* Communicate between services using **OpenFeign**

### 📧 Email Notifications

After a policy is successfully created:

```text
Policy Created
      ↓
Kafka Event
      ↓
Notification Service
      ↓
Email Sent
```

Users receive a confirmation email on their registered email address.

### 🔐 Authentication

* JWT-based authentication
* Secure API endpoints

### 🐳 Containerization

The application can be run using:

* Docker
* Docker Compose

### ☸️ Deployment

Deployment configuration is designed around:

* Docker
* Kubernetes

---
### Event Consumers

The Kafka event is consumed by multiple services:

```text
                 policy-events
                      │
             ┌────────┴────────┐
             │                 │
             ▼                 ▼
     Customer Service    Notification Service
             │                 │
             ▼                 ▼
      Policy Summary       Send Email
```

This demonstrates **event-driven communication** where services do not need to directly call each other for every operation.

---
# 🏗️ Architecture

InsureFlow follows a **microservices architecture**.

```text
                         ┌─────────────────┐
                         │     React UI    │
                         └────────┬────────┘
                                  │
                                  ▼
                          ┌─────────────────┐
                          │  Quote Service  │
                          │     :8082       │
                          └───────┬─────────┘
                                  │
                             |OpenFeign│
                                  ▼
                         ┌─────────────────┐
                         │ Customer Service│
                         │       8081      │
                         └─────────────────┘


                              Quote Service
                                    │
                                    │ Publish
                                    ▼
                         ┌──────────────────────┐
                         │        Kafka         │
                         │    policy-events     │
                         └──────────┬───────────┘
                                    │
                     ┌──────────────┴──────────────┐
                     │                             │
                     ▼                             ▼
       ┌───────────────────┐             ┌────────────────────┐
       │ Customer Service  │             │ Notification       │
       │                   │             │ Service            │
       │ Policy Summary    │             │      :8083         │
       └───────────────────┘             └─────────┬──────────┘
                                                   │
                                                   ▼
                                              📧 Email
       
---

# 🧩 Microservices

| Service                 |   Port | Responsibility                                          |
| ----------------------- | -----: | ------------------------------------------------------- |
| 👤 Customer Service     | `8081` | Customer and policy summary management                  |
| 📄 Quote Service        | `8082` | Quote creation, premium calculation and policy creation |
| 📧 Notification Service | `8083` | Email notifications                                     |
| 🗄️ MySQL               | `3306` | Persistent data storage                                 |
| 📨 Kafka                | `9092` | Event-driven communication                              |

---

# 🛠️ Tech Stack

### Frontend

* ⚛️ React.js
* HTML
* CSS
* JavaScript

### Backend

* ☕ Java 17
* 🌱 Spring Boot 3.3.5
* Spring Data JPA
* Spring Web
* OpenFeign
* Spring Security
* JWT

### Messaging

* 📨 Apache Kafka
* ZooKeeper

### Database

* 🐬 MySQL

### DevOps

* 🐳 Docker
* 🐳 Docker Compose
* ☸️ Kubernetes

### API Testing

* Postman

---

# 📋 Prerequisites

Before running the project locally, install:

* Java 17+
* Spring Boot 3.3.5
* Node.js
* npm
* React.js
* Docker Desktop
* MySQL
* Apache Kafka
* Postman

---

# 🐳 Running with Docker

The recommended startup order is:

```text
1. Docker Desktop
        ↓
2. MySQL
        ↓
3. ZooKeeper
        ↓
4. Kafka
        ↓
5. Customer Service :8081
        ↓
6. Quote Service :8082
        ↓
7. Notification Service :8083
        ↓
8. Postman / React UI
```

### Start MySQL

```bash
docker start insureflow-mysql
```

### Start Kafka and other infrastructure

```bash
docker compose up -d
```

Verify running containers:

```bash
docker ps
```
---

# 📚 What I Learned

Building InsureFlow helped me gain practical experience with:

* Microservices architecture
* Spring Boot
* REST API development
* OpenFeign client communication
* Kafka producers and consumers
* Event-driven architecture
* JWT authentication
* MySQL and JPA
* Docker and Docker Compose
* Kubernetes fundamentals
* Git and GitHub
* API testing with Postman
* Email integration
* Building and connecting multiple services

---

# 🚀 Future Improvements

Some areas planned for future development:

* API Gateway
* Service Discovery
* Centralized configuration
* Distributed tracing
* Prometheus and Grafana monitoring
* CI/CD pipeline
* Improved Kubernetes deployment
* Automated integration testing

---

# 👨‍💻 Author

**Prajjaval Tiwari**

Java | Spring Boot | Microservices | Kafka | Docker | Kubernetes

🔗 [GitHub](https://github.com/Prajjavaltiwari)

---

## ⭐ If you find this project useful

Give the repository a ⭐ and feel free to explore the code!

---

> **InsureFlow — From Quote to Policy, powered by Microservices and Event-Driven Architecture.**
