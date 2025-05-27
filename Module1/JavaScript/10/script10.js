// Event data with default values
const defaultEvent = {
    name: 'Untitled Event',
    date: new Date().toISOString().split('T')[0],
    capacity: 50,
    registered: 0
};

// Event collection
let events = [
    { id: 1, name: 'Tech Workshop', date: '2025-06-15', capacity: 30, registered: 0 },
    { id: 2, name: 'Music Festival', date: '2025-07-20', capacity: 100, registered: 0 }
];

// Create event with default parameters
const createEvent = ({ name, date, capacity } = defaultEvent) => {
    const newEvent = {
        id: Date.now(),
        name,
        date,
        capacity,
        registered: 0
    };
    events = [...events, newEvent];
    renderEvents();
};

// Filter events using destructuring
const filterEvents = (searchTerm = '') => {
    return events.filter(({ name }) => 
        name.toLowerCase().includes(searchTerm.toLowerCase())
    );
};

// Register for event using destructuring and spread
const registerForEvent = (eventId) => {
    events = events.map(event => {
        if (event.id === eventId) {
            const { registered, capacity } = event;
            if (registered < capacity) {
                return { ...event, registered: registered + 1 };
            }
        }
        return event;
    });
    renderEvents();
};

// Render events with template literals
const renderEvents = () => {
    const eventList = document.getElementById('eventList');
    eventList.innerHTML = events.map(({ id, name, date, capacity, registered }) => `
        <div class="event-card">
            <h3>${name}</h3>
            <p>Date: ${date}</p>
            <p>Availability: ${capacity - registered}/${capacity}</p>
            <button onclick="registerForEvent(${id})" 
                    ${registered >= capacity ? 'disabled' : ''}>
                Register
            </button>
        </div>
    `).join('');
};

// Event listeners using arrow functions
document.getElementById('addEventBtn').addEventListener('click', () => {
    const customEvent = {
        name: `Custom Event ${events.length + 1}`,
        date: '2025-12-31',
        capacity: 50
    };
    createEvent(customEvent);
});

document.getElementById('searchInput').addEventListener('input', ({ target }) => {
    const filtered = filterEvents(target.value);
    const eventList = document.getElementById('eventList');
    eventList.innerHTML = filtered.map(({ id, name, date, capacity, registered }) => `
        <div class="event-card">
            <h3>${name}</h3>
            <p>Date: ${date}</p>
            <p>Availability: ${capacity - registered}/${capacity}</p>
            <button onclick="registerForEvent(${id})"
                    ${registered >= capacity ? 'disabled' : ''}>
                Register
            </button>
        </div>
    `).join('');
});

// Initial render
renderEvents();