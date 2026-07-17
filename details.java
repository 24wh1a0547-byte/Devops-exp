// Enable Fields One by One

function enableLastName() {
    document.getElementById("lastName").disabled = false;
}

function enableUsername() {
    document.getElementById("username").disabled = false;
}

function enablePassword() {
    document.getElementById("password").disabled = false;
}

function enableConfirmPassword() {
    document.getElementById("confirmPassword").disabled = false;
}

function enableDOB() {
    document.getElementById("dob").disabled = false;
}

function enableMobile() {
    document.getElementById("mobile").disabled = false;
}

function enableAddress() {
    document.getElementById("address").disabled = false;
}

function enablePin() {
    document.getElementById("pin").disabled = false;
}

function enableGender() {
    document.getElementById("gender").disabled = false;
}

function enableRegister() {
    document.getElementById("registerBtn").disabled = false;
}


// -------------------- REGISTER --------------------

function register() {

    let password = document.getElementById("password").value;
    let confirmPassword = document.getElementById("confirmPassword").value;

    if (password !== confirmPassword) {
        alert("Passwords do not match!");
        return;
    }

    let user = {

        firstName: document.getElementById("firstName").value,
        lastName: document.getElementById("lastName").value,
        username: document.getElementById("username").value,
        password: password,
        dob: document.getElementById("dob").value,
        mobile: document.getElementById("mobile").value,
        address: document.getElementById("address").value,
        pin: document.getElementById("pin").value,
        gender: document.getElementById("gender").value

    };

    localStorage.setItem(user.username, JSON.stringify(user));

    alert("Registration Successful!");

    window.location.href = "login.html";

}


// -------------------- LOGIN --------------------

function login() {

    let username = document.getElementById("loginUsername").value;
    let password = document.getElementById("loginPassword").value;

    let user = JSON.parse(localStorage.getItem(username));

    if (user == null) {
        alert("User Not Found!");
        return;
    }

    if (user.password !== password) {
        alert("Wrong Password!");
        return;
    }

    alert("Login Successful!");

    displayUsers();

}


// -------------------- DISPLAY USERS --------------------

function displayUsers() {

    let html = `
    <html>
    <head>
    <title>Registered Users</title>

    <style>

    body{
        font-family:Arial;
        background:#6dd5ed;
        padding:30px;
    }

    .container{
        max-width:800px;
        margin:auto;
        background:white;
        padding:20px;
        border-radius:10px;
    }

    h1{
        text-align:center;
        color:#2193b0;
    }

    .user{
        border:1px solid #ccc;
        padding:15px;
        margin-top:15px;
        border-radius:8px;
    }

    </style>

    </head>

    <body>

    <div class="container">

    <h1>Registered Users</h1>
    `;

    let count = 1;

    for (let i = 0; i < localStorage.length; i++) {

        let key = localStorage.key(i);

        let user = JSON.parse(localStorage.getItem(key));

        html += `

        <div class="user">

        <h3>User ${count}</h3>

        <p><b>First Name:</b> ${user.firstName}</p>

        <p><b>Last Name:</b> ${user.lastName}</p>

        <p><b>Username:</b> ${user.username}</p>

        <p><b>Password:</b> ${user.password}</p>

        <p><b>Date of Birth:</b> ${user.dob}</p>

        <p><b>Mobile:</b> ${user.mobile}</p>

        <p><b>Address:</b> ${user.address}</p>

        <p><b>PIN Code:</b> ${user.pin}</p>

        <p><b>Gender:</b> ${user.gender}</p>

        </div>

        `;

        count++;
    }

    html += `
    </div>
    </body>
    </html>
    `;

    document.open();
    document.write(html);
    document.close();

}