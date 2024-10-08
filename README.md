# Library Management System
Incubyte Assessment 😍

## Project Explaination
Language: Java

Dependencies: junit 4.13.1

IDE: IntelliJ IDEA



# Problem Statement
## Kata

## Kata: Library Management System

Objective
Create a simple library management system that allows users to perform basic operations
such as adding books, borrowing books, returning books, and viewing available books.
Requirements

. **Add Books**:

• Users should be able to add new books to the library.
• Each book should have a unique identifier (e.g., ISBN), title, author, and
publication year.

. **Borrow Books**:

• Users should be able to borrow a book from the library.
• The system should ensure that the book is available before allowing it to be
borrowed.
• If the book is not available, the system should raise an appropriate error.


. **Return Books**:

• Users should be able to return a borrowed book.
• The system should update the availability of the book accordingly.


. **View Available Books**:

• Users should be able to view a list of all available books in the library.


**Instructions**


. **Code Only:**

• This is a code-only kata. Focus on writing clean, maintainable code and
implementing the required features. Do not spend time creating any user
interface.

**. Test-Driven Development (TDD):**

• Write tests before implementing the functionality. Follow the three laws of TDD
• Ensure that all tests pass before considering the implementation complete.
• Aim for high test coverage and meaningful test cases.

**. Clean Coding Practices:**

• Write clean, readable, and maintainable code.
• Follow SOLID principles and other best practices in software design.
• Ensure the code is well-documented with meaningful comments and clear
variable/method names




# What is TDD

As the name suggests, the test process drives software development.

Moreover, it’s a structuring practice that enables developers and testers to obtain optimized code that proves resilient in the long term.

In TDD, developers create small test cases for every feature based on their initial understanding. The primary intention of this technique is to modify or write new code only if the tests fail. This prevents duplication of test scripts.

Robert C. Martin (“Uncle Bob”) provides a concise set of rules for practicing TDD.

1. Write production code only to pass a failing unit test.

2. Write no more of a unit test than sufficient to fail (compilation failures are failures).

3. Write no more production code than necessary to pass the one failing unit test.


## What I have Done

I have tested the system using a comprehensive suite of test cases, ensuring extensive coverage of all critical functionalities.

Tested with test cases as many as possible to ensure that it is woring properly

refactored code wherever needed

I encapsulated instance variables by making them private to enhance security and ensure proper data encapsulation.

## What could I have done?

I considered adding a boolean isBorrowed variable in the Book class to track borrowed books directly. This would allow automatic adjustment
of the book count upon borrowing and returning, eliminating the need for a HashMap and improving time complexity.

some time we need to do what client wants.We don't need to 
add functionality on our own.  As the problem statement only required the Book class to include ISBN, title, author, and production year,
I adhered strictly to those specifications, focusing on delivering exactly what the problem statement mentioned without adding unnecessary features.