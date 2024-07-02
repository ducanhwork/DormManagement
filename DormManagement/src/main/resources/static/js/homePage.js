const body = document.querySelector("body"),
    sidebar = body.querySelector(".sidebar"),
    toggle = body.querySelector(".toggle"),
    searchBtn = body.querySelector(".search-box");
toggle.addEventListener("click", () => {
    sidebar.classList.toggle("close");
});

function showSection(sectionId) {
    // Hide all sections
    const sections = document.querySelectorAll('.section-content');
    sections.forEach(section => section.classList.remove('active'));

    // Show the selected section
    const selectedSection = document.getElementById(sectionId);
    selectedSection.classList.add('active');
}

// Show the default section (e.g., dashboard) on page load
document.addEventListener('DOMContentLoaded', () => {
    showSection('dashboard');
});

function updateURL(newURL) {
    window.history.pushState(null, null, newURL);
}

window.addEventListener("message", function (event) {
    if (event.origin !== window.location.origin) {
        // Ignore messages from different origins
        return;
    }
    if (event.data.type === "navigate") {
        updateURL(event.data.url);
    }
}, false);