function searchCountries() {
        var query = $("#searchInput").val();
        if (query.length >= 1) {
        $.ajax({
            url: "/api/countries/search", //Arama API'sine istek
            type: "GET",
            data: { name: query },  //Parametre olarak name'i gönderiyoruz
            success: function(data) {
                var suggestions = $("#suggestionsList");
                suggestions.empty(); //Önceden eklenmiş önerileri temizle
                if (data && data.length > 0) {
                    data.forEach(function(country) {
                        suggestions.append('<li><a href="/countries/' + country.code + '">' + country.countryName + '</a></li>');
                    });
                    $("#suggestionsContainer").show();  //Göster
                } else {
                    $("#suggestionsContainer").hide(); //Hiç öneri yoksa gizle
                }
            }
        });
    } else {
        $("#suggestionsContainer").hide(); //Eğer arama kutusu boşsa önerileri gizle
    }
}