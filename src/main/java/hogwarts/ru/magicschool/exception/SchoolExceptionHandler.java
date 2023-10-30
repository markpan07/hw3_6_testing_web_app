package hogwarts.ru.magicschool.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class SchoolExceptionHandler {

    @ExceptionHandler({FacultyNotFoundException.class,
            StudentNotFoundException.class,
            AvatarNotFoundException.class})
    public ResponseEntity<?> handleNotFound(RuntimeException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler({FacultyAlreadyExistException.class})
    public ResponseEntity<?> handleBadRequest(RuntimeException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}
