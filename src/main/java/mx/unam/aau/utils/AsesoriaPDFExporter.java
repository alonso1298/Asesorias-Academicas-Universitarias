package mx.unam.aau.utils;

import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import jakarta.servlet.http.HttpServletResponse;
import mx.unam.aau.entities.Asesoria;

import java.io.IOException;
import java.util.List;

public class AsesoriaPDFExporter {

    private List<Asesoria> asesorias;

    public AsesoriaPDFExporter(List<Asesoria> asesorias){
        this.asesorias = asesorias;
    }

    public void export(HttpServletResponse response) throws IOException{
        Document documento = new Document(PageSize.A4);
        PdfWriter.getInstance(documento, response.getOutputStream());

        documento.open();

        Font fontTitulo = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        fontTitulo.setSize(18);

        Paragraph titulo = new Paragraph("Reporte de Asesorías", fontTitulo);
        titulo.setAlignment(Paragraph.ALIGN_CENTER);

        documento.add(titulo);

        PdfPTable tabla = new PdfPTable(6);

        tabla.setWidthPercentage(100);
        tabla.setSpacingBefore(15);

        tabla.addCell("Alumno");
        tabla.addCell("Profesor");
        tabla.addCell("Materia");
        tabla.addCell("Fecha");
        tabla.addCell("Hora");
        tabla.addCell("Estado");

        for (Asesoria a : asesorias){

            tabla.addCell(a.getAlumno().getUsuario().getNombre());
            tabla.addCell(a.getProfesor().getNombre());
            tabla.addCell(a.getMateria().getNombre());
            tabla.addCell(a.getFecha().toString());
            tabla.addCell(a.getHora().toString());
            tabla.addCell(a.getEstado().name());

        }

        documento.add(tabla);

        documento.close();
    }
}
