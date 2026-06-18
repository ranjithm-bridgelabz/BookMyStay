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

## Current Implementation: Use Case 3 (Booking Request Queue)

**Purpose:**
Implements a First-Come-First-Served logic using a `Queue<Reservation>` (`LinkedList`). This ensures fairness during high traffic, enqueuing booking requests in their exact arrival order and processing them sequentially to avoid race conditions.

**Input:**
- Add Request: `Reservation("Alice", "Single")`
- Add Request: `Reservation("Bob", "Double")`
- Add Request: `Reservation("Charlie", "Suite")`

**Output:**
```
--- [UC3: Booking Request Queue (FIFO)] ---
Enqueued booking request: ReservationRequest{guest='Alice', roomType='Single'}
Enqueued booking request: ReservationRequest{guest='Bob', roomType='Double'}
Enqueued booking request: ReservationRequest{guest='Charlie', roomType='Suite'}

--- Processing Queue ---
Processing next request: ReservationRequest{guest='Alice', roomType='Single'}
Processing next request: ReservationRequest{guest='Bob', roomType='Double'}
Processing next request: ReservationRequest{guest='Charlie', roomType='Suite'}
```
