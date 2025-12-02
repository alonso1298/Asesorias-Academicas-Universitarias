package mx.unam.dgtic.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "profesor_materia")
public class ProfesorMateria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "profesor_id")
    private Profesor profesor;
    @ManyToOne
    @JoinColumn(name = "materia_id")
    private Materia materia;

    public ProfesorMateria(){}

    public ProfesorMateria(int id, Profesor profesor, Materia materia) {
        this.id = id;
        this.profesor = profesor;
        this.materia = materia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    @Override
    public String toString() {
        return "ProfesorMateria{" +
                "id=" + id +
                ", profesor=" + profesor +
                ", materia=" + materia +
                '}';
    }
}
