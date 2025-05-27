// Mock API endpoint
const mockApiUrl = 'https://api.jsonbin.io/v3/b/your-bin-id';

// UI Elements
const spinner = document.getElementById('spinner');
const eventList = document.getElementById('eventList');

// Show/hide loading spinner
function toggleSpinner(show) {
    spinner.style.display = show ? 'block' : 'none';
}

// Display events
function displayEvents(events) {
    eventList.innerHTML = events.map(event => `
        <div class="event-card">
            <h3>${event.name}</h3>
            <p>Date: ${event.date}</p>
            <p>Category: ${event.category}</p>
        </div>
    `).join('');
}

// Show error message
function showError(message) {
    eventList.innerHTML = `<div class="error">${message}</div>`;
}

// Promise-based implementation
function loadEventsPromise() {
    toggleSpinner(true);
    eventList.innerHTML = '';

    // Simulating API call with timeout
    new Promise((resolve, reject) => {
        setTimeout(() => {
            const success = Math.random() > 0.3; // 70% success rate
            if (success) {
                resolve([
                    { name: "Summer Festival", date: "2025-06-15", category: "Music" },
                    { name: "Tech Workshop", date: "2025-07-20", category: "Education" }
                ]);
            } else {
                reject(new Error("Failed to load events"));
            }
        }, 1500);
    })
    .then(events => {
        displayEvents(events);
    })
    .catch(error => {
        showError(error.message);
    })
    .finally(() => {
        toggleSpinner(false);
    });
}

// Async/Await implementation
async function loadEventsAsync() {
    try {
        toggleSpinner(true);
        eventList.innerHTML = '';

        // Simulating API call with timeout
        const events = await new Promise((resolve, reject) => {
            setTimeout(() => {
                const success = Math.random() > 0.3; // 70% success rate
                if (success) {
                    resolve([
                        { name: "Coding Bootcamp", date: "2025-08-10", category: "Education" },
                        { name: "Art Exhibition", date: "2025-09-15", category: "Culture" }
                    ]);
                } else {
                    reject(new Error("Failed to load events"));
                }
            }, 1500);
        });

        displayEvents(events);
    } catch (error) {
        showError(error.message);
    } finally {
        toggleSpinner(false);
    }
}