// Event data
const events = [
    { id: 1, name: "Summer Festival", date: "2025-06-15", seats: 50 },
    { id: 2, name: "Tech Conference", date: "2024-01-01", seats: 0 },
    { id: 3, name: "Art Exhibition", date: "2025-08-20", seats: 100 }
];

// Display events
function displayEvents() {
    const eventList = document.getElementById('eventList');
    eventList.innerHTML = '';

    try {
        events.forEach(event => {
            // Check if event is upcoming and has seats
            const eventDate = new Date(event.date);
            const isUpcoming = eventDate > new Date();
            const hasSeats = event.seats > 0;

            if (isUpcoming && hasSeats) {
                const eventCard = `
                    <div class="event-card">
                        <h3>${event.name}</h3>
                        <p>Date: ${event.date}</p>
                        <p>Available Seats: ${event.seats}</p>
                        <button onclick="registerForEvent(${event.id})">Register</button>
                    </div>
                `;
                eventList.innerHTML += eventCard;
            } else if (!isUpcoming) {
                const pastEventCard = `
                    <div class="event-card past-event">
                        <h3>${event.name} (Past Event)</h3>
                        <p>Date: ${event.date}</p>
                    </div>
                `;
                eventList.innerHTML += pastEventCard;
            }
        });
    } catch (error) {
        showError("Error displaying events: " + error.message);
    }
}

// Register for event
function registerForEvent(eventId) {
    try {
        const event = events.find(e => e.id === eventId);
        
        if (!event) {
            throw new Error("Event not found");
        }

        if (event.seats <= 0) {
            throw new Error("No seats available");
        }

        event.seats--;
        displayEvents();
        alert(`Successfully registered for ${event.name}`);

    } catch (error) {
        showError("Registration failed: " + error.message);
    }
}

// Show error message
function showError(message) {
    const errorDiv = document.getElementById('errorMessages');
    errorDiv.innerHTML = `<div style="color: red; padding: 10px;">${message}</div>`;
    setTimeout(() => errorDiv.innerHTML = '', 3000);
}

// Initialize display
displayEvents();