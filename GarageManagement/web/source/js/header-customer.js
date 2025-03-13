document.addEventListener('DOMContentLoaded', function() {
        var toggleLink = document.querySelector('.user-toggle');
        var dropdownMenu = document.querySelector('.user-menu');
        
        // Toggle dropdown on click
        toggleLink.addEventListener('click', function(e) {
            e.preventDefault(); // Prevent default link behavior
            dropdownMenu.classList.toggle('active');
        });
        
        // Hide dropdown when clicking outside
        document.addEventListener('click', function(e) {
            if (!toggleLink.contains(e.target) && !dropdownMenu.contains(e.target)) {
                dropdownMenu.classList.remove('active');
            }
        });
    });