
package com.SchoolManagementSystem.servicios;

import com.SchoolManagementSystem.exceptions.EstudianteNoInscritoEnCursoException;
import com.SchoolManagementSystem.exceptions.EstudianteYaInscritoException;
import com.SchoolManagementSystem.modelos.Curso;
import com.SchoolManagementSystem.modelos.Estudiante;

public interface ServiciosAcademicos1 {
    void matricularEstudiante(Estudiante estudiante) throws EstudianteYaInscritoException;
    void agregarCurso(Curso curso);
    void inscribirEstudianteCurso(Estudiante estudiante, int idCurso) throws EstudianteYaInscritoException;
    void desinscribirEstudianteCurso(int idEstudiante, int idCurso) throws EstudianteNoInscritoEnCursoException;
}
