$(document).ready(function() {


    $("#queryButton").click(function(){
        console.log("Query Click")
        $("#queryDIV").show();
        $("#formDIV").hide();
        $("#resultDIV").hide();

        $.ajax({
            url: "/json",
            type: "POST"
        }).then(function(data) {
            // console.log(data.length)
            // console.log(data[data.length-1]);
            // $('.greeting-id').append(data[data.length-1].name);
            // $('.greeting-content').append(data[data.length-1].phoneNum);
            $( "#bidders" ).empty();
            for(var i = 0; i < data.length; i++) {
                $('#bidders').append('<tr><td>' + data[i].name + '</td><td>' +data[i].phoneNum +'</td></tr>' );
            }
        });

    });

    $("#newBuddyButton").click(function(){
        console.log("New Buddy Click")
        $("#queryDIV").hide();
        $("#formDIV").show();
        $("#resultDIV").hide();
    });

    $("#buddySubmit").click(function(event){
        alert( "Name: " + document.getElementById("formName").value + " "+
            "Phone Number: " + document.getElementById("formPhone").value);
        event.preventDefault();
        document.getElementById("buddyForm").submit();
    });
});
