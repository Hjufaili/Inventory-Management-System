# Product Inventory Management System

This is a Spring Boot app that manages products in a clean, organized way.  
It supports adding, viewing, updating, and soft-deleting products using a real database.

---

## What the System Can Do

### Add Product
**You provide:**  
- Name  
- Category  
- Price  
- Quantity  
- Availability  

**System automatically sets:**  
- Product ID  
- Created Date  
- Updated Date  
- Active = `true`

---

### Get All Products
- Shows **only active** products  
- Soft-deleted products are hidden

---

### Get Product by ID
- Returns the product if it exists and is active  
- Returns "Product not found" if the product is missing or inactive

---

### Update Product
You can update:
- Name  
- Category  
- Price  
- Quantity  

**System auto-updates the Updated Date.**

You **cannot** change:
- Product ID  
- Created Date  
- Active Status  

---

### Soft Delete
- Marks the product as inactive (not removed from the database)  
- Updates the Updated Date  

---

## Validation
- **Name:** must not be empty  
- **Category:** must not be empty  
- **Price:** must be > 0  
- **Quantity:** must be ≥ 0  

---

## Database
- Uses a relational database  
- Auto-generated product IDs  
- Created and updated timestamps maintained  
- Records are **not permanently deleted** (soft delete)

---

## Project Structure
- **Controller** → handles API endpoints  
- **Service** → contains business logic  
- **Repository** → performs database operations  
