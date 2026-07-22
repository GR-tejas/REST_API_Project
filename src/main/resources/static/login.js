const bt_login = $("#login");
const bt_register = $("#register");
const inp_username = $("#username");
const inp_password = $("#password");
const url_login = "/login";
const url_register = "/register";

function getLoginRequest()
{
    return{
        username: inp_username.val(),
        password: inp_password.val()
    }
}

function checkResult(result)
{
    if(result.id > 0)
        {
            localStorage.setItem("userId", result.id);
            localStorage.setItem("username", result.username)

            window.location.href = "notes.html";
        }
    else
        {
            switch(result.id)
            {
                case(-1):
                {
                    alert("Invalid password!");
                    break;
                }

                case(-2):
                {
                    alert("User does not exist!");
                    break;
                }

                case(-3):
                {
                    alert("Username already exists!");
                    break;
                }
            }
        }

}

function clickEvent(url)
{
    const loginRequest = getLoginRequest();

    if(loginRequest.username.trim() !== "" && loginRequest.password.trim() !== "")
    {
        fetch (url, {
            method: "POST",
            headers: 
            {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(loginRequest)
        }).then(function(response)
        {
            return response.json();
        })
        .then(function(result)
        {
            checkResult(result);
        });
    }
    else
    {
        alert("Please enter both username and password.");
    }
}

bt_login.click(function()
{
    clickEvent(url_login);
});

bt_register.click(function ()
{
    clickEvent(url_register);
});