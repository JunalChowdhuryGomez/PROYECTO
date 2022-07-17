package com.example.proyectopoo.backend.dao.impl;

import com.example.proyectopoo.backend.dao.ClienteDao;
import com.example.proyectopoo.backend.dto.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ClienteDaoImpl implements ClienteDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private Connection connecction;

    private void obtenerConexion() {
        try {
            connecction = jdbcTemplate.getDataSource().getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void cerrarConexion(ResultSet resultado, Statement sentencia) {
        if(resultado != null) {
            try {
                resultado.close();
                if(sentencia != null) sentencia.close();
                this.connecction.close();
                this.connecction = null;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    @Override
    public List<Producto> verCatalogo() {
        List<Producto> productos = new ArrayList<>();
        String sql = "SELECT id_producto,tipo,nombre,descripcion,precio_regular,cantidad,url_imagen\n" +
                    "FROM producto;";
        obtenerConexion();
        try {
            Statement statement = connecction.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                productos.add(extraerProducto(resultSet));
            }
            cerrarConexion(resultSet,statement);
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return productos;
    }

    @Override
    public Producto verDetalleProducto(Integer idProducto) {
        String sql = "SELECT id_producto,tipo,nombre,descripcion,precio_regular,cantidad,url_imagen\n" +
                "FROM producto p\n" +
                "WHERE p.id_producto = ?;";
        Producto producto=null;
        try {
            obtenerConexion();
            PreparedStatement preparedStatement = connecction.prepareStatement(sql);
            preparedStatement.setInt(1,idProducto);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                producto = extraerProducto(resultSet);
            }
            cerrarConexion(resultSet, preparedStatement);
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return producto;
    }

    @Override
    public List<Producto> buscarProducto(String nombre) {
        String sql= "SELECT *\n" +
                "FROM producto p\n" +
                "WHERE p.descripcion LIKE \"%?%\";";
        List<Producto> productos = null;
        try {
            obtenerConexion();
            PreparedStatement preparedStatement = connecction.prepareStatement(sql);
            preparedStatement.setString(1,nombre);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                productos.add(extraerProducto(resultSet));
            }
            cerrarConexion(resultSet, preparedStatement);
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return productos;

    }

    private Producto extraerProducto(ResultSet resultado) throws SQLException {

        Producto producto = new Producto(
                resultado.getInt("id_producto"),
                resultado.getString("tipo"),
                resultado.getString("nombre"),
                resultado.getString("descripcion"),
                resultado.getDouble("precio_regular"),
                resultado.getInt("cantidad"),
                resultado.getString("url_imagen")
        );
        return producto;
    }

}
