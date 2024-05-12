<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <title>Empleado</title>
    </head>
    <body>
        <div class="d-flex">
            <div class="card col-sm-4">
                <div class="card-body">
                    <form action="Controlador?menu=Empleado" method="POST">
                        <div class="form-group">
                            <label>Dni</label>
                            <input  type="text" value="${empleado.getDni()}" name="txtDni" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Nombres</label>
                            <input  type="text" value="${empleado.getNom()}" name="txtNombres" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Telefono</label>
                            <input  type="text" value="${empleado.getTel()}" name="txtTel" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Estado</label>
                            <input  type="text" value="${empleado.getEstado()}" name="txtEstado" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Usuario</label>
                            <input  type="text" value="${empleado.getUser()}" name="txtUser" class="form-control">
                        </div>
                        <input type="submit" name="accion" value="Agregar" class="btn btn-info" >
                        <input type="submit" name="accion" value="Actualizar" class="btn btn-info" >
                </div>
            </div>
            <div class="col-sm-8">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>DNI</th>
                            <th>NOMBRE</th>
                            <th>TELEFONOS</th>
                            <th>ESTADO</th>
                            <th>USUARIO</th>
                            <th>ACCIONES</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="em" items="${empleados}">
                            <tr>
                                <td>${em.getId()}</td>
                                <td>${em.getDni()}</td>
                                <td>${em.getNom()}</td>
                                <td>${em.getTel()}</td>
                                <td>${em.getEstado()}</td>
                                <td>${em.getUser()}</td>
                                <td>
                                    <a class="btn btn-warning" href="Controlador?menu=Empleado&accion=Editar&id=${em.getId()}">Editar</a>
                                    <a class="btn btn-danger" href="Controlador?menu=Empleado&accion=Eliminar&id=${em.getId()}">Eliminar</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    </body>
</html>
