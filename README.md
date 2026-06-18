# BookMyStay App

A hotel booking app that lets guests search and reserve rooms/services on a first-come, first-served basis. It manages live inventory (room types, counts, prices, amenities), enforces availability holds, processes bookings, and tracks add-on services (e.g., breakfast, airport pickup, spa). Inventory updates atomically as reservations confirm, preventing double-booking.

## Use Cases

### 1. Room Inventory Setup & Management
**Description:** Initializes room types (Single, Double, Suite), stores counts and prices, and provides real-time availability updates.
**Data Structures:** `HashMap<String, Integer>`, `HashMap<String, Double>`

### 2. Room Search & Availability Check
**Description:** Read-only access to view available room types, pricing, and prevent booking of unavailable rooms. 
**Data Structures:** `HashMap` (read operations)

### 3. Booking Request (First-Come-First-Served)
**Description:** Handles incoming booking requests sequentially during peak demand, enforcing arrival order.
**Data Structures:** `Queue<Reservation>` (`LinkedList`)

### 4. Reservation Confirmation & Room Allocation
**Description:** Assigns unique room IDs to reservations to prevent double booking and syncs instantly with inventory.
**Data Structures:** `Set<String>` (`HashSet`), `HashMap<String, Set<String>>`

### 5. Add-On Service Selection
**Description:** Attaches optional services (breakfast, spa, pickup) to bookings and calculates additional costs.
**Data Structures:** `Map<String, List<Service>>`

### 6. Booking History & Reporting
**Description:** Stores confirmed reservations, supports cancellation, and generates audit reports.
**Data Structures:** `List<Reservation>` (`ArrayList`)

---

## Current Implementation: Use Case 5 (Add-On Service Selection)

**Purpose:**
Uses a `Map<String, List<Service>>` to associate multiple optional services (like Breakfast, Spa) to a specific booking ID. It dynamically calculates the additional cost incurred by these services without altering the base room rate.

**Input:**
- Add Service: `("D-184", Service("Breakfast", $20.0))`
- Add Service: `("D-184", Service("Spa", $50.0))`

**Output:**
```
--- [UC5: Add-On Service Selection] ---
Adding services to Bob's reservation...
 -> Added Breakfast ($20.0) to Reservation D-184
 -> Added Spa ($50.0) to Reservation D-184
Bob's total add-on cost: $70.0
```
