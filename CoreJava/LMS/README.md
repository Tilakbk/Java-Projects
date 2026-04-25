# Library Management System (LMS)

A simple Java console-based Library Management System built using plain Java classes and file-based persistence.

## Overview

This project provides a basic library management application with two user roles:
- `Admin`: add/delete books, search books, view orders, erase all data
- `NormalUser`: view books, search books, place orders, borrow books, calculate fines, return books

The system persists users, books, orders, and borrowed records in local files under the `Data` folder.

## Features

- User registration and login by phone number and email
- Admin and normal user role support
- Add and delete books (admin only)
- Search for books by name
- View all available books
- Place book orders and update inventory
- Borrow and return books with due-date tracking
- Fine calculation for late returns
- Data persistence using plain text files
- Erase all stored data from the system

## Project Structure

- `Library/Main.java`: application entry point and main menu
- `Library/Database.java`: handles in-memory data, file loading, saving, and persistence operations
- `Library/User.java`: base user class
- `Library/Admin.java`: admin-specific menu and operations
- `Library/NormalUser.java`: normal user menu and operations
- `Library/IOOperation.java`: interface for menu operations
- `Library/*Book*.java`: classes for book operations, adding, deleting, searching, viewing, borrowing, returning, and ordering
- `Library/Order.java`: order record model
- `Library/Borrowing.java`: borrowing record model
- `Data/`: storage directory for application data files

## Data Storage

The app stores data in the `Data` directory using plain text files named:
- `Users`
- `Books`
- `Order`
- `BorrowedBook`

> Note: The current implementation uses hard-coded absolute paths to `D:\Java-Projects\CoreJava\LMS\Data`. If you move the project to a different location, update the paths in `Library/Database.java` or convert them to relative paths.

## Setup and Run

### Compile

Open a terminal at the `d:\Java-Projects` root and execute:

```powershell
javac CoreJava/LMS/Library/*.java
```

### Run

From the same root folder, run:

```powershell
java CoreJava.LMS.Library.Main
```

## Usage

1. Launch the application.
2. Select `1` to log in or `2` to create a new account.
3. Choose `Admin` or `Normal user` when creating a new account.
4. Use the displayed menu options to perform library actions.

## Notes and Limitations

- Input is read from the console and does not use a graphical interface.
- Data files are text-based and use simple custom separators like `<N/>`, `<NewBook/>`, and `<NewOrder/>`.
- The code assumes the `Data` directory exists or can be created on startup.
- Some file operations are hard-coded to Windows paths.
- No automated unit tests are included.

## Improvements

Possible enhancements for the project include:
- Use relative file paths and configurable storage locations
- Add input validation and better error handling
- Replace text-based persistence with a database or JSON storage
- Add a continuous loop for user menus rather than returning to the main method only
- Add support for multiple copies, search by author/publisher, and user roles persistence

---

Enjoy using the Library Management System!
