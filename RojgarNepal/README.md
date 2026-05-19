# RojgarNepal - Job Portal Platform

A comprehensive job portal platform designed to connect job seekers and employers in Nepal. Built with modern web technologies, RojgarNepal provides a seamless experience for browsing job listings, creating profiles, and managing job applications.

## 🌟 Features

- **Job Listings**: Browse and search for job opportunities across various sectors
- **Advanced Search**: Powerful search functionality with filtering options
- **Job Creation**: Employers can post new job listings with detailed descriptions
- **Responsive Design**: Mobile-friendly interface built with Material-UI
- **Real-time Updates**: Instant job listing updates with MongoDB integration
- **API Documentation**: Complete Swagger/OpenAPI documentation
- **RESTful Architecture**: Clean and scalable REST API design

## 🛠️ Tech Stack

### Backend
- **Java 21**: Latest Java version with modern language features
- **Spring Boot 4.0.6**: Robust and scalable backend framework
- **MongoDB**: NoSQL database for flexible data storage
- **SpringDoc OpenAPI 2.8.8**: API documentation and Swagger UI
- **Maven**: Build automation and dependency management

### Frontend
- **React 18.2.0**: Modern UI library with hooks support
- **Material-UI (MUI) 5.10.6**: Professional UI component library
- **Axios 0.27.2**: HTTP client for API communication
- **React Router DOM 6.4.0**: Client-side routing
- **JSON Server**: Mock API for development

## 📁 Project Structure

```
RojgarNepal/
├── RojgarNepal-Backend/          # Spring Boot backend application
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   │   └── com/tilak/RojgarNepal/
│   │   │   │       ├── RojgarNepalApplication.java
│   │   │   │       ├── Config/          # Configuration classes
│   │   │   │       ├── Controller/      # REST API endpoints
│   │   │   │       ├── Model/           # Domain models
│   │   │   │       ├── Repos/           # Repository layer
│   │   │   │       └── Service/         # Business logic
│   │   │   └── resources/
│   │   │       └── application.properties
│   │   └── test/                        # Unit tests
│   └── pom.xml                   # Maven configuration
│
├── RojgarNepal-Frontend/         # React frontend application
│   ├── src/
│   │   ├── pages/               # React page components
│   │   ├── App.js              # Main application component
│   │   ├── index.js            # Application entry point
│   │   └── styles/             # CSS files
│   ├── public/
│   └── package.json            # NPM dependencies
│
└── ScreenShots/                 # Application screenshots
```

## 🚀 Getting Started

### Prerequisites
- Java 21 or higher
- Node.js 16+ and npm
- MongoDB (local or cloud instance)
- Maven 3.6+

### Backend Setup

1. Navigate to the backend directory:
```bash
cd RojgarNepal-Backend
```

2. Configure MongoDB connection in `src/main/resources/application.properties`:
```properties
spring.application.name=RojgarNepal
spring.data.mongodb.uri=mongodb://localhost:27017/RojgarNepal
```

3. Build the project:
```bash
mvn clean install
```

4. Run the application:
```bash
mvn spring-boot:run
```

The backend API will be available at `http://localhost:8080`

### Frontend Setup

1. Navigate to the frontend directory:
```bash
cd RojgarNepal-Frontend
```

2. Install dependencies:
```bash
npm install
```

3. Start the development server:
```bash
npm start
```

The frontend will be available at `http://localhost:3000`

## 📚 API Documentation

Once the backend is running, access the Swagger UI documentation at:
```
http://localhost:8080/swagger-ui.html
```

### Main API Endpoints

- **GET** `/api/jobs` - Get all job listings
- **GET** `/api/jobs/{id}` - Get job details
- **POST** `/api/jobs` - Create a new job listing
- **PUT** `/api/jobs/{id}` - Update job listing
- **DELETE** `/api/jobs/{id}` - Delete job listing
- **GET** `/api/search` - Search jobs with filters

## 🎬 Demo

### Application Screenshots

#### Home Page
![Home Page](./ScreenShots/Screenshot%20(355).png)

#### Dashboard
![Dashboard](./ScreenShots/Screenshot%20(356).png)

#### Job Feed
![Job Feed](./ScreenShots/Screenshot%20(357).png)

#### Create Job Listing
![Create Job](./ScreenShots/Screenshot%20(358).png)

#### Job Details
![Job Details](./ScreenShots/Screenshot%20(359).png)

## 🧪 Testing

### Backend Tests
Run unit tests with Maven:
```bash
mvn test
```

### Frontend Tests
Run React tests:
```bash
npm test
```

## 🔧 Configuration

### MongoDB Configuration
The MongoDB configuration is handled in:
- Backend: `src/main/java/com/tilak/RojgarNepal/Config/MongoConfig.java`

### Swagger Configuration
API documentation is configured in:
- Backend: `src/main/java/com/tilak/RojgarNepal/Config/SwaggerConfig.java`

## 📝 API Modules

### JobController
Handles all job-related REST API endpoints and HTTP requests.

### JobService
Implements business logic for job operations and data processing.

### JobRepo & SearchRepo
Data access layer for MongoDB operations with custom search implementations.

### Models
- **Post**: Main job listing model with title, description, location, salary, etc.

## 🤝 Contributing

Contributions are welcome! Please feel free to submit pull requests or open issues for bugs and feature suggestions.

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📄 License

This project is licensed under the MIT License - see the LICENSE file for details.

## 👨‍💻 Author

**Tilak** - Project Developer

## 📞 Support

For support, email support@rojgarnepal.com or open an issue in the repository.

---

**Last Updated**: May 2026
**Version**: 0.0.1-SNAPSHOT
