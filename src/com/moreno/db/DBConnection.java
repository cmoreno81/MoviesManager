/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.moreno.db;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cristina
 */
public class DBConnection {

    Connection con = null;
    private Properties prop = new Properties();

    public DBConnection() throws IOException, ClassNotFoundException {
        Path path = Paths.get("credentials.properties");
        try ( FileInputStream fis = new FileInputStream(new File("/Users/cristina/cursos/JAVA APP/MoviesManager/src/com/moreno/models/credentials.properties"))) {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            prop.load(fis);
            con = DriverManager.getConnection(prop.get("URL").toString(), prop.get("USER").toString(), prop.get("PASSWORD").toString());
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void cerrarConexion() {
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void createMovie(int id, String titulo, String genero, int valoracion, boolean visto, String formato) throws SQLException, ClassNotFoundException {
        String sql = "insert into MOVIES(ID, TITULO, GENERO, VALORACION, VISTO, FORMATO) VALUES (next value for pid_seq,?,?,?,?,?)";

        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, titulo);
        stm.setString(2, genero);
        stm.setInt(3, valoracion);
        stm.setBoolean(4, visto);
        stm.setString(5, formato);
        stm.execute();

    }

    public ResultSet readAllMovies() {

        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM MOVIES";
            Statement st = st = con.createStatement();

            st.execute(sql);
            rs = st.getResultSet();

        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rs;

    }

    public ResultSet findMoviesByName(String titulo) {
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM MOVIES WHERE TITULO = '" + titulo + "' ";
            Statement st = st = con.createStatement();

            st.execute(sql);
            rs = st.getResultSet();

        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rs;
    }

}
