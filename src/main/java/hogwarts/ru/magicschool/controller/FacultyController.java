package hogwarts.ru.magicschool.controller;

import hogwarts.ru.magicschool.dto.FacultyDtoIn;
import hogwarts.ru.magicschool.dto.FacultyDtoOut;
import hogwarts.ru.magicschool.dto.StudentDtoOut;
import hogwarts.ru.magicschool.service.FacultyService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("faculty")
public class FacultyController {

    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }


    @PostMapping
    public FacultyDtoOut createFaculty(@RequestBody FacultyDtoIn facultyDtoIn) {
        return facultyService.createFaculty(facultyDtoIn);
    }

    @GetMapping("{id}")
    public FacultyDtoOut getFaculty(@PathVariable Long id) {
        return facultyService.getFaculty(id);
    }

    @GetMapping
    public Collection<FacultyDtoOut> getFaculties(@RequestParam(required = false) String colorOrName) {
        if (colorOrName != null && !colorOrName.isBlank()) {
            return facultyService.getFacultiesByColorOrName(colorOrName);
        }
        return facultyService.getAllFaculties();
    }

    @GetMapping("{id}/students")
    public Collection<StudentDtoOut> getStudents(@PathVariable Long id) {
        return facultyService.getStudents(id);
    }

    @PutMapping("{id}")
    public FacultyDtoOut editFaculty(@PathVariable Long id, @RequestBody FacultyDtoIn facultyDtoIn) {
        return facultyService.editFaculty(id, facultyDtoIn);
    }

    @DeleteMapping("{id}")
    public FacultyDtoOut removeFaculty(@PathVariable Long id) {
        return facultyService.removeFaculty(id);
    }
}
