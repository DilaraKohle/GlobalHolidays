document.addEventListener("DOMContentLoaded", function () {
    const form = document.getElementById("workingDaysForm");
    const resultDiv = document.getElementById("workingDaysResult");

    if (!form) return;

    form.addEventListener("submit", function (e) {
        e.preventDefault();

        const startDate = document.getElementById("startDate").value;
        const endDate = document.getElementById("endDate").value;
        const sectorName = document.getElementById("sectorName").value;
        const encodedCountry = encodeURIComponent(window.countryName);
        const encodedSector = encodeURIComponent(sectorName);

        let url = `/api/holidays/working-days?countryName=${encodedCountry}&startDate=${startDate}&endDate=${endDate}`;
        if (sectorName) url += `&sectorName=${encodedSector}`;

        resultDiv.innerHTML = "Hesaplıyor...";

        fetch(url)
            .then(response => {
                if (!response.ok) throw new Error("Sunucu hatası");
                return response.json();
            })
            .then(data => {
                resultDiv.innerHTML = `
                    <strong>${data.country}</strong> ülkesinde
                    <strong>${data.sector}</strong> sektörü için<br>
                    <strong>${data.startDate}</strong> ile <strong>${data.endDate}</strong> arasında<br>
                    <span style="color: green; font-weight: bold;">${data.workingDays} gün</span> çalışma günü vardır.
                `;
            })
            .catch(error => {
                console.error(error);
                resultDiv.innerHTML = `<span style="color:red;">Hesaplama başarısız. Girdi verilerini kontrol edin.</span>`;
            });
    });
});