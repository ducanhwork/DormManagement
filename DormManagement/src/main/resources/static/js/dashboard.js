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
document.addEventListener('DOMContentLoaded', function() {
    var dormData = /*[[${listDorm}]]*/[];

    dormData.forEach(function(dorm) {
        var containerId = 'container-' + dorm.id;
        var data = dorm.room.map(function(room) {
            return { name: room.status, y: room.count };
        });

        Highcharts.chart(containerId, {
            colors: ['#01BAF2', '#71BF45', '#FAA74B', '#B37CD2'],
            chart: {
                type: 'pie'
            },
            title: {
                text: dorm.name + ' - Number of rooms'
            },
            tooltip: {
                valueSuffix: '%'
            },
            plotOptions: {
                pie: {
                    allowPointSelect: true,
                    cursor: 'pointer',
                    dataLabels: {
                        enabled: true,
                        format: '{point.name}: {y}'
                    },
                    showInLegend: true
                }
            },
            series: [{
                name: 'Percentage',
                colorByPoint: true,
                innerSize: '75%',
                data: data
            }]
        });
    });
});