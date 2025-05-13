
# Java latest features from version 8 to 21.

## Table of Contents

1. [Lambda Expression](#1-lambda-expression)
2. [Method Reference](#2-method-reference)
3. [Default Methods](#3-default-methods)
4. [Date and Time API](#4-date-and-time-api)
5. [Functional Interface](#5-functional-interface)
6. [Optional in Java](#6-optional-in-java)
7. [Nashorn JavaScript Engine](#7-nashorn-javascript-engine)
8. [Streams in Java](#8-streams-in-java)
9. [Java Module System (Project Jigsaw)](#9-java-module-system-project-jigsaw)
10. [Try-With-Resources](#10-try-with-resources)
11. [Private Interface Methods](#11-private-interface-methods)
12. [Local Variable Type Inference](#12-local-variable-type-inference)
13. [Local Variable Type in Lambda Expressions](#13-local-variable-type-in-lambda-expressions)
14. [String Indent and Transform](#14-string-indent-and-transform)
15. [Files Mismatch](#15-explain-files-mismatch)
16. [Text Blocks](#16-explain-text-blocks)
17. [Yield Keyword](#17-explain-yield-keyword)
18. [Garbage Collector Updates](#18-garbage-collector-updates)
19. [Pattern Matching for `instanceof`](#19-pattern-matching-for-instanceof)
20. [Records](#20-explain-records-with-example)
21. [Sealed Class](#21-explain-sealed-class)
22. [Virtual Threads](#22-explain-virtual-threads-with-example)
23. [Sequenced Collections](#23-explain-sequenced-collections-with-example)
24. [String Templates](#24-explain-string-templates-with-example)
25. [Record Patterns](#25-explain-record-patterns-with-example)


# JAVA-8

## 1. Lambda expression

A Lambda expression is a feature introduced in Java 8 that provides a clear and concise way to represent a single method interface (functional interface) using an expression. It enables functional programming in Java and reduces boilerplate code.

#### Syntax:
```java
(parameters) -> expression
```
or
```java
(parameters) -> { statements; }
```

#### Example:
```java
import java.util.Arrays;
import java.util.List;

public class LambdaExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

        // Using Lambda Expression to iterate through the list
        names.forEach(name -> System.out.println(name));
    }
}
```

In this example:
- `name -> System.out.println(name)` is the Lambda expression.
- It takes a single parameter `name` and executes the `System.out.println(name)` statement.

Lambda expressions are commonly used with functional interfaces like `Runnable`, `Comparator`, and in APIs like `Stream` and `Collections`.

## 2. Method Reference

Method references are a shorthand notation introduced in Java 8 for calling a method by referring to it with the help of `::` (double colon) operator. They make the code more readable and concise by eliminating the need for a lambda expression when the method already exists.

#### Types of Method References:
1. Reference to a static method: `ClassName::staticMethodName`
2. Reference to an instance method of a particular object: `instance::instanceMethodName`
3. Reference to an instance method of an arbitrary object of a particular type: `ClassName::instanceMethodName`
4. Reference to a constructor: `ClassName::new`

#### Example:
```java
import java.util.Arrays;
import java.util.List;

public class MethodReferenceExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

        // Using Method Reference to print each name
        names.forEach(System.out::println);
    }
}
```

In this example:
- `System.out::println` is a method reference to the `println` method of the `System.out` object.
- It replaces the lambda expression `name -> System.out.println(name)`.

Method references are often used with functional interfaces and can simplify the code when the method being referred to matches the functional interface's method signature.



## 3. Default Methods

Default methods were introduced in Java 8 to allow interfaces to have method implementations. This feature enables developers to add new methods to interfaces without breaking the existing implementations of those interfaces.

#### Key Features:
- Default methods are defined using the `default` keyword.
- They provide a way to achieve backward compatibility.
- Classes implementing the interface can override the default methods if needed.
- They allow interfaces to evolve without forcing all implementing classes to provide an implementation for the new methods.

#### Syntax:
```java
public interface MyInterface {
    default void myDefaultMethod() {
        System.out.println("This is a default method.");
    }
}
```

#### Example:
```java
public interface Vehicle {
    default void start() {
        System.out.println("Vehicle is starting...");
    }
}

public class Car implements Vehicle {
    @Override
    public void start() {
        System.out.println("Car is starting...");
    }
}

public class Bike implements Vehicle {
    // Inherits the default implementation
}

public class DefaultMethodExample {
    public static void main(String[] args) {
        Vehicle car = new Car();
        car.start(); // Output: Car is starting...

        Vehicle bike = new Bike();
        bike.start(); // Output: Vehicle is starting...
    }
}
```


#### How Does This Support Backward Compatibility?
Default methods support backward compatibility by allowing developers to add new methods to interfaces without breaking the existing implementations of those interfaces. Before Java 8, adding a new method to an interface would require all implementing classes to provide an implementation for the new method, which could lead to compilation errors in existing codebases. With default methods:
- Existing classes that implement the interface automatically inherit the default implementation, ensuring they continue to work without modification.
- Developers can introduce new functionality in interfaces while maintaining compatibility with older versions of the code.

For example:
```java
public interface LegacyInterface {
    void existingMethod();

    // Adding a new method with a default implementation
    default void newMethod() {
        System.out.println("Default implementation of newMethod");
    }
}

public class LegacyClass implements LegacyInterface {
    @Override
    public void existingMethod() {
        System.out.println("Implementation of existingMethod");
    }
}

public class BackwardCompatibilityExample {
    public static void main(String[] args) {
        LegacyInterface legacy = new LegacyClass();
        legacy.existingMethod(); // Output: Implementation of existingMethod
        legacy.newMethod();      // Output: Default implementation of newMethod
    }
}
```

In this example, the `LegacyClass` continues to function without requiring changes, even though a new method (`newMethod`) was added to the interface.


#### Additional Notes:
1. **Conflict Resolution**:
   - If a class implements multiple interfaces with conflicting default methods, the class must override the method to resolve the conflict.
   - Example:
     ```java
     public interface InterfaceA {
         default void display() {
             System.out.println("InterfaceA display");
         }
     }

     public interface InterfaceB {
         default void display() {
             System.out.println("InterfaceB display");
         }
     }

     public class MyClass implements InterfaceA, InterfaceB {
         @Override
         public void display() {
             System.out.println("MyClass display");
         }
     }
     ```

2. **Static Methods in Interfaces**:
   - Along with default methods, Java 8 also introduced static methods in interfaces.
   - Static methods in interfaces cannot be overridden and are called using the interface name.
   - Example:
     ```java
     public interface Utility {
         static void printMessage() {
             System.out.println("Static method in interface");
         }
     }

     public class StaticMethodExample {
         public static void main(String[] args) {
             Utility.printMessage(); // Output: Static method in interface
         }
     }
     ```

3. **Use Cases**:
   - Adding helper methods to interfaces without breaking existing implementations.
   - Providing default behavior for methods in APIs.
   - Reducing boilerplate code in implementing classes.

Default methods and static methods in interfaces have significantly enhanced the flexibility and functionality of Java interfaces, making them more powerful and versatile.


## 4. Date and Time API

The Date and Time API introduced in Java 8 (in the `java.time` package) provides a modern and comprehensive way to handle date and time. It overcomes the shortcomings of the old `java.util.Date` and `java.util.Calendar` classes, offering an immutable and thread-safe approach.

#### Key Classes:
1. `LocalDate`: Represents a date (year, month, day) without time.
2. `LocalTime`: Represents a time (hour, minute, second, nanosecond) without a date.
3. `LocalDateTime`: Combines date and time without a time zone.
4. `ZonedDateTime`: Represents date and time with a time zone.
5. `Duration` and `Period`: Represent the difference between two date-time objects.
6. `DateTimeFormatter`: Formats and parses date-time objects.

#### Example:
```java
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeAPIExample {
    public static void main(String[] args) {
        // Current date
        LocalDate currentDate = LocalDate.now();
        System.out.println("Current Date: " + currentDate);

        // Current time
        LocalTime currentTime = LocalTime.now();
        System.out.println("Current Time: " + currentTime);

        // Current date and time
        LocalDateTime currentDateTime = LocalDateTime.now();
        System.out.println("Current Date and Time: " + currentDateTime);

        // Formatting date and time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDateTime = currentDateTime.format(formatter);
        System.out.println("Formatted Date and Time: " + formattedDateTime);

        // Parsing a date
        LocalDate parsedDate = LocalDate.parse("2023-10-01");
        System.out.println("Parsed Date: " + parsedDate);
    }
}
```

In this example:
- `LocalDate.now()` and `LocalTime.now()` fetch the current date and time.
- `DateTimeFormatter` is used to format the date-time into a custom pattern.
- `LocalDate.parse()` parses a string into a `LocalDate` object.

The Date and Time API is widely used for its simplicity, immutability, and ability to handle time zones effectively.


## 5. Functional Interface

A Functional Interface is an interface in Java that contains exactly one abstract method. It can have any number of default or static methods but must have only one abstract method. Functional interfaces are the foundation of lambda expressions in Java.

#### Key Features:
- Marked with the `@FunctionalInterface` annotation (optional but recommended).
- Can be used as the assignment target for a lambda expression or method reference.
- Examples include `Runnable`, `Callable`, `Comparator`, and custom interfaces.

#### Example:
```java
@FunctionalInterface
interface Greeting {
    void sayHello(String name);
}

public class FunctionalInterfaceExample {
    public static void main(String[] args) {
        // Using a lambda expression to implement the functional interface
        Greeting greeting = name -> System.out.println("Hello, " + name + "!");
        
        // Calling the method
        greeting.sayHello("Alice");
    }
}
```

In this example:
- The `Greeting` interface is a functional interface with a single abstract method `sayHello`.
- A lambda expression `name -> System.out.println("Hello, " + name + "!")` is used to provide the implementation for the `sayHello` method.

Functional interfaces enable functional programming in Java and are widely used in APIs like `Stream` and `Optional`.



## 6. Optional in Java

The `Optional` class, introduced in Java 8, is a container object used to represent the presence or absence of a value. It helps avoid `NullPointerException` by providing a way to explicitly deal with null values.

### Key Features:
- Represents a value that may or may not be present.
- Provides methods to handle the value or take alternative actions if the value is absent.
- Encourages functional programming by using methods like `map`, `filter`, and `flatMap`.

### Creating an Optional:
1. **Empty Optional**:
    ```java
    Optional<String> emptyOptional = Optional.empty();
    ```
2. **Optional with a Non-Null Value**:
    ```java
    Optional<String> optional = Optional.of("Hello");
    ```
3. **Optional with a Nullable Value**:
    ```java
    Optional<String> optional = Optional.ofNullable(null);
    ```

### Common Methods:
1. **`isPresent()`**: Checks if a value is present.
    ```java
    if (optional.isPresent()) {
         System.out.println(optional.get());
    }
    ```
2. **`ifPresent()`**: Executes a block of code if a value is present.
    ```java
    optional.ifPresent(value -> System.out.println("Value: " + value));
    ```
3. **`orElse()`**: Returns a default value if the value is absent.
    ```java
    String result = optional.orElse("Default Value");
    ```
4. **`orElseGet()`**: Returns a value from a supplier if the value is absent.
    ```java
    String result = optional.orElseGet(() -> "Generated Value");
    ```
5. **`orElseThrow()`**: Throws an exception if the value is absent.
    ```java
    String result = optional.orElseThrow(() -> new IllegalArgumentException("Value is absent"));
    ```
6. **`map()`**: Transforms the value if present.
    ```java
    Optional<Integer> length = optional.map(String::length);
    ```
7. **`filter()`**: Filters the value based on a condition.
    ```java
    Optional<String> filtered = optional.filter(value -> value.startsWith("H"));
    ```

### Example:
```java
import java.util.Optional;

public class OptionalExample {
     public static void main(String[] args) {
          // Creating an Optional
          Optional<String> optional = Optional.ofNullable("Hello");

          // Checking if a value is present
          if (optional.isPresent()) {
                System.out.println("Value: " + optional.get());
          }

          // Using ifPresent
          optional.ifPresent(value -> System.out.println("Value using ifPresent: " + value));

          // Using orElse
          String result = optional.orElse("Default Value");
          System.out.println("Result using orElse: " + result);

          // Using orElseGet
          result = optional.orElseGet(() -> "Generated Value");
          System.out.println("Result using orElseGet: " + result);

          // Using map
          Optional<Integer> length = optional.map(String::length);
          length.ifPresent(len -> System.out.println("Length of value: " + len));

          // Using filter
          Optional<String> filtered = optional.filter(value -> value.startsWith("H"));
          filtered.ifPresent(value -> System.out.println("Filtered value: " + value));
     }
}
```

### Use Cases:
1. Avoiding `NullPointerException` by explicitly handling null values.
2. Returning optional values from methods to indicate the possibility of absence.
3. Simplifying null checks and making the code more readable.

### Example with a Method:
```java
import java.util.Optional;

public class OptionalMethodExample {
     public static Optional<String> getGreeting(String name) {
          if (name == null || name.isEmpty()) {
                return Optional.empty();
          }
          return Optional.of("Hello, " + name + "!");
     }

     public static void main(String[] args) {
          Optional<String> greeting = getGreeting("Alice");
          greeting.ifPresent(System.out::println);

          Optional<String> emptyGreeting = getGreeting("");
          System.out.println(emptyGreeting.orElse("No greeting available"));
     }
}
```

In this example:
- The `getGreeting` method returns an `Optional` to indicate whether a greeting is available.
- The caller can handle the absence of a value using methods like `ifPresent` or `orElse`.

The `Optional` class promotes better programming practices by encouraging developers to handle null values explicitly, reducing the risk of runtime exceptions.


## 7. Nashorn JavaScript Engine

Nashorn is a JavaScript engine introduced in Java 8, which allows developers to execute JavaScript code directly on the Java Virtual Machine (JVM). It provides better performance and compliance with the ECMAScript specification compared to its predecessor, Rhino.

### Key Features:
1. Allows embedding JavaScript code in Java applications.
2. Enables interaction between Java and JavaScript.
3. Provides the `javax.script` package for scripting support.
4. Can be used to execute JavaScript files or inline scripts.

### Example: Executing JavaScript in Java
```java
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class NashornExample {
    public static void main(String[] args) {
        // Create a ScriptEngineManager
        ScriptEngineManager manager = new ScriptEngineManager();

        // Get the Nashorn ScriptEngine
        ScriptEngine engine = manager.getEngineByName("nashorn");

        // JavaScript code as a string
        String script = "var greeting = 'Hello, Nashorn!'; greeting;";

        try {
            // Execute the JavaScript code
            Object result = engine.eval(script);
            System.out.println(result); // Output: Hello, Nashorn!
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }
}
```

### Example: Interacting Between Java and JavaScript
```java
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class NashornInteractionExample {
    public static void main(String[] args) {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("nashorn");

        try {
            // Define a JavaScript function
            engine.eval("function add(a, b) { return a + b; }");

            // Invoke the JavaScript function from Java
            Object result = engine.eval("add(5, 10);");
            System.out.println("Result: " + result); // Output: Result: 15
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }
}
```

### Deprecation Note:
Starting from Java 11, Nashorn has been deprecated and removed in Java 15. Developers are encouraged to use alternative JavaScript engines or external libraries like GraalVM for JavaScript execution.

### Use Cases:
1. Embedding JavaScript logic in Java applications.
2. Dynamic scripting and runtime evaluation of JavaScript code.
3. Interoperability between Java and JavaScript for hybrid applications.

Nashorn was a significant addition in Java 8, enabling seamless integration of JavaScript into Java applications, but its deprecation highlights the shift towards more modern solutions like GraalVM.



## 8. Streams in Java

Streams in Java, introduced in Java 8, provide a powerful way to process collections of data in a functional programming style. They allow developers to perform operations such as filtering, mapping, and reducing data in a declarative and concise manner.

### Characteristics of Streams
1. **Declarative**: Streams allow you to focus on *what* to do rather than *how* to do it.
2. **Lazy Evaluation**: Intermediate operations are not executed until a terminal operation is invoked.
3. **Immutable**: Streams do not modify the source; they produce a new stream or result.
4. **Pipelining**: Operations can be chained together to form a pipeline.
5. **Parallelism**: Streams can be processed in parallel using `parallelStream()` for better performance on multi-core processors.

---

### Methods to Generate Streams
Streams can be created in several ways:

1. **From a Collection**:
    ```java
    List<String> list = Arrays.asList("A", "B", "C");
    Stream<String> stream = list.stream();
    ```

2. **From an Array**:
    ```java
    String[] array = {"A", "B", "C"};
    Stream<String> stream = Arrays.stream(array);
    ```

3. **Using `Stream.of()`**:
    ```java
    Stream<String> stream = Stream.of("A", "B", "C");
    ```

4. **Using `Stream.generate()`**:
    ```java
    Stream<Double> randomNumbers = Stream.generate(Math::random).limit(5);
    ```

5. **Using `Stream.iterate()`**:
    ```java
    Stream<Integer> numbers = Stream.iterate(1, n -> n + 1).limit(5);
    ```

6. **From Files**:
    ```java
    try (Stream<String> lines = Files.lines(Paths.get("file.txt"))) {
         lines.forEach(System.out::println);
    } catch (IOException e) {
         e.printStackTrace();
    }
    ```

7. **From a Range**:
    ```java
    IntStream range = IntStream.range(1, 10); // 1 to 9
    ```

---

### Common Stream Operations

#### 1. **`forEach`**
Used to iterate over each element in the stream.
```java
List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
names.stream().forEach(System.out::println);
```

#### 2. **`map`**
Transforms each element in the stream.
```java
List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
List<Integer> nameLengths = names.stream()
                                            .map(String::length)
                                            .collect(Collectors.toList());
System.out.println(nameLengths); // Output: [5, 3, 7]
```

#### 3. **`filter`**
Filters elements based on a condition.
```java
List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
List<String> filteredNames = names.stream()
                                             .filter(name -> name.startsWith("C"))
                                             .collect(Collectors.toList());
System.out.println(filteredNames); // Output: [Charlie]
```

#### 4. **`limit`**
Limits the number of elements in the stream.
```java
Stream<Integer> numbers = Stream.iterate(1, n -> n + 1).limit(5);
numbers.forEach(System.out::println); // Output: 1, 2, 3, 4, 5
```

#### 5. **`sorted`**
Sorts the elements in natural or custom order.
```java
List<String> names = Arrays.asList("Charlie", "Alice", "Bob");
List<String> sortedNames = names.stream()
                                          .sorted()
                                          .collect(Collectors.toList());
System.out.println(sortedNames); // Output: [Alice, Bob, Charlie]
```

#### 6. **`parallelStream`**
Processes the stream in parallel for better performance.
```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
numbers.parallelStream().forEach(System.out::println);
```

#### 7. **`collect`**
Collects the elements into a collection or other data structure.
```java
List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
Set<String> nameSet = names.stream().collect(Collectors.toSet());
System.out.println(nameSet);
```

#### 8. **`reduce`**
Performs a reduction operation (e.g., sum, product).
```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
int sum = numbers.stream().reduce(0, Integer::sum);
System.out.println(sum); // Output: 15
```

---

### Collectors and Statistics

#### 1. **Joining Strings**
```java
List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
String result = names.stream().collect(Collectors.joining(", "));
System.out.println(result); // Output: Alice, Bob, Charlie
```

#### 2. **Grouping**
```java
List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");
Map<Integer, List<String>> groupedByLength = names.stream()
                                                                  .collect(Collectors.groupingBy(String::length));
System.out.println(groupedByLength);
// Output: {3=[Bob], 5=[Alice, David], 7=[Charlie]}
```

#### 3. **Statistics**
```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
IntSummaryStatistics stats = numbers.stream().mapToInt(Integer::intValue).summaryStatistics();
System.out.println("Count: " + stats.getCount());
System.out.println("Sum: " + stats.getSum());
System.out.println("Min: " + stats.getMin());
System.out.println("Max: " + stats.getMax());
System.out.println("Average: " + stats.getAverage());
```

---

### Example: Comprehensive Usage
```java
import java.util.*;
import java.util.stream.*;
import java.util.function.*;

public class StreamExample {
     public static void main(String[] args) {
          List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve");

          // Filter names starting with 'C', map to uppercase, limit to 2, and collect to a list
          List<String> result = names.stream()
                                              .filter(name -> name.startsWith("C"))
                                              .map(String::toUpperCase)
                                              .limit(2)
                                              .collect(Collectors.toList());
          System.out.println(result); // Output: [CHARLIE]

          // Parallel stream example
          names.parallelStream().forEach(System.out::println);

          // Statistics example
          List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
          IntSummaryStatistics stats = numbers.stream().mapToInt(Integer::intValue).summaryStatistics();
          System.out.println("Sum: " + stats.getSum()); // Output: Sum: 15
     }
}
```

---

### Advantages of Streams
1. Simplifies data processing with functional programming.
2. Improves readability and reduces boilerplate code.
3. Enables parallel processing for better performance.
4. Provides a rich set of operations for data manipulation.

Streams are a cornerstone of functional programming in Java, enabling developers to write clean, concise, and efficient code for data processing tasks.

# JAVA-9

## 9. Java Module System (Project Jigsaw)

The Java Module System, introduced in Java 9 as part of Project Jigsaw, is a significant enhancement to the Java platform. It provides a way to modularize applications and the JDK itself, improving scalability, maintainability, and security.

### Key Features:
1. **Encapsulation**: Modules explicitly specify which parts of their code are accessible to other modules.
2. **Dependency Management**: Modules declare their dependencies, ensuring that all required modules are available at runtime.
3. **Reduced Footprint**: Applications can include only the required modules, reducing the size of the runtime.
4. **Improved Security**: By limiting access to internal APIs, the module system enhances security.

---

### Key Concepts:

1. **Module**: A module is a collection of packages and resources with a `module-info.java` file that defines the module's metadata.
2. **`module-info.java`**: This file is the module descriptor, specifying the module's name, dependencies, and exported packages.

---

### Syntax of `module-info.java`:
```java
module moduleName {
    requires dependencyModule; // Declares dependencies
    exports packageName;       // Exports packages
}
```

---

### Example:

#### 1. Creating a Module:
- Directory structure:
  ```
  src/
    com.example.app/
      module-info.java
      com/example/app/Main.java
  ```

- `module-info.java`:
  ```java
  module com.example.app {
      requires java.base; // Implicitly required, can be omitted
      exports com.example.app;
  }
  ```

- `Main.java`:
  ```java
  package com.example.app;

  public class Main {
      public static void main(String[] args) {
          System.out.println("Hello, Java Modules!");
      }
  }
  ```

#### 2. Using Another Module:
- Directory structure:
  ```
  src/
    com.example.app/
      module-info.java
      com/example/app/Main.java
    com.example.util/
      module-info.java
      com/example/util/Utility.java
  ```

- `com.example.util/module-info.java`:
  ```java
  module com.example.util {
      exports com.example.util;
  }
  ```

- `com.example.util/Utility.java`:
  ```java
  package com.example.util;

  public class Utility {
      public static String getMessage() {
          return "Hello from Utility!";
      }
  }
  ```

- `com.example.app/module-info.java`:
  ```java
  module com.example.app {
      requires com.example.util;
  }
  ```

- `com.example.app/Main.java`:
  ```java
  package com.example.app;

  import com.example.util.Utility;

  public class Main {
      public static void main(String[] args) {
          System.out.println(Utility.getMessage());
      }
  }
  ```

---

### Benefits of the Module System:
1. **Better Encapsulation**: Internal implementation details are hidden, reducing the risk of accidental misuse.
2. **Improved Maintainability**: Dependencies are explicitly declared, making it easier to understand and manage them.
3. **Custom Runtime Images**: Tools like `jlink` allow creating custom runtime images containing only the required modules.
4. **Enhanced Performance**: Smaller runtime images and better dependency management can lead to improved performance.

---

### Tools for Modules:
1. **`javac`**: Compile modules.
   ```bash
   javac -d out --module-source-path src $(find src -name "*.java")
   ```
2. **`java`**: Run modules.
   ```bash
   java --module-path out --module com.example.app/com.example.app.Main
   ```
3. **`jlink`**: Create a custom runtime image.
   ```bash
   jlink --module-path $JAVA_HOME/jmods:out --add-modules com.example.app --output custom-runtime
   ```

---

### Use Cases:
1. Modularizing large applications for better maintainability.
2. Creating lightweight applications with custom runtime images.
3. Enhancing security by restricting access to internal APIs.

The Java Module System is a powerful feature that helps developers build scalable, maintainable, and secure applications by modularizing both the JDK and user applications.



## 10. Try-With-Resources

The `try-with-resources` statement, introduced in Java 7, is a feature that simplifies resource management in Java. It ensures that resources such as files, sockets, or database connections are automatically closed after use, reducing the risk of resource leaks.

### Key Features:
1. Automatically closes resources that implement the `AutoCloseable` interface.
2. Eliminates the need for explicit `finally` blocks to close resources.
3. Improves code readability and reduces boilerplate code.

---

### Syntax:
```java
try (ResourceType resource = new ResourceType()) {
    // Use the resource
} catch (ExceptionType e) {
    // Handle exceptions
}
```

---

### Example:
```java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TryWithResourcesExample {
    public static void main(String[] args) {
        // Using try-with-resources to manage a file resource
        try (BufferedReader reader = new BufferedReader(new FileReader("example.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

In this example:
- The `BufferedReader` resource is automatically closed at the end of the `try` block.
- There is no need for a `finally` block to close the resource explicitly.

---

### Multiple Resources:
You can manage multiple resources in a single `try-with-resources` statement by separating them with semicolons (`;`):
```java
try (
    BufferedReader reader = new BufferedReader(new FileReader("example.txt"));
    FileReader fileReader = new FileReader("anotherFile.txt")
) {
    // Use the resources
} catch (IOException e) {
    e.printStackTrace();
}
```

---

### Custom Resources:
To use a custom resource with `try-with-resources`, the resource must implement the `AutoCloseable` interface:
```java
class CustomResource implements AutoCloseable {
    @Override
    public void close() {
        System.out.println("CustomResource closed.");
    }
}

public class CustomResourceExample {
    public static void main(String[] args) {
        try (CustomResource resource = new CustomResource()) {
            System.out.println("Using CustomResource.");
        }
    }
}
```

Output:
```
Using CustomResource.
CustomResource closed.
```

---

### Advantages:
1. **Automatic Resource Management**: Resources are closed automatically, even if an exception occurs.
2. **Reduced Boilerplate Code**: No need for explicit `finally` blocks to close resources.
3. **Improved Readability**: Code is cleaner and easier to understand.

---

### Use Cases:
1. Managing file I/O operations (`FileReader`, `BufferedReader`, etc.).
2. Handling database connections (`Connection`, `Statement`, `ResultSet`).
3. Managing network resources like sockets.

The `try-with-resources` statement is a powerful feature that simplifies resource management and helps prevent resource leaks in Java applications.


## 11. Private Interface Methods

Private interface methods, introduced in Java 9, allow interfaces to have private methods that can be used to share common code between default and static methods within the same interface. This feature enhances code reusability and reduces duplication in interfaces.

### Key Features:
1. **Encapsulation**: Private methods are not accessible outside the interface.
2. **Code Reusability**: Common logic can be extracted into private methods and reused in default and static methods.
3. **Improved Maintainability**: Reduces code duplication and makes interfaces easier to maintain.

---

### Syntax:
```java
public interface MyInterface {
    // Default method
    default void defaultMethod() {
        commonLogic();
    }

    // Static method
    static void staticMethod() {
        commonLogic();
    }

    // Private method
    private void commonLogic() {
        System.out.println("Common logic executed.");
    }
}
```

---

### Example:
```java
public interface Calculator {
    // Default method
    default int add(int a, int b) {
        return calculate(a, b, "+");
    }

    // Default method
    default int subtract(int a, int b) {
        return calculate(a, b, "-");
    }

    // Private method
    private int calculate(int a, int b, String operation) {
        switch (operation) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            default:
                throw new IllegalArgumentException("Invalid operation");
        }
    }
}

public class CalculatorExample implements Calculator {
    public static void main(String[] args) {
        Calculator calculator = new CalculatorExample();
        System.out.println("Addition: " + calculator.add(5, 3));       // Output: Addition: 8
        System.out.println("Subtraction: " + calculator.subtract(5, 3)); // Output: Subtraction: 2
    }
}
```

In this example:
- The `calculate` method is private and contains the common logic for addition and subtraction.
- The `add` and `subtract` methods reuse the `calculate` method, reducing code duplication.

---

### Rules for Private Methods in Interfaces:
1. Private methods can only be accessed within the interface.
2. They cannot be abstract, default, or static.
3. They can be used by default and static methods in the same interface.

---

### Use Cases:
1. Sharing common logic between multiple default or static methods in an interface.
2. Encapsulating helper methods within an interface to improve code organization.

Private interface methods provide a way to write cleaner and more maintainable code by enabling code reuse within interfaces.



# JAVA-10


## 12. Local Variable Type Inference

Local Variable Type Inference, introduced in Java 10, allows the use of the `var` keyword to declare local variables. The compiler infers the type of the variable based on the value assigned to it. This feature simplifies code by reducing verbosity while maintaining type safety.

### Key Features:
1. **Type Inference**: The compiler determines the type of the variable at compile time.
2. **Improved Readability**: Reduces boilerplate code by eliminating redundant type declarations.
3. **Type Safety**: The inferred type is still strongly typed, ensuring type safety.

---

### Syntax:
```java
var variableName = value;
```

---

### Example:
```java
import java.util.List;

public class LocalVariableTypeInferenceExample {
    public static void main(String[] args) {
        // Using var for local variables
        var message = "Hello, Java 10!";
        System.out.println(message);

        // Using var with collections
        var numbers = List.of(1, 2, 3, 4, 5);
        for (var number : numbers) {
            System.out.println(number);
        }

        // Using var with a loop
        for (var i = 0; i < 5; i++) {
            System.out.println("Index: " + i);
        }
    }
}
```

In this example:
- The type of `message` is inferred as `String`.
- The type of `numbers` is inferred as `List<Integer>`.
- The type of `i` in the loop is inferred as `int`.

---

### Rules and Limitations:
1. **Local Scope Only**: `var` can only be used for local variables, including loop variables and lambda expressions.
2. **Cannot Be Null**: The initializer must provide enough information for the compiler to infer the type. For example:
   ```java
   var value = null; // Compilation error
   ```
3. **Cannot Be Used Without Initialization**:
   ```java
   var uninitialized; // Compilation error
   ```
4. **Not for Method Parameters or Fields**: `var` cannot be used for method parameters, return types, or class fields.
5. **Readable Code**: Avoid using `var` when the inferred type is not obvious, as it can reduce code readability.

---

### Advantages:
1. **Reduced Boilerplate**: Simplifies code by removing redundant type declarations.
2. **Improved Maintainability**: Makes code easier to refactor, as the type is inferred automatically.
3. **Type Safety**: Ensures that the inferred type is still strongly typed.

---

### Use Cases:
1. **Working with Generics**:
   ```java
   var map = Map.of(1, "One", 2, "Two");
   ```
2. **Iterating Over Collections**:
   ```java
   for (var entry : map.entrySet()) {
       System.out.println(entry.getKey() + ": " + entry.getValue());
   }
   ```
3. **Simplifying Complex Declarations**:
   ```java
   var stream = List.of(1, 2, 3).stream().filter(n -> n > 1);
   ```

---

### Best Practices:
1. Use `var` when the type is obvious from the context.
2. Avoid using `var` for complex or ambiguous types to maintain code readability.
3. Use meaningful variable names to compensate for the lack of explicit type information.

Local Variable Type Inference is a powerful feature that enhances code readability and reduces verbosity while preserving Java's strong type system.


# JAVA-11

## 13. Local Variable Type in Lambda Expressions

Java 11 introduced the ability to use `var` in lambda expressions for local variable type inference. This feature allows developers to declare the type of lambda parameters using the `var` keyword, improving consistency and enabling annotations on lambda parameters.

### Key Features:
1. **Type Inference**: The compiler infers the type of lambda parameters when `var` is used.
2. **Annotations**: Enables the use of annotations on lambda parameters, which was not possible with implicit type inference.
3. **Consistency**: Provides a uniform way to declare lambda parameters.

---

### Syntax:
```java
(var parameter1, var parameter2) -> expression
```

---

### Example:
```java
import java.util.List;

public class LambdaVarExample {
    public static void main(String[] args) {
        List<String> names = List.of("Alice", "Bob", "Charlie");

        // Using var in lambda expressions
        names.stream()
             .map((var name) -> name.toUpperCase())
             .forEach(System.out::println);
    }
}
```

In this example:
- The `var` keyword is used to declare the type of the `name` parameter in the lambda expression.
- The compiler infers the type of `name` as `String`.

---

### Using Annotations with `var`:
```java
import java.util.List;

public class LambdaVarWithAnnotations {
    public static void main(String[] args) {
        List<String> names = List.of("Alice", "Bob", "Charlie");

        // Using var with annotations in lambda expressions
        names.stream()
             .map((@Deprecated var name) -> name.toUpperCase())
             .forEach(System.out::println);
    }
}
```

In this example:
- The `@Deprecated` annotation is applied to the `name` parameter using `var`.
- This was not possible with implicit type inference in lambda expressions.

---

### Rules and Limitations:
1. **Explicit Use**: If `var` is used for one parameter in a lambda expression, it must be used for all parameters.
   ```java
   (var a, var b) -> a + b; // Valid
   (var a, b) -> a + b;     // Compilation error
   ```
2. **Annotations**: Annotations on lambda parameters require the use of `var`.
3. **No Mixing**: You cannot mix `var` with explicitly typed or implicitly typed parameters.

---

### Advantages:
1. **Annotations Support**: Enables annotations on lambda parameters, improving flexibility.
2. **Consistency**: Provides a uniform way to declare lambda parameters, similar to local variable declarations.
3. **Improved Readability**: Makes the type of lambda parameters explicit when needed.

---

### Use Cases:
1. **Adding Annotations**:
   ```java
   (var x, @Nullable var y) -> x + y;
   ```
2. **Improving Code Consistency**:
   ```java
   (var a, var b) -> a * b;
   ```

---

### Best Practices:
1. Use `var` in lambda expressions when annotations are required or when it improves code clarity.
2. Avoid using `var` if it reduces readability or makes the code ambiguous.

The ability to use `var` in lambda expressions enhances the flexibility and consistency of lambda parameter declarations, making it a valuable addition to Java's type inference capabilities.



# JAVA-12

## 14. String Indent and Transform

Java 12 introduced two new methods for the `String` class: `indent` and `transform`. These methods enhance the functionality of strings, making it easier to manipulate and transform them.

---

### 1. `String.indent(int n)`

The `indent` method adjusts the indentation of each line in a string. It can add or remove leading spaces based on the value of `n`.

#### Syntax:
```java
String.indent(int n)
```

#### Key Features:
- Adds `n` spaces to the beginning of each line if `n` is positive.
- Removes up to `n` leading spaces from each line if `n` is negative.
- Preserves blank lines by replacing them with a line separator.

#### Example:
```java
public class StringIndentExample {
    public static void main(String[] args) {
        String text = "Hello\nWorld\nJava 12";

        // Adding indentation
        String indentedText = text.indent(4);
        System.out.println("Indented Text:\n" + indentedText);

        // Removing indentation
        String unindentedText = indentedText.indent(-2);
        System.out.println("Unindented Text:\n" + unindentedText);
    }
}
```

#### Output:
```
Indented Text:
    Hello
    World
    Java 12

Unindented Text:
  Hello
  World
  Java 12
```

---

### 2. `String.transform(Function<String, R> f)`

The `transform` method applies a function to the string and returns the result. It simplifies chaining operations on strings.

#### Syntax:
```java
<R> R transform(Function<? super String, ? extends R> f)
```

#### Key Features:
- Accepts a function that takes a string as input and produces a result.
- Can be used to apply multiple transformations in a concise manner.

#### Example:
```java
import java.util.Locale;

public class StringTransformExample {
    public static void main(String[] args) {
        String text = "hello";

        // Transforming the string
        String result = text.transform(s -> s.toUpperCase(Locale.ROOT))
                            .transform(s -> s + " WORLD");
        System.out.println(result); // Output: HELLO WORLD
    }
}
```

---

### Use Cases:
1. **`indent`**:
   - Formatting multi-line strings for better readability.
   - Adjusting indentation levels in generated code or logs.

2. **`transform`**:
   - Applying multiple transformations to a string in a functional style.
   - Simplifying string manipulation by avoiding intermediate variables.

---

### Advantages:
- **`indent`**: Simplifies indentation management for multi-line strings.
- **`transform`**: Enables functional programming with strings, improving code readability and reducing boilerplate.

These methods make string manipulation more powerful and concise, aligning with modern programming practices.



## 15. Explain Files Mismatch

### Question:
What is a `FilesMismatchException` in Java, and how can it be used?

### Answer:
The `Files.mismatch` method, introduced in Java 12, is a utility method in the `java.nio.file.Files` class that compares the contents of two files and identifies the first byte position where they differ. If the files are identical, it returns `-1`.

This method is useful for efficiently comparing large files without loading their entire contents into memory.

---

### Syntax:
```java
public static long mismatch(Path path1, Path path2) throws IOException
```

---

### Parameters:
- `path1`: The path to the first file.
- `path2`: The path to the second file.

---

### Returns:
- The position of the first mismatched byte, or `-1` if the files are identical.

---

### Example:
```java
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;

public class FilesMismatchExample {
    public static void main(String[] args) {
        Path file1 = Paths.get("file1.txt");
        Path file2 = Paths.get("file2.txt");

        try {
            long mismatchPosition = Files.mismatch(file1, file2);

            if (mismatchPosition == -1) {
                System.out.println("The files are identical.");
            } else {
                System.out.println("The files differ at byte position: " + mismatchPosition);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

---

### Output:
- If the files are identical:
  ```
  The files are identical.
  ```
- If the files differ:
  ```
  The files differ at byte position: 1024
  ```

---

### Use Cases:
1. **File Comparison**:
   - Quickly determine if two files are identical.
   - Identify the exact position of the first difference for debugging or validation purposes.

2. **Data Integrity**:
   - Verify the integrity of files after copying or downloading.
   - Compare files in backup systems to detect changes.

---

### Advantages:
- **Efficiency**: Compares files byte-by-byte without loading them entirely into memory.
- **Simplicity**: Provides a straightforward API for file comparison.
- **Scalability**: Suitable for comparing large files.

The `Files.mismatch` method is a powerful addition to the `java.nio.file` package, making file comparison tasks more efficient and easier to implement.


# JAVA-13

## 16. Explain Text Blocks

### Question:
What are Text Blocks in Java, and how are they used?

### Answer:
Text Blocks, introduced in Java 13 as a preview feature and finalized in Java 15, provide a new way to represent multi-line strings in Java. They simplify the creation of strings that span multiple lines, such as JSON, XML, SQL, or HTML, by eliminating the need for explicit line breaks and escape sequences.

---

### Key Features:
1. **Multi-Line Strings**: Text Blocks allow strings to span multiple lines without requiring concatenation or escape characters.
2. **Improved Readability**: The syntax is cleaner and more readable, especially for structured data.
3. **Automatic Formatting**: Leading and trailing whitespace is handled automatically, and indentation can be adjusted.

---

### Syntax:
```java
String textBlock = """
    Line 1
    Line 2
    Line 3
    """;
```

---

### Example:
```java
public class TextBlockExample {
    public static void main(String[] args) {
        String json = """
            {
                "name": "Alice",
                "age": 30,
                "city": "New York"
            }
            """;

        System.out.println(json);
    }
}
```

#### Output:
```
{
    "name": "Alice",
    "age": 30,
    "city": "New York"
}
```

---

### Key Methods:
1. **`stripIndent()`**: Removes incidental whitespace from each line.
   ```java
   String text = """
       Line 1
       Line 2
       """.stripIndent();
   System.out.println(text);
   ```
   Output:
   ```
   Line 1
   Line 2
   ```

2. **`translateEscapes()`**: Converts escape sequences into their corresponding characters.
   ```java
   String text = """
       Line 1\nLine 2
       """.translateEscapes();
   System.out.println(text);
   ```
   Output:
   ```
   Line 1
   Line 2
   ```

---

### Advantages:
1. **Cleaner Syntax**: Reduces boilerplate code for multi-line strings.
2. **Improved Maintainability**: Easier to read and modify structured data.
3. **Automatic Formatting**: Handles indentation and whitespace automatically.

---

### Use Cases:
1. **Structured Data**: Representing JSON, XML, SQL, or HTML in a readable format.
2. **Multi-Line Messages**: Creating user-facing messages or logs that span multiple lines.
3. **Code Generation**: Generating code snippets or templates dynamically.

Text Blocks are a powerful feature that simplifies working with multi-line strings, making code more readable and maintainable.


# JAVA-14

## 17. Explain Yield Keyword

### Question:
What is the `yield` keyword in Java, and how is it used?

### Answer:
The `yield` keyword, introduced in Java 14, is used within a `switch` expression to return a value. It provides a way to specify the result of a `case` in a `switch` expression, making the code more concise and expressive.

---

### Key Features:
1. **Return Values in Switch Expressions**: `yield` is used to produce a value for a `switch` expression.
2. **Improved Readability**: Simplifies the syntax for returning values from `switch` cases.
3. **Compatibility**: Works seamlessly with both traditional and enhanced `switch` expressions.

---

### Syntax:
```java
String result = switch (value) {
    case 1 -> "One";
    case 2 -> {
        yield "Two";
    }
    default -> "Other";
};
```

---

### Example:
```java
public class YieldExample {
    public static void main(String[] args) {
        int day = 3;

        String dayType = switch (day) {
            case 1, 7 -> "Weekend";
            case 2, 3, 4, 5, 6 -> {
                yield "Weekday";
            }
            default -> "Invalid day";
        };

        System.out.println("Day type: " + dayType);
    }
}
```

#### Output:
```
Day type: Weekday
```

---

### Key Points:
1. **Block Syntax**: `yield` is required when using a block (`{}`) in a `switch` case to return a value.
2. **Enhanced Switch**: Works with the enhanced `switch` syntax introduced in Java 12.

---

### Advantages:
1. **Concise Code**: Reduces boilerplate code in `switch` expressions.
2. **Improved Readability**: Makes the intent of returning a value explicit.
3. **Flexibility**: Allows complex logic within `switch` cases using blocks.

---

### Use Cases:
1. **Returning Values**: Simplifies returning values from `switch` cases in expressions.
2. **Complex Logic**: Enables multi-line logic within `switch` cases while still returning a value.

The `yield` keyword enhances the functionality of `switch` expressions, making them more powerful and expressive.


# JAVA-15

## 18. Garbage Collector Updates

### Question:
What are the recent updates to Garbage Collectors in Java, and how do they improve performance?

### Answer:
Java has introduced several updates and new Garbage Collectors (GC) in recent versions to improve application performance, reduce latency, and enhance scalability. These updates include the introduction of new GCs, enhancements to existing ones, and the deprecation of older GCs.

---

### Key Updates:

#### 1. **G1 Garbage Collector Enhancements (Java 9+)**
- **Improved Throughput**: G1 GC received optimizations to reduce pause times and improve overall throughput.
- **Parallel Full GC**: Starting from Java 9, G1 GC supports parallel processing during full GC, reducing the time taken for full GC cycles.
- **Default GC**: G1 became the default garbage collector in Java 9, replacing the Parallel GC.

---

#### 2. **Z Garbage Collector (ZGC)**
- **Introduced in Java 11**: ZGC is a low-latency garbage collector designed for applications requiring very short pause times.
- **Key Features**:
    - Pause times are typically less than 10ms, even for large heaps (up to terabytes).
    - Performs most of its work concurrently with the application threads.
    - Supports very large heaps (up to 16TB).
- **Production-Ready**: ZGC became production-ready in Java 15.

---

#### 3. **Shenandoah Garbage Collector**
- **Introduced in Java 12**: Shenandoah GC is another low-latency garbage collector designed to minimize pause times.
- **Key Features**:
    - Reduces pause times by performing concurrent compaction.
    - Suitable for applications with medium to large heaps.
- **Production-Ready**: Shenandoah became production-ready in Java 15.

---

#### 4. **Removal of CMS (Concurrent Mark-Sweep) GC**
- **Deprecated in Java 9**: The CMS GC was deprecated due to its complexity and the availability of better alternatives like G1, ZGC, and Shenandoah.
- **Removed in Java 14**: CMS was officially removed, encouraging users to migrate to newer GCs.

---

#### 5. **Epsilon Garbage Collector**
- **Introduced in Java 11**: Epsilon is a no-op garbage collector designed for testing and benchmarking purposes.
- **Key Features**:
    - Does not perform any memory reclamation.
    - Useful for applications where GC is not required or for testing GC overhead.

---

### Example: Switching Garbage Collectors
You can specify the garbage collector to use with the `-XX:+Use` JVM options. For example:
- **G1 GC** (default):
    ```bash
    java -XX:+UseG1GC MyApp
    ```
- **ZGC**:
    ```bash
    java -XX:+UseZGC MyApp
    ```
- **Shenandoah GC**:
    ```bash
    java -XX:+UseShenandoahGC MyApp
    ```

---

### Advantages of Recent GC Updates:
1. **Reduced Latency**: GCs like ZGC and Shenandoah minimize pause times, making them ideal for low-latency applications.
2. **Scalability**: Support for very large heaps (up to terabytes) ensures scalability for modern applications.
3. **Improved Performance**: Enhancements to G1 and other GCs improve throughput and reduce GC overhead.
4. **Flexibility**: Developers can choose a GC that best suits their application's requirements.

---

### Use Cases:
1. **Low-Latency Applications**: Use ZGC or Shenandoah for applications requiring minimal pause times, such as financial systems or real-time analytics.
2. **Large Heap Applications**: Use ZGC for applications with very large heaps, such as big data processing.
3. **General Purpose**: Use G1 GC for a balanced approach to throughput and latency.

The recent updates to Garbage Collectors in Java provide developers with powerful tools to optimize application performance and scalability, catering to a wide range of use cases.


# JAVA-16

## 19. Pattern Matching for `instanceof`

### Question:
What is Pattern Matching for `instanceof` in Java, and how does it simplify code?

### Answer:
Pattern Matching for `instanceof`, introduced in Java 16, simplifies the common pattern of using the `instanceof` operator followed by a type cast. It allows developers to test if an object is of a specific type and, if true, automatically cast it to that type in a single step.

---

### Key Features:
1. **Simplified Syntax**: Eliminates the need for explicit type casting after an `instanceof` check.
2. **Improved Readability**: Reduces boilerplate code and makes the intent clearer.
3. **Type Safety**: Ensures that the cast is only performed if the `instanceof` check passes.

---

### Syntax:
```java
if (object instanceof Type variableName) {
    // variableName is automatically cast to Type
}
```

---

### Example:
```java
public class PatternMatchingExample {
    public static void main(String[] args) {
        Object obj = "Hello, Java 16!";

        // Traditional instanceof with explicit casting
        if (obj instanceof String) {
            String str = (String) obj;
            System.out.println("Length: " + str.length());
        }

        // Pattern Matching for instanceof
        if (obj instanceof String str) {
            System.out.println("Length: " + str.length());
        }
    }
}
```

#### Output:
```
Length: 14
Length: 14
```

---

### Key Points:
1. **Scope of the Variable**: The variable declared in the `instanceof` pattern is only accessible within the `if` block.
2. **Short-Circuiting**: The variable is not accessible if the `instanceof` check fails.
3. **Combining with Logical Operators**:
   ```java
   if (obj instanceof String str && str.length() > 5) {
       System.out.println("String is long enough: " + str);
   }
   ```

---

### Advantages:
1. **Reduced Boilerplate**: Combines type checking and casting into a single operation.
2. **Improved Readability**: Makes the code more concise and easier to understand.
3. **Type Safety**: Ensures that the variable is only used when the `instanceof` check passes.

---

### Use Cases:
1. **Type-Specific Logic**: Simplifies code that performs operations based on the runtime type of an object.
2. **Polymorphism**: Enhances readability when working with polymorphic objects.
3. **Data Processing**: Useful in scenarios where objects of different types need to be processed differently.

Pattern Matching for `instanceof` is a powerful feature that streamlines type checking and casting, making Java code more concise and expressive.



## 20. Explain Records with Example

### Question:
What are Records in Java, and how are they used?

### Answer:
Records, introduced in Java 14 as a preview feature and finalized in Java 16, are a special kind of class in Java designed to model immutable data. They provide a concise way to declare classes that are primarily used to store data without requiring boilerplate code for constructors, getters, `equals`, `hashCode`, and `toString` methods.

---

### Key Features:
1. **Immutable Data**: Records are immutable by default, meaning their fields cannot be modified after the object is created.
2. **Concise Syntax**: Automatically generates boilerplate code such as constructors, getters, `equals`, `hashCode`, and `toString`.
3. **Compact Representation**: Ideal for modeling simple data-carrying classes.

---

### Syntax:
```java
public record RecordName(Type field1, Type field2, ...) {}
```

---

### Example:
```java
public record Person(String name, int age) {}

public class RecordExample {
    public static void main(String[] args) {
        // Creating a record instance
        Person person = new Person("Alice", 30);

        // Accessing fields
        System.out.println("Name: " + person.name());
        System.out.println("Age: " + person.age());

        // Using toString
        System.out.println(person);

        // Comparing records
        Person anotherPerson = new Person("Alice", 30);
        System.out.println("Are they equal? " + person.equals(anotherPerson));
    }
}
```

#### Output:
```
Name: Alice
Age: 30
Person[name=Alice, age=30]
Are they equal? true
```

---

### Key Points:
1. **Immutable Fields**: Fields in a record are final and cannot be reassigned.
2. **Generated Methods**:
   - A canonical constructor that initializes all fields.
   - Getters for each field (named after the fields).
   - `equals`, `hashCode`, and `toString` methods.
3. **Custom Methods**: You can add custom methods to a record, but you cannot override the generated methods like `equals` or `hashCode`.

---

### Customizing Records:
You can define additional methods or override the canonical constructor:
```java
public record Person(String name, int age) {
    // Custom method
    public String greet() {
        return "Hello, " + name + "!";
    }

    // Custom constructor
    public Person {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
    }
}
```

---

### Advantages:
1. **Reduced Boilerplate**: Simplifies the creation of data classes by eliminating repetitive code.
2. **Immutability**: Promotes immutability, which is beneficial for thread safety and functional programming.
3. **Readability**: Makes the intent of the class clear, as records are explicitly designed for data storage.

---

### Use Cases:
1. **Data Transfer Objects (DTOs)**: Representing data that is transferred between layers or systems.
2. **Immutable Value Objects**: Modeling entities with fixed values, such as coordinates or configurations.
3. **Lightweight Data Structures**: Simplifying the creation of small, immutable data structures.

Records are a powerful addition to Java, enabling developers to write cleaner and more concise code for data-centric classes.


# JAVA-17

## 21. Explain Sealed Class

### Question:
What are Sealed Classes in Java, and how are they used?

### Answer:
Sealed Classes, introduced in Java 17, provide a way to restrict which classes or interfaces can extend or implement a given class or interface. This feature enhances control over inheritance, making it easier to design and maintain class hierarchies.

---

### Key Features:
1. **Controlled Inheritance**: Allows the class designer to specify a limited set of subclasses or implementations.
2. **Improved Maintainability**: Makes class hierarchies more predictable and easier to understand.
3. **Enhanced Security**: Prevents unintended extensions or implementations.

---

### Syntax:
A sealed class or interface is declared using the `sealed` modifier, and its permitted subclasses or implementations are specified using the `permits` clause.

```java
public sealed class ClassName permits Subclass1, Subclass2 {
    // Class body
}
```

---

### Example:
```java
// Sealed class
public sealed class Shape permits Circle, Rectangle {}

// Permitted subclasses
public final class Circle extends Shape {
    double radius;
    public Circle(double radius) {
        this.radius = radius;
    }
}

public final class Rectangle extends Shape {
    double length, width;
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }
}
```

In this example:
- The `Shape` class is sealed and permits only `Circle` and `Rectangle` to extend it.
- Both `Circle` and `Rectangle` are `final`, meaning they cannot be further extended.

---

### Rules for Sealed Classes:
1. **Permitted Subclasses**: All permitted subclasses must be explicitly declared in the `permits` clause.
2. **Subclass Modifiers**: Permitted subclasses must be one of the following:
   - `final`: Cannot be extended further.
   - `sealed`: Can restrict further inheritance.
   - `non-sealed`: Allows unrestricted inheritance.
3. **Same Module or Package**: Permitted subclasses must be in the same module or package as the sealed class.

---

### Example with `non-sealed`:
```java
public sealed class Animal permits Dog, Cat {}

public final class Dog extends Animal {}

public non-sealed class Cat extends Animal {}
```

In this example:
- `Dog` is `final` and cannot be extended.
- `Cat` is `non-sealed`, allowing unrestricted inheritance.

---

### Advantages:
1. **Controlled Extensibility**: Ensures that only specific classes can extend or implement a sealed class or interface.
2. **Improved Design**: Makes class hierarchies more predictable and easier to maintain.
3. **Enhanced Security**: Prevents unauthorized or unintended extensions.

---

### Use Cases:
1. **Domain Modeling**: Representing a fixed set of related types, such as shapes, animals, or commands.
2. **API Design**: Restricting the extensibility of APIs to ensure consistency and prevent misuse.
3. **Exhaustive Pattern Matching**: Works seamlessly with `switch` expressions to ensure all cases are handled.

Sealed Classes are a powerful feature that enhances control over inheritance, making Java class hierarchies more robust and maintainable.


# JAVA-21

## 22. Explain Virtual Threads with Example

### Question:
What are Virtual Threads in Java, and how do they improve concurrency?

### Answer:
Virtual Threads, introduced in Java 21, are lightweight threads managed by the Java Virtual Machine (JVM). They are part of Project Loom and aim to simplify concurrent programming by enabling the creation of thousands (or even millions) of threads without significant resource overhead.

---

### Key Features:
1. **Lightweight**: Virtual threads are much lighter than platform threads, as they are not tied to OS threads.
2. **Scalable Concurrency**: Allows applications to handle a large number of concurrent tasks efficiently.
3. **Simplified Code**: Enables writing concurrent code in a synchronous style without sacrificing performance.
4. **Compatibility**: Works seamlessly with existing Java APIs and libraries.

---

### Syntax:
Virtual threads can be created using the `Thread.ofVirtual()` factory methods.

```java
Thread.startVirtualThread(() -> {
    // Task to execute
});
```

---

### Example:
```java
import java.util.concurrent.Executors;

public class VirtualThreadsExample {
    public static void main(String[] args) {
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 1; i <= 10; i++) {
                int taskId = i;
                executor.submit(() -> {
                    System.out.println("Task " + taskId + " is running on thread: " + Thread.currentThread());
                    try {
                        Thread.sleep(1000); // Simulate work
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                });
            }
        }
    }
}
```

#### Output:
```
Task 1 is running on thread: VirtualThread[#1]/runnable
Task 2 is running on thread: VirtualThread[#2]/runnable
...
Task 10 is running on thread: VirtualThread[#10]/runnable
```

In this example:
- A virtual thread is created for each task using a `VirtualThreadPerTaskExecutor`.
- The tasks run concurrently without the overhead of creating platform threads.

---

### Advantages:
1. **High Scalability**: Virtual threads enable handling a large number of concurrent tasks efficiently.
2. **Simplified Concurrency**: Allows developers to write blocking code without worrying about performance bottlenecks.
3. **Resource Efficiency**: Virtual threads consume fewer system resources compared to platform threads.
4. **Improved Debugging**: Virtual threads integrate with existing debugging tools, making it easier to diagnose issues.

---

### Use Cases:
1. **I/O-Intensive Applications**: Ideal for applications that perform a large number of blocking I/O operations, such as web servers or database clients.
2. **Concurrent Workflows**: Simplifies the implementation of workflows that involve multiple concurrent tasks.
3. **Microservices**: Enhances the scalability of microservices by enabling efficient handling of concurrent requests.

---

### Best Practices:
1. Use virtual threads for tasks that involve blocking operations, such as I/O or waiting for external resources.
2. Avoid using virtual threads for CPU-bound tasks, as they do not provide performance benefits in such scenarios.
3. Leverage structured concurrency to manage virtual threads effectively.

Virtual Threads revolutionize concurrency in Java by providing a lightweight and scalable alternative to traditional threads, making it easier to build high-performance concurrent applications.


## 23. Explain Sequenced Collections with Example

### Question:
What are Sequenced Collections in Java, and how are they used?

### Answer:
Sequenced Collections, introduced in Java 21, are a new family of collection interfaces that provide a consistent way to handle collections with a defined encounter order. They extend the existing `Collection` framework and include `SequencedSet`, `SequencedMap`, and `SequencedCollection`.

---

### Key Features:
1. **Defined Order**: Sequenced collections maintain a predictable order of elements, either insertion order or some other defined order.
2. **Bidirectional Access**: Provide methods to access elements from both ends of the collection.
3. **Enhanced Consistency**: Unifies the behavior of ordered collections like `List`, `LinkedHashSet`, and `LinkedHashMap`.

---

### Key Interfaces:
1. **`SequencedCollection<E>`**: Extends `Collection<E>` and provides methods for accessing the first and last elements.
2. **`SequencedSet<E>`**: Extends `Set<E>` and `SequencedCollection<E>`, ensuring unique elements with a defined order.
3. **`SequencedMap<K, V>`**: Extends `Map<K, V>` and provides methods for accessing entries in a defined order.

---

### Example: Using `SequencedSet`
```java
import java.util.SequencedSet;
import java.util.LinkedHashSet;

public class SequencedSetExample {
    public static void main(String[] args) {
        SequencedSet<String> sequencedSet = new LinkedHashSet<>();

        // Adding elements
        sequencedSet.add("Alice");
        sequencedSet.add("Bob");
        sequencedSet.add("Charlie");

        // Accessing elements
        System.out.println("First: " + sequencedSet.getFirst()); // Output: Alice
        System.out.println("Last: " + sequencedSet.getLast());   // Output: Charlie

        // Removing elements
        sequencedSet.removeFirst();
        System.out.println("After removing first: " + sequencedSet);

        sequencedSet.removeLast();
        System.out.println("After removing last: " + sequencedSet);
    }
}
```

#### Output:
```
First: Alice
Last: Charlie
After removing first: [Bob, Charlie]
After removing last: [Bob]
```

---

### Example: Using `SequencedMap`
```java
import java.util.SequencedMap;
import java.util.LinkedHashMap;

public class SequencedMapExample {
    public static void main(String[] args) {
        SequencedMap<Integer, String> sequencedMap = new LinkedHashMap<>();

        // Adding entries
        sequencedMap.put(1, "Alice");
        sequencedMap.put(2, "Bob");
        sequencedMap.put(3, "Charlie");

        // Accessing entries
        System.out.println("First Entry: " + sequencedMap.getFirstEntry()); // Output: 1=Alice
        System.out.println("Last Entry: " + sequencedMap.getLastEntry());   // Output: 3=Charlie

        // Removing entries
        sequencedMap.removeFirstEntry();
        System.out.println("After removing first: " + sequencedMap);

        sequencedMap.removeLastEntry();
        System.out.println("After removing last: " + sequencedMap);
    }
}
```

#### Output:
```
First Entry: 1=Alice
Last Entry: 3=Charlie
After removing first: {2=Bob, 3=Charlie}
After removing last: {2=Bob}
```

---

### Advantages:
1. **Unified API**: Provides a consistent way to work with ordered collections.
2. **Bidirectional Access**: Simplifies operations like retrieving or removing elements from both ends.
3. **Enhanced Flexibility**: Works seamlessly with existing ordered collections like `LinkedHashSet` and `LinkedHashMap`.

---

### Use Cases:
1. **Ordered Data Processing**: Ideal for scenarios where the order of elements is important, such as processing tasks in insertion order.
2. **Deque-Like Behavior**: Simplifies deque-like operations on sets and maps.
3. **Consistent APIs**: Reduces the need for custom implementations to handle ordered collections.

Sequenced Collections enhance the Java Collections Framework by providing a unified and consistent API for working with ordered collections, making it easier to handle data with a defined encounter order.



## 24. Explain String Templates with Example

### Question:
What are String Templates in Java, and how are they used?

### Answer:
String Templates, introduced as a preview feature in Java 21, provide a new way to create and format strings by embedding expressions directly within string literals. This feature simplifies string interpolation and improves readability by eliminating the need for concatenation or external formatting methods.

---

### Key Features:
1. **Embedded Expressions**: Allows embedding expressions directly within string literals using placeholders.
2. **Improved Readability**: Simplifies the creation of dynamic strings by reducing boilerplate code.
3. **Type Safety**: Ensures that embedded expressions are evaluated safely at compile time.

---

### Syntax:
String Templates use the `STR.` prefix and placeholders enclosed in `${}` for embedding expressions.

```java
String template = STR."Hello, ${name}! You have ${messages.size()} new messages.";
```

---

### Example:
```java
import java.util.List;

public class StringTemplatesExample {
    public static void main(String[] args) {
        String name = "Alice";
        List<String> messages = List.of("Message 1", "Message 2", "Message 3");

        // Using String Templates
        String greeting = STR."Hello, ${name}! You have ${messages.size()} new messages.";
        System.out.println(greeting);
    }
}
```

#### Output:
```
Hello, Alice! You have 3 new messages.
```

---

### Key Points:
1. **Placeholders**: Expressions inside `${}` are evaluated and replaced with their values.
2. **Compile-Time Safety**: Ensures that the embedded expressions are valid and type-safe.
3. **Integration with Existing APIs**: Works seamlessly with existing Java APIs and libraries.

---

### Advanced Example:
```java
public class AdvancedStringTemplatesExample {
    public static void main(String[] args) {
        int a = 5;
        int b = 10;

        // Using String Templates for calculations
        String result = STR."The sum of ${a} and ${b} is ${a + b}.";
        System.out.println(result);
    }
}
```

#### Output:
```
The sum of 5 and 10 is 15.
```

---

### Advantages:
1. **Simplified String Interpolation**: Reduces the need for concatenation or `String.format`.
2. **Improved Readability**: Makes dynamic strings easier to read and maintain.
3. **Type Safety**: Ensures that embedded expressions are evaluated correctly at compile time.

---

### Use Cases:
1. **Dynamic Messages**: Creating user-facing messages with embedded variables.
2. **Logging**: Simplifying the creation of log messages with dynamic content.
3. **Templates**: Generating formatted strings for reports, emails, or other outputs.

String Templates are a powerful addition to Java, making it easier to create and manage dynamic strings while improving code readability and maintainability.



## 25. Explain Record Patterns with Example

### Question:
What are Record Patterns in Java, and how are they used?

### Answer:
Record Patterns, introduced as a preview feature in Java 21, allow developers to deconstruct record objects into their components directly within pattern matching constructs. This feature simplifies working with records by enabling concise and readable extraction of their fields.

---

### Key Features:
1. **Deconstruction**: Automatically extracts the components of a record into variables.
2. **Pattern Matching**: Works seamlessly with `switch` expressions, `if` statements, and enhanced `for` loops.
3. **Improved Readability**: Reduces boilerplate code when working with records.

---

### Syntax:
```java
if (object instanceof RecordName(Type1 field1, Type2 field2)) {
    // Use field1 and field2
}
```

---

### Example:
```java
public record Point(int x, int y) {}

public class RecordPatternExample {
    public static void main(String[] args) {
        Object obj = new Point(3, 4);

        // Using Record Patterns in an if statement
        if (obj instanceof Point(int x, int y)) {
            System.out.println("Point coordinates: x = " + x + ", y = " + y);
        }
    }
}
```

#### Output:
```
Point coordinates: x = 3, y = 4
```

---

### Example with `switch`:
```java
public record Shape(String type, double size) {}

public class RecordPatternSwitchExample {
    public static void main(String[] args) {
        Shape shape = new Shape("Circle", 5.0);

        String description = switch (shape) {
            case Shape("Circle", double radius) -> "A circle with radius " + radius;
            case Shape("Square", double side) -> "A square with side " + side;
            default -> "Unknown shape";
        };

        System.out.println(description);
    }
}
```

#### Output:
```
A circle with radius 5.0
```

---

### Key Points:
1. **Deconstruction in Place**: Record patterns automatically extract fields into variables, eliminating the need for explicit getters.
2. **Combining with Other Patterns**: Record patterns can be combined with other patterns, such as type patterns or nested patterns.
3. **Exhaustiveness**: Works well with `switch` expressions to ensure all cases are handled.

---

### Advanced Example with Nested Patterns:
```java
public record Rectangle(Point topLeft, Point bottomRight) {}

public class NestedRecordPatternExample {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(new Point(1, 2), new Point(3, 4));

        if (rectangle instanceof Rectangle(Point(int x1, int y1), Point(int x2, int y2))) {
            System.out.println("Rectangle corners: (" + x1 + ", " + y1 + ") and (" + x2 + ", " + y2 + ")");
        }
    }
}
```

#### Output:
```
Rectangle corners: (1, 2) and (3, 4)
```

---

### Advantages:
1. **Concise Code**: Reduces boilerplate when extracting fields from records.
2. **Improved Readability**: Makes code involving records more expressive and easier to understand.
3. **Seamless Integration**: Works with existing pattern matching constructs like `switch` and `if`.

---

### Use Cases:
1. **Data Processing**: Simplifies extracting and processing fields from record objects.
2. **Pattern Matching**: Enhances the readability of `switch` expressions and `if` statements involving records.
3. **Nested Structures**: Handles complex, nested record structures with ease.

Record Patterns are a powerful addition to Java, making it easier to work with records and improving the expressiveness of pattern matching constructs.

