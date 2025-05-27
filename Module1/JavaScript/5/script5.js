// Event Constructor
function Event(name, date, capacity) {
    this.name = name;
    this.date = new Date(date);
    this.capacity = capacity;
    this.registered = 0;
    this.waitlist = [];
}

// Adding methods to prototype
Event.prototype.checkAvailability = function() {
    return this.capacity - this.registered;
};

Event.prototype.register = function(personName) {
    if (this.checkAvailability() > 0) {
        this.registered++;
        return `${personName} registered successfully!`;
    } else {
        this.waitlist.push(personName);
        return `${personName} added to waitlist.`;
    }
};

// Create sample event
const summerFestival = new Event("Summer Festival", "2025-06-15", 50);

// Function to display event details
function listEventDetails() {
    const details = document.getElementById('eventDetails');
    const entries = Object.entries(summerFestival);
    
    let html = '<h2>Event Details:</h2><ul>';
    entries.forEach(([key, value]) => {
        if (key !== 'waitlist') {
            html += `<li><strong>${key}:</strong> ${value}</li>`;
        }
    });
    html += '</ul>';
    
    details.innerHTML = html;
}

// Function to check and display availability
function checkAvailability() {
    const available = summerFestival.checkAvailability();
    alert(`Available seats: ${available}`);
}

// Test registrations
console.log(summerFestival.register("John Doe"));
console.log(summerFestival.register("Jane Smith"));