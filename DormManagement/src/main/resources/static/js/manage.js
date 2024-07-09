document.addEventListener('DOMContentLoaded', function() {
    var openBtn = document.getElementById('openPopupBtn');
    var closeBtn = document.getElementById('closePopupBtn');
    var popupForm = document.getElementById('popupForm');

    openBtn.addEventListener('click', function() {
        popupForm.style.display = 'block';
    });

    closeBtn.addEventListener('click', function() {
        popupForm.style.display = 'none';
    });

    // Close the popup if the user clicks outside of it
    window.onclick = function(event) {
        if (event.target == popupForm) {
            popupForm.style.display = 'none';
        }
    }
});
document.addEventListener('DOMContentLoaded', function() {
    var openBtn = document.getElementById('openPopupBtn1');
    var closeBtn = document.getElementById('closePopupBtn1');
    var popupForm = document.getElementById('popupForm1');
    var body= document.querySelector("body");


    openBtn.addEventListener('click', function() {
        popupForm.style.display = 'block';
        body.style.opacity = '1';
    });

    closeBtn.addEventListener('click', function() {
        popupForm.style.display = 'none';
    });

    // Close the popup if the user clicks outside of it
    window.onclick = function(event) {
        if (event.target == popupForm) {
            popupForm.style.display = 'none';
        }
    }
});
function confirmDelete() {
    return confirm("Do you want to delete this dom ?");
}