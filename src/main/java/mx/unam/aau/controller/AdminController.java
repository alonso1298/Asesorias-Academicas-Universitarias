package mx.unam.aau.controller;

import jakarta.servlet.http.HttpServletResponse;
import mx.unam.aau.entities.Asesoria;
import mx.unam.aau.entities.Materia;
import mx.unam.aau.entities.Profesor;
import mx.unam.aau.entities.Usuario;
import mx.unam.aau.service.AsesoriaService;
import mx.unam.aau.service.MateriaService;
import mx.unam.aau.service.ProfesorService;
import mx.unam.aau.service.UsuarioService;
import mx.unam.aau.utils.AsesoriaPDFExporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AsesoriaService asesoriaService;
    @Autowired
    private MateriaService materiaService;
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private ProfesorService profesorService;

    @GetMapping("")
    public String adminHome() {
        return "redirect:/admin/asesorias";
    }

    @GetMapping("/asesorias")
    public String verTodas(Model model) {
        List<Asesoria> asesorias = asesoriaService.listar();
        model.addAttribute("asesorias", asesorias);
        return "paginas/asesorias";

    }

    // Endpoint de reportes
    @GetMapping("/reportes")
    public String reporteAdmin(Model model, Authentication auth){

        LocalDate inicio = asesoriaService.getInicioSemana();
        LocalDate fin = asesoriaService.getFinSemana();

        List<Asesoria> asesorias = asesoriaService.obtenerPorRango(inicio, fin);
        Map<String, Object> reporte = asesoriaService.generarReporteSemanal(asesorias);

        model.addAttribute("reporte", reporte);
        model.addAttribute("asesorias", asesorias);

        return "paginas/reporte-admin";
    }

    @GetMapping("/reportes/pdf")
    public void exportarPDF(HttpServletResponse response) throws IOException {
        response.setContentType("application/pdf");

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=reporte_asesorias.pdf";

        response.setHeader(headerKey, headerValue);

        LocalDate inicio = asesoriaService.getInicioSemana();
        LocalDate fin = asesoriaService.getFinSemana();
        List<Asesoria> asesorias = asesoriaService.obtenerPorRango(inicio, fin);

        AsesoriaPDFExporter exporter = new AsesoriaPDFExporter(asesorias);
        exporter.export(response);
    }
}
