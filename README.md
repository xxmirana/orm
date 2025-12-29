# Образовательная платформа

Система управления онлайн-курсами с поддержкой тестирования, заданий и отслеживания прогресса студентов.

## Технологии
- Java 17+
- Spring Boot 3.x
- Spring Data JPA / Hibernate
- PostgreSQL
- JWT аутентификация
- Maven

## Функциональность
- Управление курсами и модулями
- Регистрация студентов на курсы
- Система заданий и проверки работ
- Тестирование с автоматической оценкой
- Ролевая модель (студент, преподаватель, администратор)
- JWT-аутентификация

## Требования
- Java 17 или выше
- PostgreSQL 12+
- Maven 3.6+

## Структура проекта
```
src/main/java/com/education/platform/
├── EducationPlatformApplication.java
├── config/
│   ├── TokenAuthenticationInterceptor.java
│   ├── TokenManager.java
│   ├── SecurityConfiguration.java
│   └── PlatformUserDetailsService.java
├── controller/
│   ├── AuthenticationController.java
│   ├── EducationalCourseController.java
│   └── ExaminationController.java
├── dto/
│   ├── LoginRequest.java
│   └── QuizResponseRequest.java
├── entity/
│   ├── QuizOption.java
│   ├── LearningTask.java
│   ├── SubjectCategory.java
│   ├── EducationalCourse.java
│   ├── CourseFeedback.java
│   ├── CourseRegistration.java
│   ├── LearningUnit.java
│   ├── CourseModule.java
│   ├── UserProfile.java
│   ├── QuizQuestion.java
│   ├── CourseExamination.java
│   ├── ExaminationResult.java
│   ├── UserRole.java
│   ├── TaskSubmission.java
│   ├── CourseLabel.java
│   └── PlatformUser.java
├── repository/
│   ├── QuizOptionRepository.java
│   ├── LearningTaskRepository.java
│   ├── SubjectCategoryRepository.java
│   ├── EducationalCourseRepository.java
│   ├── CourseFeedbackRepository.java
│   ├── CourseRegistrationRepository.java
│   ├── LearningUnitRepository.java
│   ├── CourseModuleRepository.java
│   ├── QuizQuestionRepository.java
│   ├── CourseExaminationRepository.java
│   ├── ExaminationResultRepository.java
│   ├── TaskSubmissionRepository.java
│   ├── CourseLabelRepository.java
│   └── PlatformUserRepository.java
├── service/
│   ├── AuthenticationService.java
│   ├── EducationalCourseService.java
│   ├── ExaminationService.java
│   └── UserManagementService.java
└── util/
    ├── TestDataLoader.java
    └── EducationPlatformApplication.java

```
## Настройка подключения в application.yaml
```
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/education_platform
    username: ваш_пользователь
    password: ваш_пароль
```
## API Эндпоинты

### Аутентификация

- POST /api/auth/register - регистрация нового пользователя
- POST /api/auth/login - вход в систему

### Курсы

- POST /api/courses - создание курса
- GET /api/courses/{id}/full - получение курса с полной структурой

### Задания и тесты

- POST /api/assignments/{id}/submit - отправка решения задания
- POST /api/quizzes/{id}/submit - отправка ответов на тест

### Модель данных

Система содержит более 15 сущностей, связанных отношениями:

- Один-ко-многим: Курс → Модули → Уроки → Задания
Многие-ко-многим: Пользователь ↔ Курс (через запись)
Один-к-одному: Пользователь ↔ Профиль
Особенности реализации

- Используется Lazy Loading для оптимизации запросов
Каскадные операции для связанных сущностей
Интеграционные тесты проверяют CRUD операции
Настроена обработка исключений LazyInitializationException

## Запуск приложения
```
mvn clean install
mvn spring-boot:run
```
## Тестирование
```
mvn test
```
## Настройка базы данных
Создайте базу данных PostgreSQL:
```sql
CREATE DATABASE education_platform;
