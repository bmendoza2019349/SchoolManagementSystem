
package com.SchoolManagementSystem.modelos;

import com.SchoolManagementSystem.exceptions.EstudianteNoInscritoEnCursoException;
import com.SchoolManagementSystem.exceptions.EstudianteYaInscritoException;
import com.SchoolManagementSystem.servicios.ServiciosAcademicos1;
import java.util.ArrayList;
import java.util.HashMap;

public class GestorAcademico implements ServiciosAcademicos1{
    private ArrayList<Estudiante> estudiantes;
    private ArrayList<Curso> cursos;
    private HashMap<Integer, ArrayList<Estudiante>> estudiantesPorCurso;

    public GestorAcademico() {
        estudiantes = new ArrayList<>();
        cursos = new ArrayList<>();
        estudiantesPorCurso = new HashMap<>();
    }

    @Override
    public void matricularEstudiante(Estudiante estudiante) throws EstudianteYaInscritoException {
        if (estudiantes.contains(estudiante)) {
            throw new EstudianteYaInscritoException("El estudiante ya está matriculado.");
        }
        estudiantes.add(estudiante);
    }

    @Override
    public void agregarCurso(Curso curso) {
        if (!cursos.contains(curso)) {
            cursos.add(curso);
        }
    }

    @Override
    public void inscribirEstudianteCurso(Estudiante estudiante, int idCurso) throws EstudianteYaInscritoException {
        ArrayList<Estudiante> inscritos = estudiantesPorCurso.getOrDefault(idCurso, new ArrayList<>());
        if (inscritos.contains(estudiante)) {
            throw new EstudianteYaInscritoException("El estudiante ya está inscrito en el curso.");
        }
        inscritos.add(estudiante);
        estudiantesPorCurso.put(idCurso, inscritos);
    }

    @Override
    public void desinscribirEstudianteCurso(int idEstudiante, int idCurso) throws EstudianteNoInscritoEnCursoException {
         ArrayList<Estudiante> inscritos = estudiantesPorCurso.get(idCurso);
        if (inscritos == null || inscritos.stream().noneMatch(e -> e.getId() == idEstudiante)) {
            throw new EstudianteNoInscritoEnCursoException("El estudiante no está inscrito en el curso.");
        }
        inscritos.removeIf(e -> e.getId() == idEstudiante);
        estudiantesPorCurso.put(idCurso, inscritos);
    }

     public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public ArrayList<Curso> getCursos() {
        return cursos;
    }

    public ArrayList<Estudiante> getEstudiantesPorCurso(int idCurso) {
        return estudiantesPorCurso.getOrDefault(idCurso, new ArrayList<>());
    }
    
}
