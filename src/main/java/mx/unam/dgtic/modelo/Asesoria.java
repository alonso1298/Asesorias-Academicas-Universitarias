package mx.unam.dgtic.modelo;

public class Asesoria {

     private Profesor profesor;
     private Materia materia;

     public Asesoria(){}

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    @Override
    public String toString() {
        return "Asesoria{" +
                "profesor=" + profesor +
                ", materia=" + materia +
                '}';
    }
}
