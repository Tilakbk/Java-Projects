"# EcomNepal - Full Stack Ecommerce Platform

A modern, responsive full-stack e-commerce application built with Spring Boot and React. EcomNepal provides a seamless shopping experience with product browsing, cart management, and checkout functionality.

## 📋 Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Tech Stack](#tech-stack)
- [Prerequisites](#prerequisites)
- [Installation & Setup](#installation--setup)
- [Project Structure](#project-structure)
- [Running the Application](#running-the-application)
- [Demo](#demo)
- [API Documentation](#api-documentation)
- [Contributing](#contributing)
- [License](#license)

## Overview

EcomNepal is a full-stack e-commerce platform designed to provide users with an intuitive and efficient way to browse, search, and purchase products online. The application features a robust backend API powered by Spring Boot and a modern, responsive frontend built with React and Vite.

## ✨ Features

### Frontend Features
- **Product Browsing**: Browse products with detailed information and images
- **Shopping Cart**: Add/remove products and manage quantities
- **Checkout System**: Streamlined checkout process with popup confirmation
- **Product Management**: Add and update products
- **Responsive Design**: Mobile-friendly interface using Bootstrap
- **Dynamic Navigation**: React Router-based navigation
- **Search & Filter**: Find products easily

### Backend Features
- **RESTful API**: Complete REST API for product management
- **Database**: H2 in-memory database for data persistence
- **Spring Data JPA**: Efficient database operations
- **Product Management**: Create, read, update, and delete products
- **CORS Support**: Cross-origin requests enabled

## 🛠️ Tech Stack

### Backend
- **Java 21**: Latest Java version
- **Spring Boot 4.0.6**: Modern Spring Boot framework
- **Spring Data JPA**: ORM and database operations
- **H2 Database**: Lightweight, in-memory database
- **Maven**: Build and dependency management

### Frontend
- **React 18.2.0**: Latest React library
- **Vite**: Next-generation frontend tooling
- **Bootstrap 5.3.3**: Responsive UI framework
- **React Bootstrap**: Bootstrap components for React
- **React Router 6.22.3**: Client-side routing
- **Axios 1.6.8**: HTTP client for API calls
- **React Icons**: Icon library

## 📋 Prerequisites

Before you begin, ensure you have the following installed:

- **Java Development Kit (JDK)**: Version 21 or higher
- **Node.js**: Version 16.0.0 or higher
- **npm**: Version 8.0.0 or higher
- **Maven**: Version 3.6.0 or higher (or use the included mvnw wrapper)
- **Git**: For version control

## 🚀 Installation & Setup

### Backend Setup

1. Navigate to the backend directory:
```bash
cd EcomNepal-Backend
```

2. Build the project using Maven:
```bash
# Using Maven wrapper on Windows
mvnw.cmd clean install

# Or using Maven directly
maven clean install
```

3. The application will start on `http://localhost:8080` by default

### Frontend Setup

1. Navigate to the frontend directory:
```bash
cd EcomNepal-frontend
```

2. Install dependencies:
```bash
npm install
```

3. Start the development server:
```bash
npm run dev
```

4. The application will be available at `http://localhost:5173`

## 📁 Project Structure

```
EcomNepal/
├── EcomNepal-Backend/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   │   └── com/tilak/EcomNepalBackend/
│   │   │   │       ├── Controller/        # REST API endpoints
│   │   │   │       ├── Model/             # Data models (Product, etc.)
│   │   │   │       ├── Repository/        # Data access layer
│   │   │   │       ├── Service/           # Business logic layer
│   │   │   │       └── EcomNepalBackendApplication.java
│   │   │   └── resources/
│   │   │       ├── application.properties # Configuration
│   │   │       └── data1.sql              # Initial data
│   │   └── test/                          # Unit tests
│   └── pom.xml                            # Maven configuration
│
├── EcomNepal-frontend/
│   ├── src/
│   │   ├── components/
│   │   │   ├── Home.jsx                   # Home page
│   │   │   ├── Product.jsx                # Product details
│   │   │   ├── Cart.jsx                   # Shopping cart
│   │   │   ├── Navbar.jsx                 # Navigation bar
│   │   │   ├── AddProduct.jsx             # Add product form
│   │   │   ├── UpdateProduct.jsx          # Update product form
│   │   │   └── CheckoutPopup.jsx          # Checkout modal
│   │   ├── Context/
│   │   │   └── Context.jsx                # Global state management
│   │   ├── App.jsx                        # Main app component
│   │   ├── axios.jsx                      # API client configuration
│   │   └── main.jsx                       # Entry point
│   ├── package.json
│   └── vite.config.js
│
└── ScreenShots/                           # Application screenshots
```

## 🎬 Running the Application

### Development Mode

**Terminal 1 - Start Backend:**
```bash
cd EcomNepal-Backend
mvnw.cmd spring-boot:run
```

**Terminal 2 - Start Frontend:**
```bash
cd EcomNepal-frontend
npm run dev
```

### Production Build

**Build Backend:**
```bash
cd EcomNepal-Backend
mvnw.cmd clean package
```

**Build Frontend:**
```bash
cd EcomNepal-frontend
npm run build
npm run preview
```

## 🎨 Demo

Here's a visual walkthrough of the EcomNepal application:

### 1. Home Page
![Screenshot 1](ScreenShots/Screenshot%20(326).png)

### 2. Product Display
![Screenshot 2](ScreenShots/Screenshot%20(327).png)

### 3. Product Details
![Screenshot 3](ScreenShots/Screenshot%20(328).png)

### 4. Add to Cart
![Screenshot 4](ScreenShots/Screenshot%20(329).png)

### 5. Shopping Cart View
![Screenshot 5](ScreenShots/Screenshot%20(330).png)

### 6. Cart Management
![Screenshot 6](ScreenShots/Screenshot%20(331).png)

### 7. Product Addition
![Screenshot 7](ScreenShots/Screenshot%20(332).png)

### 8. Add Product Form
![Screenshot 8](ScreenShots/Screenshot%20(333).png)

### 9. Product Updates
![Screenshot 9](ScreenShots/Screenshot%20(334).png)

### 10. Update Product Interface
![Screenshot 10](ScreenShots/Screenshot%20(335).png)

### 11. Checkout Process
![Screenshot 11](ScreenShots/Screenshot%20(336).png)

### 12. Checkout Confirmation
![Screenshot 12](ScreenShots/Screenshot%20(337).png)

### 13. Cart Summary
![Screenshot 13](ScreenShots/Screenshot%20(338).png)

### 14. Order Completion
![Screenshot 14](ScreenShots/Screenshot%20(339).png)

### 15. Navigation Features
![Screenshot 15](ScreenShots/Screenshot%20(340).png)

### 16. Final Interface
![Screenshot 16](ScreenShots/Screenshot%20(341).png)

## 📡 API Documentation

### Base URL
```
http://localhost:8080
```

### Product Endpoints

#### Get All Products
```http
GET /api/products
Response: List of all products
```

#### Get Product by ID
```http
GET /api/products/{id}
Response: Product details
```

#### Create New Product
```http
POST /api/products
Content-Type: application/json

{
  "name": "Product Name",
  "price": 99.99,
  "description": "Product Description",
  "imageUrl": "url/to/image"
}
```

#### Update Product
```http
PUT /api/products/{id}
Content-Type: application/json

{
  "name": "Updated Name",
  "price": 149.99,
  "description": "Updated Description",
  "imageUrl": "url/to/image"
}
```

#### Delete Product
```http
DELETE /api/products/{id}
Response: 204 No Content
```

## 🤝 Contributing

Contributions are welcome! Please follow these guidelines:

1. **Fork** the repository
2. **Create** a feature branch (`git checkout -b feature/AmazingFeature`)
3. **Commit** your changes (`git commit -m 'Add some AmazingFeature'`)
4. **Push** to the branch (`git push origin feature/AmazingFeature`)
5. **Open** a Pull Request

### Code Style Guidelines
- Follow Java naming conventions (camelCase for variables/methods, PascalCase for classes)
- Use meaningful variable and function names
- Add comments for complex logic
- Keep components focused and reusable
- Follow React best practices

## 📝 License

This project is open source and available under the MIT License. See the LICENSE file for more details.

## 📞 Support

For support, questions, or issues:
- Open an issue on GitHub
- Contact the development team
- Check the documentation

---

**Happy Shopping with EcomNepal!** 🛍️" 
