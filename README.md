# 📦 Product Inventory Management System

A complete Spring Boot application designed to manage products using clean architecture principles.  
This project demonstrates CRUD operations, layered structure, validation, timestamps handling, and soft deletion using a real relational database.

---

## 🚀 Overview

This system allows you to:

- Add new products  
- Retrieve only active products  
- Get a product by ID  
- Update product information  
- Perform soft delete (mark inactive instead of removing)  
- Validate all important fields  
- Persist data using a relational database  
- Maintain clean separation of Controller, Service, Repository, and DTO layers  

---

## 🧱 System Features

### ✅ 1. Add a New Product
When a new product is created, the system:
- Accepts **name, category, price, quantity, availability**
- Automatically generates:
  - Unique Product ID  
  - Created Date  
  - Updated Date  
  - Active Status = `true`

---

### 🔍 2. Get All Active Products
- Returns only products with `activeStatus = true`
- Soft-deleted products do **not** appear
- Shows only available inventory items

---

### 🔎 3. Get Product by ID
- Fetch a product using its ID  
- Returns an error if:
  - Product does not exist  
  - Product is inactive  

---

### ✏️ 4. Update Product Details
Editable fields:
- Product Name  
- Category  
- Price  
- Quantity  

Automatically updates **Updated Date**.  
Fields that **cannot** be edited:
- Product ID  
- Created Date  
- Active Status  

---

### 🗑️ 5. Soft Delete a Product
Instead of permanent deletion:
- Set `activeStatus = false`
- Update the Updated Date
- Exclude from active product listings

---

## ⚖️ Validation Rules

The system applies the following constraints:

| Field         | Validation Rule                  |
|---------------|----------------------------------|
| Name          | Must not be empty (`@NotBlank`)  |
| Category      | Must not be empty (`@NotBlank`)  |
| Price         | Must be > 0 (`@Positive`)        |
| Quantity      | Must be ≥ 0 (`@PositiveOrZero`)  |
| Available     | Must not be null (`@NotNull`)    |
| Active Status | Must not be null (`@NotNull`)    |

---

## 🗄️ Database Persistence

- All products are stored in a relational DB (MySQL / H2 / PostgreSQL)
- IDs auto-generated
- Created & Updated timestamps maintained
- Soft deletion using boolean flag
- No permanent record removal

---

## 🧩 Layered Architecture

This project uses a clean and modular structure:

### **Controller Layer**
Handles REST API routes and returns responses.

### **Service Layer**
Contains business logic, validation, and soft deletion rules.

### **Repository Layer**
Uses Spring Data JPA for database operations.

