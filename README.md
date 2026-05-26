# University Library Management System

A highly performant, enterprise-grade desktop application engineered using JavaFX (OpenJFX) for the graphical user interface and backed by a relational database engine. The application utilizes a clean Data Access Object (DAO) architecture to manage operational records including membership registration, book inventory auditing, and transactional lending cycles.

## 🚀 Live Visuals & Dashboard
The system boots cleanly into a data-driven metrics dashboard rendering core system states fetched directly from relational tables.

* **Total Members Counter:** Dynamic database count aggregation tracking active user profiles.
* **Total Books Counter:** Live inventory metrics reporting overall catalog listings.
* **Active Borrows Tracker:** Real-time auditing tracking outstanding items.

---

## ✨ Architectural Design Pillars

* **Data Access Object (DAO) Pattern:** Decouples core structural business logic from data storage access layers, encapsulating direct raw SQL statements away from the primary UI rendering loop.
* **Event-Driven Interface State Machine:** JavaFX controllers use explicit event handling methods to synchronize active observable tabular data views immediately following target row transactions (Inserts/Deletions).
* **Relational Integrity Controls:** Implements structured relational tracking allowing immediate updates to item availability flags ("Available" vs. "Issued") dynamically inside transaction operations.

---

## 🛠️ Technology Stack & Requirements

* **Language Environment:** Java Core (JDK 17 or higher)
* **GUI Framework:** JavaFX (OpenJFX 21+)
* **Data Tier:** Relational Database Engine (SQL backend connected via JDBC drivers)
* **Dependency Management:** Maven / Gradle

---

## 🗄️ Relational Database Blueprint (SQL Schema)

To run this application locally, ensure your database has the following tables configured matching your DAO model structures:

```sql
CREATE TABLE books (
    book_id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(150) NOT NULL,
    genre VARCHAR(100),
    isbn VARCHAR(50) UNIQUE,
    publication_year INT,
    status VARCHAR(50) DEFAULT 'Available'
);

CREATE TABLE members (
    member_id INT PRIMARY KEY AUTO_INCREMENT,
    full_name VARCHAR(255) NOT NULL,
    email VARCHAR(150) UNIQUE NOT NULL,
    phone VARCHAR(50),
    department VARCHAR(100),
    membership_type VARCHAR(50) DEFAULT 'Student'
);

CREATE TABLE borrowings (
    borrow_id INT PRIMARY KEY AUTO_INCREMENT,
    member_id INT,
    book_id INT,
    borrow_date DATE NOT NULL,
    due_date DATE NOT NULL,
    return_date DATE,
    status VARCHAR(50) DEFAULT 'Active',
    FOREIGN KEY (member_id) REFERENCES members(member_id) ON DELETE CASCADE,
    FOREIGN KEY (book_id) REFERENCES books(book_id) ON DELETE CASCADE
);
