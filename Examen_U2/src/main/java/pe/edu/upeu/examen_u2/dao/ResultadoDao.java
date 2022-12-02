/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.upeu.examen_u2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import pe.edu.upeu.examen_u2.coon.ConnS;
import pe.edu.upeu.examen_u2.modelo.ResultadoTO;

/**
 *
 * @author AVATEC
 */
public class ResultadoDao implements ResultadoDaoI{
    ConnS intance=ConnS.getInstance();
    Connection conexion=intance.getConnection();
    PreparedStatement ps;
    ResultSet rs;
    
    public List listarResultado() {
        List<ResultadoTO> lista=new ArrayList();
        String sql="select * from resultado";
        try {
            ps=conexion.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                ResultadoTO to=new ResultadoTO();
                to.setIdresultado(rs.getInt("id_resultado"));
                to.setPunto(rs.getInt("punto"));
                to.setNpartida(rs.getString("npartidas"));
                to.setNjugador1(rs.getString("njugador1"));
                to.setNjugardor2(rs.getString("njugador2"));
                to.setGanador(rs.getString("ganador"));
                to.setEstado(rs.getString("estado"));
                
            }
            
        } catch (Exception e) {
        }
        return lista;
    }

    public int crearResultado(ResultadoTO re) {
        int exec=0;
        int i=0;
        String sql="insert into resultado(punto, npartidas, njugador1,njugador2, ganador, estado ) values(?,?,?,?,?,?)";
        try {
            ps=conexion.prepareStatement(sql);
            ps.setInt(++i, re.getPunto());
            ps.setString(++i, re.getNpartida());
            ps.setString(++i, re.getNjugador1());
            ps.setString(++i, re.getNjugardor2());
            ps.setString(++i, re.getGanador());
            ps.setString(++i, re.getEstado());
            exec=ps.executeUpdate();
        } catch (Exception e) {
        }
        return exec;
    }
    
}
