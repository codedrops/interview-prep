
# JavaScript Interview Q&A


## Table of Contents

1. [JavaScript Data Types](#1-javascript-data-types)
2. [What is Temporal Dead Zone (TDZ)?](#2-what-is-temporal-dead-zone-tdz)
3. [What is Hoisting?](#3-what-is-hoisting)
4. [How to Avoid Hoisting?](#4-how-to-avoid-hoisting)
5. [Difference Between `==` and `===`](#5-difference-between--and-)
6. [Difference Between `var`, `let`, and `const`](#6-difference-between-var-let-and-const)
7. [Type Coercion](#8-type-coercion)
8. [Is JavaScript Statically Typed or Dynamically Typed?](#9-is-javascript-statically-typed-or-dynamically-typed)
9. [NaN](#10-nan)
10. [Passed by Value and Passed by Reference](#11-passed-by-value-and-passed-by-reference)
11. [Immediately Invoked Function Expression (IIFE)](#12-immediately-invoked-function-expression-iife)
12. [What is Strict Mode?](#13-what-is-strict-mode)
13. [Higher Order Functions](#14-higher-order-functions)
14. [The `this` Keyword](#15-the-this-keyword)
15. [`call`, `apply`, and `bind` Methods](#16-call-apply-and-bind-methods)
16. [Difference Between `exec()` and `test()` Methods](#17-difference-between-exec-and-test-methods)
17. [What is Currying?](#18-what-is-currying)
18. [Scope and Scope Chain](#19-scope-and-scope-chain)
19. [Closures](#20-closures)
20. [What are Object Prototypes?](#21-what-are-object-prototypes)
21. [What are Callbacks?](#22-what-are-callbacks)
22. [What is Memoization?](#23-what-is-memoization)
23. [Constructor Functions](#24-constructor-functions)
24. [Must-Know JavaScript Array Methods](#25-must-know-javascript-array-methods)
25. [Must-Know JavaScript String Methods](#26-must-know-javascript-string-methods)
26. [Must-Know JavaScript Object Methods](#27-must-know-javascript-object-methods)
27. [What is an Arrow Function?](#28-what-is-an-arrow-function)
28. [Rest Parameter and Spread Operator](#29-rest-parameter-and-spread-operator)
29. [Deep Copy of an Object with Spread Operator](#30-deep-copy-of-an-object-with-spread-operator)
30. [Shallow Copy vs Deep Copy](#31-shallow-copy-vs-deep-copy)
31. [Object Destructuring](#32-object-destructuring)
32. [Array Destructuring](#33-array-destructuring)
33. [WeakMap](#34-weakmap)
34. [Map and Set](#35-map-and-set)
35. [Generator Functions](#36-generator-functions)
36. [Set and WeakSet](#37-set-and-weakset)
37. [Promises](#38-promises)
38. [Async/Await](#39-asyncawait)
39. [What are Pure Functions?](#40-what-are-pure-functions)
40. [What is Functional Programming?](#41-what-is-functional-programming)
41. [Function Composition](#42-function-composition)
42. [Object Prototypes](#43-object-prototypes)
43. [Classes](#44-classes)
44. [Currying and Partial Application](#45-currying-and-partial-application)
45. [Truthy and Falsy Values](#46-truthy-and-falsy-values)


## 1. JavaScript Data Types

JavaScript provides different types of data that can be used to store and manipulate values. These are categorized into two main types: **Primitive** and **Non-Primitive (Reference)**.

#### Primitive Data Types:
1. **Number**: Represents numeric values (both integers and floating-point numbers).
    ```javascript
    let age = 25; // Integer
    let price = 99.99; // Floating-point
    ```
2. **String**: Represents textual data.
    ```javascript
    let name = "John Doe";
    ```
3. **Boolean**: Represents logical values: `true` or `false`.
    ```javascript
    let isLoggedIn = true;
    ```
4. **Undefined**: A variable that has been declared but not assigned a value.
    ```javascript
    let x;
    console.log(x); // Output: undefined
    ```
5. **Null**: Represents an explicitly empty or non-existent value.
    ```javascript
    let y = null;
    ```
6. **Symbol**: Represents a unique and immutable value, often used as object keys.
    ```javascript
    let sym = Symbol("unique");
    ```
7. **BigInt**: Represents integers with arbitrary precision.
    ```javascript
    let bigNumber = 123456789012345678901234567890n;
    ```

#### Non-Primitive (Reference) Data Types:
1. **Object**: Used to store collections of data and more complex entities.
    ```javascript
    let person = { name: "Alice", age: 30 };
    ```
2. **Array**: A special type of object used to store ordered collections.
    ```javascript
    let numbers = [1, 2, 3, 4];
    ```
3. **Function**: A block of code designed to perform a particular task.
    ```javascript
    function greet() {
         console.log("Hello, World!");
    }
    ```

#### Explanation:
- Primitive types are immutable and stored by value.
- Non-primitive types are mutable and stored by reference.
- JavaScript is dynamically typed, meaning variables can hold any data type and can change types during execution.


## 2. What is Temporal Dead Zone (TDZ)?

The Temporal Dead Zone (TDZ) refers to the time between the entering of a block scope and the actual declaration of a variable (using `let` or `const`) within that scope. During this time, the variable is in an uninitialized state and accessing it will result in a `ReferenceError`.

#### Example:

```javascript
// Using var
console.log(a); // Output: undefined (hoisted but uninitialized)
var a = 10;
console.log(a); // Output: 10

// Using let
console.log(b); // ReferenceError: Cannot access 'b' before initialization
let b = 20;
console.log(b); // Output: 20

// Using const
console.log(c); // ReferenceError: Cannot access 'c' before initialization
const c = 30;
console.log(c); // Output: 30
```

#### Explanation:
1. **`var`**: Variables declared with `var` are hoisted and initialized with `undefined`. Accessing them before their declaration does not throw an error.
2. **`let` and `const`**: Variables declared with `let` and `const` are also hoisted but are not initialized. They remain in the TDZ from the start of the block until the declaration is encountered. Accessing them during this period throws a `ReferenceError`.


## 3. What is Hoisting?

Hoisting is a JavaScript mechanism where variables, function declarations, and classes are moved to the top of their scope during the compile phase. This allows these entities to be used before they are declared in the code.

#### Key Points:
1. **Variable Declarations**:
    - Variables declared with `var` are hoisted and initialized with `undefined`.
    - Variables declared with `let` and `const` are hoisted but are not initialized, leading to the Temporal Dead Zone (TDZ).

2. **Function Declarations**:
    - Function declarations are hoisted along with their definitions, meaning they can be invoked before their declaration in the code.

3. **Class Declarations**:
    - Classes are hoisted but are not initialized, so accessing them before their declaration results in a `ReferenceError`.

#### Examples:

1. **Variable Hoisting**:
    ```javascript
    console.log(x); // Output: undefined
    var x = 5;

    console.log(y); // ReferenceError: Cannot access 'y' before initialization
    let y = 10;
    ```

2. **Function Hoisting**:
    ```javascript
    greet(); // Output: Hello, World!

    function greet() {
         console.log("Hello, World!");
    }
    ```

3. **Class Hoisting**:
    ```javascript
    const obj = new MyClass(); // ReferenceError: Cannot access 'MyClass' before initialization

    class MyClass {
         constructor() {
              this.name = "Example";
         }
    }
    ```

#### Explanation:
- Hoisting allows for the use of functions and variables before they are declared, but the behavior differs based on the type of declaration (`var`, `let`, `const`, function, or class).
- Understanding hoisting helps avoid unexpected errors and improves code readability.



## 4. How to Avoid Hoisting?

To avoid issues caused by hoisting, follow these best practices:

1. **Declare Variables at the Top of Their Scope**:
    Always declare variables at the beginning of their scope to make the code more predictable and easier to read.
    ```javascript
    function example() {
         let x = 10; // Declare at the top
         console.log(x); // Output: 10
    }
    ```

2. **Use `let` and `const` Instead of `var`**:
    Avoid using `var` as it is hoisted and initialized with `undefined`. Use `let` and `const` to ensure variables are not accessible before their declaration.
    ```javascript
    let x = 5; // Use let
    const y = 10; // Use const
    ```

3. **Declare Functions Before Calling Them**:
    Always declare functions before invoking them to avoid confusion, even though function declarations are hoisted.
    ```javascript
    function greet() {
         console.log("Hello, World!");
    }
    greet(); // Output: Hello, World!
    ```

4. **Avoid Implicit Globals**:
    Always declare variables explicitly to avoid creating global variables unintentionally, which can lead to hoisting-related issues.
    ```javascript
    // Avoid this
    x = 10; // Implicit global variable

    // Use this
    let x = 10; // Explicit declaration
    ```

5. **Use Strict Mode**:
    Enable strict mode in your code to catch common mistakes and prevent the use of undeclared variables.
    ```javascript
    "use strict";
    let x = 10;
    console.log(x); // Output: 10
    ```

## 5. Difference Between `==` and `===`

In JavaScript, `==` and `===` are comparison operators used to compare two values. However, they differ in how they perform the comparison.

#### `==` (Equality Operator):
- Compares two values for equality after performing type conversion (if necessary).
- It is less strict because it allows type coercion.

#### Example:
```javascript
console.log(5 == "5"); // Output: true (type coercion occurs)
console.log(null == undefined); // Output: true
console.log(true == 1); // Output: true
```

#### `===` (Strict Equality Operator):
- Compares two values for equality without performing type conversion.
- It is more strict because it checks both the value and the type.

#### Example:
```javascript
console.log(5 === "5"); // Output: false (no type coercion)
console.log(null === undefined); // Output: false
console.log(true === 1); // Output: false
```

#### Key Differences:
| Feature                | `==` (Equality) | `===` (Strict Equality) |
|------------------------|-----------------|--------------------------|
| Type Conversion        | Yes             | No                       |
| Comparison Strictness  | Less strict     | More strict              |
| Use Case               | Loose comparison| Precise comparison       |

#### Best Practice:
- Use `===` for comparisons to avoid unexpected results caused by type coercion.
- Use `==` only when type conversion is explicitly desired.

#### Example of Best Practice:
```javascript
let a = "5";
let b = 5;

console.log(a === b); // Output: false (strict comparison)
console.log(a == b);  // Output: true (loose comparison)
```

## 6. Difference Between `var`, `let`, and `const`

In JavaScript, `var`, `let`, and `const` are used to declare variables, but they differ in their scope, hoisting behavior, and mutability.

#### `var`:
- **Scope**: Function-scoped.
- **Hoisting**: Variables declared with `var` are hoisted and initialized with `undefined`.
- **Re-declaration**: Allowed within the same scope.
- **Use Case**: Avoid using `var` in modern JavaScript due to its function-scoping and potential for bugs.

#### Example:
```javascript
function example() {
    console.log(a); // Output: undefined
    var a = 10;
    console.log(a); // Output: 10
}
example();
```

#### `let`:
- **Scope**: Block-scoped.
- **Hoisting**: Variables declared with `let` are hoisted but not initialized, leading to the Temporal Dead Zone (TDZ).
- **Re-declaration**: Not allowed within the same scope.
- **Use Case**: Use `let` for variables that need to be reassigned.

#### Example:
```javascript
{
    let x = 10;
    console.log(x); // Output: 10
    x = 20;
    console.log(x); // Output: 20
}
```

#### `const`:
- **Scope**: Block-scoped.
- **Hoisting**: Variables declared with `const` are hoisted but not initialized, leading to the Temporal Dead Zone (TDZ).
- **Re-declaration**: Not allowed within the same scope.
- **Mutability**: The variable itself cannot be reassigned, but if it holds an object or array, the contents of the object or array can be modified.
- **Use Case**: Use `const` for variables that should not be reassigned.

#### Example:
```javascript
{
    const y = 30;
    console.log(y); // Output: 30
    // y = 40; // Error: Assignment to constant variable

    const obj = { name: "Alice" };
    obj.name = "Bob"; // Allowed
    console.log(obj.name); // Output: Bob
}
```

#### Key Differences:
| Feature                | `var`            | `let`           | `const`          |
|------------------------|------------------|-----------------|------------------|
| Scope                 | Function-scoped  | Block-scoped    | Block-scoped     |
| Hoisting              | Yes (initialized with `undefined`) | Yes (TDZ applies) | Yes (TDZ applies) |
| Re-declaration        | Allowed          | Not allowed     | Not allowed      |
| Reassignment          | Allowed          | Allowed         | Not allowed      |

#### Best Practice:
- Use `const` by default for variables that do not need reassignment.
- Use `let` for variables that need to be reassigned.
- Avoid using `var` in modern JavaScript.

#### Example of Best Practice:
```javascript
const MAX_USERS = 100; // Use const for constants
let currentUsers = 0; // Use let for variables that change
currentUsers += 1;
console.log(currentUsers); // Output: 1
```

## 8. Type Coercion

Type coercion refers to the automatic or implicit conversion of values from one data type to another. This occurs when an operation involves values of different types, and JavaScript attempts to convert one or both values to a common type.

#### Types of Coercion:
1. **Implicit Coercion**: Performed automatically by JavaScript.
2. **Explicit Coercion**: Performed manually by the developer.

#### Implicit Coercion Examples:
1. **String Coercion**:
    ```javascript
    console.log("5" + 2); // Output: "52" (number 2 is coerced to a string)
    console.log("5" - 2); // Output: 3 (string "5" is coerced to a number)
    ```

2. **Boolean Coercion**:
    ```javascript
    console.log(!!1); // Output: true (1 is coerced to true)
    console.log(!!0); // Output: false (0 is coerced to false)
    console.log(!!""); // Output: false (empty string is coerced to false)
    ```

3. **Number Coercion**:
    ```javascript
    console.log("5" * 2); // Output: 10 (string "5" is coerced to a number)
    console.log("5" / 2); // Output: 2.5 (string "5" is coerced to a number)
    ```

#### Explicit Coercion Examples:
1. **To String**:
    ```javascript
    let num = 10;
    console.log(String(num)); // Output: "10"
    ```

2. **To Number**:
    ```javascript
    let str = "123";
    console.log(Number(str)); // Output: 123
    ```

3. **To Boolean**:
    ```javascript
    let value = 0;
    console.log(Boolean(value)); // Output: false
    ```

#### Explanation:
- Implicit coercion can lead to unexpected results if not understood properly.
- Explicit coercion is more predictable and should be preferred when converting types.

#### Best Practices:
- Use explicit coercion to avoid confusion and improve code readability.
- Be cautious with implicit coercion, especially when using operators like `+`, `-`, `*`, and `/`.

## 9. Is JavaScript Statically Typed or Dynamically Typed?

JavaScript is a **dynamically typed** language. This means that variables are not bound to a specific data type, and their type can change during runtime.

#### Key Characteristics of Dynamically Typed Languages:
1. **No Type Declaration**:
    - Variables in JavaScript do not require a type to be declared.
    - The type is determined automatically based on the value assigned.
    ```javascript
    let x = 10; // x is a number
    x = "Hello"; // Now x is a string
    ```

2. **Type Checking at Runtime**:
    - Type errors are not caught during compilation but may occur during execution.
    ```javascript
    let y = 5;
    console.log(y.toUpperCase()); // TypeError: y.toUpperCase is not a function
    ```

3. **Flexibility**:
    - JavaScript allows reassignment of variables to values of different types.
    ```javascript
    let z = true;
    z = 42; // No error
    ```

#### Comparison with Statically Typed Languages:
- In statically typed languages (e.g., Java, C++), variables must be declared with a specific type, and type checking is done at compile time.
- JavaScript's dynamic typing provides flexibility but can lead to runtime errors if types are not handled carefully.

#### Best Practices for Working with Dynamic Typing:
1. **Use Descriptive Variable Names**:
    - Clearly indicate the purpose of the variable to avoid confusion.
    ```javascript
    let userAge = 25; // Clear and descriptive
    ```

2. **Use Type Checking**:
    - Use `typeof` or libraries like TypeScript to check or enforce types.
    ```javascript
    let value = "Hello";
    if (typeof value === "string") {
         console.log("Value is a string");
    }
    ```

3. **Adopt TypeScript**:
    - TypeScript is a superset of JavaScript that adds static typing, helping catch type-related errors during development.


## 10. NaN

`NaN` stands for "Not-a-Number" and is a special value in JavaScript that indicates an invalid number. It is a property of the global object and is returned when a mathematical operation or function fails to produce a valid number.

#### Characteristics of `NaN`:
1. **Type**: The type of `NaN` is `number`.
    ```javascript
    console.log(typeof NaN); // Output: "number"
    ```
2. **Self-inequality**: `NaN` is the only value in JavaScript that is not equal to itself.
    ```javascript
    console.log(NaN === NaN); // Output: false
    ```

#### Common Scenarios Producing `NaN`:
1. **Invalid Mathematical Operations**:
    ```javascript
    console.log(0 / 0); // Output: NaN
    console.log(Math.sqrt(-1)); // Output: NaN
    ```
2. **Parsing Invalid Numbers**:
    ```javascript
    console.log(Number("abc")); // Output: NaN
    console.log(parseInt("xyz")); // Output: NaN
    ```
3. **Operations with `undefined`**:
    ```javascript
    let x;
    console.log(x + 5); // Output: NaN
    ```

#### Checking for `NaN`:
Since `NaN` is not equal to itself, you cannot use equality operators to check for it. Instead, use the `isNaN()` function or `Number.isNaN()` method:
1. **Using `isNaN()`**:
    ```javascript
    console.log(isNaN("abc")); // Output: true
    console.log(isNaN(123));   // Output: false
    ```
2. **Using `Number.isNaN()`**:
    ```javascript
    console.log(Number.isNaN(NaN)); // Output: true
    console.log(Number.isNaN("abc")); // Output: false
    ```

#### Best Practices:
- Use `Number.isNaN()` for precise checks, as it does not perform type coercion like `isNaN()`.
- Handle potential `NaN` values in your code to avoid unexpected behavior.

By understanding and properly handling `NaN`, you can write more robust JavaScript code.

## 11. Passed by Value and Passed by Reference

In JavaScript, variables can be passed by value or by reference depending on the type of data they hold. Understanding this distinction is crucial for avoiding unintended side effects in your code.

#### Passed by Value:
- **Definition**: When a variable is passed by value, a copy of the value is passed to the function or assigned to another variable. Changes made to the copy do not affect the original value.
- **Applies to**: Primitive data types (`Number`, `String`, `Boolean`, `Undefined`, `Null`, `Symbol`, `BigInt`).

#### Example:
```javascript
let a = 10;
let b = a; // Copy of the value is assigned
b = 20; // Changing b does not affect a
console.log(a); // Output: 10
console.log(b); // Output: 20
```

#### Passed by Reference:
- **Definition**: When a variable is passed by reference, a reference (or memory address) to the original value is passed. Changes made to the reference affect the original value.
- **Applies to**: Non-primitive data types (`Object`, `Array`, `Function`).

#### Example:
```javascript
let obj1 = { name: "Alice" };
let obj2 = obj1; // Reference to the same object is assigned
obj2.name = "Bob"; // Changing obj2 affects obj1
console.log(obj1.name); // Output: Bob
console.log(obj2.name); // Output: Bob
```

#### Key Differences:
| Feature                | Passed by Value          | Passed by Reference       |
|------------------------|--------------------------|---------------------------|
| Data Type             | Primitive types          | Non-primitive types       |
| Copy or Reference      | Creates a copy           | Shares the same reference |
| Effect of Changes      | No effect on original    | Affects the original      |

#### Best Practices:
1. **Avoid Unintended Mutations**:
    - Use `Object.assign()` or the spread operator (`...`) to create a shallow copy of objects.
    ```javascript
    let obj1 = { name: "Alice" };
    let obj2 = { ...obj1 }; // Creates a shallow copy
    obj2.name = "Bob";
    console.log(obj1.name); // Output: Alice
    ```

2. **Use Immutable Data Structures**:
    - Libraries like `Immutable.js` can help manage state without unintended mutations.

## 12. Immediately Invoked Function Expression (IIFE)

An **Immediately Invoked Function Expression (IIFE)** is a JavaScript function that is executed immediately after it is defined. It is a common pattern used to create a new scope and avoid polluting the global namespace.

#### Syntax:
An IIFE is defined using a function expression enclosed in parentheses, followed by another set of parentheses to invoke it.

```javascript
(function() {
    // Code inside the IIFE
    console.log("IIFE executed!");
})();
```

Alternatively, you can use the arrow function syntax for an IIFE:

```javascript
(() => {
    console.log("IIFE with arrow function executed!");
})();
```

#### Example:
```javascript
(function() {
    let message = "Hello, IIFE!";
    console.log(message); // Output: Hello, IIFE!
})();

// The variable `message` is not accessible outside the IIFE
console.log(typeof message); // Output: undefined
```

#### Explanation:
1. **Encapsulation**:
   - Variables and functions defined inside an IIFE are not accessible outside of it, preventing conflicts with other code.
2. **Avoid Global Scope Pollution**:
   - IIFEs are often used in JavaScript to create a private scope for variables and functions, especially in older codebases before the introduction of ES6 modules.
3. **Execution Context**:
   - The function is executed immediately after it is defined, making it useful for initialization tasks.

#### Use Cases:
1. **Module Pattern**:
   - IIFEs can be used to create modules that encapsulate private data and expose only the necessary parts.
   ```javascript
   const myModule = (function() {
       let privateVar = "I am private";
       return {
           publicMethod: function() {
               console.log(privateVar);
           }
       };
   })();

   myModule.publicMethod(); // Output: I am private
   ```

2. **Initialization Code**:
   - IIFEs are useful for running setup or initialization code without leaving variables in the global scope.
   ```javascript
   (function() {
       console.log("Initialization code executed!");
   })();
   ```

## 13. What is Strict Mode?

Strict mode in JavaScript is a way to opt into a restricted variant of JavaScript, introduced in ECMAScript 5. It helps catch common coding mistakes and prevents the use of certain unsafe features of JavaScript.

#### Enabling Strict Mode:
Strict mode can be enabled by adding the string `"use strict";` at the beginning of a script or a function.

1. **For the Entire Script**:
    ```javascript
    "use strict";
    let x = 10;
    console.log(x); // Output: 10
    ```

2. **For a Specific Function**:
    ```javascript
    function myFunction() {
        "use strict";
        let y = 20;
        console.log(y); // Output: 20
    }
    ```

#### Benefits of Strict Mode:
1. **Eliminates Silent Errors**:
    - Converts silent errors into throw errors, making debugging easier.
    ```javascript
    "use strict";
    x = 10; // ReferenceError: x is not defined
    ```

2. **Prevents Accidental Globals**:
    - Variables must be explicitly declared using `let`, `const`, or `var`.
    ```javascript
    "use strict";
    myVar = 5; // ReferenceError: myVar is not defined
    ```

3. **Disallows Duplicates**:
    - Duplicate parameter names or object properties are not allowed.
    ```javascript
    "use strict";
    function sum(a, a) { // SyntaxError: Duplicate parameter name not allowed
        return a + a;
    }
    ```

4. **Restricts `this` Keyword**:
    - In strict mode, `this` is `undefined` in functions that are not called as methods.
    ```javascript
    "use strict";
    function showThis() {
        console.log(this); // Output: undefined
    }
    showThis();
    ```

5. **Disables Deprecated Features**:
    - Certain features like `with` statements are not allowed.
    ```javascript
    "use strict";
    with (Math) { // SyntaxError: Strict mode code may not include a with statement
        console.log(sqrt(16));
    }
    ```

#### Best Practices:
- Always use strict mode in your JavaScript code to catch errors early and write safer, more reliable code.
- Modern JavaScript modules (`import`/`export`) are in strict mode by default, so you don't need to explicitly enable it.

By understanding and using strict mode, you can improve the quality and maintainability of your JavaScript code.

## 14. Higher Order Functions

Higher Order Functions are functions that either take other functions as arguments, return a function, or both. They are a key feature of JavaScript and enable functional programming paradigms.

#### Characteristics of Higher Order Functions:
1. **Accept Functions as Arguments**:
    - A higher order function can take other functions as input.
2. **Return Functions**:
    - A higher order function can return a new function as its output.

#### Examples:

1. **Passing Functions as Arguments**:
    ```javascript
    function greet(name) {
         return `Hello, ${name}!`;
    }

    function processUserInput(callback) {
         const name = "Alice";
         console.log(callback(name));
    }

    processUserInput(greet); // Output: Hello, Alice!
    ```

2. **Returning Functions**:
    ```javascript
    function multiplier(factor) {
         return function(number) {
              return number * factor;
         };
    }

    const double = multiplier(2);
    console.log(double(5)); // Output: 10
    ```

3. **Common Higher Order Functions in JavaScript**:
    - **`map`**: Transforms each element in an array.
      ```javascript
      const numbers = [1, 2, 3];
      const squared = numbers.map(num => num * num);
      console.log(squared); // Output: [1, 4, 9]
      ```
    - **`filter`**: Filters elements based on a condition.
      ```javascript
      const numbers = [1, 2, 3, 4];
      const even = numbers.filter(num => num % 2 === 0);
      console.log(even); // Output: [2, 4]
      ```
    - **`reduce`**: Reduces an array to a single value.
      ```javascript
      const numbers = [1, 2, 3, 4];
      const sum = numbers.reduce((acc, num) => acc + num, 0);
      console.log(sum); // Output: 10
      ```

#### Benefits of Higher Order Functions:
1. **Code Reusability**:
    - They allow you to write reusable and modular code.
2. **Abstraction**:
    - They help abstract common patterns, making code cleaner and easier to understand.
3. **Functional Programming**:
    - They enable functional programming techniques, such as immutability and pure functions.

## 15. The `this` Keyword

The `this` keyword in JavaScript refers to the object it belongs to. Its value depends on the context in which it is used.

The `this` keyword refers to the object that the function is part of.

The value of `this` keyword will always depend on the object that is invoking the function.

#### Key Points:
1. **Global Context**:
    - In the global execution context (outside of any function), `this` refers to the global object (`window` in browsers, `global` in Node.js).
    ```javascript
    console.log(this); // In browsers, this refers to the window object
    ```

2. **Inside a Function**:
    - In a regular function, `this` refers to the global object in non-strict mode, and `undefined` in strict mode.
    ```javascript
    function showThis() {
         console.log(this);
    }
    showThis(); // Output: global object (non-strict mode) or undefined (strict mode)
    ```

3. **Inside a Method**:
    - When a function is called as a method of an object, `this` refers to the object the method is called on.
    ```javascript
    const obj = {
         name: "Alice",
         greet: function() {
              console.log(this.name);
         }
    };
    obj.greet(); // Output: Alice
    ```

4. **Arrow Functions**:
    - Arrow functions do not have their own `this`. Instead, they inherit `this` from the surrounding lexical scope.
    ```javascript
    const obj = {
         name: "Alice",
         greet: () => {
              console.log(this.name);
         }
    };
    obj.greet(); // Output: undefined (inherited from global scope)
    ```

5. **Event Handlers**:
    - In event handlers, `this` refers to the element that received the event.
    ```javascript
    const button = document.querySelector("button");
    button.addEventListener("click", function() {
         console.log(this); // Output: the button element
    });
    ```

#### Example:
```javascript
const person = {
     name: "John",
     sayName: function() {
          console.log(this.name);
     }
};

person.sayName(); // Output: John
```

#### Best Practices:
- Use arrow functions for callbacks to avoid issues with `this`.
- Use `bind()`, `call()`, or `apply()` to explicitly set the value of `this` when needed.


## 16. `call`, `apply`, and `bind` Methods

The `call`, `apply`, and `bind` methods are used to explicitly set the value of `this` in JavaScript. These methods are particularly useful when working with functions and objects.

#### `call` Method:
- Invokes a function with a specified `this` value and arguments provided individually.

#### Syntax:
```javascript
functionName.call(thisArg, arg1, arg2, ...);
```

#### Example:
```javascript
const person = {
    name: "Alice",
};

function greet(greeting) {
    console.log(`${greeting}, ${this.name}`);
}

greet.call(person, "Hello"); // Output: Hello, Alice
```

---

#### `apply` Method:
- Similar to `call`, but arguments are passed as an array.

#### Syntax:
```javascript
functionName.apply(thisArg, [arg1, arg2, ...]);
```

#### Example:
```javascript
const person = {
    name: "Bob",
};

function greet(greeting) {
    console.log(`${greeting}, ${this.name}`);
}

greet.apply(person, ["Hi"]); // Output: Hi, Bob
```

---

#### `bind` Method:
- Returns a new function with a specified `this` value and optional arguments. The new function can be invoked later.

#### Syntax:
```javascript
const boundFunction = functionName.bind(thisArg, arg1, arg2, ...);
```

#### Example:
```javascript
const person = {
    name: "Charlie",
};

function greet(greeting) {
    console.log(`${greeting}, ${this.name}`);
}

const boundGreet = greet.bind(person, "Hey");
boundGreet(); // Output: Hey, Charlie
```

---

#### Key Differences:
| Feature                | `call`           | `apply`          | `bind`           |
|------------------------|------------------|------------------|------------------|
| Invocation             | Immediately      | Immediately      | Returns a function |
| Arguments              | Individually     | As an array      | Individually or partially applied |

#### Use Cases:
1. **`call`**: Use when you need to invoke a function immediately with a specific `this` value and individual arguments.
2. **`apply`**: Use when you need to invoke a function immediately with a specific `this` value and arguments as an array.
3. **`bind`**: Use when you need to create a new function with a specific `this` value for later use.

## 17. Difference Between `exec()` and `test()` Methods

The `exec()` and `test()` methods are used with regular expressions in JavaScript, but they serve different purposes.

#### `exec()` Method:
- Executes a search for a match in a string and returns an array of information about the match, or `null` if no match is found.
- Useful when you need detailed information about the match, such as capturing groups.

#### Syntax:
```javascript
regex.exec(string);
```

#### Example:
```javascript
const regex = /(\d+)/;
const result = regex.exec("The number is 42");
console.log(result);
// Output: ["42", "42"]
// Explanation: The first element is the full match, and subsequent elements are capturing groups.
```

#### `test()` Method:
- Tests for a match in a string and returns a boolean (`true` or `false`).
- Useful when you only need to check if a pattern exists in a string.

#### Syntax:
```javascript
regex.test(string);
```

#### Example:
```javascript
const regex = /\d+/;
const result = regex.test("The number is 42");
console.log(result); // Output: true
```

#### Key Differences:
| Feature                | `exec()`          | `test()`         |
|------------------------|-------------------|------------------|
| Return Value           | Array or `null`   | Boolean          |
| Use Case               | Detailed match info | Existence check  |
| Capturing Groups       | Yes               | No               |

#### Best Practices:
- Use `exec()` when you need to extract match details or capturing groups.
- Use `test()` for simple existence checks.

By understanding the difference between `exec()` and `test()`, you can choose the appropriate method for your use case.

## 18. What is Currying?

Curring is an advanced technique to transform a function of arguments n - to n functions of one or fewer arguments.

Currying is a technique in functional programming where a function is transformed into a sequence of functions, each taking a single argument. Instead of taking all arguments at once, the curried function takes them one at a time.

#### Syntax:
```javascript
function curry(fn) {
    return function curried(...args) {
        if (args.length >= fn.length) {
            return fn.apply(this, args);
        } else {
            return function(...nextArgs) {
                return curried.apply(this, args.concat(nextArgs));
            };
        }
    };
}
```

#### Example:
```javascript
function add(a, b) {
    return a + b;
}

const curriedAdd = curry(add);

console.log(curriedAdd(2)(3)); // Output: 5
```

#### Simple Example:
```javascript
function add(a){
    return function(b){
        return a+b;
    }
}
add(1)(2); // Output: 3
```

#### Explanation:
1. **Partial Application**:
   - Currying allows you to partially apply a function by providing some of its arguments and returning a new function that takes the remaining arguments.
   ```javascript
   const add5 = curriedAdd(5);
   console.log(add5(10)); // Output: 15
   ```

2. **Reusability**:
   - Curried functions can be reused with different sets of arguments, making them more modular and composable.

#### Use Cases:
1. **Function Composition**:
   - Currying is often used in functional programming to create pipelines of functions.
2. **Event Handling**:
   - Currying can simplify event handlers by pre-configuring some arguments.
3. **Configuration**:
   - Curried functions can be used to create pre-configured versions of functions for specific use cases.

## 19. Scope and Scope Chain

In JavaScript, **scope** refers to the accessibility of variables, functions, and objects in a specific part of the code. The **scope chain** determines the order in which the JavaScript engine looks for variables when executing code.

#### Types of Scope:
1. **Global Scope**:
    - Variables declared outside any function or block belong to the global scope and can be accessed from anywhere in the code.
    ```javascript
    let globalVar = "I am global";
    function example() {
         console.log(globalVar); // Output: I am global
    }
    ```

2. **Function Scope**:
    - Variables declared inside a function are accessible only within that function.
    ```javascript
    function example() {
         let localVar = "I am local";
         console.log(localVar); // Output: I am local
    }
    // console.log(localVar); // Error: localVar is not defined
    ```

3. **Block Scope**:
    - Variables declared with `let` or `const` inside a block (`{}`) are accessible only within that block.
    ```javascript
    {
         let blockVar = "I am block-scoped";
         console.log(blockVar); // Output: I am block-scoped
    }
    // console.log(blockVar); // Error: blockVar is not defined
    ```

#### Scope Chain:
- The **scope chain** is the hierarchy of scopes that the JavaScript engine traverses to resolve variable references.
- When a variable is accessed, JavaScript first looks in the current scope. If not found, it moves up to the parent scope, continuing until it reaches the global scope. If the variable is still not found, a `ReferenceError` is thrown.

#### Example:
```javascript
let globalVar = "Global";

function outerFunction() {
     let outerVar = "Outer";

     function innerFunction() {
          let innerVar = "Inner";
          console.log(globalVar); // Output: Global
          console.log(outerVar);  // Output: Outer
          console.log(innerVar);  // Output: Inner
     }

     innerFunction();
}

outerFunction();
```

#### Key Points:
1. **Lexical Scope**:
    - JavaScript uses lexical scoping, meaning the scope of a variable is determined by its position in the source code.

2. **Closures**:
    - Functions retain access to their outer scope even after the outer function has executed, enabling closures.

3. **Avoid Polluting the Global Scope**:
    - Minimize the use of global variables to avoid conflicts and unexpected behavior.

## 20. Closures

A **closure** is a feature in JavaScript where an inner function has access to the outer (enclosing) function's variables, even after the outer function has executed. Closures are created every time a function is defined, allowing the function to "remember" the scope in which it was created.

#### Characteristics of Closures:
1. **Access to Outer Variables**:
    - An inner function can access variables declared in its outer function.
2. **Preservation of Scope**:
    - The variables of the outer function are preserved in memory as long as the inner function exists.

#### Example:
```javascript
function outerFunction(outerVariable) {
     return function innerFunction(innerVariable) {
          console.log(`Outer Variable: ${outerVariable}`);
          console.log(`Inner Variable: ${innerVariable}`);
     };
}

const newFunction = outerFunction("outside");
newFunction("inside");
// Output:
// Outer Variable: outside
// Inner Variable: inside
```

#### Explanation:
1. **Outer Function**:
    - `outerFunction` creates a local variable `outerVariable` and returns `innerFunction`.
2. **Inner Function**:
    - `innerFunction` has access to `outerVariable` even after `outerFunction` has finished executing.

#### Use Cases of Closures:
1. **Data Privacy**:
    - Closures can be used to create private variables that cannot be accessed from outside the function.
    ```javascript
    function counter() {
         let count = 0;
         return function() {
              count++;
              return count;
         };
    }

    const increment = counter();
    console.log(increment()); // Output: 1
    console.log(increment()); // Output: 2
    ```

2. **Partial Application**:
    - Closures can be used to create partially applied functions.
    ```javascript
    function multiply(a) {
         return function(b) {
              return a * b;
         };
    }

    const double = multiply(2);
    console.log(double(5)); // Output: 10
    ```

3. **Event Handlers**:
    - Closures are commonly used in event handlers to retain access to variables from their outer scope.
    ```javascript
    function attachEventListener(element, message) {
         element.addEventListener("click", function() {
              console.log(message);
         });
    }

    const button = document.querySelector("button");
    attachEventListener(button, "Button clicked!");
    ```

#### Key Points:
- Closures are created when a function is defined, not when it is executed.
- They allow functions to retain access to their lexical scope, even when executed outside that scope.
- Proper use of closures can lead to cleaner and more modular code.

## 21. What are Object Prototypes?

In JavaScript, every object has an internal property called `[[Prototype]]`, which points to another object or `null`. This is the basis of prototypal inheritance, allowing objects to share properties and methods.

#### Key Points:
1. **Prototype Chain**:
    - When accessing a property or method on an object, JavaScript first looks for it on the object itself. If not found, it traverses up the prototype chain to the object's prototype, and so on, until it reaches `null`.

2. **`Object.prototype`**:
    - The top of the prototype chain is `Object.prototype`, which provides common methods like `toString()` and `hasOwnProperty()`.

3. **Setting Prototypes**:
    - Prototypes can be set using the `Object.create()` method or the `__proto__` property (deprecated but still widely used).

#### Example:
```javascript
const parent = {
     greet: function() {
          console.log("Hello from the parent!");
     }
};

const child = Object.create(parent);
child.sayHi = function() {
     console.log("Hi from the child!");
};

child.greet(); // Output: Hello from the parent!
child.sayHi(); // Output: Hi from the child!
```

#### Explanation:
1. **`Object.create()`**:
    - Creates a new object with the specified prototype.
2. **Prototype Inheritance**:
    - The `child` object inherits the `greet` method from the `parent` object.

#### Modifying Prototypes:
- You can add methods or properties to an object's prototype, which will be available to all instances of that object.
```javascript
function Person(name) {
     this.name = name;
}

Person.prototype.sayHello = function() {
     console.log(`Hello, my name is ${this.name}`);
};

const alice = new Person("Alice");
alice.sayHello(); // Output: Hello, my name is Alice
```

#### Best Practices:
1. **Avoid Overwriting Prototypes**:
    - Instead of overwriting the prototype, extend it to avoid breaking the prototype chain.
2. **Use `Object.create()` for Inheritance**:
    - It is a cleaner and more modern approach compared to using constructors and manually setting `__proto__`.


## 22. What are Callbacks?

A **callback** is a function passed as an argument to another function, which is then executed inside the outer function to complete some kind of routine or action. Callbacks are a key feature of JavaScript and are often used for asynchronous operations.

#### Characteristics of Callbacks:
1. **Higher-Order Functions**:
    - A function that accepts another function as an argument or returns a function is called a higher-order function. Callbacks are often used with higher-order functions.
2. **Asynchronous Programming**:
    - Callbacks are commonly used in asynchronous programming to handle tasks like API calls, file reading, or event handling.

#### Example of a Callback:
```javascript
function fetchData(callback) {
    setTimeout(() => {
        console.log("Data fetched");
        callback();
    }, 1000);
}

function processData() {
    console.log("Processing data");
}

fetchData(processData);
// Output:
// Data fetched
// Processing data
```

#### Explanation:
1. **`fetchData` Function**:
    - Accepts a callback function as an argument and simulates an asynchronous operation using `setTimeout`.
2. **Callback Execution**:
    - Once the asynchronous operation is complete, the callback function (`processData`) is executed.

#### Synchronous vs Asynchronous Callbacks:
1. **Synchronous Callback**:
    - Executed immediately within the function it is passed to.
    ```javascript
    function greet(name, callback) {
        console.log("Hello, " + name);
        callback();
    }

    greet("Alice", () => {
        console.log("Callback executed");
    });
    // Output:
    // Hello, Alice
    // Callback executed
    ```

2. **Asynchronous Callback**:
    - Executed after an asynchronous operation is completed.
    ```javascript
    setTimeout(() => {
        console.log("Asynchronous callback executed");
    }, 1000);
    ```

#### Common Use Cases:
1. **Event Handling**:
    ```javascript
    document.querySelector("button").addEventListener("click", () => {
        console.log("Button clicked");
    });
    ```

2. **API Calls**:
    ```javascript
    function getUserData(callback) {
        fetch("https://api.example.com/user")
            .then(response => response.json())
            .then(data => callback(data));
    }

    getUserData(user => {
        console.log(user);
    });
    ```

3. **Array Methods**:
    - Callbacks are used in array methods like `map`, `filter`, and `reduce`.
    ```javascript
    const numbers = [1, 2, 3];
    const squared = numbers.map(num => num * num);
    console.log(squared); // Output: [1, 4, 9]
    ```

#### Best Practices:
1. **Use Named Functions**:
    - Use named functions instead of anonymous functions for better readability and debugging.
    ```javascript
    function logMessage() {
        console.log("Callback executed");
    }

    setTimeout(logMessage, 1000);
    ```

2. **Handle Errors**:
    - Ensure proper error handling in callbacks to avoid unexpected behavior.
    ```javascript
    function fetchData(callback, errorCallback) {
        try {
            // Simulate fetching data
            throw new Error("Something went wrong");
        } catch (error) {
            errorCallback(error);
        }
    }

    fetchData(
        () => console.log("Data fetched"),
        error => console.error(error.message)
    );
    ```

3. **Avoid Callback Hell**:
    - Use Promises or `async/await` to avoid deeply nested callbacks, also known as "callback hell."
    ```javascript
    // Callback Hell Example
    setTimeout(() => {
        console.log("Step 1");
        setTimeout(() => {
            console.log("Step 2");
            setTimeout(() => {
                console.log("Step 3");
            }, 1000);
        }, 1000);
    }, 1000);

    // Using Promises
    const step = (message, delay) =>
        new Promise(resolve => setTimeout(() => {
            console.log(message);
            resolve();
        }, delay));

    step("Step 1", 1000)
        .then(() => step("Step 2", 1000))
        .then(() => step("Step 3", 1000));
    ```

## 23. What is Memoization?

Memoization is an optimization technique used to improve the performance of functions by caching their results. When a function is called with a specific set of arguments, its result is stored in a cache. If the function is called again with the same arguments, the cached result is returned instead of recomputing the result.

#### How Memoization Works:
1. **Cache Storage**:
    - A data structure (usually an object or a Map) is used to store the results of function calls.
2. **Check Cache**:
    - Before executing the function, check if the result for the given arguments exists in the cache.
3. **Return Cached Result**:
    - If the result is found in the cache, return it. Otherwise, compute the result, store it in the cache, and return it.

#### Example:
```javascript
function memoize(fn) {
     const cache = {};
     return function(...args) {
          const key = JSON.stringify(args);
          if (cache[key]) {
                console.log("Fetching from cache:", key);
                return cache[key];
          }
          console.log("Computing result for:", key);
          const result = fn(...args);
          cache[key] = result;
          return result;
     };
}

function add(a, b) {
     return a + b;
}

const memoizedAdd = memoize(add);

console.log(memoizedAdd(1, 2)); // Computing result for: [1,2] -> Output: 3
console.log(memoizedAdd(1, 2)); // Fetching from cache: [1,2] -> Output: 3
console.log(memoizedAdd(2, 3)); // Computing result for: [2,3] -> Output: 5
```

#### Explanation:
1. **`memoize` Function**:
    - Wraps the original function and adds caching logic.
2. **Cache Key**:
    - The arguments are serialized into a string (using `JSON.stringify`) to create a unique key for the cache.
3. **Cache Lookup**:
    - If the key exists in the cache, the cached result is returned. Otherwise, the function is executed, and the result is stored in the cache.

#### Use Cases:
1. **Expensive Computations**:
    - Memoization is useful for functions that perform time-consuming calculations, such as recursive algorithms (e.g., Fibonacci sequence).
2. **API Calls**:
    - Cache the results of API calls to reduce network requests and improve performance.
3. **Data Transformation**:
    - Cache the results of data transformation functions to avoid redundant processing.

#### Example: Memoized Fibonacci Function
```javascript
function memoizedFibonacci() {
     const cache = {};
     return function fib(n) {
          if (n <= 1) return n;
          if (cache[n]) return cache[n];
          cache[n] = fib(n - 1) + fib(n - 2);
          return cache[n];
     };
}

const fibonacci = memoizedFibonacci();
console.log(fibonacci(10)); // Output: 55
console.log(fibonacci(10)); // Output: 55 (fetched from cache)
```

#### Benefits of Memoization:
1. **Improved Performance**:
    - Reduces redundant computations, especially for functions with repeated calls and the same inputs.
2. **Efficient Resource Usage**:
    - Saves computational resources by reusing previously computed results.

#### Best Practices:
1. **Use for Pure Functions**:
    - Memoization works best with pure functions (functions that always produce the same output for the same input and have no side effects).
2. **Cache Size Management**:
    - For functions with a large number of possible inputs, consider limiting the cache size to avoid excessive memory usage.
3. **Use Libraries**:
    - Libraries like `lodash` provide built-in memoization utilities (e.g., `_.memoize`).

By using memoization, you can optimize your JavaScript code for better performance and efficiency.

## 24. Constructor Functions

A **constructor function** in JavaScript is a special type of function used to create and initialize objects. It acts as a blueprint for creating multiple objects with similar properties and methods.

#### Characteristics of Constructor Functions:
1. **Naming Convention**:
    - Constructor functions are named with a capitalized first letter (e.g., `Person`, `Car`) to distinguish them from regular functions.
2. **`this` Keyword**:
    - Inside a constructor function, the `this` keyword refers to the new object being created.
3. **`new` Keyword**:
    - Constructor functions are invoked using the `new` keyword, which creates a new object and binds `this` to it.

#### Syntax:
```javascript
function ConstructorName(parameters) {
    // Initialize properties
    this.property1 = value1;
    this.property2 = value2;
    // Define methods
    this.methodName = function() {
        // Method logic
    };
}
```

#### Example:
```javascript
function Person(name, age) {
    this.name = name;
    this.age = age;
    this.greet = function() {
        console.log(`Hello, my name is ${this.name} and I am ${this.age} years old.`);
    };
}

const person1 = new Person("Alice", 25);
const person2 = new Person("Bob", 30);

person1.greet(); // Output: Hello, my name is Alice and I am 25 years old.
person2.greet(); // Output: Hello, my name is Bob and I am 30 years old.
```

#### Explanation:
1. **`Person` Constructor**:
    - Defines properties (`name`, `age`) and a method (`greet`) for the `Person` object.
2. **Creating Objects**:
    - `new Person("Alice", 25)` creates a new object with the specified properties and methods.

#### Advantages of Constructor Functions:
1. **Code Reusability**:
    - Constructor functions allow you to create multiple objects with similar properties and methods, reducing code duplication.
2. **Encapsulation**:
    - Properties and methods can be encapsulated within the constructor function, providing a clear structure for objects.

#### Best Practices:
1. **Use Prototypes for Methods**:
    - Define methods on the constructor's prototype to avoid duplicating them for each object instance.
    ```javascript
    function Person(name, age) {
        this.name = name;
        this.age = age;
    }

    Person.prototype.greet = function() {
        console.log(`Hello, my name is ${this.name} and I am ${this.age} years old.`);
    };

    const person1 = new Person("Alice", 25);
    person1.greet(); // Output: Hello, my name is Alice and I am 25 years old.
    ```

2. **Avoid Using Arrow Functions for Methods**:
    - Arrow functions do not have their own `this` and may not work as expected in constructor functions.

By understanding and using constructor functions, you can create structured and reusable object-oriented code in JavaScript.

## 25. Must-Know JavaScript Array Methods

JavaScript provides a variety of array methods that are essential for manipulating and working with arrays. Here are some of the most commonly used ones:

#### 1. `push()` and `pop()`
- **`push()`**: Adds one or more elements to the end of an array and returns the new length.
- **`pop()`**: Removes the last element from an array and returns it.

```javascript
let fruits = ["apple", "banana"];
fruits.push("orange"); // ["apple", "banana", "orange"]
fruits.pop(); // ["apple", "banana"]
```

#### 2. `shift()` and `unshift()`
- **`shift()`**: Removes the first element from an array and returns it.
- **`unshift()`**: Adds one or more elements to the beginning of an array and returns the new length.

```javascript
let fruits = ["apple", "banana"];
fruits.shift(); // ["banana"]
fruits.unshift("orange"); // ["orange", "banana"]
```

#### 3. `map()`
- Creates a new array by applying a function to each element of the original array.

```javascript
let numbers = [1, 2, 3];
let squared = numbers.map(num => num * num); // [1, 4, 9]
```

#### 4. `filter()`
- Creates a new array with elements that pass a specified condition.

```javascript
let numbers = [1, 2, 3, 4];
let even = numbers.filter(num => num % 2 === 0); // [2, 4]
```

#### 5. `reduce()`
- Reduces an array to a single value by applying a function to each element and accumulating the result.

```javascript
let numbers = [1, 2, 3, 4];
let sum = numbers.reduce((acc, num) => acc + num, 0); // 10
```

#### 6. `forEach()`
- Executes a provided function once for each array element.

```javascript
let fruits = ["apple", "banana", "orange"];
fruits.forEach(fruit => console.log(fruit));
// Output:
// apple
// banana
// orange
```

#### 7. `find()` and `findIndex()`
- **`find()`**: Returns the first element that satisfies a condition.
- **`findIndex()`**: Returns the index of the first element that satisfies a condition.

```javascript
let numbers = [1, 2, 3, 4];
let firstEven = numbers.find(num => num % 2 === 0); // 2
let firstEvenIndex = numbers.findIndex(num => num % 2 === 0); // 1
```

#### 8. `includes()`
- Checks if an array contains a specific element.

```javascript
let fruits = ["apple", "banana", "orange"];
console.log(fruits.includes("banana")); // true
console.log(fruits.includes("grape")); // false
```

#### 9. `slice()`
- Returns a shallow copy of a portion of an array into a new array.

```javascript
let fruits = ["apple", "banana", "orange"];
let sliced = fruits.slice(1, 3); // ["banana", "orange"]
```

#### 10. `splice()`
- Adds or removes elements from an array.

```javascript
let fruits = ["apple", "banana", "orange"];
fruits.splice(1, 1, "grape"); // ["apple", "grape", "orange"]
```

#### 11. `concat()`
- Merges two or more arrays into a new array.

```javascript
let fruits = ["apple", "banana"];
let moreFruits = ["orange", "grape"];
let allFruits = fruits.concat(moreFruits); // ["apple", "banana", "orange", "grape"]
```

#### 12. `sort()`
- Sorts the elements of an array in place.

```javascript
let numbers = [3, 1, 4, 2];
numbers.sort(); // [1, 2, 3, 4]
```

#### 13. `reverse()`
- Reverses the order of the elements in an array.

```javascript
let numbers = [1, 2, 3];
numbers.reverse(); // [3, 2, 1]
```

#### 14. `join()`
- Joins all elements of an array into a string.

```javascript
let fruits = ["apple", "banana", "orange"];
let result = fruits.join(", "); // "apple, banana, orange"
```

#### 15. `split()`
- Splits a string into an array of substrings.

```javascript
let str = "apple,banana,orange";
let fruits = str.split(","); // ["apple", "banana", "orange"]
```

#### 16. `every()` and `some()`
- **`every()`**: Checks if all elements satisfy a condition.
- **`some()`**: Checks if at least one element satisfies a condition.

```javascript
let numbers = [2, 4, 6];
console.log(numbers.every(num => num % 2 === 0)); // true
console.log(numbers.some(num => num > 5)); // true
```

#### 17. `flat()` and `flatMap()`
- **`flat()`**: Flattens nested arrays.
- **`flatMap()`**: Maps each element and flattens the result.

```javascript
let nested = [1, [2, [3, 4]]];
console.log(nested.flat(2)); // [1, 2, 3, 4]

let numbers = [1, 2, 3];
console.log(numbers.flatMap(num => [num, num * 2])); // [1, 2, 2, 4, 3, 6]
```

#### 18. `indexOf()` and `lastIndexOf()`
- **`indexOf()`**: Returns the first index of a specified element.
- **`lastIndexOf()`**: Returns the last index of a specified element.

```javascript
let fruits = ["apple", "banana", "orange", "banana"];
console.log(fruits.indexOf("banana")); // 1
console.log(fruits.lastIndexOf("banana")); // 3
```

#### 19. `fill()`
- Fills all elements in an array with a static value.

```javascript
let numbers = [1, 2, 3];
numbers.fill(0); // [0, 0, 0]
```

#### 20. `Array.from()` and `Array.of()`
- **`Array.from()`**: Creates an array from an iterable or array-like object.
- **`Array.of()`**: Creates an array from a set of arguments.

```javascript
console.log(Array.from("hello")); // ["h", "e", "l", "l", "o"]
console.log(Array.of(1, 2, 3)); // [1, 2, 3]
```

## 26. Must-Know JavaScript String Methods

JavaScript provides a variety of string methods that are essential for manipulating and working with strings. Here are some of the most commonly used ones:

#### 1. `charAt()`
- Returns the character at a specified index in a string.

```javascript
let str = "Hello";
console.log(str.charAt(1)); // Output: "e"
```

#### 2. `concat()`
- Combines two or more strings and returns a new string.

```javascript
let str1 = "Hello";
let str2 = "World";
console.log(str1.concat(" ", str2)); // Output: "Hello World"
```

#### 3. `includes()`
- Checks if a string contains a specified substring.

```javascript
let str = "Hello World";
console.log(str.includes("World")); // Output: true
```

#### 4. `indexOf()` and `lastIndexOf()`
- **`indexOf()`**: Returns the index of the first occurrence of a specified substring.
- **`lastIndexOf()`**: Returns the index of the last occurrence of a specified substring.

```javascript
let str = "Hello World";
console.log(str.indexOf("o")); // Output: 4
console.log(str.lastIndexOf("o")); // Output: 7
```

#### 5. `slice()`
- Extracts a portion of a string and returns it as a new string.

```javascript
let str = "Hello World";
console.log(str.slice(0, 5)); // Output: "Hello"
```

#### 6. `substring()`
- Similar to `slice()`, but does not accept negative indices.

```javascript
let str = "Hello World";
console.log(str.substring(0, 5)); // Output: "Hello"
```

#### 7. `substr()`
- Extracts a substring starting at a specified index and for a specified length.

```javascript
let str = "Hello World";
console.log(str.substr(0, 5)); // Output: "Hello"
```

#### 8. `toLowerCase()` and `toUpperCase()`
- Converts a string to lowercase or uppercase.

```javascript
let str = "Hello World";
console.log(str.toLowerCase()); // Output: "hello world"
console.log(str.toUpperCase()); // Output: "HELLO WORLD"
```

#### 9. `trim()`
- Removes whitespace from both ends of a string.

```javascript
let str = "   Hello World   ";
console.log(str.trim()); // Output: "Hello World"
```

#### 10. `replace()` and `replaceAll()`
- **`replace()`**: Replaces the first occurrence of a substring with a new value.
- **`replaceAll()`**: Replaces all occurrences of a substring with a new value.

```javascript
let str = "Hello World";
console.log(str.replace("World", "JavaScript")); // Output: "Hello JavaScript"
console.log(str.replaceAll("o", "0")); // Output: "Hell0 W0rld"
```

#### 11. `split()`
- Splits a string into an array of substrings based on a specified delimiter.

```javascript
let str = "apple,banana,orange";
console.log(str.split(",")); // Output: ["apple", "banana", "orange"]
```

#### 12. `repeat()`
- Repeats a string a specified number of times.

```javascript
let str = "Hello";
console.log(str.repeat(3)); // Output: "HelloHelloHello"
```

#### 13. `startsWith()` and `endsWith()`
- **`startsWith()`**: Checks if a string starts with a specified substring.
- **`endsWith()`**: Checks if a string ends with a specified substring.

```javascript
let str = "Hello World";
console.log(str.startsWith("Hello")); // Output: true
console.log(str.endsWith("World")); // Output: true
```

#### 14. `padStart()` and `padEnd()`
- **`padStart()`**: Pads the beginning of a string with another string until it reaches a specified length.
- **`padEnd()`**: Pads the end of a string with another string until it reaches a specified length.

```javascript
let str = "5";
console.log(str.padStart(3, "0")); // Output: "005"
console.log(str.padEnd(3, "0")); // Output: "500"
```

#### 15. `match()` and `matchAll()`
- **`match()`**: Searches a string for a match against a regular expression and returns the matches.
- **`matchAll()`**: Returns an iterator of all matches against a regular expression.

```javascript
let str = "The rain in Spain";
console.log(str.match(/ain/g)); // Output: ["ain", "ain"]
console.log([...str.matchAll(/ain/g)]); // Output: [["ain"], ["ain"]]
```

#### 16. `charCodeAt()`
- Returns the Unicode value of the character at a specified index.

```javascript
let str = "Hello";
console.log(str.charCodeAt(0)); // Output: 72
```

#### 17. `fromCharCode()`
- Converts Unicode values to characters.

```javascript
console.log(String.fromCharCode(72, 101, 108, 108, 111)); // Output: "Hello"
```

#### 18. `search()`
- Searches a string for a match against a regular expression and returns the index of the first match.

```javascript
let str = "The rain in Spain";
console.log(str.search(/ain/)); // Output: 5
```

#### 19. `localeCompare()`
- Compares two strings in the current locale.

```javascript
let str1 = "apple";
let str2 = "banana";
console.log(str1.localeCompare(str2)); // Output: -1 (str1 comes before str2)
```

#### 20. `toString()`
- Converts a value to a string.

```javascript
let num = 123;
console.log(num.toString()); // Output: "123"
```

## 27. Must-Know JavaScript Object Methods

JavaScript provides several built-in methods for working with objects. These methods are essential for manipulating and interacting with objects effectively.

#### 1. `Object.keys()`
- Returns an array of a given object's own enumerable property names.

```javascript
const obj = { a: 1, b: 2, c: 3 };
console.log(Object.keys(obj)); // Output: ["a", "b", "c"]
```

#### 2. `Object.values()`
- Returns an array of a given object's own enumerable property values.

```javascript
const obj = { a: 1, b: 2, c: 3 };
console.log(Object.values(obj)); // Output: [1, 2, 3]
```

#### 3. `Object.entries()`
- Returns an array of a given object's own enumerable property `[key, value]` pairs.

```javascript
const obj = { a: 1, b: 2, c: 3 };
console.log(Object.entries(obj)); // Output: [["a", 1], ["b", 2], ["c", 3]]
```

#### 4. `Object.assign()`
- Copies the values of all enumerable own properties from one or more source objects to a target object.

```javascript
const target = { a: 1 };
const source = { b: 2, c: 3 };
Object.assign(target, source);
console.log(target); // Output: { a: 1, b: 2, c: 3 }
```

#### 5. `Object.freeze()`
- Freezes an object, preventing new properties from being added or existing properties from being modified or deleted.

```javascript
const obj = { a: 1 };
Object.freeze(obj);
obj.a = 2; // No effect
console.log(obj.a); // Output: 1
```

#### 6. `Object.seal()`
- Seals an object, preventing new properties from being added but allowing modification of existing properties.

```javascript
const obj = { a: 1 };
Object.seal(obj);
obj.a = 2; // Allowed
obj.b = 3; // Not allowed
console.log(obj); // Output: { a: 2 }
```

#### 7. `Object.create()`
- Creates a new object with the specified prototype object and properties.

```javascript
const prototype = { greet: function() { console.log("Hello!"); } };
const obj = Object.create(prototype);
obj.greet(); // Output: Hello!
```

#### 8. `Object.hasOwnProperty()`
- Checks if an object has a specific property as its own (not inherited).

```javascript
const obj = { a: 1 };
console.log(obj.hasOwnProperty("a")); // Output: true
console.log(obj.hasOwnProperty("b")); // Output: false
```

#### 9. `Object.is()`
- Compares two values to determine if they are the same value.

```javascript
console.log(Object.is(25, 25)); // Output: true
console.log(Object.is(NaN, NaN)); // Output: true
console.log(Object.is(0, -0)); // Output: false
```

#### 10. `Object.getPrototypeOf()`
- Returns the prototype of the specified object.

```javascript
const obj = {};
const prototype = Object.getPrototypeOf(obj);
console.log(prototype === Object.prototype); // Output: true
```

#### 11. `Object.setPrototypeOf()`
- Sets the prototype of a specified object.

```javascript
const prototype = { greet: function() { console.log("Hello!"); } };
const obj = {};
Object.setPrototypeOf(obj, prototype);
obj.greet(); // Output: Hello!
```

#### 12. `Object.defineProperty()`
- Defines a new property directly on an object or modifies an existing property.

```javascript
const obj = {};
Object.defineProperty(obj, "a", {
    value: 1,
    writable: false,
});
obj.a = 2; // No effect
console.log(obj.a); // Output: 1
```

#### 13. `Object.defineProperties()`
- Defines multiple properties directly on an object.

```javascript
const obj = {};
Object.defineProperties(obj, {
    a: { value: 1, writable: true },
    b: { value: 2, writable: false },
});
console.log(obj); // Output: { a: 1, b: 2 }
```

#### 14. `Object.fromEntries()`
- Converts an array of key-value pairs into an object.

```javascript
const entries = [["a", 1], ["b", 2], ["c", 3]];
const obj = Object.fromEntries(entries);
console.log(obj); // Output: { a: 1, b: 2, c: 3 }
```

#### 15. `Object.toString()`
- Returns a string representation of the object.

```javascript
const obj = {};
console.log(obj.toString()); // Output: "[object Object]"
```

## 28. What is an Arrow Function?

Arrow functions are a concise syntax for writing functions in JavaScript. They were introduced in ES6 and provide a shorter way to write function expressions. Arrow functions are particularly useful for writing small, anonymous functions.

#### Syntax:
```javascript
// Traditional function
function add(a, b) {
    return a + b;
}

// Arrow function
const add = (a, b) => a + b;
```

#### Key Features:
1. **Concise Syntax**:
   - Arrow functions allow you to write shorter function expressions.
   ```javascript
   const greet = name => `Hello, ${name}!`;
   console.log(greet("Alice")); // Output: Hello, Alice!
   ```

2. **Implicit Return**:
   - If the function body contains a single expression, the result of that expression is returned implicitly.
   ```javascript
   const square = x => x * x;
   console.log(square(4)); // Output: 16
   ```

3. **No `this` Binding**:
   - Arrow functions do not have their own `this`. Instead, they inherit `this` from the surrounding lexical scope.
   ```javascript
   const obj = {
       name: "Alice",
       greet: function() {
           const arrowFunc = () => console.log(`Hello, ${this.name}`);
           arrowFunc();
       }
   };
   obj.greet(); // Output: Hello, Alice
   ```

4. **Cannot Be Used as Constructors**:
   - Arrow functions cannot be used with the `new` keyword because they do not have a `prototype` property.

5. **No `arguments` Object**:
   - Arrow functions do not have their own `arguments` object. Use rest parameters instead.
   ```javascript
   const sum = (...args) => args.reduce((acc, num) => acc + num, 0);
   console.log(sum(1, 2, 3)); // Output: 6
   ```

#### Use Cases:
- **Callbacks**:
  Arrow functions are commonly used as callbacks due to their concise syntax.
  ```javascript
  const numbers = [1, 2, 3];
  const doubled = numbers.map(num => num * 2);
  console.log(doubled); // Output: [2, 4, 6]
  ```

- **Event Handlers**:
  Arrow functions are useful for event handlers, especially when you need to preserve the `this` context.
  ```javascript
  const button = document.querySelector("button");
  button.addEventListener("click", () => console.log("Button clicked!"));
  ```

#### Limitations:
- Arrow functions are not suitable for methods that require their own `this`.
- They cannot be used as constructors.

By understanding and using arrow functions, you can write cleaner and more concise JavaScript code.

## 29. Rest Parameter and Spread Operator

The **rest parameter** and **spread operator** are two powerful features introduced in ES6 that simplify working with arrays, objects, and function arguments.

#### Rest Parameter (`...`):
The rest parameter allows a function to accept an indefinite number of arguments as an array.

#### Syntax:
```javascript
function functionName(...args) {
    // args is an array
}
```

#### Example:
```javascript
function sum(...numbers) {
    return numbers.reduce((acc, num) => acc + num, 0);
}

console.log(sum(1, 2, 3, 4)); // Output: 10
```

#### Explanation:
- The `...numbers` collects all arguments passed to the function into an array called `numbers`.
- Useful for handling variable numbers of arguments.

---

#### Spread Operator (`...`):
The spread operator allows an iterable (like an array or object) to be expanded into individual elements.

#### Syntax:
```javascript
const newArray = [...iterable];
const newObject = { ...object };
```

#### Example with Arrays:
```javascript
const arr1 = [1, 2, 3];
const arr2 = [4, 5, 6];
const combined = [...arr1, ...arr2];
console.log(combined); // Output: [1, 2, 3, 4, 5, 6]
```

#### Example with Objects:
```javascript
const obj1 = { a: 1, b: 2 };
const obj2 = { c: 3, d: 4 };
const combined = { ...obj1, ...obj2 };
console.log(combined); // Output: { a: 1, b: 2, c: 3, d: 4 }
```

#### Explanation:
- The spread operator expands the elements of an array or object into individual elements or properties.
- Useful for cloning or merging arrays and objects.

---

#### Key Differences:
| Feature                | Rest Parameter           | Spread Operator          |
|------------------------|--------------------------|--------------------------|
| Purpose                | Collects multiple elements into an array | Expands elements of an array or object |
| Use Case               | Function arguments       | Arrays, objects, function calls |

#### Example of Both:
```javascript
function multiply(multiplier, ...numbers) {
    return numbers.map(num => num * multiplier);
}

const nums = [1, 2, 3];
console.log(multiply(2, ...nums)); // Output: [2, 4, 6]
```

By understanding the rest parameter and spread operator, you can write more flexible and concise JavaScript code.


## 30. Deep Copy of an Object with Spread Operator

The spread operator (`...`) can be used to create a shallow copy of an object. However, for a **deep copy** (where nested objects are also copied), the spread operator alone is insufficient. To achieve a deep copy, you can use additional techniques.

#### Why Spread Operator Alone Doesn't Work for Deep Copy
The spread operator only creates a shallow copy of the object. If the object contains nested objects or arrays, the references to those nested structures are copied, not the actual values.

```javascript
const original = { a: 1, b: { c: 2 } };
const shallowCopy = { ...original };

shallowCopy.b.c = 42;
console.log(original.b.c); // Output: 42 (nested object is shared)
```

#### Using JSON Methods for Deep Copy
A common way to create a deep copy is to use `JSON.stringify()` and `JSON.parse()`.

```javascript
const original = { a: 1, b: { c: 2 } };
const deepCopy = JSON.parse(JSON.stringify(original));

deepCopy.b.c = 42;
console.log(original.b.c); // Output: 2 (nested object is not shared)
```

#### Limitations of JSON Methods
- Cannot handle functions, `undefined`, `Symbol`, or circular references.
- May lose special object types like `Date`, `Map`, or `Set`.

#### Alternative: Using Libraries
For complex objects, consider using libraries like `lodash` for deep cloning.

```javascript
const _ = require('lodash');
const original = { a: 1, b: { c: 2 } };
const deepCopy = _.cloneDeep(original);

deepCopy.b.c = 42;
console.log(original.b.c); // Output: 2
```

## 31. Shallow Copy vs Deep Copy

When working with objects and arrays in JavaScript, it's important to understand the difference between **shallow copy** and **deep copy**.

#### Shallow Copy:
- A shallow copy creates a new object or array, but only copies the top-level properties. If the original object contains nested objects or arrays, the references to those nested structures are copied, not the actual values.
- Changes to the nested objects or arrays in the copied object will affect the original object.

##### Example:
```javascript
const original = { a: 1, b: { c: 2 } };
const shallowCopy = { ...original };

shallowCopy.b.c = 42;
console.log(original.b.c); // Output: 42 (nested object is shared)
```

#### Deep Copy:
- A deep copy creates a new object or array and recursively copies all levels of nested objects or arrays. The copied object is completely independent of the original.
- Changes to the nested objects or arrays in the copied object will not affect the original object.

##### Example:
Using `JSON.stringify()` and `JSON.parse()`:
```javascript
const original = { a: 1, b: { c: 2 } };
const deepCopy = JSON.parse(JSON.stringify(original));

deepCopy.b.c = 42;
console.log(original.b.c); // Output: 2 (nested object is not shared)
```

#### Comparison:
| Feature                | Shallow Copy            | Deep Copy               |
|------------------------|-------------------------|-------------------------|
| Top-Level Properties   | Copied                 | Copied                 |
| Nested Objects/Arrays  | References are copied  | Values are copied      |
| Independence           | No                     | Yes                    |

#### Techniques for Deep Copy:
1. **Using JSON Methods**:
    - Suitable for simple objects without functions, `undefined`, `Symbol`, or special types like `Date`, `Map`, or `Set`.
    ```javascript
    const deepCopy = JSON.parse(JSON.stringify(original));
    ```

2. **Using Libraries**:
    - Libraries like `lodash` provide robust solutions for deep cloning.
    ```javascript
    const _ = require('lodash');
    const deepCopy = _.cloneDeep(original);
    ```

3. **Manual Recursion**:
    - Write a custom recursive function to handle deep copying.

By understanding the difference between shallow and deep copies, you can choose the appropriate method for your use case and avoid unintended side effects in your JavaScript code.

## 32. Object Destructuring

Object destructuring is a convenient way to extract values from objects and assign them to variables. It allows you to unpack properties from an object into distinct variables in a concise and readable manner.

#### Syntax:
```javascript
const { property1, property2 } = object;
```

#### Example:
```javascript
const person = { name: "Alice", age: 25, city: "New York" };
const { name, age } = person;

console.log(name); // Output: Alice
console.log(age);  // Output: 25
```

#### Explanation:
- The `name` and `age` properties of the `person` object are unpacked into variables with the same names.

#### Default Values:
You can assign default values to variables in case the property does not exist in the object.
```javascript
const person = { name: "Alice" };
const { name, age = 30 } = person;

console.log(age); // Output: 30 (default value)
```

#### Renaming Variables:
You can rename variables while destructuring by using a colon (`:`).
```javascript
const person = { name: "Alice", age: 25 };
const { name: fullName, age: years } = person;

console.log(fullName); // Output: Alice
console.log(years);    // Output: 25
```

#### Nested Destructuring:
You can destructure nested objects by specifying the structure.
```javascript
const person = { name: "Alice", address: { city: "New York", zip: 10001 } };
const { address: { city, zip } } = person;

console.log(city); // Output: New York
console.log(zip);  // Output: 10001
```

#### Rest Properties:
You can use the rest operator to collect the remaining properties into a new object.
```javascript
const person = { name: "Alice", age: 25, city: "New York" };
const { name, ...rest } = person;

console.log(rest); // Output: { age: 25, city: "New York" }
```

#### Use Cases:
1. **Function Parameters**:
    - Destructure objects directly in function parameters for cleaner code.
    ```javascript
    function greet({ name, age }) {
         console.log(`Hello, ${name}. You are ${age} years old.`);
    }

    const person = { name: "Alice", age: 25 };
    greet(person); // Output: Hello, Alice. You are 25 years old.
    ```

2. **API Responses**:
    - Extract specific data from API responses.
    ```javascript
    const response = { data: { user: { id: 1, name: "Alice" } } };
    const { data: { user: { name } } } = response;

    console.log(name); // Output: Alice
    ```

## 33. Array Destructuring

Array destructuring is a concise way to extract values from arrays and assign them to variables. It allows you to unpack elements from an array into distinct variables in a single statement.

#### Syntax:
```javascript
const [variable1, variable2] = array;
```

#### Example:
```javascript
const numbers = [1, 2, 3];
const [first, second] = numbers;

console.log(first); // Output: 1
console.log(second); // Output: 2
```

#### Explanation:
- The `first` and `second` variables are assigned the first and second elements of the `numbers` array, respectively.

#### Skipping Elements:
You can skip elements in the array by leaving a blank space between commas.
```javascript
const numbers = [1, 2, 3, 4];
const [first, , third] = numbers;

console.log(first); // Output: 1
console.log(third); // Output: 3
```

#### Default Values:
You can assign default values to variables in case the array does not have enough elements.
```javascript
const numbers = [1];
const [first, second = 0] = numbers;

console.log(second); // Output: 0 (default value)
```

#### Swapping Variables:
Array destructuring provides a simple way to swap variable values.
```javascript
let a = 1, b = 2;
[a, b] = [b, a];

console.log(a); // Output: 2
console.log(b); // Output: 1
```

#### Nested Destructuring:
You can destructure nested arrays by specifying the structure.
```javascript
const nestedArray = [1, [2, 3]];
const [first, [second, third]] = nestedArray;

console.log(second); // Output: 2
console.log(third);  // Output: 3
```

#### Rest Elements:
You can use the rest operator to collect the remaining elements into a new array.
```javascript
const numbers = [1, 2, 3, 4];
const [first, ...rest] = numbers;

console.log(rest); // Output: [2, 3, 4]
```

#### Use Cases:
1. **Function Parameters**:
    - Destructure arrays directly in function parameters for cleaner code.
    ```javascript
    function sum([a, b]) {
         return a + b;
    }

    console.log(sum([1, 2])); // Output: 3
    ```

2. **Returning Multiple Values**:
    - Use array destructuring to handle functions that return multiple values.
    ```javascript
    function getCoordinates() {
         return [10, 20];
    }

    const [x, y] = getCoordinates();
    console.log(x, y); // Output: 10 20
    ```

## 34. WeakMap

A **WeakMap** is a special type of `Map` in JavaScript where keys must be objects, and the references to these keys are weak. This means that if there are no other references to a key object, it can be garbage-collected, even if it is still in the `WeakMap`.

#### Characteristics of WeakMap:
1. **Keys Must Be Objects**:
    - Unlike regular `Map`, where keys can be of any type, `WeakMap` keys must be objects.
    ```javascript
    const weakMap = new WeakMap();
    const obj = {};
    weakMap.set(obj, "value");
    console.log(weakMap.get(obj)); // Output: "value"
    ```

2. **Weak References**:
    - The keys in a `WeakMap` are weakly referenced, meaning they do not prevent garbage collection.
    ```javascript
    let obj = { name: "Alice" };
    const weakMap = new WeakMap();
    weakMap.set(obj, "value");

    obj = null; // The object is eligible for garbage collection
    ```

3. **No Iteration**:
    - `WeakMap` does not provide methods to iterate over its elements (like `keys()`, `values()`, or `entries()`), as the keys are weakly held and may be garbage-collected at any time.

4. **Methods**:
    - `set(key, value)`: Adds a key-value pair to the `WeakMap`.
    - `get(key)`: Retrieves the value associated with the key.
    - `has(key)`: Checks if a key exists in the `WeakMap`.
    - `delete(key)`: Removes a key-value pair from the `WeakMap`.

#### Example:
```javascript
const weakMap = new WeakMap();
let obj = { id: 1 };

weakMap.set(obj, "metadata");
console.log(weakMap.get(obj)); // Output: "metadata"

obj = null; // The object is garbage-collected, and the entry is removed from the WeakMap
```

#### Use Cases:
1. **Private Data Storage**:
    - `WeakMap` can be used to associate private data with objects without exposing it publicly.
    ```javascript
    const privateData = new WeakMap();

    class Person {
         constructor(name) {
              privateData.set(this, { name });
         }

         getName() {
              return privateData.get(this).name;
         }
    }

    const person = new Person("Alice");
    console.log(person.getName()); // Output: Alice
    ```

2. **DOM Node Metadata**:
    - `WeakMap` is useful for storing metadata about DOM nodes without preventing their garbage collection.

#### Advantages:
- Prevents memory leaks by allowing unused objects to be garbage-collected.
- Provides a way to store private data associated with objects.

#### Limitations:
- Keys must be objects.
- No iteration or size property, as the keys are weakly held.

By understanding `WeakMap`, you can manage memory more effectively and write cleaner, more efficient JavaScript code.

## 35. Map and Set

JavaScript provides two powerful data structures, `Map` and `Set`, introduced in ES6, which offer unique features for managing collections of data.

#### Map
A `Map` is a collection of key-value pairs where keys can be of any type, including objects, functions, and primitives.

##### Characteristics:
1. **Key Flexibility**:
    - Unlike objects, `Map` keys can be of any type.
2. **Preserves Order**:
    - Keys are iterated in the order of their insertion.
3. **Size Property**:
    - `Map` has a `size` property to get the number of key-value pairs.

##### Methods:
- `set(key, value)`: Adds or updates a key-value pair.
- `get(key)`: Retrieves the value associated with a key.
- `has(key)`: Checks if a key exists.
- `delete(key)`: Removes a key-value pair.
- `clear()`: Removes all key-value pairs.
- `keys()`, `values()`, `entries()`: Iterates over keys, values, or key-value pairs.

##### Example:
```javascript
const map = new Map();
map.set("name", "Alice");
map.set("age", 25);

console.log(map.get("name")); // Output: Alice
console.log(map.has("age")); // Output: true
console.log(map.size); // Output: 2

map.delete("age");
console.log(map.size); // Output: 1
```

---

#### Set
A `Set` is a collection of unique values, where duplicates are not allowed.

##### Characteristics:
1. **Unique Values**:
    - A `Set` automatically removes duplicate values.
2. **Preserves Order**:
    - Values are iterated in the order of their insertion.
3. **Size Property**:
    - `Set` has a `size` property to get the number of elements.

##### Methods:
- `add(value)`: Adds a value to the `Set`.
- `has(value)`: Checks if a value exists.
- `delete(value)`: Removes a value.
- `clear()`: Removes all values.
- `keys()`, `values()`, `entries()`: Iterates over values (keys and values are the same in a `Set`).

##### Example:
```javascript
const set = new Set();
set.add(1);
set.add(2);
set.add(2); // Duplicate, will not be added

console.log(set.has(1)); // Output: true
console.log(set.size); // Output: 2

set.delete(1);
console.log(set.size); // Output: 1
```

---

#### Differences Between Map and Set
| Feature                | Map                          | Set                          |
|------------------------|------------------------------|------------------------------|
| Data Structure         | Key-value pairs              | Unique values                |
| Key Flexibility        | Keys can be any type         | Not applicable               |
| Duplicate Handling     | Allows duplicate keys        | Removes duplicate values     |
| Iteration              | Iterates over key-value pairs| Iterates over values         |

#### Use Cases:
- **Map**:
  - Storing structured data with unique keys.
  - Caching results of function calls.
- **Set**:
  - Removing duplicates from an array.
  - Checking for the existence of a value in a collection.

By understanding `Map` and `Set`, you can choose the appropriate data structure for your specific use case and write more efficient JavaScript code.

## 36. Generator Functions

A **generator function** in JavaScript is a special type of function that can pause its execution and resume later. It is defined using the `function*` syntax and produces an **iterator** when invoked.

When generator functions are called, they do not execute the code, instead, they return a generator object. It consist of a method called next(). When next() is called, it executes the code until the nearest yeild statement & returns the yeild value. The next returns an object consisting of a value and done {value:0,done:false} value.

#### Characteristics of Generator Functions:
1. **`function*` Syntax**:
    - A generator function is declared using the `function*` keyword.
2. **`yield` Keyword**:
    - The `yield` keyword is used to pause the function execution and return a value.
3. **Iterator Interface**:
    - Generator functions return an iterator object that conforms to the iterable protocol.

#### Syntax:
```javascript
function* generatorFunction() {
     yield "First value";
     yield "Second value";
     return "Final value";
}
```

#### Example:
```javascript
function* simpleGenerator() {
     yield 1;
     yield 2;
     yield 3;
}

const generator = simpleGenerator();

console.log(generator.next()); // Output: { value: 1, done: false }
console.log(generator.next()); // Output: { value: 2, done: false }
console.log(generator.next()); // Output: { value: 3, done: false }
console.log(generator.next()); // Output: { value: undefined, done: true }
```

#### Explanation:
1. **`yield`**:
    - Each `yield` statement pauses the generator function and returns the specified value.
2. **`next()`**:
    - The `next()` method resumes the generator function from where it was paused and returns an object with `value` and `done` properties.

#### Infinite Generators:
Generators can be used to create infinite sequences.
```javascript
function* infiniteGenerator() {
     let i = 0;
     while (true) {
          yield i++;
     }
}

const generator = infiniteGenerator();
console.log(generator.next().value); // Output: 0
console.log(generator.next().value); // Output: 1
console.log(generator.next().value); // Output: 2
```

#### Use Cases:
1. **Lazy Evaluation**:
    - Generators allow you to produce values on demand, making them memory-efficient for large or infinite sequences.
2. **Asynchronous Programming**:
    - Generators can be used with `yield` to pause execution until asynchronous operations are complete.
    ```javascript
    function* asyncGenerator() {
         yield fetch("https://api.example.com/data").then(res => res.json());
    }

    const generator = asyncGenerator();
    generator.next().value.then(data => console.log(data));
    ```
3. **Custom Iterators**:
    - Generators simplify the creation of custom iterators for objects.
    ```javascript
    const iterableObject = {
         *[Symbol.iterator]() {
              yield "A";
              yield "B";
              yield "C";
         }
    };

    for (const value of iterableObject) {
         console.log(value); // Output: A, B, C
    }
    ```

#### Advantages:
- Simplifies the implementation of iterators.
- Provides a clean way to handle asynchronous workflows.
- Enables lazy evaluation for performance optimization.

## 37. Set and WeakSet

JavaScript provides two special data structures, `Set` and `WeakSet`, for managing collections of unique values.

#### Set
A `Set` is a collection of unique values, where duplicates are not allowed. It can store any type of value, whether primitive or object references.

##### Characteristics:
1. **Unique Values**:
    - A `Set` automatically removes duplicate values.
2. **Preserves Insertion Order**:
    - Values are iterated in the order of their insertion.
3. **Size Property**:
    - `Set` has a `size` property to get the number of elements.

##### Methods:
- `add(value)`: Adds a value to the `Set`.
- `has(value)`: Checks if a value exists in the `Set`.
- `delete(value)`: Removes a value from the `Set`.
- `clear()`: Removes all values from the `Set`.
- `keys()`, `values()`, `entries()`: Iterates over values (keys and values are the same in a `Set`).

##### Example:
```javascript
const set = new Set();
set.add(1);
set.add(2);
set.add(2); // Duplicate, will not be added

console.log(set.has(1)); // Output: true
console.log(set.size); // Output: 2

set.delete(1);
console.log(set.size); // Output: 1
```

#### WeakSet
A `WeakSet` is similar to a `Set`, but it only stores object references, and these references are weak. This means that if there are no other references to an object stored in a `WeakSet`, the object can be garbage-collected.

##### Characteristics:
1. **Object References Only**:
    - A `WeakSet` can only store objects, not primitive values.
2. **Weak References**:
    - Objects in a `WeakSet` are weakly held, meaning they do not prevent garbage collection.
3. **No Iteration**:
    - `WeakSet` does not provide methods to iterate over its elements, as the objects may be garbage-collected at any time.

##### Methods:
- `add(value)`: Adds an object to the `WeakSet`.
- `has(value)`: Checks if an object exists in the `WeakSet`.
- `delete(value)`: Removes an object from the `WeakSet`.

##### Example:
```javascript
const weakSet = new WeakSet();
let obj = { name: "Alice" };

weakSet.add(obj);
console.log(weakSet.has(obj)); // Output: true

obj = null; // The object is garbage-collected, and the entry is removed from the WeakSet
```

#### Differences Between Set and WeakSet
| Feature                | Set                          | WeakSet                     |
|------------------------|------------------------------|-----------------------------|
| Data Type              | Any type of value            | Objects only                |
| Duplicate Handling     | Removes duplicates           | Removes duplicates          |
| Garbage Collection     | No                           | Yes                         |
| Iteration              | Supports iteration           | No iteration support        |
| Size Property          | Yes                          | No                          |

#### Use Cases:
- **Set**:
  - Removing duplicates from an array.
  - Checking for the existence of a value in a collection.
- **WeakSet**:
  - Storing metadata or tracking objects without preventing their garbage collection.

## 38. Promises

A **Promise** in JavaScript is an object that represents the eventual completion (or failure) of an asynchronous operation and its resulting value. Promises provide a cleaner and more manageable way to handle asynchronous code compared to traditional callback functions.

#### States of a Promise:
1. **Pending**: The initial state, neither fulfilled nor rejected.
2. **Fulfilled**: The operation completed successfully, and the promise has a resulting value.
3. **Rejected**: The operation failed, and the promise has a reason for the failure.

#### Syntax:
```javascript
const promise = new Promise((resolve, reject) => {
    // Asynchronous operation
    if (/* success */) {
        resolve("Success!");
    } else {
        reject("Error!");
    }
});
```

#### Example:
```javascript
const fetchData = new Promise((resolve, reject) => {
    setTimeout(() => {
        const success = true;
        if (success) {
            resolve("Data fetched successfully!");
        } else {
            reject("Failed to fetch data.");
        }
    }, 1000);
});

fetchData
    .then(result => {
        console.log(result); // Output: Data fetched successfully!
    })
    .catch(error => {
        console.error(error); // Output: Failed to fetch data.
    });
```

#### Explanation:
1. **`resolve`**:
   - Called when the asynchronous operation is successful, passing the resulting value.
2. **`reject`**:
   - Called when the asynchronous operation fails, passing the error reason.
3. **`then()`**:
   - Used to handle the resolved value of the promise.
4. **`catch()`**:
   - Used to handle errors or rejected promises.
5. **`finally()`**:
   - Executes a callback after the promise is settled (fulfilled or rejected), regardless of the outcome.

#### Chaining Promises:
Promises can be chained to handle a sequence of asynchronous operations.
```javascript
fetchData
    .then(result => {
        console.log(result);
        return "Next operation";
    })
    .then(nextResult => {
        console.log(nextResult);
    })
    .catch(error => {
        console.error(error);
    });
```

#### Combining Promises:
1. **`Promise.all()`**:
   - Waits for all promises to resolve or any to reject.
   ```javascript
   const promise1 = Promise.resolve(10);
   const promise2 = Promise.resolve(20);

   Promise.all([promise1, promise2]).then(results => {
       console.log(results); // Output: [10, 20]
   });
   ```

2. **`Promise.race()`**:
   - Resolves or rejects as soon as one of the promises settles.
   ```javascript
   const promise1 = new Promise(resolve => setTimeout(resolve, 100, "First"));
   const promise2 = new Promise(resolve => setTimeout(resolve, 200, "Second"));

   Promise.race([promise1, promise2]).then(result => {
       console.log(result); // Output: First
   });
   ```

#### Advantages of Promises:
- Avoids "callback hell" by chaining `.then()` calls.
- Provides better error handling with `.catch()`.
- Makes asynchronous code easier to read and maintain.

## 39. Async/Await

**Async/Await** is a modern way to handle asynchronous operations in JavaScript. It is built on top of Promises and provides a more readable and synchronous-looking syntax for writing asynchronous code.

#### Key Features:
1. **`async` Keyword**:
    - Declares a function as asynchronous.
    - An `async` function always returns a Promise.
    ```javascript
    async function example() {
         return "Hello, Async!";
    }

    example().then(result => console.log(result)); // Output: Hello, Async!
    ```

2. **`await` Keyword**:
    - Pauses the execution of an `async` function until the Promise is resolved or rejected.
    - Can only be used inside `async` functions.
    ```javascript
    async function fetchData() {
         const response = await fetch("https://api.example.com/data");
         const data = await response.json();
         console.log(data);
    }

    fetchData();
    ```

#### Example:
```javascript
function fetchUserData() {
     return new Promise(resolve => {
          setTimeout(() => resolve({ name: "Alice", age: 25 }), 1000);
     });
}

async function displayUserData() {
     console.log("Fetching user data...");
     const userData = await fetchUserData();
     console.log(`User: ${userData.name}, Age: ${userData.age}`);
}

displayUserData();
// Output:
// Fetching user data...
// User: Alice, Age: 25
```

#### Error Handling:
Use `try...catch` blocks to handle errors in `async` functions.
```javascript
async function fetchData() {
     try {
          const response = await fetch("https://api.example.com/data");
          if (!response.ok) {
                throw new Error("Network response was not ok");
          }
          const data = await response.json();
          console.log(data);
     } catch (error) {
          console.error("Error fetching data:", error);
     }
}

fetchData();
```

#### Parallel Execution:
Use `Promise.all()` with `await` to execute multiple asynchronous operations in parallel.
```javascript
async function fetchMultipleData() {
     const [data1, data2] = await Promise.all([
          fetch("https://api.example.com/data1").then(res => res.json()),
          fetch("https://api.example.com/data2").then(res => res.json())
     ]);
     console.log(data1, data2);
}

fetchMultipleData();
```

#### Advantages of Async/Await:
1. **Improved Readability**:
    - Makes asynchronous code look and behave more like synchronous code.
2. **Error Handling**:
    - Easier to handle errors using `try...catch`.
3. **Chaining Simplified**:
    - Avoids deeply nested `.then()` chains.

By understanding and using Async/Await, you can write cleaner and more maintainable asynchronous JavaScript code.

## 40. What are Pure Functions?

A **pure function** is a function that adheres to the following principles:
1. **Deterministic**: For the same input, it always produces the same output.
2. **No Side Effects**: It does not modify any external state or rely on external state that might change.

#### Characteristics of Pure Functions:
1. **Same Input, Same Output**:
    - A pure function always returns the same result when given the same arguments.
    ```javascript
    function add(a, b) {
        return a + b;
    }

    console.log(add(2, 3)); // Output: 5
    console.log(add(2, 3)); // Output: 5 (same input, same output)
    ```

2. **No Side Effects**:
    - A pure function does not modify variables, objects, or data outside its scope.
    ```javascript
    let count = 0;

    // Impure function
    function increment() {
        count++;
    }

    // Pure function
    function add(a, b) {
        return a + b;
    }
    ```

3. **Immutability**:
    - Pure functions do not modify their input arguments.
    ```javascript
    // Impure function
    function impureAddToArray(arr, value) {
        arr.push(value);
        return arr;
    }

    // Pure function
    function pureAddToArray(arr, value) {
        return [...arr, value];
    }

    const numbers = [1, 2, 3];
    console.log(pureAddToArray(numbers, 4)); // Output: [1, 2, 3, 4]
    console.log(numbers); // Output: [1, 2, 3] (original array is unchanged)
    ```

#### Benefits of Pure Functions:
1. **Predictability**:
    - Pure functions are easier to test and debug because their output depends only on their input.
2. **Reusability**:
    - They can be reused in different parts of the code without unintended side effects.
3. **Improved Readability**:
    - Pure functions are self-contained and easier to understand.

#### Use Cases:
1. **Functional Programming**:
    - Pure functions are a core concept in functional programming, enabling techniques like function composition and immutability.
2. **State Management**:
    - Pure functions are often used in state management libraries like Redux to ensure predictable state updates.

By adhering to the principles of pure functions, you can write more reliable and maintainable JavaScript code.


## 41. What is Functional Programming?

Functional programming (FP) is a programming paradigm that treats computation as the evaluation of mathematical functions and avoids changing state or mutable data. It emphasizes the use of pure functions, immutability, and declarative code to build software.

#### Key Principles of Functional Programming:
1. **Pure Functions**:
    - Functions that always produce the same output for the same input and have no side effects.
    ```javascript
    function add(a, b) {
         return a + b;
    }
    ```

2. **Immutability**:
    - Data is never modified. Instead, new data structures are created when changes are needed.
    ```javascript
    const numbers = [1, 2, 3];
    const newNumbers = [...numbers, 4]; // Original array remains unchanged
    ```

3. **First-Class Functions**:
    - Functions are treated as first-class citizens, meaning they can be assigned to variables, passed as arguments, and returned from other functions.
    ```javascript
    const greet = name => `Hello, ${name}!`;
    const sayHello = greet;
    console.log(sayHello("Alice")); // Output: Hello, Alice!
    ```

4. **Higher-Order Functions**:
    - Functions that take other functions as arguments or return functions.
    ```javascript
    const numbers = [1, 2, 3];
    const doubled = numbers.map(num => num * 2); // Higher-order function
    console.log(doubled); // Output: [2, 4, 6]
    ```

5. **Declarative Code**:
    - Focuses on what to do rather than how to do it, making code more readable and concise.
    ```javascript
    // Imperative
    let sum = 0;
    for (let i = 0; i < numbers.length; i++) {
         sum += numbers[i];
    }

    // Declarative
    const sum = numbers.reduce((acc, num) => acc + num, 0);
    ```

6. **Function Composition**:
    - Combining smaller functions to build more complex functions.
    ```javascript
    const multiplyByTwo = x => x * 2;
    const addThree = x => x + 3;
    const compose = (f, g) => x => f(g(x));
    const multiplyAndAdd = compose(addThree, multiplyByTwo);
    console.log(multiplyAndAdd(5)); // Output: 13
    ```

#### Benefits of Functional Programming:
1. **Predictable Code**:
    - Pure functions and immutability make code easier to test and debug.
2. **Reusability**:
    - Functions can be reused across different parts of the application.
3. **Concurrency**:
    - Immutability makes it easier to write concurrent and parallel code.
4. **Readability**:
    - Declarative code is often more concise and easier to understand.

#### Use Cases:
- **Data Transformation**:
  - Functional programming is ideal for transforming data using methods like `map`, `filter`, and `reduce`.
- **State Management**:
  - Libraries like Redux use functional programming principles to manage application state predictably.
- **Asynchronous Programming**:
  - Functional programming works well with promises and async/await for handling asynchronous operations.

## 42. Function Composition

Function composition is a technique in functional programming where multiple functions are combined to produce a new function. The output of one function becomes the input of the next, allowing you to build complex operations from simpler ones.

#### Syntax:
```javascript
const compose = (f, g) => x => f(g(x));
```

#### Example:
```javascript
const multiplyByTwo = x => x * 2;
const addThree = x => x + 3;

const multiplyAndAdd = compose(addThree, multiplyByTwo);

console.log(multiplyAndAdd(5)); // Output: 13
```

#### Explanation:
1. **`compose` Function**:
    - Takes two functions (`f` and `g`) and returns a new function.
    - The returned function takes an argument (`x`), applies `g` to it, and then applies `f` to the result.

2. **Order of Execution**:
    - Functions are executed from right to left in the composition.

#### Benefits of Function Composition:
1. **Reusability**:
    - Smaller, reusable functions can be combined to create more complex operations.
2. **Readability**:
    - Function composition makes code more declarative and easier to understand.
3. **Modularity**:
    - Encourages breaking down logic into smaller, testable functions.

#### Real-World Use Case:
Function composition is commonly used in data transformation pipelines, where data passes through a series of functions to produce the desired result.

```javascript
const trim = str => str.trim();
const toUpperCase = str => str.toUpperCase();
const addExclamation = str => `${str}!`;

const transform = compose(addExclamation, compose(toUpperCase, trim));

console.log(transform("  hello world  ")); // Output: "HELLO WORLD!"
```

By mastering function composition, you can write cleaner, more modular, and maintainable JavaScript code.

## 43. Object Prototypes

In JavaScript, every object has an internal property called `[[Prototype]]`, which points to another object or `null`. This is the basis of prototypal inheritance, allowing objects to share properties and methods.

#### Key Points:
1. **Prototype Chain**:
    - When accessing a property or method on an object, JavaScript first looks for it on the object itself. If not found, it traverses up the prototype chain to the object's prototype, and so on, until it reaches `null`.

2. **`Object.prototype`**:
    - The top of the prototype chain is `Object.prototype`, which provides common methods like `toString()` and `hasOwnProperty()`.

3. **Setting Prototypes**:
    - Prototypes can be set using the `Object.create()` method or the `__proto__` property (deprecated but still widely used).

#### Example:
```javascript
const parent = {
    greet: function() {
        console.log("Hello from the parent!");
    }
};

const child = Object.create(parent);
child.sayHi = function() {
    console.log("Hi from the child!");
};

child.greet(); // Output: Hello from the parent!
child.sayHi(); // Output: Hi from the child!
```

#### Explanation:
1. **`Object.create()`**:
    - Creates a new object with the specified prototype.
2. **Prototype Inheritance**:
    - The `child` object inherits the `greet` method from the `parent` object.

#### Modifying Prototypes:
- You can add methods or properties to an object's prototype, which will be available to all instances of that object.
```javascript
function Person(name) {
    this.name = name;
}

Person.prototype.sayHello = function() {
    console.log(`Hello, my name is ${this.name}`);
};

const alice = new Person("Alice");
alice.sayHello(); // Output: Hello, my name is Alice
```

#### Best Practices:
1. **Avoid Overwriting Prototypes**:
    - Instead of overwriting the prototype, extend it to avoid breaking the prototype chain.
2. **Use `Object.create()` for Inheritance**:
    - It is a cleaner and more modern approach compared to using constructors and manually setting `__proto__`.

By understanding object prototypes, you can leverage JavaScript's prototypal inheritance to write more efficient and reusable code.

## 44. Classes

Classes in JavaScript are a blueprint for creating objects. They were introduced in ES6 and provide a cleaner and more structured way to implement object-oriented programming compared to traditional constructor functions and prototypes.

#### Syntax:
```javascript
class ClassName {
    constructor(parameters) {
        // Initialize properties
        this.property = parameters;
    }

    // Method
    methodName() {
        // Method logic
    }
}
```

#### Example:
```javascript
class Person {
    constructor(name, age) {
        this.name = name;
        this.age = age;
    }

    greet() {
        console.log(`Hello, my name is ${this.name} and I am ${this.age} years old.`);
    }
}

const person1 = new Person("Alice", 25);
person1.greet(); // Output: Hello, my name is Alice and I am 25 years old.
```

#### Explanation:
1. **`constructor` Method**:
    - The `constructor` is a special method used to initialize object properties. It is called automatically when a new instance of the class is created.
2. **Methods**:
    - Methods defined inside a class are added to the prototype of the class, making them shared among all instances.

#### Inheritance:
Classes support inheritance, allowing you to create a new class that extends an existing class.
```javascript
class Animal {
    constructor(name) {
        this.name = name;
    }

    speak() {
        console.log(`${this.name} makes a noise.`);
    }
}

class Dog extends Animal {
    speak() {
        console.log(`${this.name} barks.`);
    }
}

const dog = new Dog("Rex");
dog.speak(); // Output: Rex barks.
```

#### Static Methods:
Static methods are defined on the class itself, not on instances of the class.
```javascript
class MathUtils {
    static add(a, b) {
        return a + b;
    }
}

console.log(MathUtils.add(2, 3)); // Output: 5
```

#### Getters and Setters:
Classes can define getter and setter methods to control access to properties.
```javascript
class Rectangle {
    constructor(width, height) {
        this.width = width;
        this.height = height;
    }

    get area() {
        return this.width * this.height;
    }

    set dimensions({ width, height }) {
        this.width = width;
        this.height = height;
    }
}

const rect = new Rectangle(10, 20);
console.log(rect.area); // Output: 200
rect.dimensions = { width: 15, height: 25 };
console.log(rect.area); // Output: 375
```

#### Key Points:
1. Classes are syntactic sugar over JavaScript's prototypal inheritance.
2. They make it easier to define and manage object-oriented code.
3. Use `extends` for inheritance and `super` to call the parent class's constructor or methods.

By understanding classes, you can write more structured and maintainable JavaScript code.

## 45. Currying and Partial Application

#### Currying:
Currying is a functional programming technique where a function is transformed into a sequence of functions, each taking a single argument. Instead of taking all arguments at once, the curried function takes them one at a time.

#### Syntax:
```javascript
function curry(fn) {
    return function curried(...args) {
        if (args.length >= fn.length) {
            return fn.apply(this, args);
        } else {
            return function(...nextArgs) {
                return curried.apply(this, args.concat(nextArgs));
            };
        }
    };
}
```

#### Example:
```javascript
function add(a, b) {
    return a + b;
}

const curriedAdd = curry(add);

console.log(curriedAdd(2)(3)); // Output: 5
```

#### Explanation:
1. **Breaking Down Arguments**:
   - Currying breaks down a function that takes multiple arguments into a series of functions that each take one argument.
2. **Reusability**:
   - Curried functions can be reused with different sets of arguments.

#### Use Case:
Currying is useful in scenarios where you want to create specialized functions by pre-filling some arguments.
```javascript
function multiply(a, b) {
    return a * b;
}

const curriedMultiply = curry(multiply);
const double = curriedMultiply(2);
console.log(double(5)); // Output: 10
```

---

#### Partial Application:
Partial application is a technique where a function is pre-filled with some arguments, producing a new function with fewer arguments.

#### Syntax:
```javascript
function partial(fn, ...presetArgs) {
    return function(...laterArgs) {
        return fn(...presetArgs, ...laterArgs);
    };
}
```

#### Example:
```javascript
function greet(greeting, name) {
    return `${greeting}, ${name}!`;
}

const sayHello = partial(greet, "Hello");
console.log(sayHello("Alice")); // Output: Hello, Alice!
```

#### Explanation:
1. **Pre-Filling Arguments**:
   - Partial application allows you to pre-fill some arguments of a function, creating a new function that requires fewer arguments.
2. **Simplifying Function Calls**:
   - It simplifies function calls by reducing the number of arguments needed at the point of invocation.

#### Difference Between Currying and Partial Application:
| Feature                | Currying                     | Partial Application         |
|------------------------|------------------------------|-----------------------------|
| Transformation         | Converts a function into a series of unary functions | Pre-fills some arguments of a function |
| Arguments Handling     | Takes one argument at a time | Takes multiple arguments at once |
| Use Case               | Function composition         | Simplifying function calls  |

## 46. Truthy and Falsy Values

In JavaScript, values are categorized as either **truthy** or **falsy** based on how they are evaluated in a boolean context (e.g., in an `if` statement). 

#### Falsy Values:
Falsy values are values that are considered `false` when evaluated in a boolean context. There are only six falsy values in JavaScript:
1. `false`
2. `0` (the number zero)
3. `""` (an empty string)
4. `null`
5. `undefined`
6. `NaN` (Not-a-Number)

#### Example:
```javascript
if (!false) console.log("Falsy"); // Output: Falsy
if (!0) console.log("Falsy");    // Output: Falsy
if (!"") console.log("Falsy");   // Output: Falsy
if (!null) console.log("Falsy"); // Output: Falsy
if (!undefined) console.log("Falsy"); // Output: Falsy
if (!NaN) console.log("Falsy");  // Output: Falsy
```

#### Truthy Values:
Truthy values are all values that are not falsy. This includes:
- Non-zero numbers (e.g., `1`, `-1`)
- Non-empty strings (e.g., `"hello"`)
- Objects (e.g., `{}`, `[]`)
- Functions

#### Example:
```javascript
if (true) console.log("Truthy");       // Output: Truthy
if (1) console.log("Truthy");          // Output: Truthy
if ("hello") console.log("Truthy");    // Output: Truthy
if ({}) console.log("Truthy");         // Output: Truthy
if ([]) console.log("Truthy");         // Output: Truthy
if (function() {}) console.log("Truthy"); // Output: Truthy
```

#### Use Cases:
1. **Conditional Statements**:
    - Truthy and falsy values are often used in `if` statements to determine the flow of execution.
    ```javascript
    const value = "hello";
    if (value) {
         console.log("Value is truthy");
    } else {
         console.log("Value is falsy");
    }
    ```

2. **Logical Operators**:
    - Logical operators like `||` and `&&` rely on truthy and falsy evaluations.
    ```javascript
    const name = "" || "Default Name"; // Output: "Default Name"
    const isValid = true && "Valid";   // Output: "Valid"
    ```



## End of File

This document provides a comprehensive guide to JavaScript interview questions and answers. It covers fundamental concepts, advanced topics, and practical examples to help you prepare effectively. If you have any suggestions or additional topics you'd like to see included, feel free to contribute!

Happy coding! 🚀
