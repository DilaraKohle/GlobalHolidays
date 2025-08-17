async function fetchHolidays(year) {
    try {
        const response = await fetch(`/api/holidays/by-country?countryName=${countryName}&year=${year}`);
        if (!response.ok) throw new Error("Sunucu hatası");
        const data = await response.json();
        document.getElementById('yearText').textContent = year;
        renderNationalTable(data["Genel Tatiller"], 'nationalHolidaysTableBody');

        const regionalSection = document.getElementById('regionalHolidaysSection');
        if (data["Bölgesel Tatiller"] === "Bulunmamaktadır") {
            regionalSection.innerHTML = '<h3>Bölgesel Tatiller</h3><p>Bulunmamaktadır</p>';
        } else {
            regionalSection.innerHTML = `
                <h3>Bölgesel Tatiller</h3>
                <div id="TabloContainer">
                <table>
                    <thead>
                        <tr>
                            <th>Bölgenin Adı</th>
                            <th>Tarih</th>
                            <th>Gün</th>
                            <th>Tatil</th>
                            <th>Gün Sayısı</th>
                            <th>Tür</th>
                        </tr>
                    </thead>
                    <tbody id="regionalHolidaysTableBody"></tbody>
                </table>
                <div>
            `;
            renderRegionTable(data["Bölgesel Tatiller"], 'regionalHolidaysTableBody');
        }
    } catch (error) {
        alert("Tatil verileri alınırken bir hata oluştu.");
        console.error(error);
    }
}

function renderNationalTable(holidays, containerId) {
    const container = document.getElementById(containerId);
    let rows = "";

    holidays.sort((a, b) => new Date(a.startDate) - new Date(b.startDate));

    holidays.forEach(h => {
        const date = new Date(h.startDate);
        const day = date.toLocaleDateString('tr-TR', { weekday: 'long' });
        const dateFormatted = date.toLocaleDateString('tr-TR', { day: 'numeric', month: 'long' });
        const sector = h.sectorName === null || h.sectorName === undefined ? "Genel" : h.sectorName;

        rows += `<tr>
                    <td>${dateFormatted}</td>
                    <td>${capitalizeFirstLetter(day)}</td>
                    <td>${h.holidayName}</td>
                    <td>${h.durationDays}</td>
                    <td>${h.holidayTypeName}</td>
                    <td>${sector}</td>
                </tr>`;
    });
    container.innerHTML = rows;
}

function renderRegionTable(holidays, containerId) {
    const container = document.getElementById(containerId);
    let rows = "";

    holidays.sort((a, b) => new Date(a.startDate) - new Date(b.startDate));

    holidays.forEach(h => {
        const date = new Date(h.startDate);
        const day = date.toLocaleDateString('tr-TR', { weekday: 'long' });
        const dateFormatted = date.toLocaleDateString('tr-TR', { day: 'numeric', month: 'long' });

        rows += `<tr>
                    <td>${h.regionName}</td>
                    <td>${dateFormatted}</td>
                    <td>${capitalizeFirstLetter(day)}</td>
                    <td>${h.holidayName}</td>
                    <td>${h.durationDays}</td>
                    <td>${h.holidayTypeName}</td>
                </tr>`;
    });
    container.innerHTML = rows;
}

function capitalizeFirstLetter(string) {
    return string.charAt(0).toUpperCase() + string.slice(1);
}