package com.ejemplo1.controlador;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class Controlador {

    private List<Artista> artistas = new ArrayList<>();

    
    @GetMapping("/registro")
    public String registro() {
        artistas.add(new Artista(1, "Pirlo La rata", "Cantante", 100));
        artistas.add(new Artista(2, "Blessd el blandito", "Cantante", 150));
        artistas.add(new Artista(3, "Julian ortiz", "Acrobata", 120));
        artistas.add(new Artista(4, "Cristian el tecno", "Cantante", 180));
        artistas.add(new Artista(5, "El mono", "Artista", 200));
        artistas.add(new Artista(6, "Yazmin PicaPiedra", "Mujer De Felipe", 25));
        return "Se han registrado 6 artistas por defecto.";
    }

    
    @GetMapping("/listado")
    public String listado() {
        StringBuilder html = new StringBuilder();
        html.append("<table border=\"1\">");
        html.append("<tr><th>ID</th><th>Nombre</th><th>Género Artístico</th><th>Costo Hora Función</th></tr>");
        for (Artista artista : artistas) {
            html.append("<tr>");
            html.append("<td>").append(artista.getId()).append("</td>");
            html.append("<td>").append(artista.getNombre()).append("</td>");
            html.append("<td>").append(artista.getGeneroArtistico()).append("</td>");
            html.append("<td>").append(artista.getCostoHoraFuncion()).append("</td>");
            html.append("</tr>");
        }
        html.append("</table>");
        return html.toString();
    }

    
    @GetMapping("/buscar/{id}")
    public String buscar(@PathVariable int id) {
        for (Artista artista : artistas) {
            if (artista.getId() == id) {
                return "ID: " + artista.getId() +
                       "<br/>Nombre: " + artista.getNombre() +
                       "<br/>Género Artístico: " + artista.getGeneroArtistico() +
                       "<br/>Costo Hora Función: " + artista.getCostoHoraFuncion();
            }
        }
        return "El artista con ID " + id + " no fue encontrado.";
    }

    
    private static class Artista {
        private int id;
        private String nombre;
        private String generoArtistico;
        private double costoHoraFuncion;

        public Artista(int id, String nombre, String generoArtistico, double costoHoraFuncion) {
            this.id = id;
            this.nombre = nombre;
            this.generoArtistico = generoArtistico;
            this.costoHoraFuncion = costoHoraFuncion;
        }

        public int getId() {
            return id;
        }

        public String getNombre() {
            return nombre;
        }

        public String getGeneroArtistico() {
            return generoArtistico;
        }

        public double getCostoHoraFuncion() {
            return costoHoraFuncion;
        }
    }
}
