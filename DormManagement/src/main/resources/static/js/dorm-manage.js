document.addEventListener('DOMContentLoaded', function() {
    const openButtons = document.querySelectorAll('.open-button');
    const closeButtons = document.querySelectorAll('.cancel');
    const popups = document.querySelectorAll('.form-popup');
    const overlay = document.querySelector('.overlay');

    openButtons.forEach(function(button, index) {
        button.addEventListener('click', function() {
            popups[index].style.display = 'block';
            overlay.style.display = 'block';
        });
    });

    closeButtons.forEach(function(button) {
        button.addEventListener('click', function() {
            button.closest('.form-popup').style.display = 'none';
            overlay.style.display = 'none';
        });
    });
    overlay.addEventListener('click', function() {
        popups.forEach(function(popup) {
            popup.style.display = 'none';
        });
        overlay.style.display = 'none';
    });
});
