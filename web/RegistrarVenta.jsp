<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <title>Registrar Venta</title>
    </head>
    <body>
        <div class="row">
            <div class="col-sm-5">
                <div class="card">
                    <form action="Controlador?menu=NuevaVenta" method="POST">
                        <div class="card-body">
                            <div class="form-group">
                                <label class="form-label">Datos del cliente</label>
                            </div>
                            <div class="row">
                                <div class="col-sm-6">
                                    <div class="input-group mb-3">
                                        <input type="text" value="${clien.getDni()}" name="codigoCliente" class="form-control" placeholder="Código">
                                        <input type="submit" name="accion" value="BuscarCliente" class="btn btn-outline-primary" >
                                    </div>
                                </div>
                                <div class="col-sm-6">
                                    <div class="form-group">
                                        <input type="text" name="nombreCliente" value="${clien.getNom()}" class="form-control" placeholder="Datos cliente">
                                    </div>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="form-label">Datos Producto</label>
                            </div>
                            <div class="row">
                                <div class="col-sm-6">
                                    <div class="input-group mb-3">
                                        <input type="text" class="form-control" placeholder="Código" name="codigoproducto" value="${producto.getId()}">
                                        <button class="btn btn-outline-primary" name="accion" type="submit" value="BuscarProducto">Buscar producto</button>
                                    </div>
                                </div>
                                <div class="col-sm-6">
                                    <div class="form-group">
                                        <input type="text" name="nombreProducto" value="${producto.getNom()}" class="form-control" placeholder="Datos producto">
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-sm-6">
                                    <div class="form-group">
                                        <input type="text" name="precio" value="${producto.getPrecio()}" class="form-control" placeholder="$/.0.00">
                                    </div>
                                </div>
                                <div class="col-sm-3">
                                    <div class="form-group">
                                        <input type="number" name="cant" value="1" class="form-control" placeholder="">
                                    </div>
                                </div>
                                <div class="col-sm-3">
                                    <div class="form-group">
                                        <input type="text" name="stock" value="${producto.getStock()}" class="form-control" placeholder="Stock">
                                    </div>
                                </div>
                            </div>
                            <div class="d-flex form-group">
                                <button type="submit" name="accion" value="Agregar" class="btn btn-primary mt-4">Agregar Producto</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="col-sm-7">
                <div class="card p-3">
                    <div calss="card-body">
                        <div class="row g-3 align-items-center ms-auto justify-content-end mb-3">
                            <div class="col-auto">
                                <label for="NroSerie" class="col-form-label me3">Nro.Serie: </label>
                            </div>
                            <div class="col-auto">
                                <input type="text" id="NroSerie" name="NroSerie" class="form-control">
                            </div>
                        </div>
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th>Nro</th>
                                    <th>Código</th>
                                    <th>Descripción</th>
                                    <th>Precio</th>
                                    <th>Cantidad</th>
                                    <th>Subtotal</th>
                                    <th>Acciones</th>
                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="list" items="${lista}"> 
                                <tr>
                                    <td>${list.getItem()}</td>
                                    <td>${list.getIdproducto()}</td>
                                    <td>${list.getDescripcionP()}</td>
                                    <td>${list.getPrecio()}</td>
                                    <td>${list.getCantidad()}</td>
                                    <td>${list.getSubtotal()}</td>
                                    <td>
                                        <a href="#" class="btn btn-warning mb-md-0 mb-2 mb-lg-2 mb-xl-0" >Editar</a>
                                        <a href="#" class="btn btn-danger">Delete</a>
                                    </td>
                                </tr>
                            </c:forEach>
                                    
                            </tbody>
                        </table>
                    </div>
                    <div class="card-footer d-flex">
                        <div class="col-sm-6">
                            <input type="submit" name="accion" value="Genear venta" class="btn btn-success me-2">
                            <input type="submit" name="accion" value="Cancelar" class="btn btn-danger">
                        </div>
                        <div class="col-sm-4 ml-auto">
                            <input type="text" name="txtTotal" class="form-control" value="${totalpagar}">
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    </body>
</html>
