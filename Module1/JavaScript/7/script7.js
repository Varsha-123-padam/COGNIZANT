// Event data
let events = [
    { id: 1, name: 'Summer Festival', date: '2025-06-15', registered: false },
    { id: 2, name: 'Tech Workshop', date: '2025-07-20', registered: false }
];

// DOM Elements
const eventContainer = document.querySelector('#eventContainer');
const searchInput = document.querySelector('#searchInput');
const addEventBtn = document.querySelector('#addEventBtn');

// Create event card
function createEventCard(event) {
    const card = document.createElement('div');
    card.className = `event-card ${event.registered ? 'registered' : ''}`;
    card.id = `event-${event.id}`;

    const title = document.createElement('h3');
    title.textContent = event.name;

    const date = document.createElement('p');
    date.textContent = `Date: ${event.date}`;

    const registerBtn = document.createElement('button');
    registerBtn.textContent = event.registered ? 'Cancel Registration' : 'Register';
    registerBtn.onclick = () => toggleRegistration(event.id);

    const deleteBtn = document.createElement('button');
    deleteBtn.textContent = 'Delete';
    deleteBtn.onclick = () => deleteEvent(event.id);

    card.append(title, date, registerBtn, deleteBtn);
    return card;
}

// Display all events
function displayEvents(eventList = events) {
    eventContainer.innerHTML = '';
    eventList.forEach(event => {
        eventContainer.appendChild(createEventCard(event));
    });
}

// Toggle registration
function toggleRegistration(eventId) {
    const event = events.find(e => e.id === eventId);
    if (event) {
        event.registered = !event.registered;
        const card = document.querySelector(`#event-${eventId}`);
        card.classList.toggle('registered');
        const registerBtn = card.querySelector('button');
        registerBtn.textContent = event.registered ? 'Cancel Registration' : 'Register';
    }
}

// Delete event
function deleteEvent(eventId) {
    events = events.filter(e => e.id !== eventId);
    const card = document.querySelector(`#event-${eventId}`);
    card.remove();
}

// Add new event
addEventBtn.addEventListener('click', () => {
    const newEvent = {
        id: events.length + 1,
        name: `New Event ${events.length + 1}`,
        date: '2025-12-31',
        registered: false
    };
    events.push(newEvent);
    eventContainer.appendChild(createEventCard(newEvent));
});

// Search events
searchInput.addEventListener('input', (e) => {
    const searchTerm = e.target.value.toLowerCase();
    const filteredEvents = events.filter(event => 
        event.name.toLowerCase().includes(searchTerm)
    );
    displayEvents(filteredEvents);
});

// Initial display
displayEvents();