
# Java Collections Interview Q&A

Java Collection interview questions and answers.


## Table of Contents

1. [What is the Java Collection Framework?](#1-what-is-the-java-collection-framework)
2. [What are Generics in Java?](#2-what-are-generics-in-java)
3. [Favorite Classes from the Java Collection Framework](#3-favorite-classes-from-the-java-collection-framework)
4. [When to Use Set, List, and Map?](#4-when-to-use-set-list-and-map)
5. [What Are Sorted Collections in Java?](#5-what-are-sorted-collections-in-java)
6. [How Does `HashSet` Work in Java?](#6-how-does-hashset-work-in-java)
7. [Which 2 Methods Should Be Overridden for an Object to Be Used as a Key in Hash-Based Collections?](#7-which-2-methods-should-be-overridden-for-an-object-to-be-used-as-a-key-in-hash-based-collections)
8. [Can You Use `HashMap` in a Concurrent Application?](#8-can-you-use-hashmap-in-a-concurrent-application)
9. [Difference Between `HashMap` and `Hashtable`](#9-difference-between-hashmap-and-hashtable)
10. [Difference Between Synchronized and Concurrent Collections](#10-difference-between-synchronized-and-concurrent-collections)
11. [How Does `ConcurrentHashMap` Work in Java?](#11-how-does-concurrenthashmap-work-in-java)
12. [What is a PriorityQueue in Java?](#12-what-is-a-priorityqueue-in-java)
13. [What is Type Erasure in Generics?](#13-what-is-type-erasure-in-generics)
14. [Difference Between ArrayList and Vector](#14-difference-between-arraylist-and-vector)
15. [Difference Between LinkedList and ArrayList](#15-difference-between-linkedlist-and-arraylist)
16. [Difference Between `Hashtable` and `ConcurrentHashMap`](#16-difference-between-hashtable-and-concurrenthashmap)
17. [Difference Between `LinkedHashSet` and `TreeSet`](#17-difference-between-linkedhashset-and-treeset)
18. [Difference Between `extends` and `super` in Generics](#18-difference-between-extends-and-super-in-generics)
19. [What Do You Mean by Thread-Safe Collection? Explain 2 Thread-Safe Collections](#19-what-do-you-mean-by-thread-safe-collection-explain-2-thread-safe-collections)
20. [Relation Between `equals` and `compareTo`](#20-relation-between-equals-and-compareto)
21. [Default Size of `ArrayList` and `HashMap`](#21-default-size-of-arraylist-and-hashmap)
22. [What is Load Factor, Capacity, and Size of a Collection?](#22-what-is-load-factor-capacity-and-size-of-a-collection)
23. [When Does ConcurrentModificationException Occur?](#23-when-does-concurrentmodificationexception-occur)
24. [Difference Between Fail-Safe and Fail-Fast Iterator](#24-difference-between-fail-safe-and-fail-fast-iterator)
25. [What is `CopyOnWriteArrayList` in Java?](#25-what-is-copyonwritearraylist-in-java)
26. [When to Use `BlockingQueue` in Java?](#26-when-to-use-blockingqueue-in-java)
27. [Difference Between Iterator and Enumeration](#27-difference-between-iterator-and-enumeration)
28. [Difference Between `peek` and `poll` Method of Queue in Java](#28-difference-between-peek-and-poll-method-of-queue-in-java)
29. [How Do You Find if an `ArrayList` Contains an Object or Not?](#29-how-do-you-find-if-an-arraylist-contains-an-object-or-not)
30. [Can We Store Integer in `ArrayList<Number>`?](#30-can-we-store-integer-in-arraylistnumber)
31. [How Does the `get` Method of `HashMap` Work? Explain with Example](#31-how-does-the-get-method-of-hashmap-work-explain-with-example)
32. [How Do You Sort a Collection in Java?](#32-how-do-you-sort-a-collection-in-java)
33. [Difference Between `ListIterator` and `Iterator`](#33-difference-between-listiterator-and-iterator)
34. [Difference Between `HashSet` and `LinkedHashSet`](#34-difference-between-hashset-and-linkedhashset)
35. [When Do You Use `EnumSet`? With Example](#35-when-do-you-use-enumset-with-example)
36. [List 4 Ways to Iterate Over a Map with Examples](#36-list-4-ways-to-iterate-over-a-map-with-examples)
37. [How Do You Create a Read-Only Collection?](#37-how-do-you-create-a-read-only-collection)
38. [What is `IdentityHashMap` in Java?](#38-what-is-identityhashmap-in-java)
39. [Difference Between `IdentityHashMap` and `WeakHashMap`](#39-difference-between-identityhashmap-and-weakhashmap)
40. [Difference Between `Comparator` and `Comparable`](#40-difference-between-comparator-and-comparable)
41. [What is Deque and When to Use It?](#41-what-is-deque-and-when-to-use-it)
42. [How to Remove an Object from a Collection?](#42-how-to-remove-an-object-from-a-collection)
43. [Difference Between `remove()` of Collection and Iterator](#43-difference-between-remove-of-collection-and-iterator)
44. [Difference Between `ArrayList` and `ArrayList<?>`](#44-difference-between-arraylist-and-arraylist)
45. [Difference Between `PriorityQueue` and `TreeSet`](#45-difference-between-priorityqueue-and-treeset)
46. [How to Avoid Unchecked Cast Warning?](#46-how-to-avoid-unchecked-cast-warning)
47. [What is the Diamond Operator in Java?](#47-what-is-the-diamond-operator-in-java)
48. [What is Covariant Method Overriding?](#48-what-is-covariant-method-overriding)
49. [Difference Between Bounded and Unbounded Wildcards in Generics](#49-difference-between-bounded-and-unbounded-wildcards-in-generics)



## 1. What is the Java Collection Framework?

The Java Collection Framework is a set of classes and interfaces that implement commonly reusable collection data structures. It provides a unified architecture to store and manipulate groups of objects, making it easier to manage data. Examples include `ArrayList`, `HashSet`, `HashMap`, and `LinkedList`.

### How to Choose a Collection?

Choosing the right collection depends on your specific requirements:

1. **List**: Use when you need an ordered collection that allows duplicates.
    - `ArrayList`: Best for random access and when frequent reads are required.
    - `LinkedList`: Best for frequent insertions and deletions.

2. **Set**: Use when you need a collection that does not allow duplicates.
    - `HashSet`: Best for fast lookups and no ordering.
    - `TreeSet`: Best for sorted elements.
    - `LinkedHashSet`: Maintains insertion order.

3. **Map**: Use when you need key-value pairs.
    - `HashMap`: Best for fast lookups with no ordering.
    - `TreeMap`: Best for sorted keys.
    - `LinkedHashMap`: Maintains insertion order.

4. **Queue/Deque**: Use for FIFO or LIFO operations.
    - `PriorityQueue`: Best for priority-based processing.
    - `ArrayDeque`: Best for stack or queue operations.

Always consider factors like performance, memory usage, and thread safety when choosing a collection.


## 2. What are Generics in Java?

Generics in Java are a feature that allows you to define classes, interfaces, and methods with type parameters. They enable type safety by allowing you to specify the type of objects that a collection can hold or a method can operate on, reducing runtime errors and eliminating the need for explicit type casting.

### Benefits of Generics:
1. **Type Safety**: Ensures that only the specified type of objects can be added to a collection.
2. **Elimination of Type Casting**: Reduces the need for explicit casting when retrieving objects from a collection.
3. **Code Reusability**: Allows the same code to be used with different types.

### Example of Generics:

```java
// Without Generics
List list = new ArrayList();
list.add("Hello");
String str = (String) list.get(0); // Explicit casting required

// With Generics
List<String> list = new ArrayList<>();
list.add("Hello");
String str = list.get(0); // No casting required
```

Generics are widely used in the Java Collection Framework, such as `ArrayList<T>`, `HashMap<K, V>`, and `HashSet<E>`.


## 3. Favorite Classes from the Java Collection Framework

Here are some of the most commonly used and favorite classes from the Java Collection Framework:

1. **ArrayList**:
    - A resizable array implementation of the `List` interface.
    - Provides fast random access and is ideal for scenarios where frequent reads are required.
    - Example:
      ```java
      List<String> list = new ArrayList<>();
      list.add("Java");
      list.add("Collections");
      ```

2. **HashMap**:
    - Implements the `Map` interface and stores key-value pairs.
    - Provides constant-time performance for basic operations like `get` and `put`.
    - Example:
      ```java
      Map<Integer, String> map = new HashMap<>();
      map.put(1, "Java");
      map.put(2, "HashMap");
      ```

3. **HashSet**:
    - Implements the `Set` interface and does not allow duplicate elements.
    - Backed by a `HashMap` and provides constant-time performance for basic operations.
    - Example:
      ```java
      Set<String> set = new HashSet<>();
      set.add("Java");
      set.add("HashSet");
      ```

4. **LinkedList**:
    - Implements both `List` and `Deque` interfaces.
    - Ideal for scenarios where frequent insertions and deletions are required.
    - Example:
      ```java
      List<String> list = new LinkedList<>();
      list.add("Java");
      list.add("LinkedList");
      ```

5. **PriorityQueue**:
    - Implements the `Queue` interface and provides priority-based ordering.
    - Useful for scenarios like task scheduling.
    - Example:
      ```java
      Queue<Integer> queue = new PriorityQueue<>();
      queue.add(10);
      queue.add(5);
      ```

These classes are versatile and widely used in Java programming for various data manipulation tasks.

## 4. When to Use Set, List, and Map?

Understanding when to use `Set`, `List`, and `Map` is crucial for designing efficient and maintainable Java applications. Here's a quick guide:

1. **Set**:
    - Use a `Set` when you need a collection of unique elements.
    - Ideal for scenarios where duplicates are not allowed, such as storing unique IDs or ensuring unique entries in a dataset.
    - Examples:
        - `HashSet`: Fast lookups without maintaining order.
        - `TreeSet`: Automatically sorts elements.
        - `LinkedHashSet`: Maintains insertion order.

2. **List**:
    - Use a `List` when you need an ordered collection that allows duplicates.
    - Ideal for scenarios where the order of elements matters, such as maintaining a sequence of tasks or a history of actions.
    - Examples:
        - `ArrayList`: Best for frequent reads and random access.
        - `LinkedList`: Best for frequent insertions and deletions.

3. **Map**:
    - Use a `Map` when you need to store key-value pairs.
    - Ideal for scenarios where you need to associate unique keys with specific values, such as a dictionary or a cache.
    - Examples:
        - `HashMap`: Fast lookups without maintaining order.
        - `TreeMap`: Automatically sorts keys.
        - `LinkedHashMap`: Maintains insertion order.

## 5. What Are Sorted Collections in Java?

Sorted collections in Java are data structures that maintain their elements in a specific order, typically based on their natural ordering or a custom comparator. These collections are part of the Java Collection Framework and are useful when you need to retrieve elements in a sorted manner.

### Examples of Sorted Collections:

1. **TreeSet**:
    - A `Set` implementation that maintains elements in their natural order or according to a custom comparator.
    - Example:
        ```java
        Set<Integer> sortedSet = new TreeSet<>();
        sortedSet.add(3);
        sortedSet.add(1);
        sortedSet.add(2);
        System.out.println(sortedSet); // Output: [1, 2, 3]
        ```

2. **TreeMap**:
    - A `Map` implementation that maintains its keys in their natural order or according to a custom comparator.
    - Example:
        ```java
        Map<String, Integer> sortedMap = new TreeMap<>();
        sortedMap.put("B", 2);
        sortedMap.put("A", 1);
        sortedMap.put("C", 3);
        System.out.println(sortedMap); // Output: {A=1, B=2, C=3}
        ```

3. **PriorityQueue**:
    - A `Queue` implementation that orders its elements based on their natural ordering or a custom comparator.
    - Example:
        ```java
        Queue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(10);
        priorityQueue.add(5);
        priorityQueue.add(20);
        System.out.println(priorityQueue.poll()); // Output: 5
        ```

### When to Use Sorted Collections:
- Use `TreeSet` or `TreeMap` when you need a sorted `Set` or `Map`.
- Use `PriorityQueue` when you need priority-based processing, such as task scheduling or implementing a min-heap or max-heap.

Sorted collections are particularly useful in scenarios where maintaining order is critical, such as implementing leaderboards, scheduling tasks, or managing sorted datasets.

## 6. How Does `HashSet` Work in Java?

`HashSet` is a class in the Java Collection Framework that implements the `Set` interface. It is backed by a `HashMap` and is designed to store unique elements. Here's how it works:

### Key Features of `HashSet`:
1. **No Duplicates**: Ensures that no duplicate elements are stored.
2. **Unordered**: Does not maintain any specific order of elements.
3. **Fast Operations**: Provides constant-time performance for basic operations like `add`, `remove`, and `contains`.

### How `HashSet` Works Internally:
1. **Hashing**: When an element is added to a `HashSet`, its `hashCode()` method is called to compute a hash value. This hash value determines the bucket where the element will be stored.
2. **Buckets**: The `HashSet` uses a `HashMap` internally, where the elements are stored as keys, and a dummy value is used as the associated value.
3. **Collision Handling**: If two elements have the same hash value (a collision), they are stored in the same bucket using a linked list or a balanced tree (since Java 8).
4. **Equality Check**: The `equals()` method is used to ensure that duplicate elements are not added to the set.

### Example of `HashSet`:

```java
Set<String> set = new HashSet<>();
set.add("Java");
set.add("HashSet");
set.add("Java"); // Duplicate, will not be added
System.out.println(set); // Output: [Java, HashSet]
```

### When to Use `HashSet`:
- Use `HashSet` when you need a collection of unique elements and do not care about the order of elements.
- Ideal for scenarios like removing duplicates from a dataset or checking membership in a collection.

### Limitations of `HashSet`:
- Does not maintain the order of elements.
- Not thread-safe. Use `Collections.synchronizedSet` or `ConcurrentHashMap` for thread safety.

`HashSet` is a powerful and efficient tool for managing unique elements in Java applications.


## 7. Which 2 Methods Should Be Overridden for an Object to Be Used as a Key in Hash-Based Collections?

To use an object as a key in hash-based collections like `HashMap` or `HashSet`, you must override the following two methods in the object's class:

1. **`hashCode()`**:
    - This method returns an integer hash code for the object.
    - It determines the bucket where the key-value pair will be stored in the hash table.
    - Objects that are equal (as determined by the `equals()` method) must have the same hash code.

2. **`equals()`**:
    - This method checks if two objects are logically equal.
    - It ensures that two objects considered equal have the same behavior in the hash-based collection.

### Why Are These Methods Important?

- The `hashCode()` method is used to quickly locate the bucket where the object might be stored.
- The `equals()` method is used to compare the actual content of the objects to confirm equality.

### Example:

```java
import java.util.HashMap;
import java.util.Map;

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int hashCode() {
        // Generate a hash code based on name and age
        return name.hashCode() + age;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return age == person.age && name.equals(person.name);
    }

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }
}

public class Main {
    public static void main(String[] args) {
        Map<Person, String> map = new HashMap<>();
        Person p1 = new Person("Alice", 30);
        Person p2 = new Person("Alice", 30);

        map.put(p1, "Developer");
        System.out.println(map.get(p2)); // Output: Developer
    }
}
```

### Explanation:

1. In the example, the `Person` class overrides `hashCode()` and `equals()` to ensure that two `Person` objects with the same name and age are treated as equal.
2. When `p2` is used to retrieve the value from the map, the `hashCode()` and `equals()` methods ensure that it matches the key `p1`.

### Key Points:
- Always override both `hashCode()` and `equals()` together.
- Failing to do so can lead to unexpected behavior in hash-based collections.



## 8. Can You Use `HashMap` in a Concurrent Application?

`HashMap` is **not thread-safe** and should not be used directly in a concurrent application where multiple threads might access or modify it simultaneously. Doing so can lead to unpredictable behavior, data corruption, or even infinite loops in certain scenarios.

### Alternatives to `HashMap` for Concurrent Applications:

1. **`ConcurrentHashMap`**:
    - A thread-safe alternative to `HashMap`.
    - Allows concurrent read and write operations without locking the entire map.
    - Uses a segmented locking mechanism to improve performance in multi-threaded environments.
    - Example:
      ```java
      import java.util.concurrent.ConcurrentHashMap;

      Map<String, Integer> map = new ConcurrentHashMap<>();
      map.put("Java", 1);
      map.put("Concurrency", 2);
      System.out.println(map.get("Java")); // Output: 1
      ```

2. **`Collections.synchronizedMap`**:
    - Wraps a `HashMap` with synchronized methods to make it thread-safe.
    - All operations are synchronized on the map object, which can lead to performance bottlenecks.
    - Example:
      ```java
      import java.util.Collections;
      import java.util.HashMap;
      import java.util.Map;

      Map<String, Integer> map = Collections.synchronizedMap(new HashMap<>());
      map.put("Java", 1);
      map.put("Synchronized", 2);
      synchronized (map) {
          System.out.println(map.get("Java")); // Output: 1
      }
      ```

### Key Differences Between `ConcurrentHashMap` and `Collections.synchronizedMap`:
| Feature                  | `ConcurrentHashMap`               | `Collections.synchronizedMap`       |
|--------------------------|------------------------------------|--------------------------------------|
| Locking Mechanism        | Fine-grained (per segment/bucket) | Coarse-grained (entire map)         |
| Performance              | Better for high concurrency       | Slower due to global synchronization |
| Null Keys/Values Allowed | No                                | Yes                                 |

### When to Use:
- Use `ConcurrentHashMap` for high-concurrency scenarios where multiple threads frequently access and modify the map.
- Use `Collections.synchronizedMap` for simpler use cases with lower concurrency requirements.

### Important Notes:
- Even with thread-safe maps, compound actions (e.g., check-then-act operations like `if (!map.containsKey(key)) map.put(key, value)`) may still require external synchronization to ensure atomicity.

In summary, avoid using `HashMap` in concurrent applications and choose a thread-safe alternative like `ConcurrentHashMap` or `Collections.synchronizedMap` based on your specific requirements.

## 9. Difference Between `HashMap` and `Hashtable`

`HashMap` and `Hashtable` are both implementations of the `Map` interface in Java, but they have significant differences in terms of performance, thread safety, and usage.

### Key Differences:

| Feature                  | `HashMap`                          | `Hashtable`                        |
|--------------------------|-------------------------------------|------------------------------------|
| **Thread Safety**        | Not thread-safe                    | Thread-safe (synchronized methods) |
| **Performance**          | Faster (no synchronization overhead) | Slower (due to synchronization)   |
| **Null Keys/Values**     | Allows one `null` key and multiple `null` values | Does not allow `null` keys or values |
| **Introduced In**        | Java 1.2                           | Java 1.0                           |
| **Legacy or Modern**     | Part of the Java Collections Framework | Legacy class (not part of Collections Framework) |
| **Iterator Type**        | Uses `Iterator` (fail-fast)         | Uses `Enumeration` (not fail-fast) |

### When to Use:
- Use `HashMap` in single-threaded applications or when external synchronization is handled.
- Use `Hashtable` only if you need a thread-safe map and cannot use modern alternatives like `ConcurrentHashMap`.

### Example of `HashMap`:

```java
Map<Integer, String> hashMap = new HashMap<>();
hashMap.put(1, "Java");
hashMap.put(2, "HashMap");
hashMap.put(null, "NullKey");
System.out.println(hashMap); // Output: {null=NullKey, 1=Java, 2=HashMap}
```

### Example of `Hashtable`:

```java
Map<Integer, String> hashtable = new Hashtable<>();
hashtable.put(1, "Java");
hashtable.put(2, "Hashtable");
// hashtable.put(null, "NullKey"); // Throws NullPointerException
System.out.println(hashtable); // Output: {1=Java, 2=Hashtable}
```

### Modern Alternative:
For thread-safe operations, prefer `ConcurrentHashMap` over `Hashtable` as it provides better performance and scalability.

## 10. Difference Between Synchronized and Concurrent Collections

Synchronized and concurrent collections in Java are designed to handle multi-threaded environments, but they differ in their implementation and performance.

### Synchronized Collections:
- Synchronized collections are part of the `java.util.Collections` utility class.
- They provide thread safety by synchronizing all method calls, which can lead to performance bottlenecks in high-concurrency scenarios.

#### Examples:
1. **`Collections.synchronizedList`**:
    ```java
    List<String> list = Collections.synchronizedList(new ArrayList<>());
    list.add("Java");
    synchronized (list) {
         for (String item : list) {
              System.out.println(item);
         }
    }
    ```

2. **`Collections.synchronizedMap`**:
    ```java
    Map<String, Integer> map = Collections.synchronizedMap(new HashMap<>());
    map.put("Java", 1);
    synchronized (map) {
         System.out.println(map.get("Java"));
    }
    ```

#### Key Points:
- All methods are synchronized on the collection object.
- External synchronization is required for iteration to avoid `ConcurrentModificationException`.

---

### Concurrent Collections:
- Concurrent collections are part of the `java.util.concurrent` package.
- They are designed for high-concurrency scenarios and use fine-grained locking or lock-free algorithms to improve performance.

#### Examples:
1. **`ConcurrentHashMap`**:
    ```java
    Map<String, Integer> map = new ConcurrentHashMap<>();
    map.put("Java", 1);
    System.out.println(map.get("Java"));
    ```

2. **`CopyOnWriteArrayList`**:
    ```java
    List<String> list = new CopyOnWriteArrayList<>();
    list.add("Java");
    for (String item : list) {
         System.out.println(item);
    }
    ```

#### Key Points:
- No external synchronization is required for iteration.
- Provides better performance in multi-threaded environments compared to synchronized collections.

---

### Comparison Table:

| Feature                  | Synchronized Collections           | Concurrent Collections             |
|--------------------------|-------------------------------------|------------------------------------|
| **Thread Safety**        | Achieved via synchronized methods  | Achieved via fine-grained locking or lock-free algorithms |
| **Performance**          | Slower due to global synchronization | Faster due to reduced contention  |
| **Iteration**            | Requires external synchronization  | Safe without external synchronization |
| **Examples**             | `Collections.synchronizedList`, `Collections.synchronizedMap` | `ConcurrentHashMap`, `CopyOnWriteArrayList` |

---

### When to Use:
- Use synchronized collections for simpler use cases with low concurrency.
- Use concurrent collections for high-concurrency scenarios where performance is critical.



## 11. How Does `ConcurrentHashMap` Work in Java?

`ConcurrentHashMap` is a thread-safe implementation of the `Map` interface, designed for high-concurrency scenarios. It allows multiple threads to read and write without locking the entire map, making it more efficient than synchronized collections.

### Key Features of `ConcurrentHashMap`:
1. **Thread Safety**: Ensures safe access by multiple threads without external synchronization.
2. **High Performance**: Uses fine-grained locking (bucket-level locking) to minimize contention.
3. **No Null Keys/Values**: Does not allow `null` keys or values.

### How `ConcurrentHashMap` Works Internally:
1. **Segmented Locking**: The map is divided into segments (or buckets), and each segment can be locked independently. This allows multiple threads to operate on different segments concurrently.
2. **Lock-Free Reads**: Read operations do not require locking, ensuring fast access.
3. **Bucket Structure**: Each bucket is implemented as a linked list or a tree (since Java 8) to handle hash collisions.
4. **Rehashing**: Automatically resizes the map when the load factor exceeds a threshold, redistributing elements across buckets.

### Example of `ConcurrentHashMap`:

```java
import java.util.concurrent.ConcurrentHashMap;

public class Main {
    public static void main(String[] args) {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

        // Adding elements
        map.put("Java", 1);
        map.put("Concurrency", 2);

        // Accessing elements
        System.out.println(map.get("Java")); // Output: 1

        // Iterating over the map
        map.forEach((key, value) -> System.out.println(key + ": " + value));
    }
}
```

### When to Use `ConcurrentHashMap`:
- Use `ConcurrentHashMap` in multi-threaded applications where multiple threads need to access and modify a shared map.
- Ideal for scenarios like caching, counters, or maintaining thread-safe collections.

### Limitations:
- Does not allow `null` keys or values.
- Compound actions (e.g., `if (!map.containsKey(key)) map.put(key, value)`) may still require external synchronization for atomicity.

`ConcurrentHashMap` is a powerful tool for managing shared data in concurrent applications, offering a balance between thread safety and performance.


## 12. What is a PriorityQueue in Java?

A `PriorityQueue` in Java is a part of the Java Collection Framework and is an implementation of the `Queue` interface. It is designed to process elements based on their priority rather than their insertion order. The elements in a `PriorityQueue` are ordered according to their natural ordering (if they implement `Comparable`) or by a custom comparator provided at the time of creation.

### Key Features of `PriorityQueue`:
1. **Priority-Based Ordering**: Elements are ordered based on their priority, with the highest-priority element at the head of the queue.
2. **Heap Implementation**: Internally, it uses a binary heap to maintain the priority order.
3. **No Null Elements**: Does not allow `null` elements.
4. **Unbounded Queue**: The size grows dynamically as elements are added.

### Example of `PriorityQueue`:

```java
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        // Creating a PriorityQueue of integers
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Adding elements
        pq.add(10);
        pq.add(5);
        pq.add(20);

        // Accessing and removing elements based on priority
        System.out.println(pq.poll()); // Output: 5 (smallest element)
        System.out.println(pq.poll()); // Output: 10
        System.out.println(pq.poll()); // Output: 20
    }
}
```

### Custom Comparator Example:

```java
import java.util.PriorityQueue;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        // Creating a PriorityQueue with a custom comparator (max-heap)
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        // Adding elements
        pq.add(10);
        pq.add(5);
        pq.add(20);

        // Accessing and removing elements based on priority
        System.out.println(pq.poll()); // Output: 20 (largest element)
        System.out.println(pq.poll()); // Output: 10
        System.out.println(pq.poll()); // Output: 5
    }
}
```

### When to Use `PriorityQueue`:
- Use `PriorityQueue` when you need to process elements based on their priority, such as in task scheduling, Dijkstra's algorithm, or implementing a min-heap or max-heap.

### Limitations:
- Not thread-safe. Use `PriorityBlockingQueue` for concurrent applications.
- Does not maintain the order of elements with the same priority.

`PriorityQueue` is a versatile and efficient tool for managing priority-based tasks in Java applications.



## 13. What is Type Erasure in Generics?

Type erasure is a process in Java where the generic type information is removed (or erased) at runtime by the compiler. This allows Java to maintain backward compatibility with older versions that did not support generics.

### How Type Erasure Works:
1. **Compile-Time Type Checking**: The compiler ensures type safety by checking the generic types during compilation.
2. **Type Erasure**: After compilation, the generic type information is erased, and the code is replaced with raw types or type bounds.

### Example:

```java
// Generic class
class Box<T> {
    private T value;

    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}

// Usage
Box<String> box = new Box<>();
box.setValue("Hello");
String value = box.getValue();
```

After type erasure, the code becomes:

```java
class Box {
    private Object value;

    public void setValue(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }
}

// Usage
Box box = new Box();
box.setValue("Hello");
String value = (String) box.getValue(); // Explicit cast required
```

### Key Points:
1. **Type Parameters Are Replaced**:
   - If a generic type has no bounds, it is replaced with `Object`.
   - If a generic type has bounds (e.g., `<T extends Number>`), it is replaced with the first bound (e.g., `Number`).

2. **No Runtime Type Information**:
   - Generic type information is not available at runtime due to type erasure.
   - This is why you cannot use `instanceof` with generic types or create arrays of generic types.

### Limitations of Type Erasure:
1. **Cannot Use Primitive Types**: Generics work only with reference types, not primitives (e.g., `int`, `double`).
2. **Type Casting**: Explicit casting may be required when retrieving elements from a collection after type erasure.
3. **No Runtime Type Information**: Generic type information is not available at runtime, which can lead to issues like `ClassCastException`.

### Why Type Erasure Exists:
Type erasure was introduced to ensure backward compatibility with older versions of Java that did not support generics. It allows generic code to work seamlessly with legacy code.

### Example of Type Erasure Limitation:

```java
List<String> list = new ArrayList<>();
if (list instanceof ArrayList<String>) { // Compilation error
    System.out.println("This will not compile");
}
```

Instead, you can only check the raw type:

```java
if (list instanceof ArrayList) { // Valid
    System.out.println("This will compile");
}
```

Type erasure is a fundamental concept in Java generics, enabling type safety at compile time while maintaining compatibility with older versions of Java.



## 14. Difference Between ArrayList and Vector

`ArrayList` and `Vector` are both implementations of the `List` interface in Java, but they have significant differences in terms of performance, thread safety, and usage.

### Key Differences:

| Feature                  | `ArrayList`                        | `Vector`                           |
|--------------------------|-------------------------------------|------------------------------------|
| **Thread Safety**        | Not thread-safe                    | Thread-safe (synchronized methods) |
| **Performance**          | Faster (no synchronization overhead) | Slower (due to synchronization)   |
| **Growth Policy**        | Increases size by 50% when full    | Doubles its size when full         |
| **Legacy or Modern**     | Part of the Java Collections Framework | Legacy class (introduced in Java 1.0) |
| **Iterator Type**        | Uses `Iterator` (fail-fast)         | Uses `Enumeration` (not fail-fast) |

### Example of `ArrayList`:

```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Java");
        list.add("ArrayList");
        System.out.println(list); // Output: [Java, ArrayList]
    }
}
```

### Example of `Vector`:

```java
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        Vector<String> vector = new Vector<>();
        vector.add("Java");
        vector.add("Vector");
        System.out.println(vector); // Output: [Java, Vector]
    }
}
```

### When to Use:
- Use `ArrayList` in single-threaded applications or when external synchronization is handled.
- Use `Vector` only if you need a thread-safe list and cannot use modern alternatives like `CopyOnWriteArrayList`.

### Modern Alternative:
For thread-safe operations, prefer `CopyOnWriteArrayList` over `Vector` as it provides better performance and scalability.

### Summary:
`ArrayList` is generally preferred over `Vector` for most use cases due to its better performance and modern design. However, `Vector` can still be used in legacy codebases or when thread safety is required without external synchronization.



## 15. Difference Between LinkedList and ArrayList

`LinkedList` and `ArrayList` are both implementations of the `List` interface in Java, but they differ significantly in terms of performance, memory usage, and use cases.

### Key Differences:

| Feature                  | `ArrayList`                        | `LinkedList`                       |
|--------------------------|-------------------------------------|------------------------------------|
| **Underlying Data Structure** | Resizable array                  | Doubly linked list                 |
| **Access Time**          | Faster for random access (O(1))    | Slower for random access (O(n))    |
| **Insertion/Deletion**   | Slower for large lists (O(n)) due to shifting elements | Faster (O(1)) if adding/removing at the beginning or end |
| **Memory Usage**         | Less memory overhead               | More memory overhead (due to node pointers) |
| **Iteration Performance**| Faster due to contiguous memory    | Slower due to traversal of nodes   |
| **Thread Safety**        | Not thread-safe                    | Not thread-safe                    |

### When to Use:
- Use `ArrayList` when:
    - You need fast random access to elements.
    - The number of insertions and deletions is minimal.
    - Memory efficiency is a priority.

- Use `LinkedList` when:
    - You need frequent insertions and deletions, especially at the beginning or middle of the list.
    - Random access is not required.

### Example of `ArrayList`:

```java
import java.util.ArrayList;

public class Main {
        public static void main(String[] args) {
                ArrayList<String> list = new ArrayList<>();
                list.add("Java");
                list.add("ArrayList");
                System.out.println(list); // Output: [Java, ArrayList]
        }
}
```

### Example of `LinkedList`:

```java
import java.util.LinkedList;

public class Main {
        public static void main(String[] args) {
                LinkedList<String> list = new LinkedList<>();
                list.add("Java");
                list.add("LinkedList");
                System.out.println(list); // Output: [Java, LinkedList]
        }
}
```

### Summary:
- Choose `ArrayList` for scenarios where frequent access to elements is required.
- Choose `LinkedList` for scenarios where frequent insertions and deletions are needed.


## 16. Difference Between `Hashtable` and `ConcurrentHashMap`

`Hashtable` and `ConcurrentHashMap` are both thread-safe implementations of the `Map` interface in Java, but they differ significantly in terms of performance, design, and usage.

### Key Differences:

| Feature                  | `Hashtable`                        | `ConcurrentHashMap`               |
|--------------------------|-------------------------------------|------------------------------------|
| **Thread Safety**        | Thread-safe (synchronized methods) | Thread-safe (fine-grained locking) |
| **Performance**          | Slower due to global synchronization | Faster due to reduced contention  |
| **Locking Mechanism**    | Locks the entire map for every operation | Locks only specific segments/buckets |
| **Null Keys/Values**     | Does not allow `null` keys or values | Does not allow `null` keys or values |
| **Iteration**            | Uses `Enumeration` (not fail-fast) | Uses `Iterator` (fail-safe)       |
| **Introduced In**        | Java 1.0                           | Java 1.5                           |
| **Legacy or Modern**     | Legacy class                       | Modern class (part of `java.util.concurrent`) |

### Example of `Hashtable`:

```java
import java.util.Hashtable;

public class Main {
    public static void main(String[] args) {
        Hashtable<Integer, String> hashtable = new Hashtable<>();
        hashtable.put(1, "Java");
        hashtable.put(2, "Hashtable");
        System.out.println(hashtable); // Output: {1=Java, 2=Hashtable}
    }
}
```

### Example of `ConcurrentHashMap`:

```java
import java.util.concurrent.ConcurrentHashMap;

public class Main {
    public static void main(String[] args) {
        ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();
        map.put(1, "Java");
        map.put(2, "ConcurrentHashMap");
        System.out.println(map); // Output: {1=Java, 2=ConcurrentHashMap}
    }
}
```

### When to Use:
- Use `ConcurrentHashMap` for high-concurrency scenarios where multiple threads frequently access and modify the map.
- Avoid using `Hashtable` in new code as it is a legacy class. Prefer `ConcurrentHashMap` for better performance and scalability.

### Summary:
`ConcurrentHashMap` is a modern, efficient alternative to `Hashtable` for thread-safe operations in multi-threaded environments. It provides better performance and is part of the `java.util.concurrent` package.


## 17. Difference Between `LinkedHashSet` and `TreeSet`

`LinkedHashSet` and `TreeSet` are both implementations of the `Set` interface in Java, but they differ in terms of ordering, performance, and use cases.

### Key Differences:

| Feature                  | `LinkedHashSet`                    | `TreeSet`                          |
|--------------------------|-------------------------------------|------------------------------------|
| **Ordering**             | Maintains insertion order          | Maintains elements in sorted order |
| **Underlying Data Structure** | Hash table and linked list        | Red-black tree                     |
| **Performance**          | Faster for add, remove, and contains (O(1)) | Slower for add, remove, and contains (O(log n)) |
| **Null Elements**        | Allows one `null` element          | Does not allow `null` elements     |
| **Comparator Support**   | Does not support custom comparators | Supports custom comparators        |
| **Use Case**             | Use when insertion order matters   | Use when sorted order matters      |

### Example of `LinkedHashSet`:

```java
import java.util.LinkedHashSet;

public class Main {
    public static void main(String[] args) {
        LinkedHashSet<String> set = new LinkedHashSet<>();
        set.add("Java");
        set.add("Collections");
        set.add("Set");
        System.out.println(set); // Output: [Java, Collections, Set]
    }
}
```

### Example of `TreeSet`:

```java
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        TreeSet<String> set = new TreeSet<>();
        set.add("Java");
        set.add("Collections");
        set.add("Set");
        System.out.println(set); // Output: [Collections, Java, Set]
    }
}
```

### When to Use:
- Use `LinkedHashSet` when you need to maintain the insertion order of elements.
- Use `TreeSet` when you need to maintain elements in a sorted order or require custom sorting using a comparator.

### Summary:
- `LinkedHashSet` is ideal for scenarios where order of insertion is important.
- `TreeSet` is better suited for scenarios where sorted order is required.



## 18. Difference Between `extends` and `super` in Generics

In Java generics, `extends` and `super` are used to define bounded wildcards, which restrict the types that can be used as type arguments. They are commonly used to achieve flexibility and type safety in generic methods and classes.

### Key Differences:

| Feature                  | `extends`                          | `super`                            |
|--------------------------|-------------------------------------|------------------------------------|
| **Definition**           | Represents an upper bound          | Represents a lower bound           |
| **Usage**                | Accepts the specified type or its subclasses | Accepts the specified type or its superclasses |
| **Read/Write Operations**| Allows reading but restricts writing | Allows writing but restricts reading |
| **Use Case**             | Use when you need to read data      | Use when you need to write data    |

### Example of `extends`:

```java
import java.util.List;

public class Main {
    public static void printNumbers(List<? extends Number> list) {
        for (Number num : list) {
            System.out.println(num);
        }
    }

    public static void main(String[] args) {
        List<Integer> integers = List.of(1, 2, 3);
        printNumbers(integers); // Works because Integer is a subclass of Number
    }
}
```

- `? extends Number` means the list can contain `Number` or any of its subclasses (e.g., `Integer`, `Double`).

### Example of `super`:

```java
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void addNumbers(List<? super Integer> list) {
        list.add(1);
        list.add(2);
    }

    public static void main(String[] args) {
        List<Number> numbers = new ArrayList<>();
        addNumbers(numbers); // Works because Number is a superclass of Integer
        System.out.println(numbers); // Output: [1, 2]
    }
}
```

- `? super Integer` means the list can contain `Integer` or any of its superclasses (e.g., `Number`, `Object`).

### When to Use:
- Use `extends` when you need to **read** data from a collection and ensure type safety.
- Use `super` when you need to **write** data to a collection and ensure type safety.

### Summary:
- `extends` is for upper-bounded wildcards, allowing flexibility in reading data.
- `super` is for lower-bounded wildcards, allowing flexibility in writing data.



## 19. What Do You Mean by Thread-Safe Collection? Explain 2 Thread-Safe Collections

A **thread-safe collection** in Java is a collection that can be safely accessed and modified by multiple threads concurrently without causing data corruption or inconsistent behavior. Thread-safe collections use synchronization mechanisms or concurrent algorithms to ensure that operations like adding, removing, or iterating over elements are performed safely in a multi-threaded environment.

### Examples of Thread-Safe Collections:

1. **`ConcurrentHashMap`**:
    - A thread-safe implementation of the `Map` interface.
    - Allows concurrent read and write operations without locking the entire map.
    - Uses fine-grained locking (bucket-level locking) to improve performance in multi-threaded environments.
    - Example:
      ```java
      import java.util.concurrent.ConcurrentHashMap;

      public class Main {
          public static void main(String[] args) {
              ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
              map.put("Java", 1);
              map.put("Concurrency", 2);
              System.out.println(map.get("Java")); // Output: 1
          }
      }
      ```

2. **`CopyOnWriteArrayList`**:
    - A thread-safe implementation of the `List` interface.
    - Creates a new copy of the underlying array whenever a modification (e.g., `add`, `remove`) is made.
    - Ideal for scenarios where reads are frequent, and writes are infrequent.
    - Example:
      ```java
      import java.util.concurrent.CopyOnWriteArrayList;

      public class Main {
          public static void main(String[] args) {
              CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
              list.add("Java");
              list.add("Thread-Safe");
              for (String item : list) {
                  System.out.println(item);
              }
          }
      }
      ```

### Key Points:
- Thread-safe collections ensure data consistency in multi-threaded environments.
- Use `ConcurrentHashMap` for high-concurrency scenarios involving key-value pairs.
- Use `CopyOnWriteArrayList` for scenarios with frequent reads and infrequent writes.



## 20. Relation Between `equals` and `compareTo`

In Java, the `equals` method and the `compareTo` method are used to compare objects, but they serve different purposes and have specific relationships when used together.

### Key Differences:

| Feature                  | `equals`                           | `compareTo`                        |
|--------------------------|-------------------------------------|------------------------------------|
| **Purpose**              | Checks for equality between two objects | Compares the order of two objects |
| **Return Type**          | Returns a boolean (`true` or `false`) | Returns an integer (`< 0`, `0`, `> 0`) |
| **Interface**            | Defined in `Object` class          | Defined in `Comparable` interface |
| **Usage**                | Used for logical equality          | Used for sorting or ordering      |

### Relation Between `equals` and `compareTo`:
1. **Consistency**:
    - If two objects are considered equal by the `equals` method, they must return `0` when compared using the `compareTo` method.
    - However, the reverse is not necessarily true. Two objects that return `0` in `compareTo` may not be considered equal by `equals`.

2. **Contract**:
    - If a class implements both `equals` and `compareTo`, it is recommended to ensure consistency between the two methods to avoid unexpected behavior in collections like `TreeSet` or `TreeMap`.

### Example:

```java
class Person implements Comparable<Person> {
     private String name;
     private int age;

     public Person(String name, int age) {
          this.name = name;
          this.age = age;
     }

     @Override
     public boolean equals(Object obj) {
          if (this == obj) return true;
          if (obj == null || getClass() != obj.getClass()) return false;
          Person person = (Person) obj;
          return age == person.age && name.equals(person.name);
     }

     @Override
     public int compareTo(Person other) {
          return Integer.compare(this.age, other.age);
     }

     @Override
     public String toString() {
          return name + " (" + age + ")";
     }
}

public class Main {
     public static void main(String[] args) {
          Person p1 = new Person("Alice", 30);
          Person p2 = new Person("Alice", 30);
          Person p3 = new Person("Bob", 25);

          System.out.println(p1.equals(p2)); // true
          System.out.println(p1.compareTo(p2)); // 0
          System.out.println(p1.compareTo(p3)); // > 0 (because 30 > 25)
     }
}
```

### Key Points:
- Ensure that `equals` and `compareTo` are consistent when implementing both.
- Use `equals` for logical equality and `compareTo` for ordering or sorting.
- Inconsistent implementations can lead to issues in sorted collections like `TreeSet` or `TreeMap`.

### When to Use:
- Use `equals` when checking if two objects are logically the same.
- Use `compareTo` when determining the order of objects, such as in sorting algorithms or ordered collections.



## 21. Default Size of `ArrayList` and `HashMap`

### Default Size of `ArrayList`:
- When an `ArrayList` is created using the default constructor, its initial capacity is **10**.
- The capacity of an `ArrayList` is the size of the internal array used to store elements. It grows dynamically as elements are added.

#### Example:

```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        System.out.println("Initial capacity: 10 (default)");
        list.add(1); // Adding elements increases the size dynamically
    }
}
```

### Default Size of `HashMap`:
- When a `HashMap` is created using the default constructor, its initial capacity is **16**, and the default load factor is **0.75**.
- The capacity is the number of buckets in the hash table, and the load factor determines when the map will resize (rehash).

#### Example:

```java
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        System.out.println("Initial capacity: 16 (default)");
        map.put("Java", 1); // Adding elements may trigger resizing if load factor is exceeded
    }
}
```

### Key Points:
- The default size of `ArrayList` is **10**, and it grows by 50% when full.
- The default size of `HashMap` is **16**, and it resizes when the number of elements exceeds 75% of the capacity (load factor of 0.75).

### When to Specify Initial Size:
- Specify an initial size for `ArrayList` or `HashMap` if you know the approximate number of elements in advance to avoid frequent resizing or rehashing, which can impact performance.



## 22. What is Load Factor, Capacity, and Size of a Collection?

In the context of Java collections, particularly hash-based collections like `HashMap` and `HashSet`, the terms **load factor**, **capacity**, and **size** have specific meanings.

### 1. **Load Factor**:
- The load factor is a measure that determines when a hash-based collection (e.g., `HashMap`) should resize (rehash).
- It is the ratio of the number of elements (size) to the capacity of the collection.
- Default load factor for `HashMap` and `HashSet` is **0.75**.
- When the load factor exceeds the threshold (e.g., 0.75), the collection resizes by increasing its capacity (usually doubling it).

### 2. **Capacity**:
- The capacity is the number of buckets in the hash table.
- It determines how many elements the collection can hold before resizing is triggered.
- Initial capacity is the capacity when the collection is created. For example:
    - Default initial capacity of `HashMap` is **16**.

### 3. **Size**:
- The size is the number of elements currently stored in the collection.

### Example:

```java
import java.util.HashMap;

public class Main {
        public static void main(String[] args) {
                HashMap<String, Integer> map = new HashMap<>(4, 0.75f); // Initial capacity: 4, Load factor: 0.75

                map.put("A", 1); // Size: 1, Capacity: 4
                map.put("B", 2); // Size: 2, Capacity: 4
                map.put("C", 3); // Size: 3, Capacity: 4
                map.put("D", 4); // Size: 4, Capacity: 4 (Load factor reached, triggers resizing)
                map.put("E", 5); // Size: 5, Capacity: 8 (Resized to double the capacity)

                System.out.println("Size: " + map.size()); // Output: 5
                System.out.println("Capacity: Resized to 8 after exceeding load factor");
        }
}
```

### Key Points:
1. **Load Factor**:
     - Determines when resizing occurs.
     - Lower load factor reduces collisions but increases memory usage.
     - Higher load factor saves memory but increases the likelihood of collisions.

2. **Capacity**:
     - Determines the number of buckets.
     - Resizing increases capacity to reduce collisions.

3. **Size**:
     - Represents the number of elements in the collection.

### Summary:
- **Load Factor**: Threshold for resizing.
- **Capacity**: Total buckets available.
- **Size**: Current number of elements.

Understanding these concepts helps in optimizing the performance of hash-based collections by balancing memory usage and lookup efficiency.



## 23. When Does ConcurrentModificationException Occur?

A `ConcurrentModificationException` occurs when a collection is modified while it is being iterated using an iterator, and the modification is not done through the iterator's methods. This exception is a fail-fast mechanism to prevent unpredictable behavior during concurrent modifications.

### Common Scenarios:
1. **Modifying a Collection Directly During Iteration**:
    - Adding, removing, or updating elements in a collection while iterating over it using a `for-each` loop or an `Iterator`.

2. **Using Non-Thread-Safe Collections in Multi-Threaded Environments**:
    - Modifying a collection from one thread while another thread is iterating over it.

### Example:

```java
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
     public static void main(String[] args) {
          List<String> list = new ArrayList<>();
          list.add("Java");
          list.add("Collections");
          list.add("Iterator");

          // Iterating and modifying the list directly
          try {
                for (String item : list) {
                     if (item.equals("Collections")) {
                          list.remove(item); // Throws ConcurrentModificationException
                     }
                }
          } catch (ConcurrentModificationException e) {
                System.out.println("ConcurrentModificationException occurred!");
          }

          // Correct way: Using Iterator's remove method
          Iterator<String> iterator = list.iterator();
          while (iterator.hasNext()) {
                String item = iterator.next();
                if (item.equals("Iterator")) {
                     iterator.remove(); // Safe modification
                }
          }

          System.out.println("Modified list: " + list); // Output: [Java]
     }
}
```

### Key Points:
- **Fail-Fast Behavior**: Collections like `ArrayList`, `HashMap`, and `HashSet` throw `ConcurrentModificationException` when modified during iteration.
- **Safe Modification**: Use the `Iterator`'s `remove()` method to safely remove elements during iteration.
- **Thread-Safe Alternatives**: Use concurrent collections like `CopyOnWriteArrayList` or `ConcurrentHashMap` for multi-threaded environments.

### Example with `CopyOnWriteArrayList`:

```java
import java.util.concurrent.CopyOnWriteArrayList;

public class Main {
     public static void main(String[] args) {
          CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
          list.add("Java");
          list.add("Collections");
          list.add("Thread-Safe");

          for (String item : list) {
                if (item.equals("Collections")) {
                     list.remove(item); // No ConcurrentModificationException
                }
          }

          System.out.println("Modified list: " + list); // Output: [Java, Thread-Safe]
     }
}
```

### Summary:
- `ConcurrentModificationException` occurs when a collection is modified during iteration without using the iterator's methods.
- Use safe alternatives like `Iterator`'s `remove()` or thread-safe collections to avoid this exception.



## 24. Difference Between Fail-Safe and Fail-Fast Iterator

In Java, iterators are used to traverse collections. They can be categorized as **fail-fast** or **fail-safe** based on their behavior when the collection is modified during iteration.

### Key Differences:

| Feature                  | Fail-Fast Iterator                 | Fail-Safe Iterator                 |
|--------------------------|-------------------------------------|------------------------------------|
| **Behavior**             | Throws `ConcurrentModificationException` if the collection is modified during iteration | Does not throw an exception if the collection is modified during iteration |
| **Underlying Mechanism** | Directly accesses the collection and detects structural changes | Works on a copy of the collection or uses concurrent mechanisms |
| **Thread Safety**        | Not thread-safe                    | Thread-safe                        |
| **Examples**             | `ArrayList`, `HashMap`, `HashSet`  | `CopyOnWriteArrayList`, `ConcurrentHashMap` |

---

### Example of Fail-Fast Iterator:

```java
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Java");
        list.add("Fail-Fast");
        list.add("Iterator");

        try {
            for (String item : list) {
                if (item.equals("Fail-Fast")) {
                    list.remove(item); // Throws ConcurrentModificationException
                }
            }
        } catch (ConcurrentModificationException e) {
            System.out.println("ConcurrentModificationException occurred!");
        }
    }
}
```

---

### Example of Fail-Safe Iterator:

```java
import java.util.concurrent.CopyOnWriteArrayList;

public class Main {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        list.add("Java");
        list.add("Fail-Safe");
        list.add("Iterator");

        for (String item : list) {
            if (item.equals("Fail-Safe")) {
                list.remove(item); // No ConcurrentModificationException
            }
        }

        System.out.println("Modified list: " + list); // Output: [Java, Iterator]
    }
}
```

---

### Key Points:
1. **Fail-Fast Iterators**:
   - Directly operate on the collection.
   - Detect structural modifications and throw `ConcurrentModificationException`.

2. **Fail-Safe Iterators**:
   - Operate on a copy of the collection or use concurrent mechanisms.
   - Do not throw exceptions during modification.

3. **When to Use**:
   - Use fail-fast iterators for single-threaded environments where modifications during iteration are not expected.
   - Use fail-safe iterators for multi-threaded environments to avoid exceptions and ensure thread safety.

Fail-safe iterators are particularly useful in concurrent applications, while fail-fast iterators are more efficient for non-concurrent scenarios.



## 25. What is `CopyOnWriteArrayList` in Java?

`CopyOnWriteArrayList` is a thread-safe implementation of the `List` interface in Java. It is part of the `java.util.concurrent` package and is designed for scenarios where reads are frequent, and writes are infrequent.

### Key Features:
1. **Thread Safety**: Ensures safe access and modification by multiple threads without external synchronization.
2. **Copy-On-Write Mechanism**: Creates a new copy of the underlying array whenever a modification (e.g., `add`, `remove`) is made.
3. **Read-Optimized**: Iterators operate on a snapshot of the array at the time of their creation, ensuring no `ConcurrentModificationException`.

### Example:

```java
import java.util.concurrent.CopyOnWriteArrayList;

public class Main {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        list.add("Java");
        list.add("Thread-Safe");
        list.add("CopyOnWriteArrayList");

        // Iterating over the list
        for (String item : list) {
            if (item.equals("Thread-Safe")) {
                list.remove(item); // No ConcurrentModificationException
            }
        }

        System.out.println("Modified list: " + list); // Output: [Java, CopyOnWriteArrayList]
    }
}
```

### Advantages:
1. **No `ConcurrentModificationException`**: Safe to modify the list during iteration.
2. **Thread-Safe Reads**: Multiple threads can read the list without blocking.

### Disadvantages:
1. **High Memory Usage**: Creates a new copy of the array for every modification.
2. **Performance Overhead**: Modifications are slower due to the copy-on-write mechanism.

### When to Use:
- Use `CopyOnWriteArrayList` in multi-threaded environments where:
  - Reads are frequent, and writes are rare.
  - Iteration safety is critical without external synchronization.

`CopyOnWriteArrayList` is ideal for scenarios like maintaining a list of event listeners or caching data in a thread-safe manner.



## 26. When to Use `BlockingQueue` in Java?

A `BlockingQueue` in Java is a thread-safe queue that supports operations that wait for the queue to become non-empty when retrieving an element, and wait for space to become available when storing an element. It is part of the `java.util.concurrent` package and is commonly used in producer-consumer scenarios.

### Key Features:
1. **Thread Safety**: Ensures safe access and modification by multiple threads.
2. **Blocking Operations**: Provides `put()` and `take()` methods that block until the queue is ready for the operation.
3. **Bounded or Unbounded**: Can be configured with a fixed capacity (bounded) or no capacity limit (unbounded).

### When to Use:
- **Producer-Consumer Pattern**:
    - Use `BlockingQueue` to implement the producer-consumer pattern where producers add items to the queue, and consumers retrieve and process them.
    - Example: Task scheduling, logging systems, or message processing.

- **Thread Communication**:
    - Use `BlockingQueue` to facilitate communication between threads without explicit synchronization.

- **Rate Limiting**:
    - Use a bounded `BlockingQueue` to limit the rate at which tasks are produced or consumed.

### Example:

```java
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {
        public static void main(String[] args) {
                BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);

                // Producer thread
                Thread producer = new Thread(() -> {
                        try {
                                for (int i = 1; i <= 10; i++) {
                                        queue.put(i); // Blocks if the queue is full
                                        System.out.println("Produced: " + i);
                                }
                        } catch (InterruptedException e) {
                                Thread.currentThread().interrupt();
                        }
                });

                // Consumer thread
                Thread consumer = new Thread(() -> {
                        try {
                                while (true) {
                                        Integer item = queue.take(); // Blocks if the queue is empty
                                        System.out.println("Consumed: " + item);
                                }
                        } catch (InterruptedException e) {
                                Thread.currentThread().interrupt();
                        }
                });

                producer.start();
                consumer.start();
        }
}
```

### Common Implementations:
1. **`ArrayBlockingQueue`**: A bounded blocking queue backed by an array.
2. **`LinkedBlockingQueue`**: An optionally bounded blocking queue backed by a linked list.
3. **`PriorityBlockingQueue`**: A priority queue with blocking operations.
4. **`SynchronousQueue`**: A queue with no capacity where each insert operation must wait for a corresponding remove operation.

### Advantages:
- Simplifies thread communication by handling synchronization internally.
- Prevents resource contention in multi-threaded environments.

### When Not to Use:
- Avoid `BlockingQueue` if you do not need blocking behavior or if the application is single-threaded.

`BlockingQueue` is a powerful tool for managing thread-safe communication and synchronization in concurrent applications.


## 27. Difference Between Iterator and Enumeration

`Iterator` and `Enumeration` are both used to traverse collections in Java, but they differ in terms of functionality, usage, and design.

### Key Differences:

| Feature                  | `Iterator`                         | `Enumeration`                      |
|--------------------------|-------------------------------------|------------------------------------|
| **Introduced In**        | Java 1.2 (part of the Collections Framework) | Java 1.0 (legacy)                  |
| **Supported Operations** | Can traverse and remove elements   | Can only traverse elements         |
| **Methods**              | `hasNext()`, `next()`, `remove()`  | `hasMoreElements()`, `nextElement()` |
| **Fail-Fast Behavior**   | Fail-fast (throws `ConcurrentModificationException` if the collection is modified during iteration) | Not fail-fast                      |
| **Usage**                | Preferred for modern collections   | Used with legacy classes like `Vector` and `Hashtable` |
| **Thread Safety**        | Not thread-safe (requires external synchronization) | Thread-safe (due to legacy design) |

---

### Example of `Iterator`:

```java
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Java");
        list.add("Iterator");
        list.add("Example");

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            if (item.equals("Iterator")) {
                iterator.remove(); // Safe removal
            }
        }

        System.out.println("Modified list: " + list); // Output: [Java, Example]
    }
}
```

---

### Example of `Enumeration`:

```java
import java.util.Enumeration;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        Vector<String> vector = new Vector<>();
        vector.add("Java");
        vector.add("Enumeration");
        vector.add("Example");

        Enumeration<String> enumeration = vector.elements();
        while (enumeration.hasMoreElements()) {
            String item = enumeration.nextElement();
            System.out.println(item); // Output: Java, Enumeration, Example
        }
    }
}
```

---

### When to Use:
- Use `Iterator` for modern collections like `ArrayList`, `HashSet`, and `HashMap`.
- Use `Enumeration` only for legacy classes like `Vector` and `Hashtable`.

### Summary:
- `Iterator` is part of the Java Collections Framework and supports element removal, making it more versatile.
- `Enumeration` is a legacy interface with limited functionality and is primarily used for backward compatibility.



## 28. Difference Between `peek` and `poll` Method of Queue in Java

The `peek` and `poll` methods are part of the `Queue` interface in Java and are used to retrieve elements from the queue. However, they differ in their behavior.

### Key Differences:

| Feature                  | `peek`                             | `poll`                             |
|--------------------------|-------------------------------------|------------------------------------|
| **Purpose**              | Retrieves the head of the queue without removing it | Retrieves and removes the head of the queue |
| **Return Value**         | Returns `null` if the queue is empty | Returns `null` if the queue is empty |
| **Modification**         | Does not modify the queue          | Removes the head element from the queue |
| **Use Case**             | Use when you only need to view the head element | Use when you need to process and remove the head element |

---

### Example:

```java
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        queue.add("Java");
        queue.add("Queue");
        queue.add("Example");

        // Using peek
        System.out.println("Peek: " + queue.peek()); // Output: Peek: Java
        System.out.println("Queue after peek: " + queue); // Output: [Java, Queue, Example]

        // Using poll
        System.out.println("Poll: " + queue.poll()); // Output: Poll: Java
        System.out.println("Queue after poll: " + queue); // Output: [Queue, Example]
    }
}
```

---

### Key Points:
1. **`peek`**:
   - Retrieves the head element without removing it.
   - Returns `null` if the queue is empty.

2. **`poll`**:
   - Retrieves and removes the head element.
   - Returns `null` if the queue is empty.

3. **When to Use**:
   - Use `peek` when you only need to inspect the head element.
   - Use `poll` when you need to process and remove the head element.

### Summary:
- `peek` is non-destructive and leaves the queue unchanged.
- `poll` is destructive and removes the head element from the queue.



## 29. How Do You Find if an `ArrayList` Contains an Object or Not?

To check if an `ArrayList` contains a specific object, you can use the `contains()` method provided by the `List` interface. This method checks if the specified object is present in the list by using the `equals()` method of the objects.

### Syntax:
```java
boolean contains(Object o)
```

- Returns `true` if the list contains the specified object, otherwise `false`.

### Example:

```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Java");
        list.add("Collections");
        list.add("ArrayList");

        // Check if the list contains an object
        boolean containsJava = list.contains("Java");
        boolean containsPython = list.contains("Python");

        System.out.println("Contains 'Java': " + containsJava); // Output: true
        System.out.println("Contains 'Python': " + containsPython); // Output: false
    }
}
```

### Key Points:
1. **Uses `equals()` Method**:
   - The `contains()` method relies on the `equals()` method of the objects to determine equality.
   - Ensure that the `equals()` method is properly overridden in custom classes.

2. **Case Sensitivity**:
   - For `String` objects, the check is case-sensitive. For example, `"Java"` and `"java"` are considered different.

### Example with Custom Objects:

```java
import java.util.ArrayList;

class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return name.equals(person.name);
    }

    @Override
    public String toString() {
        return name;
    }
}

public class Main {
    public static void main(String[] args) {
        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person("Alice"));
        list.add(new Person("Bob"));

        // Check if the list contains a specific Person
        boolean containsAlice = list.contains(new Person("Alice"));
        boolean containsCharlie = list.contains(new Person("Charlie"));

        System.out.println("Contains 'Alice': " + containsAlice); // Output: true
        System.out.println("Contains 'Charlie': " + containsCharlie); // Output: false
    }
}
```

### When to Use:
- Use `contains()` to check for the presence of an object in an `ArrayList` when you need to perform membership checks.

### Limitations:
- The performance of `contains()` is O(n) because it iterates through the list to find the object.
- For large datasets, consider using a `HashSet` or `HashMap` for faster lookups.



## 30. Can We Store Integer in `ArrayList<Number>`?

Yes, you can store an `Integer` in an `ArrayList<Number>` because `Integer` is a subclass of `Number`. The `ArrayList<Number>` can hold any object that is a subclass of `Number`, such as `Integer`, `Double`, `Float`, etc.

### Example:

```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Number> list = new ArrayList<>();
        
        // Adding Integer to ArrayList<Number>
        list.add(10); // Integer
        list.add(20.5); // Double
        list.add(15.75f); // Float

        System.out.println(list); // Output: [10, 20.5, 15.75]
    }
}
```

### Key Points:
1. **Polymorphism**:
   - Since `Integer` is a subclass of `Number`, it can be added to an `ArrayList<Number>`.

2. **Type Safety**:
   - The generic type `<Number>` ensures that only objects of type `Number` or its subclasses can be added to the list.

3. **Retrieving Elements**:
   - When retrieving elements, you may need to cast them to their specific type if required.

### Example of Retrieving Elements:

```java
for (Number num : list) {
    if (num instanceof Integer) {
        System.out.println("Integer: " + num);
    } else if (num instanceof Double) {
        System.out.println("Double: " + num);
    }
}
```

### Limitations:
- You cannot store primitive types like `int` directly in an `ArrayList<Number>`. They are automatically boxed into their wrapper classes (e.g., `Integer` for `int`).

### Summary:
An `ArrayList<Number>` can store `Integer` objects because `Integer` is a subclass of `Number`. This makes it a flexible choice for storing various numeric types in a single collection.



## 31. How Does the `get` Method of `HashMap` Work? Explain with Example

The `get` method of `HashMap` is used to retrieve the value associated with a specific key. Internally, it uses the key's `hashCode()` and `equals()` methods to locate the value in the hash table.

### How It Works Internally:
1. **Hashing**:
    - The `hashCode()` method of the key is called to compute the hash value.
    - This hash value is used to determine the bucket where the key-value pair might be stored.

2. **Bucket Access**:
    - The hash value is mapped to a specific bucket using the formula:
      ```java
      index = (hash & 0x7FFFFFFF) % capacity
      ```
    - This ensures that the hash value is within the bounds of the hash table.

3. **Collision Handling**:
    - If multiple keys map to the same bucket (collision), the bucket stores the entries in a linked list or a balanced tree (since Java 8).
    - The `equals()` method is used to compare the keys in the bucket to find the exact match.

4. **Value Retrieval**:
    - Once the matching key is found, the associated value is returned.

### Example:

```java
import java.util.HashMap;

public class Main {
     public static void main(String[] args) {
          HashMap<String, Integer> map = new HashMap<>();

          // Adding key-value pairs
          map.put("Java", 1);
          map.put("HashMap", 2);
          map.put("Example", 3);

          // Retrieving values using keys
          System.out.println("Value for 'Java': " + map.get("Java")); // Output: 1
          System.out.println("Value for 'HashMap': " + map.get("HashMap")); // Output: 2
          System.out.println("Value for 'Example': " + map.get("Example")); // Output: 3

          // Retrieving a non-existing key
          System.out.println("Value for 'Python': " + map.get("Python")); // Output: null
     }
}
```

### Key Points:
1. **`hashCode()` and `equals()`**:
    - The `hashCode()` method determines the bucket.
    - The `equals()` method ensures the correct key is found in case of collisions.

2. **Null Keys**:
    - `HashMap` allows one `null` key. The `get` method handles it as a special case.

3. **Performance**:
    - The average time complexity of the `get` method is O(1) for well-distributed keys.
    - In the worst case (e.g., many collisions), the time complexity can degrade to O(n).

### Example with Collisions:

```java
import java.util.HashMap;

class Key {
     private String name;

     public Key(String name) {
          this.name = name;
     }

     @Override
     public int hashCode() {
          return 1; // Forces all keys to collide
     }

     @Override
     public boolean equals(Object obj) {
          if (this == obj) return true;
          if (obj == null || getClass() != obj.getClass()) return false;
          Key key = (Key) obj;
          return name.equals(key.name);
     }

     @Override
     public String toString() {
          return name;
     }
}

public class Main {
     public static void main(String[] args) {
          HashMap<Key, Integer> map = new HashMap<>();

          // Adding keys with the same hash code
          map.put(new Key("A"), 1);
          map.put(new Key("B"), 2);
          map.put(new Key("C"), 3);

          // Retrieving values
          System.out.println("Value for 'A': " + map.get(new Key("A"))); // Output: 1
          System.out.println("Value for 'B': " + map.get(new Key("B"))); // Output: 2
          System.out.println("Value for 'C': " + map.get(new Key("C"))); // Output: 3
     }
}
```

### Summary:
- The `get` method uses the `hashCode()` to locate the bucket and `equals()` to find the exact key.
- It is efficient for well-distributed keys but can degrade in performance with poor hash functions or excessive collisions.



## 32. How Do You Sort a Collection in Java?

In Java, you can sort a collection using the `Collections.sort()` method or the `Stream` API. Sorting can be done in natural order (ascending) or using a custom comparator for custom sorting logic.

### Sorting Using `Collections.sort()`

The `Collections.sort()` method is used to sort a `List` in natural order or using a custom comparator.

#### Example: Sorting in Natural Order

```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(2);
        list.add(8);
        list.add(1);

        // Sorting in natural order (ascending)
        Collections.sort(list);

        System.out.println("Sorted List: " + list); // Output: [1, 2, 5, 8]
    }
}
```

#### Example: Sorting with a Custom Comparator

```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Java");
        list.add("Python");
        list.add("C++");
        list.add("JavaScript");

        // Sorting in reverse order
        Collections.sort(list, Comparator.reverseOrder());

        System.out.println("Sorted List: " + list); // Output: [Python, JavaScript, Java, C++]
    }
}
```

---

### Sorting Using the `Stream` API

The `Stream` API provides the `sorted()` method to sort a collection. It can be used with natural ordering or a custom comparator.

#### Example: Sorting in Natural Order

```java
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(5, 2, 8, 1);

        // Sorting using Stream API
        List<Integer> sortedList = list.stream()
                                        .sorted()
                                        .toList();

        System.out.println("Sorted List: " + sortedList); // Output: [1, 2, 5, 8]
    }
}
```

#### Example: Sorting with a Custom Comparator

```java
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Java", "Python", "C++", "JavaScript");

        // Sorting in reverse order using Stream API
        List<String> sortedList = list.stream()
                                      .sorted((a, b) -> b.compareTo(a))
                                      .toList();

        System.out.println("Sorted List: " + sortedList); // Output: [Python, JavaScript, Java, C++]
    }
}
```

---

### Key Points:
1. **`Collections.sort()`**:
   - Works only with `List`.
   - Modifies the original list.

2. **`Stream.sorted()`**:
   - Works with any collection that can be converted to a stream.
   - Does not modify the original collection; returns a new sorted list.

3. **Custom Sorting**:
   - Use a `Comparator` to define custom sorting logic.

### When to Use:
- Use `Collections.sort()` for simple sorting of `List` objects.
- Use `Stream.sorted()` for functional-style programming or when working with streams.



## 33. Difference Between `ListIterator` and `Iterator`

`ListIterator` and `Iterator` are both used to traverse collections in Java, but they differ in terms of functionality and usage. `ListIterator` is a more advanced version of `Iterator` and is specifically designed for lists.

### Key Differences:

| Feature                  | `Iterator`                         | `ListIterator`                     |
|--------------------------|-------------------------------------|------------------------------------|
| **Introduced In**        | Java 1.2                           | Java 1.2                           |
| **Applicable To**        | All collections implementing `Collection` | Only for collections implementing `List` |
| **Traversal Direction**  | Supports forward traversal only    | Supports both forward and backward traversal |
| **Element Modification** | Can remove elements using `remove()` | Can add, remove, and update elements using `add()`, `remove()`, and `set()` |
| **Index Access**         | Does not provide access to indices | Provides access to indices using `nextIndex()` and `previousIndex()` |
| **Methods**              | `hasNext()`, `next()`, `remove()`  | `hasNext()`, `next()`, `hasPrevious()`, `previous()`, `add()`, `set()`, `remove()` |

---

### Example of `Iterator`:

```java
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Java");
        list.add("Iterator");
        list.add("Example");

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            if (item.equals("Iterator")) {
                iterator.remove(); // Safe removal
            }
        }

        System.out.println("Modified list: " + list); // Output: [Java, Example]
    }
}
```

---

### Example of `ListIterator`:

```java
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Java");
        list.add("ListIterator");
        list.add("Example");

        ListIterator<String> listIterator = list.listIterator();

        // Forward traversal
        while (listIterator.hasNext()) {
            String item = listIterator.next();
            if (item.equals("ListIterator")) {
                listIterator.set("Updated"); // Update element
            }
        }

        // Backward traversal
        while (listIterator.hasPrevious()) {
            System.out.println(listIterator.previous());
        }

        System.out.println("Modified list: " + list); // Output: [Java, Updated, Example]
    }
}
```

---

### Key Points:
1. **Use `Iterator`**:
   - When you only need forward traversal and basic element removal.
   - Works with all collections implementing `Collection`.

2. **Use `ListIterator`**:
   - When you need bidirectional traversal or advanced operations like adding or updating elements.
   - Works only with lists.

### Summary:
- `Iterator` is simpler and works with all collections.
- `ListIterator` is more powerful but is limited to lists. Use it when you need additional functionality like backward traversal or element modification.


## 34. Difference Between `HashSet` and `LinkedHashSet`

`HashSet` and `LinkedHashSet` are both implementations of the `Set` interface in Java, but they differ in terms of ordering and performance.

### Key Differences:

| Feature                  | `HashSet`                          | `LinkedHashSet`                    |
|--------------------------|-------------------------------------|------------------------------------|
| **Ordering**             | Does not maintain any order        | Maintains insertion order          |
| **Underlying Data Structure** | Hash table                       | Hash table and linked list         |
| **Performance**          | Faster for add, remove, and contains (O(1)) | Slightly slower due to maintaining insertion order |
| **Use Case**             | Use when order does not matter     | Use when insertion order matters   |
| **Memory Usage**         | Less memory overhead               | More memory overhead due to linked list |

---

### Example of `HashSet`:

```java
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<String> hashSet = new HashSet<>();
        hashSet.add("Java");
        hashSet.add("HashSet");
        hashSet.add("Example");

        System.out.println("HashSet: " + hashSet); // Output: [Example, Java, HashSet] (order not guaranteed)
    }
}
```

---

### Example of `LinkedHashSet`:

```java
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("Java");
        linkedHashSet.add("LinkedHashSet");
        linkedHashSet.add("Example");

        System.out.println("LinkedHashSet: " + linkedHashSet); // Output: [Java, LinkedHashSet, Example] (insertion order maintained)
    }
}
```

---

### When to Use:
- Use `HashSet` when you need a collection of unique elements and do not care about the order.
- Use `LinkedHashSet` when you need a collection of unique elements and want to preserve the insertion order.

### Summary:
- `HashSet` is faster and uses less memory but does not maintain order.
- `LinkedHashSet` maintains insertion order but has slightly higher memory and performance overhead.



## 35. When Do You Use `EnumSet`? With Example

`EnumSet` is a specialized `Set` implementation in Java designed specifically for use with enum types. It is part of the `java.util` package and provides a highly efficient way to store and manipulate sets of enum constants.

### When to Use `EnumSet`:
1. **Working with Enum Types**:
    - Use `EnumSet` when you need to store a collection of enum constants.
    - It is more efficient than other `Set` implementations like `HashSet` or `TreeSet` for enums.

2. **Performance**:
    - `EnumSet` is implemented as a bit vector, making it extremely fast for operations like `add`, `remove`, and `contains`.

3. **Type Safety**:
    - Ensures that only enum constants of a specific type can be added to the set.

4. **Memory Efficiency**:
    - Uses a compact representation, making it more memory-efficient than other `Set` implementations.

5. **Use Cases**:
    - Representing a fixed set of constants, such as days of the week, states, or flags.
    - Performing set operations like union, intersection, and difference on enum constants.

---

### Example:

```java
import java.util.EnumSet;

enum Day {
     MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

public class Main {
     public static void main(String[] args) {
          // Creating an EnumSet with specific days
          EnumSet<Day> weekdays = EnumSet.range(Day.MONDAY, Day.FRIDAY);
          EnumSet<Day> weekend = EnumSet.of(Day.SATURDAY, Day.SUNDAY);

          // Printing the sets
          System.out.println("Weekdays: " + weekdays); // Output: [MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY]
          System.out.println("Weekend: " + weekend);   // Output: [SATURDAY, SUNDAY]

          // Adding and removing elements
          weekdays.add(Day.SUNDAY); // Adding Sunday to weekdays
          System.out.println("Updated Weekdays: " + weekdays); // Output: [MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SUNDAY]

          weekdays.remove(Day.SUNDAY); // Removing Sunday
          System.out.println("After Removal: " + weekdays); // Output: [MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY]

          // Performing set operations
          EnumSet<Day> allDays = EnumSet.allOf(Day.class);
          EnumSet<Day> nonWorkingDays = EnumSet.complementOf(weekdays);
          System.out.println("All Days: " + allDays); // Output: [MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY]
          System.out.println("Non-Working Days: " + nonWorkingDays); // Output: [SATURDAY, SUNDAY]
     }
}
```

---

### Key Points:
1. **Creation Methods**:
    - `EnumSet.allOf(EnumType.class)`: Creates a set containing all enum constants.
    - `EnumSet.noneOf(EnumType.class)`: Creates an empty set.
    - `EnumSet.of(E... elements)`: Creates a set with specified elements.
    - `EnumSet.range(E from, E to)`: Creates a set with a range of elements.
    - `EnumSet.complementOf(EnumSet<E> set)`: Creates a set with elements not in the specified set.

2. **Performance**:
    - Operations like `add`, `remove`, and `contains` are O(1).

3. **Limitations**:
    - Can only be used with enums.
    - Not thread-safe. Use `Collections.synchronizedSet` for thread safety if needed.

---

### When Not to Use:
- Avoid `EnumSet` if you need to store non-enum elements or require a thread-safe implementation without external synchronization.

`EnumSet` is an excellent choice for scenarios involving enums, offering high performance and memory efficiency.



## 36. List 4 Ways to Iterate Over a Map with Examples

In Java, there are multiple ways to iterate over a `Map`. Here are four common approaches:

### 1. **Using `entrySet()` with a `for-each` Loop**
The `entrySet()` method returns a set of key-value pairs (`Map.Entry` objects), which can be iterated using a `for-each` loop.

#### Example:
```java
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("Java", 1);
        map.put("Python", 2);
        map.put("C++", 3);

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }
}
```

---

### 2. **Using `keySet()` to Iterate Over Keys**
The `keySet()` method returns a set of all keys in the map. You can use it to iterate over the keys and retrieve values using the `get()` method.

#### Example:
```java
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("Java", 1);
        map.put("Python", 2);
        map.put("C++", 3);

        for (String key : map.keySet()) {
            System.out.println("Key: " + key + ", Value: " + map.get(key));
        }
    }
}
```

---

### 3. **Using `values()` to Iterate Over Values**
The `values()` method returns a collection of all values in the map. This is useful when you only need to process the values.

#### Example:
```java
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("Java", 1);
        map.put("Python", 2);
        map.put("C++", 3);

        for (Integer value : map.values()) {
            System.out.println("Value: " + value);
        }
    }
}
```

---

### 4. **Using `forEach()` with Lambda Expressions**
The `forEach()` method introduced in Java 8 allows you to iterate over the map using a lambda expression.

#### Example:
```java
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("Java", 1);
        map.put("Python", 2);
        map.put("C++", 3);

        map.forEach((key, value) -> System.out.println("Key: " + key + ", Value: " + value));
    }
}
```

---

### Summary:
- Use `entrySet()` for both keys and values.
- Use `keySet()` when you only need keys.
- Use `values()` when you only need values.
- Use `forEach()` for concise and modern iteration.



## 37. How Do You Create a Read-Only Collection?

In Java, you can create a read-only collection using the `Collections.unmodifiableXXX()` methods provided by the `java.util.Collections` utility class. These methods return a wrapper around the original collection that prevents modification.

### Key Points:
1. **Read-Only Wrapper**:
    - The original collection can still be modified, but the wrapper will throw an `UnsupportedOperationException` if any modification is attempted through it.

2. **Methods**:
    - `Collections.unmodifiableList(List<T> list)`
    - `Collections.unmodifiableSet(Set<T> set)`
    - `Collections.unmodifiableMap(Map<K, V> map)`

3. **Use Case**:
    - Use read-only collections to ensure that a collection cannot be modified by external code.

---

### Example:

```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
     public static void main(String[] args) {
          // Original list
          List<String> list = new ArrayList<>();
          list.add("Java");
          list.add("Collections");
          list.add("Read-Only");

          // Creating a read-only list
          List<String> readOnlyList = Collections.unmodifiableList(list);

          System.out.println("Read-Only List: " + readOnlyList);

          // Attempting to modify the read-only list
          try {
                readOnlyList.add("New Element"); // Throws UnsupportedOperationException
          } catch (UnsupportedOperationException e) {
                System.out.println("Cannot modify a read-only list!");
          }

          // Modifying the original list
          list.add("New Element");
          System.out.println("Modified Original List: " + list);
          System.out.println("Read-Only List Reflects Changes: " + readOnlyList);
     }
}
```

---

### Output:
```
Read-Only List: [Java, Collections, Read-Only]
Cannot modify a read-only list!
Modified Original List: [Java, Collections, Read-Only, New Element]
Read-Only List Reflects Changes: [Java, Collections, Read-Only, New Element]
```

---

### Key Notes:
- The read-only collection reflects changes made to the original collection.
- To create a truly immutable collection, use `List.of()`, `Set.of()`, or `Map.of()` introduced in Java 9, which do not allow modifications to the original or the returned collection.

---

### Example of Immutable Collection (Java 9+):

```java
import java.util.List;

public class Main {
     public static void main(String[] args) {
          List<String> immutableList = List.of("Java", "Immutable", "Collection");

          System.out.println("Immutable List: " + immutableList);

          // Attempting to modify the immutable list
          try {
                immutableList.add("New Element"); // Throws UnsupportedOperationException
          } catch (UnsupportedOperationException e) {
                System.out.println("Cannot modify an immutable list!");
          }
     }
}
```

---

### Summary:
- Use `Collections.unmodifiableXXX()` for read-only wrappers.
- Use `List.of()`, `Set.of()`, or `Map.of()` for truly immutable collections (Java 9+).



## 38. What is `IdentityHashMap` in Java?

`IdentityHashMap` is a class in the Java Collections Framework that implements the `Map` interface. Unlike `HashMap`, which uses the `equals()` method to compare keys, `IdentityHashMap` uses the `==` operator to compare keys and values. This means that it compares the references of the objects, not their content.

### Key Features of `IdentityHashMap`:
1. **Reference Equality**:
    - Uses `==` for key and value comparison instead of `equals()`.
    - Two keys are considered equal only if they refer to the same object in memory.

2. **Performance**:
    - Slightly faster than `HashMap` for certain use cases because it avoids calling the `equals()` method.

3. **Use Case**:
    - Useful when reference equality is required, such as in caching or when working with proxies.

4. **Not Thread-Safe**:
    - Like `HashMap`, `IdentityHashMap` is not thread-safe. Use external synchronization if needed.

5. **Allows Null**:
    - Allows `null` keys and values.

---

### Example:

```java
import java.util.IdentityHashMap;

public class Main {
     public static void main(String[] args) {
          IdentityHashMap<String, String> map = new IdentityHashMap<>();

          // Adding key-value pairs
          String key1 = new String("Java");
          String key2 = new String("Java");

          map.put(key1, "Language");
          map.put(key2, "Platform");

          // Both keys are considered different because they are different objects
          System.out.println("Map Size: " + map.size()); // Output: 2
          System.out.println("Map: " + map); // Output: {Java=Language, Java=Platform}

          // Comparing with == operator
          System.out.println("key1 == key2: " + (key1 == key2)); // Output: false
     }
}
```

---

### Key Points:
1. **Reference Comparison**:
    - Unlike `HashMap`, which considers two keys equal if `key1.equals(key2)` is `true`, `IdentityHashMap` considers them equal only if `key1 == key2`.

2. **Memory Efficiency**:
    - Uses an array-based implementation, which may be more memory-efficient for small maps.

3. **Limitations**:
    - Not suitable for general-purpose maps where logical equality (`equals()`) is required.

---

### When to Use:
- Use `IdentityHashMap` when you need to distinguish between objects based on their memory reference rather than their content.
- Commonly used in frameworks or libraries that rely on object identity, such as serialization or dependency injection frameworks.

---

### Summary:
`IdentityHashMap` is a specialized map implementation that uses reference equality (`==`) for key and value comparison. It is useful in scenarios where object identity matters, but it is not a replacement for `HashMap` in general-purpose applications.



## 39. Difference Between `IdentityHashMap` and `WeakHashMap`

`IdentityHashMap` and `WeakHashMap` are both implementations of the `Map` interface in Java, but they serve different purposes and have distinct behaviors.

### Key Differences:

| Feature                  | `IdentityHashMap`                  | `WeakHashMap`                      |
|--------------------------|-------------------------------------|------------------------------------|
| **Key Comparison**       | Uses `==` for key comparison (reference equality) | Uses `equals()` for key comparison (logical equality) |
| **Garbage Collection**   | Does not support garbage collection of keys | Keys are weakly referenced and can be garbage collected when no strong references exist |
| **Use Case**             | Used when reference equality is required | Used for caching or memory-sensitive maps where keys can be garbage collected |
| **Thread Safety**        | Not thread-safe                    | Not thread-safe                    |
| **Null Keys/Values**     | Allows `null` keys and values      | Allows `null` keys and values      |

---

### Example of `IdentityHashMap`:

```java
import java.util.IdentityHashMap;

public class Main {
    public static void main(String[] args) {
        IdentityHashMap<String, String> map = new IdentityHashMap<>();

        String key1 = new String("Java");
        String key2 = new String("Java");

        map.put(key1, "Language");
        map.put(key2, "Platform");

        // Both keys are treated as different because IdentityHashMap uses reference equality
        System.out.println("IdentityHashMap: " + map); // Output: {Java=Language, Java=Platform}
    }
}
```

---

### Example of `WeakHashMap`:

```java
import java.util.WeakHashMap;

public class Main {
    public static void main(String[] args) {
        WeakHashMap<String, String> map = new WeakHashMap<>();

        String key1 = new String("Java");
        String key2 = new String("Python");

        map.put(key1, "Language");
        map.put(key2, "Language");

        // Removing strong reference to key1
        key1 = null;

        // Requesting garbage collection
        System.gc();

        // Waiting for garbage collection to complete
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Key1 may be garbage collected
        System.out.println("WeakHashMap: " + map); // Output: {Python=Language} (key1 may be removed)
    }
}
```

---

### Key Points:
1. **`IdentityHashMap`**:
   - Compares keys using `==` (reference equality).
   - Does not remove entries automatically based on garbage collection.

2. **`WeakHashMap`**:
   - Compares keys using `equals()` (logical equality).
   - Automatically removes entries when keys are no longer strongly referenced.

---

### When to Use:
- Use `IdentityHashMap` when you need to distinguish keys based on their memory reference.
- Use `WeakHashMap` for caching or memory-sensitive applications where keys should be garbage collected when no longer in use.

---

### Summary:
- `IdentityHashMap` is suitable for scenarios requiring reference equality.
- `WeakHashMap` is ideal for memory-sensitive maps where keys can be garbage collected.



## 40. Difference Between `Comparator` and `Comparable`

`Comparator` and `Comparable` are both interfaces in Java used for sorting objects, but they differ in their purpose and implementation.

### Key Differences:

| Feature                  | `Comparable`                       | `Comparator`                       |
|--------------------------|-------------------------------------|------------------------------------|
| **Purpose**              | Used to define the natural ordering of objects | Used to define custom ordering of objects |
| **Package**              | `java.lang`                        | `java.util`                        |
| **Method**               | `compareTo(Object o)`              | `compare(Object o1, Object o2)`    |
| **Implementation**       | Implemented by the class itself    | Implemented in a separate class    |
| **Modifies Original Class** | Yes, requires changes to the class | No, does not require changes to the class |
| **Number of Sorting Sequences** | Only one natural ordering can be defined | Multiple custom orderings can be defined |
| **Usage**                | Use when the class has a single, natural sorting order | Use when multiple sorting orders are needed |

---

### Example of `Comparable`:

```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Student implements Comparable<Student> {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Student other) {
        return Integer.compare(this.age, other.age); // Natural ordering by age
    }

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }
}

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 22));
        students.add(new Student("Bob", 20));
        students.add(new Student("Charlie", 25));

        Collections.sort(students); // Sort using natural ordering
        System.out.println("Sorted by age: " + students); // Output: [Bob (20), Alice (22), Charlie (25)]
    }
}
```

---

### Example of `Comparator`:

```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }
}

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 22));
        students.add(new Student("Bob", 20));
        students.add(new Student("Charlie", 25));

        // Custom comparator to sort by name
        Comparator<Student> nameComparator = (s1, s2) -> s1.getName().compareTo(s2.getName());

        Collections.sort(students, nameComparator); // Sort using custom comparator
        System.out.println("Sorted by name: " + students); // Output: [Alice (22), Bob (20), Charlie (25)]
    }
}
```

---

### Key Points:
1. **Use `Comparable`**:
   - When the class has a single natural sorting order.
   - Example: Sorting students by age.

2. **Use `Comparator`**:
   - When multiple sorting orders are needed.
   - Example: Sorting students by name or age.

3. **Flexibility**:
   - `Comparator` is more flexible as it allows custom sorting without modifying the original class.

---

### Summary:
- Use `Comparable` for natural ordering within the class.
- Use `Comparator` for custom or multiple sorting orders outside the class.



## 41. What is Deque and When to Use It?

A `Deque` (short for "Double-Ended Queue") is a linear data structure that allows elements to be added or removed from both ends. It is part of the `java.util` package and is an interface that extends the `Queue` interface.

### Key Features of Deque:
1. **Double-Ended Operations**:
    - Supports insertion and deletion at both the front and rear ends.
2. **Implementations**:
    - Common implementations include `ArrayDeque` and `LinkedList`.
3. **No Capacity Restrictions**:
    - `ArrayDeque` is resizable and does not have a fixed capacity.
4. **Thread Safety**:
    - Not thread-safe. Use `ConcurrentLinkedDeque` for thread-safe operations.

### When to Use Deque:
- **Stack Operations**:
  - Use `Deque` as a stack (LIFO) with methods like `push()` and `pop()`.
- **Queue Operations**:
  - Use `Deque` as a queue (FIFO) with methods like `offer()` and `poll()`.
- **Sliding Window Problems**:
  - Useful for maintaining a window of elements for algorithms like finding the maximum in a sliding window.
- **Palindrome Checking**:
  - Can be used to check if a sequence is a palindrome by comparing elements from both ends.

---

### Example: Using Deque as a Stack

```java
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
     public static void main(String[] args) {
          Deque<Integer> stack = new ArrayDeque<>();

          // Push elements onto the stack
          stack.push(10);
          stack.push(20);
          stack.push(30);

          // Pop elements from the stack
          System.out.println("Popped: " + stack.pop()); // Output: 30
          System.out.println("Popped: " + stack.pop()); // Output: 20
     }
}
```

---

### Example: Using Deque as a Queue

```java
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
     public static void main(String[] args) {
          Deque<Integer> queue = new ArrayDeque<>();

          // Add elements to the queue
          queue.offer(10);
          queue.offer(20);
          queue.offer(30);

          // Remove elements from the queue
          System.out.println("Polled: " + queue.poll()); // Output: 10
          System.out.println("Polled: " + queue.poll()); // Output: 20
     }
}
```

---

### Key Methods of Deque:
| Method                  | Description                                      |
|-------------------------|--------------------------------------------------|
| `addFirst(e)`           | Inserts the element at the front of the deque.  |
| `addLast(e)`            | Inserts the element at the rear of the deque.   |
| `removeFirst()`         | Removes and returns the first element.          |
| `removeLast()`          | Removes and returns the last element.           |
| `peekFirst()`           | Retrieves the first element without removing it.|
| `peekLast()`            | Retrieves the last element without removing it. |
| `push(e)`               | Pushes an element onto the stack (same as `addFirst`). |
| `pop()`                 | Pops an element from the stack (same as `removeFirst`). |

---

### Summary:
- Use `Deque` when you need a flexible data structure that supports both stack and queue operations.
- Choose `ArrayDeque` for better performance over `LinkedList` in most cases.
- For thread-safe operations, use `ConcurrentLinkedDeque`.


## 42. How to Remove an Object from a Collection?

In Java, you can remove an object from a collection using methods provided by the `Collection` interface, such as `remove(Object o)` or `removeIf(Predicate<? super E> filter)`. The exact method to use depends on the type of collection and the removal criteria.

### 1. **Using `remove(Object o)`**
This method removes the first occurrence of the specified object from the collection. It uses the `equals()` method to determine equality.

#### Example:
```java
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Java");
        list.add("Python");
        list.add("C++");

        // Removing an object
        boolean isRemoved = list.remove("Python");
        System.out.println("Is 'Python' removed? " + isRemoved); // Output: true
        System.out.println("Updated List: " + list); // Output: [Java, C++]
    }
}
```

---

### 2. **Using `removeIf(Predicate<? super E> filter)`**
This method removes all elements that satisfy the given predicate. It is useful for conditional removal.

#### Example:
```java
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Java");
        list.add("Python");
        list.add("C++");

        // Removing objects that start with 'J'
        list.removeIf(item -> item.startsWith("J"));
        System.out.println("Updated List: " + list); // Output: [Python, C++]
    }
}
```

---

### 3. **Using an Iterator**
When iterating over a collection, you can use the `Iterator`'s `remove()` method to safely remove elements without causing a `ConcurrentModificationException`.

#### Example:
```java
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Java");
        list.add("Python");
        list.add("C++");

        // Removing objects using an iterator
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            if (item.equals("C++")) {
                iterator.remove();
            }
        }
        System.out.println("Updated List: " + list); // Output: [Java, Python]
    }
}
```

---

### Key Points:
1. **`remove(Object o)`**:
   - Removes the first occurrence of the specified object.
   - Uses `equals()` for comparison.

2. **`removeIf(Predicate<? super E> filter)`**:
   - Removes elements based on a condition.
   - Introduced in Java 8.

3. **Iterator's `remove()`**:
   - Safely removes elements during iteration.
   - Prevents `ConcurrentModificationException`.

4. **Thread Safety**:
   - For thread-safe collections, use concurrent alternatives like `CopyOnWriteArrayList` or `ConcurrentHashMap`.

### Summary:
- Use `remove(Object o)` for single-object removal.
- Use `removeIf()` for conditional removal.
- Use an iterator's `remove()` for safe removal during iteration.


## 43. Difference Between `remove()` of Collection and Iterator

The `remove()` method is available in both the `Collection` interface and the `Iterator` interface, but they serve different purposes and have distinct behaviors.

### Key Differences:

| Feature                  | `remove()` of Collection           | `remove()` of Iterator             |
|--------------------------|-------------------------------------|------------------------------------|
| **Purpose**              | Removes a specific object from the collection | Removes the last element returned by the iterator |
| **Usage**                | Directly removes an object from the collection | Used during iteration to safely remove elements |
| **Method Signature**     | `boolean remove(Object o)`         | `void remove()`                    |
| **Condition**            | Uses `equals()` to find and remove the object | Can only remove the element returned by `next()` |
| **ConcurrentModificationException** | May throw if the collection is modified during iteration | Prevents `ConcurrentModificationException` when used correctly |
| **Thread Safety**        | Not inherently thread-safe         | Not inherently thread-safe         |

---

### Example of `remove()` in Collection:

```java
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Java");
        list.add("Python");
        list.add("C++");

        // Removing an object directly from the collection
        list.remove("Python");
        System.out.println("Updated List: " + list); // Output: [Java, C++]
    }
}
```

---

### Example of `remove()` in Iterator:

```java
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Java");
        list.add("Python");
        list.add("C++");

        // Removing an object using an iterator
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            if (item.equals("C++")) {
                iterator.remove(); // Safe removal
            }
        }
        System.out.println("Updated List: " + list); // Output: [Java, Python]
    }
}
```

---

### Key Points:
1. **`remove()` of Collection**:
   - Removes a specific object from the collection.
   - Can be used at any time but may throw `ConcurrentModificationException` if the collection is modified during iteration.

2. **`remove()` of Iterator**:
   - Removes the last element returned by the `next()` method.
   - Must be used during iteration and ensures safe removal without causing `ConcurrentModificationException`.

3. **When to Use**:
   - Use `remove()` of Collection for direct removal of elements.
   - Use `remove()` of Iterator for safe removal during iteration.

### Summary:
- The `remove()` method of Collection is for general-purpose removal, while the `remove()` method of Iterator is specifically designed for safe removal during iteration.



## 44. Difference Between `ArrayList` and `ArrayList<?>`

`ArrayList` and `ArrayList<?>` are both types of `ArrayList` in Java, but they differ in terms of type safety and usage.

### Key Differences:

| Feature                  | `ArrayList`                        | `ArrayList<?>`                     |
|--------------------------|-------------------------------------|------------------------------------|
| **Type**                 | Raw type (no generics)             | Wildcard type (unknown type)       |
| **Type Safety**          | No type safety; can store any type of object | Type-safe but cannot add elements (except `null`) |
| **Usage**                | Used in legacy code or when type is not specified | Used when the type is unknown but read-only access is required |
| **Warnings**             | Generates unchecked warnings during compilation | Does not generate warnings         |

---

### Example of `ArrayList` (Raw Type):

```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList list = new ArrayList(); // Raw type
        list.add("Java");
        list.add(42); // Allows adding any type of object
        System.out.println(list); // Output: [Java, 42]
    }
}
```

- **Key Point**: Using raw types is discouraged because it bypasses type safety and can lead to runtime errors.

---

### Example of `ArrayList<?>` (Wildcard Type):

```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("Java");

        ArrayList<?> wildcardList = stringList; // Wildcard type
        System.out.println(wildcardList.get(0)); // Output: Java

        // wildcardList.add("Python"); // Compilation error: Cannot add elements
        wildcardList.add(null); // Only null can be added
    }
}
```

- **Key Point**: `ArrayList<?>` is read-only for elements of unknown type, ensuring type safety.

---

### When to Use:
- **`ArrayList`**:
  - Avoid using raw types unless working with legacy code.
  - Use generic types (e.g., `ArrayList<String>`) for type safety.

- **`ArrayList<?>`**:
  - Use when you need to work with collections of unknown types, especially in methods or APIs that accept multiple types.

---

### Summary:
- `ArrayList` (raw type) is not type-safe and should generally be avoided.
- `ArrayList<?>` (wildcard type) is type-safe but read-only for unknown types, making it useful for generic programming.


## 45. Difference Between `PriorityQueue` and `TreeSet`

`PriorityQueue` and `TreeSet` are both part of the Java Collections Framework and are used to store elements in a specific order. However, they differ in terms of functionality, use cases, and underlying implementation.

### Key Differences:

| Feature                  | `PriorityQueue`                    | `TreeSet`                          |
|--------------------------|-------------------------------------|------------------------------------|
| **Ordering**             | Maintains elements in priority order (natural or custom) | Maintains elements in sorted order |
| **Duplicates**           | Allows duplicate elements          | Does not allow duplicate elements  |
| **Underlying Data Structure** | Binary heap                      | Red-black tree                     |
| **Access to Elements**   | Provides access to the highest/lowest priority element | Provides access to all elements in sorted order |
| **Null Elements**        | Does not allow `null` elements     | Does not allow `null` elements     |
| **Performance**          | Faster for priority-based operations (O(log n) for insertion/removal) | Slower for sorted operations (O(log n) for insertion/removal) |
| **Use Case**             | Use for priority-based processing  | Use for maintaining a sorted set of unique elements |

---

### Example of `PriorityQueue`:

```java
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Adding elements
        pq.add(10);
        pq.add(5);
        pq.add(20);

        // Accessing and removing elements based on priority
        System.out.println("Poll: " + pq.poll()); // Output: 5 (smallest element)
        System.out.println("Poll: " + pq.poll()); // Output: 10
        System.out.println("Poll: " + pq.poll()); // Output: 20
    }
}
```

---

### Example of `TreeSet`:

```java
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet<>();

        // Adding elements
        treeSet.add(10);
        treeSet.add(5);
        treeSet.add(20);

        // Accessing elements in sorted order
        System.out.println("TreeSet: " + treeSet); // Output: [5, 10, 20]

        // Accessing specific elements
        System.out.println("First: " + treeSet.first()); // Output: 5
        System.out.println("Last: " + treeSet.last());   // Output: 20
    }
}
```

---

### When to Use:
- **`PriorityQueue`**:
  - Use when you need to process elements based on their priority, such as in task scheduling or implementing a min-heap or max-heap.

- **`TreeSet`**:
  - Use when you need to maintain a sorted set of unique elements and perform operations like range queries or sorted traversal.

---

### Summary:
- `PriorityQueue` is ideal for priority-based processing and allows duplicates.
- `TreeSet` is ideal for maintaining a sorted set of unique elements and provides efficient access to the smallest or largest elements.



## 46. How to Avoid Unchecked Cast Warning?

The unchecked cast warning in Java occurs when you cast a generic type without ensuring type safety. This warning is generated because the compiler cannot verify the correctness of the cast at runtime due to type erasure.

### Ways to Avoid Unchecked Cast Warning:

1. **Use Generics Properly**:
    - Ensure that you use generics consistently to avoid the need for casting.
    - Example:
      ```java
      List<String> list = new ArrayList<>();
      list.add("Java");
      String value = list.get(0); // No cast needed
      ```

2. **Suppress Warnings with `@SuppressWarnings("unchecked")`**:
    - Use this annotation to suppress the warning when you are certain the cast is safe.
    - Example:
      ```java
      @SuppressWarnings("unchecked")
      public <T> List<T> castList(Object obj) {
            return (List<T>) obj; // Suppress unchecked cast warning
      }
      ```

3. **Use `instanceof` to Check Type Before Casting**:
    - Verify the type of the object before performing the cast.
    - Example:
      ```java
      Object obj = new ArrayList<String>();
      if (obj instanceof List) {
            List<String> list = (List<String>) obj; // Safe cast
      }
      ```

4. **Use `Class` Objects for Type Safety**:
    - Pass a `Class` object to ensure type safety during casting.
    - Example:
      ```java
      public <T> T castObject(Object obj, Class<T> clazz) {
            if (clazz.isInstance(obj)) {
                 return clazz.cast(obj); // Safe cast
            }
            throw new ClassCastException("Invalid type");
      }
      ```

5. **Avoid Raw Types**:
    - Do not use raw types like `List` or `Map` without specifying a generic type.
    - Example:
      ```java
      // Avoid this
      List list = new ArrayList();
      list.add("Java");

      // Use this
      List<String> list = new ArrayList<>();
      list.add("Java");
      ```

### Key Points:
- Always use generics to ensure type safety and avoid unchecked casts.
- Suppress warnings only when you are confident the cast is safe.
- Use `instanceof` or `Class` objects to validate types before casting.

Unchecked cast warnings indicate potential runtime issues, so addressing them properly ensures safer and more maintainable code.



## 47. What is the Diamond Operator in Java?

The **diamond operator (`<>`)** in Java is a feature introduced in Java 7 to simplify the use of generics. It allows the compiler to infer the type parameters of a generic class or method, reducing boilerplate code and improving readability.

### Key Features:
1. **Type Inference**:
    - The compiler automatically infers the type arguments based on the context, so you don't need to explicitly specify them.

2. **Simplifies Code**:
    - Reduces redundancy when creating instances of generic classes.

3. **Introduced In**:
    - Java 7 as part of Project Coin.

---

### Example Without Diamond Operator (Pre-Java 7):

```java
import java.util.ArrayList;
import java.util.List;

public class Main {
     public static void main(String[] args) {
          // Explicitly specifying the type arguments
          List<String> list = new ArrayList<String>();
          list.add("Java");
          list.add("Generics");
          System.out.println(list);
     }
}
```

---

### Example With Diamond Operator (Java 7+):

```java
import java.util.ArrayList;
import java.util.List;

public class Main {
     public static void main(String[] args) {
          // Using the diamond operator
          List<String> list = new ArrayList<>();
          list.add("Java");
          list.add("Generics");
          System.out.println(list);
     }
}
```

---

### Key Points:
1. **Type Safety**:
    - The diamond operator ensures type safety by inferring the type arguments from the variable declaration.

2. **Limitations**:
    - Cannot be used with anonymous inner classes. For example:
      ```java
      List<String> list = new ArrayList<>() {
            // Anonymous inner class requires explicit type arguments
      };
      ```

3. **Improves Readability**:
    - Reduces verbosity, especially when working with nested generics.

---

### When to Use:
- Use the diamond operator whenever possible to simplify the creation of generic objects and improve code readability.

---

### Summary:
The diamond operator (`<>`) is a shorthand for specifying generic types, introduced in Java 7. It allows the compiler to infer type arguments, reducing boilerplate code and making generics easier to use.



## 48. What is Covariant Method Overriding?

Covariant method overriding in Java refers to the ability of a subclass to override a method and change its return type to a subclass of the return type declared in the parent class. This feature was introduced in Java 5 and allows for more specific return types in overridden methods.

### Key Features:
1. **Return Type**:
    - The return type of the overriding method in the subclass must be a subclass (or subtype) of the return type of the method in the parent class.

2. **Compile-Time Safety**:
    - Covariant return types improve type safety by allowing more specific return types without requiring explicit casting.

3. **Polymorphism**:
    - Covariant overriding works seamlessly with polymorphism, ensuring that the overridden method in the subclass is called at runtime.

---

### Example:

```java
class Parent {
     public Number getValue() {
          return 42; // Returns a Number
     }
}

class Child extends Parent {
     @Override
     public Integer getValue() {
          return 42; // Returns an Integer (subclass of Number)
     }
}

public class Main {
     public static void main(String[] args) {
          Parent parent = new Parent();
          System.out.println("Parent: " + parent.getValue()); // Output: 42

          Parent child = new Child();
          System.out.println("Child: " + child.getValue()); // Output: 42
     }
}
```

---

### Key Points:
1. **Covariant Return Types**:
    - The overriding method can return a more specific type, making the code more flexible and type-safe.

2. **Rules**:
    - The method signature (except for the return type) must remain the same.
    - The return type in the subclass must be a subtype of the return type in the parent class.

3. **Advantages**:
    - Eliminates the need for explicit casting when working with overridden methods.
    - Enhances code readability and maintainability.

---

### When to Use:
- Use covariant overriding when you want to provide a more specific return type in a subclass while maintaining compatibility with the parent class.

---

### Summary:
Covariant method overriding allows a subclass to override a method and return a more specific type than the parent class. This feature improves type safety and eliminates the need for explicit casting, making the code cleaner and more intuitive.


## 49. Difference Between Bounded and Unbounded Wildcards in Generics

In Java generics, wildcards are used to represent unknown types. They can be bounded (restricted to a specific range of types) or unbounded (no restrictions). Understanding the difference between bounded and unbounded wildcards is crucial for writing flexible and type-safe generic code.

### Key Differences:

| Feature                  | Bounded Wildcards                  | Unbounded Wildcards                |
|--------------------------|-------------------------------------|------------------------------------|
| **Definition**           | Wildcards with upper (`? extends`) or lower (`? super`) bounds | Wildcards without any bounds (`?`) |
| **Usage**                | Used when the type is restricted to a specific range | Used when the type is completely unknown |
| **Flexibility**          | More restrictive                  | More flexible                      |
| **Read/Write Operations**| Allows reading or writing based on bounds | Allows reading but restricts writing (except `null`) |

---

### 1. **Bounded Wildcards**

Bounded wildcards restrict the type of objects that can be used. They can be upper-bounded (`? extends T`) or lower-bounded (`? super T`).

#### **Upper-Bounded Wildcards (`? extends T`)**:
- Represents a type that is `T` or a subclass of `T`.
- Allows reading elements as type `T` but restricts writing.

#### Example:
```java
import java.util.List;

public class Main {
    public static void printNumbers(List<? extends Number> list) {
        for (Number num : list) {
            System.out.println(num);
        }
        // list.add(10); // Compilation error: Cannot add elements
    }

    public static void main(String[] args) {
        List<Integer> integers = List.of(1, 2, 3);
        printNumbers(integers); // Works because Integer is a subclass of Number
    }
}
```

---

#### **Lower-Bounded Wildcards (`? super T`)**:
- Represents a type that is `T` or a superclass of `T`.
- Allows writing elements of type `T` but restricts reading.

#### Example:
```java
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void addNumbers(List<? super Integer> list) {
        list.add(1);
        list.add(2);
        // Integer num = list.get(0); // Compilation error: Cannot guarantee the type
    }

    public static void main(String[] args) {
        List<Number> numbers = new ArrayList<>();
        addNumbers(numbers); // Works because Number is a superclass of Integer
        System.out.println(numbers); // Output: [1, 2]
    }
}
```

---

### 2. **Unbounded Wildcards**

Unbounded wildcards (`?`) represent an unknown type with no restrictions. They are useful when the type is irrelevant or when you only need to access elements without modifying the collection.

#### Example:
```java
import java.util.List;

public class Main {
    public static void printList(List<?> list) {
        for (Object item : list) {
            System.out.println(item);
        }
        // list.add("Java"); // Compilation error: Cannot add elements
    }

    public static void main(String[] args) {
        List<String> strings = List.of("Java", "Generics");
        printList(strings); // Works with any type of list
    }
}
```

---

### Key Points:
1. **Bounded Wildcards**:
   - Use `? extends T` when you need to read elements as type `T`.
   - Use `? super T` when you need to write elements of type `T`.

2. **Unbounded Wildcards**:
   - Use `?` when the type is irrelevant, and you only need to access elements without modifying the collection.

3. **When to Use**:
   - Use bounded wildcards for more specific type constraints.
   - Use unbounded wildcards for maximum flexibility when the type is unknown.

---

### Summary:
- **Bounded Wildcards**: Restrict the type to a specific range (`? extends` or `? super`).
- **Unbounded Wildcards**: Represent an unknown type with no restrictions (`?`).
- Choose the appropriate wildcard based on whether you need to read, write, or both.
