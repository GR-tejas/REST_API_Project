const username = localStorage.getItem("username");
const userId = localStorage.getItem("userId");

if(userId === null || username === null)
{
    window.location.href = "login.html";
}

$("#welcome").text("Welcome " + username + "!");

function getNoteRequest()
{
    return{
        "text": $("#note").val(),
        "userId": userId
    };
}

$("#submit").click(
    function() {
        const noteRequest = getNoteRequest();
        fetch("/notes", {
            method: "POST",
            headers:
            {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(noteRequest)
        })
        .then(function (response){
            if(response.ok)
            {
                alert ("Your note was saved!");
                $("#note").val("");
            }
            else
                alert("Failed to save your note!");
        });
    }
);

$("#fetch").click(
    function(){
        fetch("notes/"+username,{
            method: "GET",
            headers: 
            {
                "Content-Type": "application/json"
            }
        })
        .then(function(response)
        {
            return response.json();
        })
        .then(function(result)
        {
            $("#noteList").empty();
            for(const note of result)
            {
                $("#noteList").append(
                    "<div id = '"+ note.id +"'><p>"+ 
                    note.text +
                    "</p><button type = 'button' class = 'text_edit'>Edit</button><button = 'button' class = 'text_delete'>Delete</button></div>"
                );
            }
        });
    }
);