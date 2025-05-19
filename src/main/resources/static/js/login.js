document.getElementById('loginForm').addEventListener('submit', async function(e) {
    e.preventDefault();
    
    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;
    
    try {
        const response = await fetch('/api/students/auth/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ email, password })
        });
        
        const data = await response.json();
        
        if (data.success) {
            // Сохраняем данные студента в localStorage
            localStorage.setItem('studentData', JSON.stringify(data.student));
            // Перенаправляем на страницу профиля
            window.location.href = '/profile.html';
        } else {
            alert(data.message || 'Ошибка входа');
        }
    } catch (error) {
        console.error('Ошибка:', error);
        alert('Произошла ошибка при входе');
    }
}); 