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
        let orginal=$("#inputOrginal").val();
        let destiny=$("#inputDestiny").val();
        $.get(`getItineraries?orginal=${orginal}&destiny=${destiny}`, function (data) {
            let shorestRoute=data.result.shorestRoute;
            let leastTransitRoute=data.result.leastTransitRoute;
            // clear table
            $("#shorestRouteTable").find("tbody tr").remove()
            $("#leastTransitRouteTable").find("tbody tr").remove()
            for (let i = 0; i < shorestRoute.length-1; i++) {
                let singalRoute=allroutes.find(x=>x.original===shorestRoute[i]&&x.destiny===shorestRoute[i+1]);
                let tr=` <tr>
                        <td>${singalRoute.original}</td>
                        <td>${singalRoute.destiny}</td>
                        <td>${singalRoute.departuretime}</td>
                        <td>${singalRoute.arrivaltime}</td>
                        <td>${singalRoute.cost}</td>
                    </tr>`;
                $("#shorestRouteTable").append(tr);
            }
            for (let i = 0; i < leastTransitRoute.length-1; i++) {
                let singalRoute=allroutes.find(x=>x.original===leastTransitRoute[i]&&x.destiny===leastTransitRoute[i+1]);
                let tr=` <tr>
                        <td>${singalRoute.original}</td>
                        <td>${singalRoute.destiny}</td>
                        <td>${singalRoute.departuretime}</td>
                        <td>${singalRoute.arrivaltime}</td>
                        <td>${singalRoute.cost}</td>
                    </tr>`;
                $("#leastTransitRouteTable").append(tr);
            }
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

