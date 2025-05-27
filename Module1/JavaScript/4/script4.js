// Event tracking closure
const eventTracker = (function() {
    const registrations = {
        workshop: 0,
        seminar: 0
    };

    return {
        addRegistration: function(category) {
            registrations[category]++;
            return registrations[category];
        },
        getCount: function(category) {
            return registrations[category];
        }
    };
})();

// Event management system
const eventSystem = {
    events: [],

    // Add new event
    addEvent: function(name, category, date, capacity) {
        const event = {
            id: this.events.length + 1,
            name,
            category,
            date,
            capacity,
            registered: 0
        };
        this.events.push(event);
        return event;
    },

    // Register user for event
    registerUser: function(eventId) {
        const event = this.events.find(e => e.id === eventId);
        if (event && event.registered < event.capacity) {
            event.registered++;
            eventTracker.addRegistration(event.category);
            return true;
        }
        return false;
    },

    // Higher-order function for filtering events
    filterEvents: function(filterCallback) {
        return this.events.filter(filterCallback);
    }
};

// Initialize some events
window.onload = function() {
    eventSystem.addEvent("JavaScript Basics", "workshop", "2025-06-15", 20);
    eventSystem.addEvent("Web Security", "seminar", "2025-07-20", 30);
    eventSystem.addEvent("Node.js Advanced", "workshop", "2025-08-10", 15);
    displayEvents();
};

// Display events
function displayEvents(events = eventSystem.events) {
    const eventList = document.getElementById('eventList');
    eventList.innerHTML = events.map(event => `
        <div class="event">
            <h3>${event.name}</h3>
            <p>Category: ${event.category}</p>
            <p>Date: ${event.date}</p>
            <p>Available: ${event.capacity - event.registered}</p>
            <button onclick="registerForEvent(${event.id})">Register</button>
        </div>
    `).join('');
}

// Register for event handler
function registerForEvent(eventId) {
    if (eventSystem.registerUser(eventId)) {
        alert('Registration successful!');
        displayEvents();
    } else {
        alert('Registration failed - event might be full');
    }
}

// Show registration count
function showRegistrationCount(category) {
    const count = eventTracker.getCount(category);
    alert(`Total ${category} registrations: ${count}`);
}

// Search events
function searchEvents() {
    const searchTerm = document.getElementById('searchTerm').value.toLowerCase();
    const filteredEvents = eventSystem.filterEvents(event => 
        event.name.toLowerCase().includes(searchTerm) || 
        event.category.toLowerCase().includes(searchTerm)
    );
    displayEvents(filteredEvents);
}