function sendData(idName,requestURL) {
    document.addEventListener('DOMContentLoaded', function () {
        // Обработчик отправки формы
        document.getElementById(idName).addEventListener('submit', function (event) {
            // Отменяем стандартное поведение формы, чтобы избежать перезагрузки страницы
            event.preventDefault();

            // Получаем данные формы
            var formData = new FormData(this);

            // Отправляем POST-запрос на сервер
            fetch(requestURL, {
                method: 'POST',
                body: formData
            })
                .then(response => response.json())
                .then(data => {
                    // Обработка успешного ответа
                    console.log(data);
                    document.getElementById('loginErrors').innerHTML = '';
                    document.getElementById('passwordErrors').innerHTML = '';
                    document.getElementById('userErrors').innerHTML = '';
                    if (data.errors) {
                        // Отображение ошибок на странице
                        Object.keys(data.errors).forEach(function (fieldName) {
                            var errorList = document.getElementById(fieldName + 'Errors');
                            data.errors[fieldName].forEach(function (error) {
                                var listItem = document.createElement('li');
                                listItem.textContent = error;
                                errorList.appendChild(listItem);
                            });
                        });
                    } else {
                        window.location.href = "/";
                    }
                })
                .catch(error => {
                    // Обработка ошибки
                    console.error('Error:', error);
                });
        });
    });
}