const body = document.querySelector("body"),
    sidebar = body.querySelector(".sidebar"),
    toggle = body.querySelector(".toggle"),
    searchBtn = body.querySelector(".search-box");
toggle.addEventListener("click", () => {
    sidebar.classList.toggle("close");
});

function showSection(sectionId,url) {
    // Hide all sections
    const sections = document.querySelectorAll('.section-content');
    sections.forEach(section => section.classList.remove('active'));

    // Show the selected section
    const selectedSection = document.getElementById(sectionId);
    selectedSection.classList.add('active');
    // Reload the iframe
    const iframe = selectedSection.querySelector('iframe');
    iframe.src = url;
}

// Show the default section (e.g., dashboard) on page load
document.addEventListener('DOMContentLoaded', () => {
    showSection('dashboard','/admin/dashboard');
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