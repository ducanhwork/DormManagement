document.getElementById('selectAll').addEventListener('change', function() {
    const checkboxes = document.querySelectorAll('#servicesTable tbody input[type="checkbox"]');
    checkboxes.forEach(checkbox => checkbox.checked = this.checked);
});

function filterTable() {
    const searchInput = document.getElementById('searchInput').value.toLowerCase();
    const rows = document.querySelectorAll('#servicesTable tbody tr');
    rows.forEach(row => {
        const cells = row.getElementsByTagName('td');
        const serviceName = cells[1].innerText.toLowerCase();
        row.style.display = serviceName.includes(searchInput) ? '' : 'none';
    });
}
