package com.example.studentmanagement.auth;

import com.example.studentmanagement.students.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/students/auth")
@CrossOrigin(origins = "*") // Разрешаем запросы с любого источника
public class AuthController {
    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) {
        try {
            logger.info("Получен запрос на вход студента");
            String email = credentials.get("email");
            String password = credentials.get("password");

            Map<String, Object> response = new HashMap<>();

            if (email == null || password == null) {
                logger.warn("Отсутствует email или пароль");
                response.put("success", false);
                response.put("message", "Email и пароль обязательны");
                return ResponseEntity.badRequest().body(response);
            }

            var student = studentRepository.findByEmail(email);
            logger.info("Найден студент: {}", student != null);

            if (student == null || !student.getPassword().equals(password)) {
                logger.warn("Неверные учетные данные для email: {}", email);
                response.put("success", false);
                response.put("message", "Неверный email или пароль");
                return ResponseEntity.ok(response);
            }

            logger.info("Успешный вход для студента: {}", email);
            response.put("success", true);
            response.put("message", "Успешный вход");
            response.put("student", student);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            logger.error("Ошибка при обработке запроса входа", e);
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("success", false);
            errorResponse.put("message", "Внутренняя ошибка сервера: " + e.getMessage());
            return ResponseEntity.status(500).body(errorResponse);
        }
    }
} 