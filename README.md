# User Management System

A desktop-based **User Management System** developed using **Java Swing** and **MySQL**. The system provides separate functionalities for administrators, employees, sellers, and users, including registration, authentication, product management, order management, returns, refunds, and email/OTP-based verification.

## 📌 Project Overview

The **User Management System** is a Java desktop application designed to manage users and different business operations through a centralized system.

The application provides role-based access for:

* 👨‍💼 Administrator
* 👨‍💻 Employee
* 🛍️ Seller
* 👤 User/Customer

The system uses **MySQL** as the backend database and provides a graphical user interface built with **Java Swing**.

---

## ✨ Features

### 🔐 Authentication & Registration

* User registration and login
* Administrator login
* Seller registration and login
* Employee management
* OTP generation and email verification
* Role-based access control

### 👨‍💼 Admin Management

* Add administrators
* Add employees
* Update employee information
* Remove employees
* View employee information
* Manage sellers
* View system data

### 🛍️ Seller Management

* Seller registration
* Seller login
* Update seller information
* Remove sellers
* View seller information
* Product management

### 📦 Product Management

* Add products
* View products
* Purchase products
* Product/order details
* Order management

### 🔄 Order & Return Management

* View orders
* Update orders
* Purchase details
* Manage product returns
* Update refund information

### 📧 Email & OTP

* OTP generation
* Email-based verification
* Email sending functionality

### 🖥️ Desktop GUI

* Java Swing-based graphical interface
* Login screens
* Registration screens
* Admin dashboard
* Seller dashboard
* User dashboard
* Splash screen
* Custom icons and background images

---

## 🛠️ Technologies Used

| Technology        | Purpose                  |
| ----------------- | ------------------------ |
| **Java**          | Application development  |
| **Java Swing**    | Graphical User Interface |
| **MySQL**         | Database management      |
| **JDBC**          | Java-MySQL connectivity  |
| **JavaMail API**  | Email functionality      |
| **OTP**           | User verification        |
| **IntelliJ IDEA** | Development environment  |

---

## 📂 Project Structure

```text
user-management-system/
│
├── src/
│   ├── icons/
│   │   ├── admin.jpg
│   │   ├── delete.png
│   │   ├── home.jpeg
│   │   ├── login.jpeg
│   │   ├── registration.png
│   │   ├── seller_login.png
│   │   └── ...
│   │
│   └── user/
│       └── management/
│           └── system/
│               ├── Main_class.java
│               ├── OTPGenerator.java
│               ├── Updateemp.java
│               ├── add_admin.java
│               ├── add_product.java
│               ├── addemp.java
│               ├── addseller.java
│               ├── admin_login.java
│               ├── conn.java
│               ├── login.java
│               ├── purchage_product.java
│               ├── purchase_details.java
│               ├── registration.java
│               ├── remove_emp.java
│               ├── remove_seller.java
│               ├── returms.java
│               ├── seller.java
│               ├── seller_login.java
│               ├── seller_regi.java
│               ├── splash.java
│               ├── update_orders.java
│               ├── update_refund.java
│               ├── updateseller.java
│               ├── user_home.java
│               ├── view_emp.java
│               ├── view_orders.java
│               ├── view_product.java
│               ├── view_returns.java
│               └── viewseller.java
│
├── .gitignore
└── user management system.iml
```

---

## 🗄️ Database

The application uses **MySQL** as its database.

The `conn.java` class is responsible for establishing the database connection using **JDBC**.

Before running the application, make sure that:

1. MySQL Server is installed.
2. The required database has been created.
3. Required tables are available.
4. Database credentials in the connection configuration are correct.
5. MySQL Connector/J is included in the project.

> **Note:** Database credentials should not be hard-coded or committed to a public repository in a production environment.

---

## 🚀 Getting Started

### Prerequisites

Make sure you have the following installed:

* Java JDK 8 or later
* MySQL Server
* IntelliJ IDEA or another Java IDE
* MySQL Connector/J
* JavaMail dependencies if email functionality is required

### 1. Clone the Repository

```bash
git clone https://github.com/koushik-013/user-management-system.git
```

### 2. Open the Project

Open the project using **IntelliJ IDEA**.

### 3. Configure MySQL

Create the required MySQL database and tables.

Then update the database connection configuration in:

```text
src/user/management/system/conn.java
```

### 4. Configure Dependencies

Make sure the required libraries are available in the project, including:

* MySQL Connector/J
* JavaMail API
* JCalendar or other required UI libraries

### 5. Run the Application

Run:

```text
Main_class.java
```

or start the application from the project's main entry point in IntelliJ IDEA.

---

## 🔑 Main Modules

```text
Authentication
     │
     ├── User Login
     ├── Admin Login
     ├── Seller Login
     └── Registration
             │
             ▼
      Role-Based Dashboard
             │
     ┌───────┼────────┐
     ▼       ▼        ▼
   Admin   Seller    User
     │       │        │
     ▼       ▼        ▼
 Employee  Product   Purchase
 Management Management Management
     │       │        │
     └───────┼────────┘
             ▼
      Order Management
             │
       ┌─────┴─────┐
       ▼           ▼
    Returns      Refunds
```

---

## 📸 Application

The project includes custom graphical assets for:

* Login
* Registration
* Admin panel
* Seller panel
* User panel
* Product management
* Home screens
* Return and refund modules

---

## 🎯 Learning Objectives

This project demonstrates practical implementation of:

* Object-Oriented Programming with Java
* Java Swing GUI development
* Database Management Systems
* JDBC connectivity
* CRUD operations
* User authentication
* Role-based system design
* MySQL database integration
* Email communication
* OTP generation and verification
* Desktop application development

---

## 🔮 Future Improvements

Possible improvements include:

* [ ] Password hashing and secure authentication
* [ ] Environment-based database configuration
* [ ] Improved database normalization
* [ ] Better input validation
* [ ] Modern responsive UI
* [ ] Role-based authorization improvements
* [ ] Transaction management
* [ ] Advanced reporting and analytics
* [ ] Database backup and recovery
* [ ] Migration from Swing to JavaFX
* [ ] REST API integration
* [ ] Automated testing

---

## 👨‍💻 Author

**Koushik**

GitHub:
https://github.com/koushik-013

---

## 📄 License

This project is intended for **educational and academic purposes**.

You are free to study and modify the source code for learning purposes.

---

## ⭐ Support

If you find this project useful, consider giving the repository a ⭐ on GitHub.
