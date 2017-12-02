document.addEventListener("DOMContentLoaded", function () {
    document.getElementById("personId").addEventListener("change", function (e) {
        update(e.currentTarget);
    })
});

function update(input) {
    new HttpRequest("/api/person", HttpRequest.POST)
        .setBody("param=" + encodeURIComponent(input.value))
        .successHandler(function (response) {
            document.getElementById("persons").innerHTML = "<span>" + response + "</span>";
        })
        .errorHandler(function (response) {
            document.getElementById("persons").innerHTML = "<span>" + response + "</span>";
        }).send();
}