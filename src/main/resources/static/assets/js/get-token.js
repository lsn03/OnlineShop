function fetchCsrfToken() {
    fetch("/csrf", {
        method: "GET",
        headers: {
            "Content-Type": "application/x-www-form-urlencoded",
        },
    })
        .then((response) => response.json())
        .then((data) => {
            const csrfTokenInput = document.getElementById("csrfToken");
            if (csrfTokenInput) {
                csrfTokenInput.value = data.token;
            }
        })
        .catch((error) => {
            console.error("Error fetching CSRF token:", error);
        });
}