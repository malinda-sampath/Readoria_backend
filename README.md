# Readoria 📚
> A scalable, microservices-based backend system for managing physical and digital libraries at a university level.

## 🧩 Overview
Readoria is an advanced online library management system designed for universities. It handles physical and digital books, inventory, borrowing processes, fines, staff/user registration, and automated email notifications. Built with Spring Boot microservices architecture, it ensures scalability, maintainability, and clear separation of responsibilities.

---

## 🛠️ Tech Stack

- **Spring Boot (Java 21)**
- **Spring Cloud (Gateway, Config, Eureka)**
- **Spring Security + JWT / Amazon Cognito**
- **PostgreSQL**
- **RabbitMQ** (for async communication)
- **Docker & Docker Compose**
- **Prometheus + Grafana** (Monitoring)
- **Maven**

---

## 🧱 Microservices Architecture

| Service | Description |
|--------|-------------|
| `api-gateway` | Routes and secures requests to microservices |
| `config-service` | Centralized configuration for all services |
| `discovery-service` | Service registry using Eureka |
| `user-service` | Staff and student registration, role-based auth |
| `book-service` | Manage physical and digital books |
| `inventory-service` | Track available, borrowed, and reserved books |
| `borrowing-service` | Handles borrow, return, renew, due dates |
| `reservation-service` | Manages book reservations |
| `payment-service` | Fine calculation and online payments |
| `notification-service` | Sends email alerts and reminders |
| `pdf-service` | Handles online book upload and reading |
| `admin-service` | Admin operations and report generation |
| `monitoring-service` | Monitoring and dashboard via Grafana |

---

## 🚀 Key Features

- 📚 Physical and digital book management
- 🧑‍🏫 Role-based user registration (staff, students, admins)
- 🔄 Borrowing, renewing, and returning system
- ⏰ Fine calculation for overdue returns
- 📬 Email reminders and notifications
- 📥 PDF library for online reading
- 📊 Admin dashboard for system reports
- 📦 Dockerized microservices
- 📈 Prometheus & Grafana monitoring

---

## 🧪 Getting Started

### Prerequisites
- Docker & Docker Compose
- JDK 21
- Maven

### Clone the Repository
```bash
git clone https://github.com/your-username/readoria-backend.git
cd readoria-backend
