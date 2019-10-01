$(document).ready(function () {

    $("#search-form").submit(function (event) {

        //stop submit the form, we will post it manually.
        event.preventDefault();

        fire_ajax_submit();

    });

});

function fire_ajax_submit() {
    $("#btn-search").prop("disabled", true);
    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: "http://localhost:8282/movies/films",
        dataType: 'json',
        timeout: 600000,
        success: function (data) {
            document.getElementById("json").innerHTML = JSON.stringify(data, undefined, 2);
            console.log("SUCCESS : ", data);
        },
        error: function (e) {

            var json = "<h4>Ajax Response</h4><pre>"
                + e.responseText + "</pre>";
            $('#feedback').html(json);

            console.log("ERROR : ", e);
            $("#btn-search").prop("disabled", false);

        }
    });

}
