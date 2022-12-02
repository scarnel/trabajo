/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.upeu.examen_u2.dao;

import java.util.List;
import pe.edu.upeu.examen_u2.modelo.ResultadoTO;

/**
 *
 * @author AVATEC
 */



public interface ResultadoDaoI {
    
    public List listarResultado();
    public int crearResultado(ResultadoTO re);
}
