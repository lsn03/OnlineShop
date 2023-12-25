fetch("/csrf", {
    method: "GET",
    headers: {
        "Content-Type": "application/json",
    },
})
    .then((response) => response.json())
    .then((data) => {
        const csrfToken = data.token;

        console.log("CSRF Token:", csrfToken);
    })
    .catch((error) => {
        console.error("Error fetching CSRF token:", error);
    });