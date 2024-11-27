# Drone Simulator Project

This project is a drone simulator developed as part of the **Object-Oriented Programming in Java – Advanced Course** from professor Müller Bady. The simulator retrieves data from a server, simulates drone behaviors, processes information, and displays real-time data dynamically for each drone.

---

## Table of Contents

- [Drone Simulator Project](#drone-simulator-project)
  - [Table of Contents](#table-of-contents)
  - [Introduction](#introduction)
  - [Features](#features)
  - [Requirements](#requirements)
  - [Usage](#usage)
    - [Build and Run](#build-and-run)
    - [Navigate Through the GUI](#navigate-through-the-gui)
    - [Key Controls for 3D Drone Model](#key-controls-for-3d-drone-model)
  - [Technical Details](#technical-details)
    - [Backend Functionality](#backend-functionality)
    - [Key Classes](#key-classes)
  - [UML Diagram](#uml-diagram)
  - [Libraries Used](#libraries-used)
  - [License](#license)

---

## Introduction

The drone simulator is an interactive application designed to simulate and visualize the behavior of drones. Users can explore various details, such as drone dynamics, types, and flight parameters, through an intuitive graphical user interface.

---

## Features

- Real-time drone behavior simulation.
- 3D visualization of drones using JavaFX.
- Interactive tables displaying drone data, dynamics, and types.
- Dynamic drone status visualization:
  - Battery levels.
  - Current coordinates.
  - Real-time updates and historical data.
- User-friendly interface designed with Swing and JavaFX.

---

## Requirements

- Java Development Kit (JDK) installed.
- JavaFX library included.
- Required libraries:
  - json.org
  - dotenv
  - JavaFX.swing
- `.env` file containing API credentials.

---

## Usage

### Build and Run

1. Clone the repository:

```bash  
git clone https://github.com/Naquoc17/DroneDataReadingProject.git
cd your-repo-name
```

2. Build and run the project:

```bash  
mvn clean install  
java -jar drone-simulator.jar
```

### Navigate Through the GUI

- Main dashboard with a refresh button for updating data.
- Side menu with navigation to:
  - Drone details.
  - Drone dynamics.
  - Drone types.
- Select a drone to view its dynamic presentation, including:
  - 3D model visualization.
  - Battery status, coordinates, and historical data.

### Key Controls for 3D Drone Model

- W/S: Zoom in/out.
- E/X: Rotate sideways.
- R/C: Circular rotation (left/right).

---

## Technical Details

### Backend Functionality

- API Data Handling:
  - Data is fetched from an API in JSON format.
  - Parsed into objects for easy manipulation.
- Dynamic Drone Presentation:
  - Displays battery, location, and status using JavaFX components.
- 3D Drone Visualization:
  - Built with JavaFX, incorporating dynamic rotation and zoom.

### Key Classes

- ClassPresent:
  - Handles dynamic drone data visualization.
  - Contains methods for displaying 3D models and dynamic stats.
- Drone3D:
  - Generates 3D drone models and controls their animations.
- InfoWindow:
  - Integrates JavaFX scenes with Swing for a seamless GUI experience.
- TestJson:
  - Fetches and parses JSON data from the API.

---

## UML Diagram

For detailed design and architecture, refer to the UML diagram in the `docs/uml-diagram.png`.

---

## Libraries Used

The following libraries are added as Maven dependencies:

- json.org
- dotenv
- JavaFX

---

## License

This project is licensed under the MIT License.
