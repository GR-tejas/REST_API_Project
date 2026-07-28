const username = localStorage.getItem("username");
const userId = localStorage.getItem("userId");

if(userId === null || username === null)
{
    window.location.href = "login.html";
}

$("#welcome").text("Welcome " + username + "!");



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
                fetchNotes();
            }
            else
            {
                alert("Failed to save your note!");
            }
        });
    }
);

$("#noteList").on("click",".text_edit", function() {
    let div = $(this).closest(".user_note");
    let span_text = $(this).siblings(".note_text").text();
    div.html("<input type = 'text' class = 'edit_text' value ='" + span_text + "'>" +
        "<button type = 'button' class = 'edit_submit'>submit</button>" +
        "<button type = 'button' class = 'edit_cancel'>cancel</button>"
    );
});

$("#noteList").on("click",".edit_submit", function() {
    const text = $(this).siblings(".edit_text").val();
    if(text.trim() !== "")
    {
        const noteId = $(this).closest(".user_note").attr("id");
        fetch("/notes", {
            method: "PUT",
            headers:
            {
                "Content-Type": "application/json"
            },
            body: JSON.stringify (getNoteEditRequest(text, noteId))
        })
        .then(fetchNotes);
    }
});

$("#noteList").on("click", ".edit_cancel", function () {
    fetchNotes();
});

$("#noteList").on("click", ".text_delete", function () {
    if(!confirm("Delete this note?"))
    {
        return;
    }

    const noteId = $(this).closest(".user_note").attr("id");

    fetch("/notes", {
        method: "DELETE",
        headers:
        {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(getNoteDeleteRequest(noteId))
    })
    .then(fetchNotes);
});

//functions


function fetchNotes() {
    fetch("/notes/" + username,{
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
                "<div id = '"+ note.id +"' class = 'user_note'>" +
                "<span class = 'note_text'>"+ note.text + "</span>" +
                "<button type = 'button' class = 'text_edit'>Edit</button>" +
                "<button type = 'button' class = 'text_delete'>Delete</button>" +
                "</div>"
            );
        }
    });
}

function getNoteRequest()
{
    return{
        "text": $("#note").val(),
        "userId": userId
    };
}

function getNoteEditRequest(text, noteId)
{
    return {
        "text": text,
        "userId": userId,
        "noteId": noteId
    };
}

function getNoteDeleteRequest(noteId)
{
    return {
        "noteId": noteId,
        "userId": userId
    };
}

$(document).ready(function () {
    fetchNotes();
});