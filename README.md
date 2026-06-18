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

## Current Implementation: Use Case 6 (Booking History & Reporting)

**Purpose:**
Maintains a chronological record of all confirmed reservations using a `List<Reservation>`. This service supports generating audit reports and handles cancellation logic, effectively removing the reservation from the list and restoring the room inventory.

**Input:**
- Add to History: (Automatically added after confirmation)
- Report Request: `printBookingReport()`
- Cancel Request: `cancelReservation("D-184")`

**Output:**
```
--- [UC4 & UC6: Allocation & Booking History] ---
...
 -> Successfully allocated Room D-184 to Bob
 -> Added to History: D-184 (Bob)
...

--- [UC6: Reporting & Cancellation] ---

--- Booking History Report ---
 - S-429 | Guest: Alice | Room: Single
 - D-184 | Guest: Bob | Room: Double
 - S-812 | Guest: Charlie | Room: Suite
------------------------------

Cancelling Bob's Reservation (D-184)...
 -> Cancelled Reservation: D-184. Inventory restored.

--- Booking History Report ---
 - S-429 | Guest: Alice | Room: Single
 - S-812 | Guest: Charlie | Room: Suite
------------------------------
```
