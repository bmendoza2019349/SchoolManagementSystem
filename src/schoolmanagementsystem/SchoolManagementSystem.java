
package schoolmanagementsystem;

import com.SchoolManagementSystem.exceptions.EstudianteYaInscritoException;
import com.SchoolManagementSystem.exceptions.EstudianteNoInscritoEnCursoException;
import com.SchoolManagementSystem.modelos.Curso;
import com.SchoolManagementSystem.modelos.Estudiante;
import com.SchoolManagementSystem.modelos.GestorAcademico;

public class SchoolManagementSystem {

    public static void main(String[] args) {
        // Crear instancias de estudiantes
        Estudiante estudiante1 = new Estudiante(1, "Juan", "Perez", "01-01-2000", "Matriculado");
        Estudiante estudiante2 = new Estudiante(2, "Maria", "Lopez", "02-02-2001", "Matriculado");

        // Crear instancias de cursos
        Curso curso1 = new Curso(101, "Matemáticas", "Curso básico de matemáticas", 5, "1.0");
        Curso curso2 = new Curso(102, "Historia", "Historia del mundo", 4, "1.0");

        // Crear instancia de GestorAcademico
        GestorAcademico gestor = new GestorAcademico();

        // Matricular estudiantes
        try {
            gestor.matricularEstudiante(estudiante1);
            gestor.matricularEstudiante(estudiante2);
        } catch (EstudianteYaInscritoException e) {
            System.out.println(e.getMessage());
        }

        // Agregar cursos
        gestor.agregarCurso(curso1);
        gestor.agregarCurso(curso2);

        // Inscribir estudiante en curso
        try {
            gestor.inscribirEstudianteCurso(estudiante1, curso1.getIdCurso());
            gestor.inscribirEstudianteCurso(estudiante2, curso1.getIdCurso());
        } catch (EstudianteYaInscritoException e) {
            System.out.println(e.getMessage());
        }

        // Desinscribir estudiante
        try {
            gestor.desinscribirEstudianteCurso(estudiante1.getId(), curso1.getIdCurso());
        } catch (EstudianteNoInscritoEnCursoException e) {
            System.out.println(e.getMessage());
        }

        // Verificar que todo funciona
        System.out.println("Estudiantes matriculados: " + gestor.getEstudiantes());
        System.out.println("Cursos creados: " + gestor.getCursos());
        System.out.println("Estudiantes inscritos en curso de Matemáticas: " + gestor.getEstudiantesPorCurso(curso1.getIdCurso()));
    }
    
}
