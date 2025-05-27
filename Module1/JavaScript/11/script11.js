// Get form element
const form = document.getElementById('registrationForm');
const successMessage = document.getElementById('successMessage');

// Validation functions
const validators = {
    name: (value) => {
        if (value.length < 2) {
            return 'Name must be at least 2 characters long';
        }
        if (!/^[a-zA-Z\s]+$/.test(value)) {
            return 'Name can only contain letters and spaces';
        }
        return '';
    },
    
    email: (value) => {
        const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        if (!emailRegex.test(value)) {
            return 'Please enter a valid email address';
        }
        return '';
    },
    
    event: (value) => {
        if (!value) {
            return 'Please select an event';
        }
        return '';
    }
};

// Show error message
const showError = (fieldName, message) => {
    const errorDiv = document.getElementById(`${fieldName}Error`);
    const formGroup = document.getElementById(fieldName).parentElement;
    
    errorDiv.textContent = message;
    errorDiv.style.display = message ? 'block' : 'none';
    formGroup.classList.toggle('has-error', Boolean(message));
};

// Form submission handler
form.addEventListener('submit', (event) => {
    event.preventDefault();
    
    // Get form values using form.elements
    const { name, email, event: selectedEvent } = form.elements;
    let hasErrors = false;

    // Validate each field
    Object.entries({ name, email, event: selectedEvent }).forEach(([fieldName, field]) => {
        const errorMessage = validators[fieldName](field.value);
        showError(fieldName, errorMessage);
        if (errorMessage) hasErrors = true;
    });

    // If no errors, process form
    if (!hasErrors) {
        // Simulate form submission
        console.log('Form submitted:', {
            name: name.value,
            email: email.value,
            event: selectedEvent.value
        });

        // Show success message
        successMessage.style.display = 'block';
        form.reset();

        // Hide success message after 3 seconds
        setTimeout(() => {
            successMessage.style.display = 'none';
        }, 3000);
    }
});

// Real-time validation on input
form.addEventListener('input', ({ target }) => {
    if (validators[target.name]) {
        const errorMessage = validators[target.name](target.value);
        showError(target.name, errorMessage);
    }
});