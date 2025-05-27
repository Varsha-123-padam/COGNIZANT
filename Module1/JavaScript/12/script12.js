// DOM Elements
const form = document.getElementById('registrationForm');
const loading = document.getElementById('loading');
const successMessage = document.getElementById('successMessage');
const errorMessage = document.getElementById('errorMessage');

// Mock API URL
const API_URL = 'https://api.example.com/register';

// Show/hide loading state
const setLoading = (isLoading) => {
    loading.style.display = isLoading ? 'block' : 'none';
    form.querySelector('button').disabled = isLoading;
};

// Show message
const showMessage = (type, message) => {
    const messageElement = type === 'success' ? successMessage : errorMessage;
    messageElement.textContent = message;
    messageElement.style.display = 'block';
    
    // Hide message after 5 seconds
    setTimeout(() => {
        messageElement.style.display = 'none';
    }, 5000);
};

// Simulate API call
const mockFetch = (data) => {
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            // Simulate 80% success rate
            if (Math.random() > 0.2) {
                resolve({
                    ok: true,
                    json: () => Promise.resolve({
                        success: true,
                        message: 'Registration successful! Check your email for confirmation.'
                    })
                });
            } else {
                reject(new Error('Registration failed. Please try again later.'));
            }
        }, 2000); // 2 second delay
    });
};

// Form submission handler
form.addEventListener('submit', async (event) => {
    event.preventDefault();
    
    // Hide any existing messages
    successMessage.style.display = 'none';
    errorMessage.style.display = 'none';
    
    // Get form data
    const formData = new FormData(form);
    const data = Object.fromEntries(formData);
    
    // Show loading state
    setLoading(true);

    try {
        // Simulate fetch request
        const response = await mockFetch(data);
        const result = await response.json();
        
        // Show success message
        showMessage('success', result.message);
        form.reset();
        
    } catch (error) {
        // Show error message
        showMessage('error', error.message);
        console.error('Registration error:', error);
        
    } finally {
        // Hide loading state
        setLoading(false);
    }
});