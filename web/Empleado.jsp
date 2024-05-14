<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Empleado</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
    <div class="container">
        <div class="row">
            <div class="col-lg-4 col-md-12">
                <div class="card mt-3">
                    <div class="card-body">
                        <form action="Controlador?menu=Empleado" method="POST">
                            <div class="form-group mb-3">
                                <label for="txtDni" class="form-label">Dni</label>
                                <input type="text" value="${empleado.getDni()}" id="txtDni" name="txtDni" class="form-control" required>
                            </div>
                            <div class="form-group mb-3">
                                <label for="txtNombres" class="form-label">Nombres</label>
                                <input type="text" value="${empleado.getNom()}" id="txtNombres" name="txtNombres" class="form-control" required>
                            </div>
                            <div class="form-group mb-3">
                                <label for="txtTel" class="form-label">Telefono</label>
                                <input type="text" value="${empleado.getTel()}" id="txtTel" name="txtTel" class="form-control" required>
                            </div>
                            <div class="form-group mb-3">
                                <label for="txtEstado" class="form-label">Estado</label>
                                <input type="text" value="${empleado.getEstado()}" id="txtEstado" name="txtEstado" class="form-control" required>
                            </div>
                            <div class="form-group mb-3">
                                <label for="txtUser" class="form-label">Usuario</label>
                                <input type="text" value="${empleado.getUser()}" id="txtUser" name="txtUser" class="form-control" required>
                            </div>
                            <div class="d-flex justify-content-center">
                                <input type="submit" name="accion" value="Agregar" class="btn btn-primary me-2 w-50">
                                <input type="submit" name="accion" value="Actualizar" class="btn btn-primary w-50">
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <div class="col-lg-8 col-md-12">
                <div class="table-responsive mt-3">
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
                                        <a class="btn btn-warning mb-md-0 mb-2 mb-lg-2 mb-xl-0" href="Controlador?menu=Empleado&accion=Editar&id=${em.getId()}">Editar</a>
                                        <a class="btn btn-danger" href="Controlador?menu=Empleado&accion=Eliminar&id=${em.getId()}">Eliminar</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>
