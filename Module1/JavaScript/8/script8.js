// Event data
let events = [
    { id: 1, name: 'JavaScript Workshop', category: 'workshop', registered: false },
    { id: 2, name: 'Web Security Seminar', category: 'seminar', registered: false },
    { id: 3, name: 'Tech Conference 2025', category: 'conference', registered: false }
];

// DOM Elements
const eventList = document.getElementById('eventList');
const searchInput = document.getElementById('searchInput');
const categoryFilter = document.getElementById('categoryFilter');

// Display events
function displayEvents(filteredEvents = events) {
    eventList.innerHTML = filteredEvents.map(event => `
        <div class="event-card ${event.registered ? 'registered' : ''}" id="event-${event.id}">
            <h3>${event.name}</h3>
            <p>Category: ${event.category}</p>
            <button onclick="toggleRegistration(${event.id})">
                ${event.registered ? 'Cancel Registration' : 'Register'}
            </button>
        </div>
    `).join('');
}

// Toggle registration status
function toggleRegistration(eventId) {
    const event = events.find(e => e.id === eventId);
    if (event) {
        event.registered = !event.registered;
        displayEvents(filterEvents());
    }
}

// Filter events based on search and category
function filterEvents() {
    const searchTerm = searchInput.value.toLowerCase();
    const categoryTerm = categoryFilter.value.toLowerCase();
    
    return events.filter(event => {
        const matchesSearch = event.name.toLowerCase().includes(searchTerm);
        const matchesCategory = !categoryTerm || event.category === categoryTerm;
        return matchesSearch && matchesCategory;
    });
}

// Event Listeners
searchInput.addEventListener('keydown', function(e) {
    // Short delay to ensure input value is updated
    setTimeout(() => displayEvents(filterEvents()), 0);
});

categoryFilter.addEventListener('change', function() {
    displayEvents(filterEvents());
});

// Initialize display
displayEvents();