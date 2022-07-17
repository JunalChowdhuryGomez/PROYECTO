package com.example.proyectopoo.backend.dao.impl;

import com.example.proyectopoo.backend.dao.AdministradorDao;
import com.example.proyectopoo.backend.dto.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AdministradorDaoImpl implements AdministradorDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private Connection connecction;

    private void obtenerConexion() {
        try {
            this.connecction = jdbcTemplate.getDataSource().getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void cerrarConexion(ResultSet resultado, Statement sentencia) {
        if(resultado != null) {
            try {
                resultado.close();
                if(sentencia != null) sentencia.close();
                this.connecction.commit();
                this.connecction.close();
                this.connecction = null;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }



    @Override
    public Producto agregarProducto(Producto producto) {
        String sql = "INSERT INTO producto(id_producto,tipo,nombre,descripcion,precio_regular,cantidad,url_imagen)\n" +
                "VALUES (nextval(secuencia_producto),?,?,?,?,?,?);";
        try {
            obtenerConexion();
            PreparedStatement sentencia = connecction.prepareStatement(sql);
            sentencia.setString(1, producto.getTipo());
            sentencia.executeUpdate();
            cerrarConexion(null,sentencia);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public Producto modificarProducto(Integer id_producto, Integer cantidad, Float precio_regular) {
        String sql = "UPDATE producto \n" +
                "SET precio_regular=?,cantidad=?\n" +
                "WHERE id_producto=?;\n";
        try {
            obtenerConexion();
            PreparedStatement sentencia = connecction.prepareStatement(sql);
            sentencia.setFloat(1,precio_regular);
            sentencia.setInt(2,cantidad);
            sentencia.setInt(3,id_producto);
            sentencia.executeUpdate();
            cerrarConexion(null,sentencia);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public Producto eliminarProducto(Integer id_producto) {
        String sql = "DELETE FROM producto\n" +
                "WHERE id_producto=?;";
        try {
            obtenerConexion();
            PreparedStatement sentencia = connecction.prepareStatement(sql);
            sentencia.setInt(1,id_producto);
            sentencia.executeUpdate();
            cerrarConexion(null,sentencia);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    @Override
    public Producto verDetalleProductoAdministrador(Integer idProducto) {
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
    public List<Producto> verCatalogoAdministrador() {
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
