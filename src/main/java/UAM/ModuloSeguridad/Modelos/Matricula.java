package UAM.ModuloSeguridad.Modelos;

import org.springframework.data.annotation.Id;

import java.util.LinkedList;

public class Matricula {
    @Id
    String _id;
    LinkedList<Double> notas;
    double notaFinal;

    public Matricula(LinkedList<Double> notas, double notaFinal) {
        this.notas = notas;
        this.notaFinal = notaFinal;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public LinkedList<Double> getNotas() {
        return notas;
    }

    public void setNotas(LinkedList<Double> notas) {
        this.notas = notas;
    }

    public double getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(double notaFinal) {
        this.notaFinal = notaFinal;
    }
}
