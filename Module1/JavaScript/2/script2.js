// Event constants
const eventName = "Summer Festival";
const eventDate = "2025-06-15";
let availableSeats = 50;

// Function to update event display
function updateEventDisplay() {
    const eventInfo = `
        Event: ${eventName}
        Date: ${eventDate}
        Available Seats: ${availableSeats}
    `;
    
    document.getElementById('eventDetails').innerHTML = 
        eventInfo.replace(/\n/g, '<br>');
}

// Book a seat
function bookSeat() {
    if (availableSeats > 0) {
        availableSeats--;
        console.log(`Seat booked! ${availableSeats} seats remaining`);
        updateEventDisplay();
    } else {
        alert("Sorry, no seats available!");
    }
}

// Cancel booking
function cancelBooking() {
    availableSeats++;
    console.log(`Booking cancelled. ${availableSeats} seats now available`);
    updateEventDisplay();
}

// Initial display
updateEventDisplay();