/**
 * 
 */
document.addEventListener('DOMContentLoaded', () => {
    const errorMessage = document.getElementById('error-message');
    
    // Check if there's an error message in the URL parameters
    const urlParams = new URLSearchParams(window.location.search);
    const error = urlParams.get('error');
    if (error) {
        errorMessage.textContent = decodeURIComponent(error);
    }

 
});
