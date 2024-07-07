function openTab(evt, tabName) {
    let i, tabcontent, tabbuttons;

    tabcontent = document.getElementsByClassName("tab-content");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }

    tabbuttons = document.getElementsByClassName("tab-button");
    for (i = 0; i < tabbuttons.length; i++) {
        tabbuttons[i].className = tabbuttons[i].className.replace(" active", "");
    }

    document.getElementById(tabName).style.display = "block";
    evt.currentTarget.className += " active";
}

function filterTable() {
    const searchInput = document.getElementById('searchInput').value.toLowerCase();
    const rows = document.querySelectorAll('#paymentTable tbody tr');
    rows.forEach(row => {
        const cells = row.getElementsByTagName('td');
        const tenantName = cells[2].innerText.toLowerCase();
        const tenantPhone = cells[2].innerText.toLowerCase();
        row.style.display = (tenantName.includes(searchInput) || tenantPhone.includes(searchInput)) ? '' : 'none';
    });
}
