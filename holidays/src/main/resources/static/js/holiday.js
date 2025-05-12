function fetchHolidays(year) {
    $.ajax({
        url: `/api/holidays/by-country?countryName=${countryName}&year=${year}`,
        method: 'GET',
        success: function (data) {
            //Yalnızca yıl metnini değiştir
            $('#yearText').text(year);

            //Genel tatiller tablosunu doldur
            renderNationalTable(data["Genel Tatiller"], '#nationalHolidaysTableBody');

            //Bölgesel tatiller kısmı
            if (data["Bölgesel Tatiller"] === "Bulunmamaktadır") {
                $('#regionalHolidaysSection').html('<h3>Bölgesel Tatiller</h3><p>Bulunmamaktadır</p>');
            } else {
                $('#regionalHolidaysSection').html(`
                    <h3 style="margin-top:40px;">Bölgesel Tatiller</h3>
                    <table>
                        <thead>
                            <tr>
                                <th>Bölgenin Adı</th>
                                <th>Tarih</th>
                                <th>Gün</th>
                                <th>İsim</th>
                                <th>Gün Sayısı</th>
                                <th>Tür</th>
                            </tr>
                        </thead>
                        <tbody id="regionalHolidaysTableBody"></tbody>
                    </table>
                `);
                renderRegionTable(data["Bölgesel Tatiller"], '#regionalHolidaysTableBody');
            }
        },
        error: function () {
            alert("Tatil verileri alınırken bir hata oluştu.");
        }
    });
}

/*Genel tatiller için tablo*/
function renderNationalTable(holidays, containerSelector) {
    let rows = "";

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
                    <td>${h.sectorName}</td>
                </tr>`;
    });

    $(containerSelector).html(rows);
}

/*Bölgesel tatiller için tablo*/
function renderRegionTable(holidays, containerSelector) {
    let rows = "";

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

    $(containerSelector).html(rows);
}


function capitalizeFirstLetter(string) {
    return string.charAt(0).toUpperCase() + string.slice(1);
}