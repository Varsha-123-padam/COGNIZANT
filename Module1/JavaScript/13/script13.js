// Debug logger
const debugLog = (message, data = null) => {
    const timestamp = new Date().toISOString().split('T')[1];
    const debugOutput = document.getElementById('debugOutput');
    const logMessage = `[${timestamp}] ${message}`;
    
    console.log(logMessage, data);
    debugOutput.innerHTML += data ? 
        `${logMessage}\n${JSON.stringify(data, null, 2)}\n\n` :
        `${logMessage}\n\n`;
    
    debugOutput.scrollTop = debugOutput.scrollHeight;
};

// Form validation
const validateForm = (formData) => {
    debugLog('Validating form data...');
    
    const errors = [];
    
    if (!formData.get('name')) {
        errors.push('Name is required');
    }
    
    if (!formData.get('email')) {
        errors.push('Email is required');
    } else if (!/\S+@\S+\.\S+/.test(formData.get('email'))) {
        errors.push('Email format is invalid');
    }
    
    if (!formData.get('event')) {
        errors.push('Event selection is required');
    }
    
    debugLog('Validation results:', errors.length ? { errors } : 'All valid');
    return errors;
};

// Mock API call
const mockApiCall = async (formData) => {
    debugLog('Preparing API call...', {
        endpoint: 'https://api.example.com/register',
        method: 'POST',
        data: Object.fromEntries(formData)
    });

    // Simulate network delay and potential failure
    await new Promise(resolve => setTimeout(resolve, 2000));
    
    // Simulate random failure
    if (Math.random() < 0.3) {
        throw new Error('Network error: Failed to register');
    }
    
    return { success: true, message: 'Registration successful' };
};

// Form submission handler
document.getElementById('registrationForm').addEventListener('submit', async (event) => {
    event.preventDefault();
    debugLog('Form submission started');

    try {
        // Create breakpoint here to inspect form data
        debugger;

        const formData = new FormData(event.target);
        debugLog('Form data collected:', Object.fromEntries(formData));

        // Validate form
        const errors = validateForm(formData);
        if (errors.length) {
            throw new Error(`Validation failed: ${errors.join(', ')}`);
        }

        // Submit form
        debugLog('Submitting form...');
        const result = await mockApiCall(formData);
        
        debugLog('Submission successful:', result);
        event.target.reset();

    } catch (error) {
        debugLog('Error occurred:', {
            message: error.message,
            stack: error.stack
        });
    }
});

// Input change logging
document.getElementById('registrationForm').addEventListener('input', (event) => {
    debugLog('Input changed:', {
        field: event.target.name,
        value: event.target.value
    });
});

debugLog('Form initialization complete');