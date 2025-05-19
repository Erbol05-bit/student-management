document.getElementById('login-form').addEventListener('submit', function (e) {
    e.preventDefault();

    const email = document.getElementById('email').value.trim();
    const password = document.getElementById('password').value.trim();
    const errorMsg = document.getElementById('error-msg');

    errorMsg.textContent = '';

    const emailRegex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/;
    if (!email || !emailRegex.test(email)) {
        errorMsg.textContent = 'Введите корректный email.';
        return;
    }

    if (!password) {
        errorMsg.textContent = 'Пароль не может быть пустым.';
        return;
    }

    if (password.length < 8) {
        errorMsg.textContent = 'Пароль должен содержать хотя бы 8 символов.';
        return;
    }

    const passwordRegex = /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,}$/;
    if (!passwordRegex.test(password)) {
        errorMsg.textContent = 'Пароль должен содержать буквы и цифры.';
        return;
    }

    // Отправка данных на сервер
    fetch('/api/auth/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ email, password }),
    })
    .then(response => response.json())
    .then(data => {
        if (data.success) {
            window.location.href = '/';
        } else {
            errorMsg.textContent = data.message || 'Ошибка входа';
        }
    })
    .catch(error => {
        errorMsg.textContent = 'Ошибка сервера. Попробуйте позже.';
    });
}); 