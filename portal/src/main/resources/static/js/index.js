var allroutes = [];
$(document).ready(function () {
    init();
    let cityset = new Set();
    allroutes.forEach(route => {
        cityset.add(route.original);
        cityset.add(route.destiny);
    })
    cityset.forEach(city => {
            $("#inputOrginal").append(`<option value="${city}">${city}</option>`);
            $("#inputDestiny").append(`<option value="${city}">${city}</option>`);
        }
    );
    $("#inputOrginal").change(souce => {
        validateInput();
    });
    $("#inputDestiny").change(souce => {
        validateInput();
    });
    $("#searchButton").click(() => {
        $.get("getItineraries", function (data) {
            alert("Data Loaded: " + data);
        });
    });
})

function init() {
    validateInput();
    $("#invalideError").hide();
    getAllRoute();
}

function getAllRoute() {
    $.ajax({
        method: "get",
        url: "getAllRoute",
        async: false
    }).done(function (data) {
        allroutes = data;
    });

}

function validateInput() {
    if (_.isEmpty($("#inputOrginal").val()) || _.isEmpty($("#inputDestiny").val())
        || $("#inputOrginal").val() === $("#inputDestiny").val()) {
        $("#searchButton").prop('disabled', true);
        $("#invalideError").show();
    } else {
        $("#searchButton").prop('disabled', false);
        $("#invalideError").hide()
    }
}

