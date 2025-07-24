
# 📘 Rest API Implementation

This is a lightweight, modular **API automation framework** built using **Java**, **REST Assured**, and **TestNG**.  
It follows a clean architecture that separates requests, responses, services, and test classes, making it scalable and easy to maintain.

---

### 📂 Project Structure

```
src/
├── main/
│   └── java/
│       └── com/api/
│           ├── base/                 # Base setup for REST Assured
│           │   └── BaseService.java
│           ├── models/
│           │   ├── requests/         # POJO for request payload
│           │   │   └── LoginRequest.java
│           │   └── responses/        # POJO for response parsing
│           │       └── LoginResponse.java
│           └── services/             # Service layer
│               └── AuthService.java
├── test/
│   └── java/
│       └── com/api/tests/            # Test layer
│           └── LoginSuccessTest.java
```

---

### 🚀 How to Run

1. **Clone the repository:**
   ```bash
   git clone https://github.com/Arti-Goswami/RestAPIImplementation.git
   cd RestAPIImplementation
   ```

2. **Run tests via Maven:**
   ```bash
   mvn clean test
   ```

---

### 🧪 Technologies Used

| Tool/Library        | Version   | Purpose                        |
|---------------------|-----------|--------------------------------|
| Java                | 8+        | Core programming language      |
| REST Assured        | 5.5.1     | API testing framework          |
| TestNG              | 7.11.0    | Test execution and reporting   |
| Jackson Databind    | 2.18.2    | JSON serialization/deserialization |
| Maven               | -         | Build & dependency management  |

---

### 📦 Dependencies (from `pom.xml`)
```xml
<dependency>
  <groupId>io.rest-assured</groupId>
  <artifactId>rest-assured</artifactId>
  <version>5.5.1</version>
  <scope>test</scope>
</dependency>

<dependency>
  <groupId>org.testng</groupId>
  <artifactId>testng</artifactId>
  <version>7.11.0</version>
  <scope>test</scope>
</dependency>

<dependency>
  <groupId>com.fasterxml.jackson.core</groupId>
  <artifactId>jackson-databind</artifactId>
  <version>2.18.2</version>
</dependency>

<dependency>
  <groupId>com.fasterxml.jackson.core</groupId>
  <artifactId>jackson-core</artifactId>
  <version>2.18.2</version>
</dependency>
```

---

### ✅ Features

- Clean separation of **Request**, **Response**, **Service**, and **Test** layers
- Built-in **BaseService** wrapper to simplify HTTP operations
- Fully **POJO-based request and response mapping**
- Easy to extend and integrate with CI/CD pipelines

---

### 🔒 Auth Service Example

Handled via `AuthService.java` with JSON request/response mapping using `LoginRequest` and `LoginResponse`.

Test case:
```java
@Test
public void testLoginSuccess() {
    // AuthService handles login call and validation
}
```
---

### 💬 Contributing

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.
---

### 📃 License
This project is open-sourced for demo purposes. Use and adapt freely.
