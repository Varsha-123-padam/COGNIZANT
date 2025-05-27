// Sample events data
const events = [
    { id: 1, name: 'Technical Workshop', date: '2025-06-15' },
    { id: 2, name: 'Web Conference', date: '2025-07-20' }
];

// jQuery document ready
$(document).ready(function() {
    // Create event cards
    events.forEach(event => {
        $('#eventContainer').append(`
            <div class="event-card" id="event-${event.id}">
                <h3>${event.name}</h3>
                <p>Date: ${event.date}</p>
                <button class="register-event" data-id="${event.id}">
                    Register
                </button>
            </div>
        `);
    });

    // Show events button click
    $('#registerBtn').click(function() {
        $('.event-card').fadeIn(1000);
    });

    // Hide events button click
    $('#hideBtn').click(function() {
        $('.event-card').fadeOut(500);
    });

    // Individual event registration
    $(document).on('click', '.register-event', function() {
        const eventId = $(this).data('id');
        const card = $(`#event-${eventId}`);
        
        // Animate the card
        card.fadeOut(300, function() {
            $(this)
                .css('background-color', '#e8f5e9')
                .html('<h3>Registration Successful!</h3>')
                .fadeIn(300);
        });
    });
});