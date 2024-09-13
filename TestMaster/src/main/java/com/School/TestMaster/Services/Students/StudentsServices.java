package com.School.TestMaster.Services.Students;

import com.School.TestMaster.Model.Curso.CursoModel;
import com.School.TestMaster.Model.Students.StudentsModel;
import com.School.TestMaster.Repository.Students.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentsServices {

    @Autowired
    private StudentsRepository studentsRepository;

    /**
     * Obtiene todos los estudiantes.
     *
     * @return Una lista de todos los modelos de estudiantes.
     **/
    public List<StudentsModel> ObtenerStudents() {
        return studentsRepository.findAll();
    }

    /**
     * Obtiene un estudiante por su ID.
     *
     * @param Id el ID del estudiante a buscar.
     *
     * @return El modelo del estudiante si se encuentra, de lo contrario, null.
     **/
    public StudentsModel ObtenerStudentPorID(Long id) {
        return studentsRepository.findById(id).orElse(null);
    }

    /**
     * Guarda un estudiante.
     *
     * @param Student el modelo del estudiante a guardar.
     *
     * @return El modelo del estudiante guardado.
     **/
    public StudentsModel GuardarStudent(StudentsModel student) {
        return studentsRepository.save(student);
    }

    /**
     *  Elimina todos los estudiantes.
     **/
    public void EliminarStudents() {
        studentsRepository.deleteAll();
    }

    /**
     * Elimina un estudiante por su Id.
     *
     * @param Id El "ID" del estudiante a eliminar.
     **/
    public void EliminarStudent(Long id) {
        studentsRepository.deleteById(id);
    }

    /**
     * Obtiene los cursos de un estudiante por su ID.
     *
     * @param Id el ID del estudiante.
     *
     * @return Una lista de cursos asociados al estudiante.
     **/
    public List<CursoModel> ObtenerCursosPorID(Long id) {
        StudentsModel student = studentsRepository.findById(id).orElse(null);
        return student != null ? student.getCursos() : new ArrayList<>();
    }

    /**
     * Calcula el promedio final del estudiante.
     *
     * @param nota30 La nota del 30%.
     * @param nota70 La nota del 70%.
     *
     * @return El promedio de la nota final.
     **/
    public Double PromedioDelEstudiante(Double nota30, Double nota70) {
        return ((nota30 * 0.3) + (nota70 * 0.7));
    }

}