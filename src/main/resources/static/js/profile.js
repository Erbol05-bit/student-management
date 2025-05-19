document.addEventListener('DOMContentLoaded', function() {
    // Получаем данные студента из localStorage
    const studentData = JSON.parse(localStorage.getItem('studentData'));
    
    if (studentData) {
        // Заполняем данные на странице
        document.getElementById('student-name').textContent = studentData.name;
        document.getElementById('student-email').textContent = studentData.email;
        document.getElementById('student-class').textContent = studentData.studentClass;
        document.getElementById('student-attendance').textContent = studentData.attendance;
        
        // Форматируем дату рождения
        const birthDate = new Date(studentData.birthDate);
        const formattedDate = birthDate.toLocaleDateString('ru-RU', {
            year: 'numeric',
            month: 'long',
            day: 'numeric'
        });
        document.getElementById('student-birthdate').textContent = formattedDate;
        
        // Получаем первую оценку из списка
        const grades = studentData.grades.split(',');
        document.getElementById('student-grades').textContent = grades[0].trim();
    } else {
        // Если данных нет, перенаправляем на страницу входа
        window.location.href = '/login.html';
    }
}); 