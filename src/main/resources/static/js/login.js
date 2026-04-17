function handleLogin(event) {
    event.preventDefault();

    // Get user input
    const email = document.getElementById("email").value;
    const password = document.getElementById("password").value;

    const user = {
        email: email,
        password: password
    };

    fetch('http://localhost:8080/api/v1/users/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(user)
    })
        .then(async (response) => {

            if (!response.ok) {
                const errorText = await response.text(); // read as text
                throw new Error(errorText);
            }

            return response.json(); // only if success
        })
        .then((data) => {
            localStorage.setItem('connectedUser', JSON.stringify(data));
            window.location.href = 'index.html';
        })
        .catch(error => {
            alert("Login failed: " + error.message);
            console.error('POST request error', error);
        });
}



const loginForm = document.getElementById("loginForm");
loginForm.addEventListener("submit", handleLogin);