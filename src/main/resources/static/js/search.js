async function searchCountries() {
    const query = document.getElementById("searchInput").value;

    if (query.length >= 1) {
        try {
            const response = await fetch(`/api/countries/search?name=${encodeURIComponent(query)}`);
            if (!response.ok) throw new Error("Sunucu hatası");

            const data = await response.json();

            const suggestions = document.getElementById("suggestionsList");
            suggestions.innerHTML = "";

            const container = document.getElementById("suggestionsContainer");

            if (data && data.length > 0) {
                data.forEach(country => {
                    const li = document.createElement("li");
                    const link = document.createElement("a");
                    link.href = `/countries/${country.code}`;
                    link.textContent = country.countryName;
                    li.appendChild(link);
                    suggestions.appendChild(li);
                });
            } else {
                const li = document.createElement("li");
                li.textContent = "Sonuç bulunamadı.";
                li.style.color = "#888";
                li.style.fontStyle = "italic";
                suggestions.appendChild(li);
            }

            container.style.display = "block";

        } catch (error) {
            console.error("Ülke arama sırasında hata oluştu:", error);
            document.getElementById("suggestionsContainer").style.display = "none";
        }
    } else {
        document.getElementById("suggestionsContainer").style.display = "none";
    }
}