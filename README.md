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

## Current Implementation: Use Case 2 (Room Search & Availability Check)

**Purpose:**
Provides a read-only `SearchService` for guests to search for available rooms, view pricing, and check amenities without modifying the core inventory data. It ensures guests cannot proceed with booking an unavailable room.

**Input:**
- Search Request: `roomType = "Double"`
- Search Request: `roomType = "Presidential"`

**Output:**
```
--- [UC2: Room Search & Availability Check] ---
Searching for room type: Double
 -> Success: 5 Double room(s) available.
    Price    : $150.0 per night
    Amenities: 2 Beds, AC, TV, Free Wi-Fi
Searching for room type: Presidential
 -> Sorry, no Presidential rooms are currently available.
```
