document.addEventListener('DOMContentLoaded', function() {
    // Проверяем, авторизован ли пользователь
    const studentData = JSON.parse(localStorage.getItem('studentData'));
    if (!studentData) {
        window.location.href = '/login.html';
        return;
    }

    // Обработчик выхода
    document.getElementById('logout').addEventListener('click', function(e) {
        e.preventDefault();
        localStorage.removeItem('studentData');
        window.location.href = '/login.html';
    });
}); 