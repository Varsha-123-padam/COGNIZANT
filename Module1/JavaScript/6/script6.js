// Initialize events array
let events = [
    { id: 1, name: "Workshop on Baking", type: "workshop", date: "2025-06-15" },
    { id: 2, name: "Jazz Night", type: "music", date: "2025-07-20" },
    { id: 3, name: "Rock Concert", type: "music", date: "2025-08-10" },
    { id: 4, name: "Pottery Class", type: "workshop", date: "2025-09-01" }
];

// Display events using .map()
function displayEvents(eventList = events) {
    const container = document.getElementById('eventList');
    const eventCards = eventList.map(event => `
        <div class="event-card">
            <h3>${event.name}</h3>
            <p>Type: ${event.type}</p>
            <p>Date: ${event.date}</p>
            <button onclick="removeEvent(${event.id})">Remove</button>
        </div>
    `).join('');
    
    container.innerHTML = eventCards;
}

// Add new event using .push()
function addNewEvent() {
    const types = ["music", "workshop", "sports", "art"];
    const randomType = types[Math.floor(Math.random() * types.length)];
    
    const newEvent = {
        id: events.length + 1,
        name: `${randomType.charAt(0).toUpperCase() + randomType.slice(1)} Event ${events.length + 1}`,
        type: randomType,
        date: "2025-12-31"
    };
    
    events.push(newEvent);
    displayEvents();
    console.log("Added new event:", newEvent);
}

// Show music events using .filter()
function showMusicEvents() {
    const musicEvents = events.filter(event => event.type === "music");
    displayEvents(musicEvents);
    console.log("Filtered music events:", musicEvents);
}

// Show all events
function showAllEvents() {
    displayEvents();
}

// Remove event
function removeEvent(id) {
    events = events.filter(event => event.id !== id);
    displayEvents();
    console.log("Removed event with ID:", id);
}

// Initialize display
displayEvents();