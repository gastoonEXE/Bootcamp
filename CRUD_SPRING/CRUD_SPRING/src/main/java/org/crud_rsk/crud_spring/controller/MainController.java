package org.crud_rsk.crud_spring.controller;

import org.crud_rsk.crud_spring.Repository.cargosRepository;
import org.crud_rsk.crud_spring.Repository.equiposRepository;
import org.crud_rsk.crud_spring.Repository.rolesRepository;
import org.crud_rsk.crud_spring.entity.usuarios;
import org.crud_rsk.crud_spring.service.usuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    usuariosService usuariosService;

    @Autowired
    private cargosRepository cargosRepository;

    @Autowired
    private equiposRepository equiposRepository;

    @Autowired
    private rolesRepository rolesRepository;

//    @GetMapping("/nuevo")
//    public String mostrarNuevoFormulario(Model model) {
//        // Entidad vacía para enlazar el formulario
//        model.addAttribute("usuario", new usuarios());
//
//        // Lista de cargos para el <select>
//        model.addAttribute("listaCargos", cargosRepository.findAll());
//
//        return "agregarUsuario"; // Nombre de la plantilla Thymeleaf
//    }




    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("mensaje", "¡Hola desde Thymeleaf!");
        return "index";
    }

    @GetMapping("/usuarios")
    public String ListaUsuarios(Model model) {
        List<usuarios> listUsers = usuariosService.getUsuarios();

        model.addAttribute("listUsers", listUsers);
        return "usuarios";
    }

    @GetMapping("/usuarios/nuevo")
    public String mostrarNuevoFormulario(Model model) {
        model.addAttribute("usuario", new usuarios());

        // Lista de cargos para el <select>
        model.addAttribute("listaCargos", cargosRepository.findAll());

        // Lista de equipos para el <select>
        model.addAttribute("listaEquipos", equiposRepository.findAll());

        // Lista de roles para el <select>
        model.addAttribute("listaRoles", rolesRepository.findAll());

        return "agregarUsuario";
    }

    @PostMapping("/usuarios/save")
    public String guardarUsuario(usuarios usuario) {
        if (usuario.getFechaIngreso() != null) {
            Period period = Period.between(usuario.getFechaIngreso(), LocalDate.now());
            String antiguedad = String.format("%d años, %d meses, %d días",
                    period.getYears(), period.getMonths(), period.getDays());
            usuario.setAntiguedad(antiguedad);
        }
        usuariosService.saveUsuarios(usuario);
        return "redirect:/usuarios";
    }



}
