$('#Login1').click(function () {
    var url = "/nishtha/loginModule";
    var name = $("#Name").val();
    $.post(url, { Name: name }, function (data) {
        $("#msg").html(data);
    });
})