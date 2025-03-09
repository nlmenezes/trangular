# Trangular

The **Trangular** application is designed to calculate the **geographic center** of `n` points on the globe, regardless of how close or far apart they are. The application currently employs a cartesian-based approach to calculate the geographic center and is intended to grow into a broader suite of tools for geography-related applications.

## Features

### Core Functionality
- **Calculate Geographic Center**:
    - Utilizes the average of the points represented in cartesian coordinates.
    - Works for any number of points (`n`) and adapts to both closely clustered points and widely spread ones.

### Future Enhancements
- **New Calculation Techniques**: Additional algorithms will be implemented to provide more precise or specialized calculations.
- **Midpoint Enhancements**: Support for finding midpoints with detailed information on:
    - Accommodations.
    - Restaurants.
    - Points of Interest.
- **Cross-Platform UIs**:
    - A web-based user interface.
    - A mobile application for on-the-go use.

## Tech Stack

- **Java 17**: Core language for the backend.
- **Spring Boot 3.2.4**: Framework for rapid application development and dependency management.
- **Apfloat Library 1.14.0**: Precision floating-point arithmetic for geographic calculations.

## Dependencies

### Build Plugins
- `java`
- `org.springframework.boot` (version 3.2.4)
- `io.spring.dependency-management` (version 1.1.4)

### Application Dependencies
- **Spring Boot Starter**: Core Spring Boot libraries.
- **Apfloat**: A library for handling high-precision floating-point arithmetic.

### Test Dependencies
- **Spring Boot Starter Test**: Testing framework for unit and integration tests.

## How to Build and Run

### Prerequisites
Ensure you have the following installed:
1. **Java 17** or higher.
2. **Maven** (or an IDE like IntelliJ IDEA with Maven integration).
3. **Git** (optional, for source code management).

### Steps

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/trangular.git
   cd trangular
   
2. Build the application:
   ```bash
   ./mvnw clean install
   ```

3. Run the application:
   ```bash
   ./mvnw spring-boot:run
   ```

### Testing

To run the tests:
   ```bash
   ./mvnw test
   ```
## Roadmap

- Implement **alternative geographic center calculation techniques**.
- Extend support for discovering **places of accommodation, restaurants, and activities** near the geographic center.
- Develop a **web interface** for easier accessibility.
- Introduce a **mobile application** for user-friendly interactions on-the-go.
- Continuously expand the precision and scalability of the application.

## Contributing

Contributions are welcome! Here's how you can help:
1. Fork the repository.
2. Create a new feature branch:
   ```bash
   git checkout -b feature-name
   ```
3. Commit your changes:
   ```bash
   git commit -m "Add a descriptive commit message"
   ```
4. Push the branch and create a pull request.

## License

This project is licensed under the **MIT License**.