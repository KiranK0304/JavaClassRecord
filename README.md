# Java Class Record - Lab Repository

Repository containing practical implementations and lab exercises aligned with the Postgraduate Java Programming syllabus and Course Outcomes (CO).

---

## Course Outcomes (CO) Mapping

| Course Outcome | Description | Module & Topics | Primary Implementation Files |
| :--- | :--- | :--- | :--- |
| **CO1** | Demonstrate software development using popular IDE (IntelliJ IDEA) features. | **Module 1: Introduction**<br>• IDE Project Setup & Structure<br>• Reading input from console<br>• Variables, expressions & operator precedence<br>• Basic Java program execution | • `session_1/t1.java` (Hello World & IDE setup)<br>• `session_1/t2.java` (Console input & parity)<br>• `session_1/t5.java` (Arithmetic expressions)<br>• `session_1/session_1.iml` / `.idea` |
| **CO2** | Write simple Java programs containing iterative and decision-making statements. | **Module 1: Selections, Loops, Methods, Arrays**<br>• `if`, `if-else`, nested conditionals<br>• `for`, `while` loops<br>• 1D & 2D Arrays, Matrix manipulations<br>• Algorithms (Sorting, Search, Partitioning) | • `session_1/t3.java` (Largest of 3 numbers)<br>• `session_1/t4.java` (Multiplication table loop)<br>• `session_1/t7.java` (Strings & Array operations)<br>• `session_2/t1.java` (Recursion & array metrics)<br>• `session_2/t2.java` (Matrix addition & transpose)<br>• `session_3/` (Formula calculations, `Sort.java`, `HeapSort.java`, `QuickSelect.java`)<br>• `session_4/` (Array merging `lc.java`, `task6.java` Binary Search) |
| **CO3** | Design programs featuring inheritance and polymorphism. | **Modules 2 & 3: Classes, Abstraction, Inheritance**<br>• Classes, Objects, Constructors & `this`<br>• Single & Multilevel Inheritance (`extends`, `super`)<br>• Overriding vs Overloading<br>• Abstract classes & Dynamic binding | • `session_1/t6.java` (Book & BookUtility encapsulation)<br>• `session_5/co3.java` (Multilevel inheritance & `super`)<br>• `session_6/Polymorphism.java` (Static & Dynamic polymorphism)<br>• `new/task1.java` (Abstract `StudentEvaluation` hierarchy: UG, PG, Diploma, Certificate) |
| **CO4** | Perform I/O operations while taking care of exceptions and concurrent access. | **Module 4: Exception Handling and Threads**<br>• `try`, `catch`, `finally` clauses<br>• `throw`, `throws` & Custom user exceptions<br>• File I/O (`File`, `Scanner`, `PrintWriter`, `BufferedReader`)<br>• Multithreading (`Thread`, `Runnable`), lifecycle & states<br>• Synchronization & Inter-thread communication (`wait`, `notify`) | • `new/FileHandling.java` (File parsing, stats, custom exception handling, `PrintWriter`)<br>• `new/programming.txt` (Data input file)<br>• `new/ThreadConcurrencyDemo.java` (Thread creation, synchronization, race condition prevention, `wait()`/`notify()`) |
| **CO5** | Create simple graphical user interfaces using JavaFX. | **Module 5: GUI Programming**<br>• JavaFX Application structure (`start()`, `launch()`)<br>• Panes & Layouts (`VBox`)<br>• UI Controls & Input (`Label`, `Button`)<br>• Event Handling (`setOnAction`) | • `JavaFX/Main.java` (JavaFX Interactive Counter Application)<br>• `JavaFX/run.sh` (Compilation & runtime launcher) |

---

## Directory Structure

```text
Java/
├── .gitignore
├── README.md
├── session_1/           # CO1 & CO2: Basic syntax, console I/O, loops, classes
├── session_2/           # CO2: Recursion, arrays, matrix operations
├── session_3/           # CO2: Computational tasks, QuickSort, HeapSort, QuickSelect
├── session_4/           # CO2: Array algorithms, Binary Search, merging
├── session_5/           # CO3: Inheritance hierarchies and super keyword
├── session_6/           # CO3: Method overloading and dynamic polymorphism
├── new/                 # CO3 & CO4: Abstract evaluations, File I/O & Thread Concurrency
└── JavaFX/              # CO5: JavaFX GUI Desktop Application
```

---

## How to Run

### Sessions 1 to 6 and `new/`
Compile and run any standalone Java file:
```bash
# Example: CO4 File Handling
javac new/FileHandling.java
java -cp new FileHandling

# Example: CO4 Thread Concurrency & Synchronization
javac new/ThreadConcurrencyDemo.java
java -cp new ThreadConcurrencyDemo
```

### JavaFX (CO5)
Run the JavaFX application using the included launcher script:
```bash
cd JavaFX
./run.sh
```
