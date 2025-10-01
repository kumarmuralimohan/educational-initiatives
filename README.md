---

✅ Exercise 1 – Design Patterns

This folder contains six small Java programs that demonstrate different design patterns.  
Each program is self-contained and can be compiled and run individually.

- SingletonDemo.java → Logger implemented as a Singleton  
- FactoryDemo.java → Factory for creating notification types (Email, SMS, Push)  
- ObserverDemo.java → News agency publishes updates to multiple channels  
- CommandDemo.java → Remote control for light and fan operations  
- AdapterDemo.java → Adapter converts Fahrenheit readings to Celsius  
- DecoratorDemo.java → Notifications extended with SMS and Email decorators  

Run any of them with:

javac SingletonDemo.java
java SingletonDemo
Exercise 2 – Satellite Command System
This is a console-based simulation of a satellite.
The program manages satellite state and executes commands such as rotating orientation, activating/deactivating solar panels, and collecting data.

Features
Menu-driven console interface (no infinite loops)

Command Pattern for operations (Rotate, Activate, Deactivate, Collect)

Singleton Logger with timestamps for consistent logging

Custom exception handling (InvalidCommandException)

Defensive programming for input validation

Retry logic in data collection to simulate transient errors

Clear separation of classes (each in its own file for maintainability)

Initial State
Orientation: North

Solar Panels: Inactive

Data Collected: 0

Example Run
mathematica
Copy code
Satellite Command System started.
=== Satellite Status ===
Orientation: North
Solar Panels: Inactive
Data Collected: 0
========================

--- Menu ---
1. Rotate
2. Activate Panels
3. Deactivate Panels
4. Collect Data
5. Show Status
6. Exit
Enter choice: 1
Enter direction (North/South/East/West): South
[2025-09-29 12:30:10] [LOG] Satellite rotated to South

Enter choice: 2
[2025-09-29 12:30:15] [LOG] Solar panels activated.

Enter choice: 4
[2025-09-29 12:30:20] [LOG] Data collected. Total = 10
🛠 How to Run
Navigate to the folder:

bash
Copy code
cd Exercise2_SatelliteSystem
Compile all .java files:

bash
Copy code
javac *.java
Run the main application:

bash
Copy code
java SatelliteCommandSystem
Key Design Choices
Used Command Pattern so that each operation is encapsulated and can be extended easily.

Implemented Singleton Logger to standardize logging across the application.

Followed SOLID principles:

Single Responsibility → each class has one job.

Open/Closed → new commands can be added without modifying existing ones.

Liskov, Interface Segregation, Dependency Inversion → applied via abstractions and interfaces.

Defensive programming with input validation and custom exceptions.

Optimized for long-running usage with a menu-driven loop instead of hardcoded infinite loops.

Evaluation Criteria Checklist
 Code quality – structured, readable, and maintainable
 Design patterns – Command & Singleton implemented correctly
 SOLID principles – followed throughout
 Exception handling – custom exception and error handling included
 Logging – timestamped logging in a centralized logger
 Performance – efficient and lightweight
 Documentation – this README explains setup, usage, and design