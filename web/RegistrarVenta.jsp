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
                                        <input type="text" class="form-control" placeholder="Código" aria-label="Código" aria-describedby="button-addon2">
                                        <button class="btn btn-outline-primary" name="accion" type="button" id="button-addon2">Buscar producto</button>
                                    </div>
                                </div>
                                <div class="col-sm-6">
                                    <div class="form-group">
                                        <input type="text" name="nombreProducto" class="form-control" placeholder="Datos producto">
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-sm-6">
                                    <div class="form-group">
                                        <input type="text" name="precio" class="form-control" placeholder="$/.0.00">
                                    </div>
                                </div>
                                <div class="col-sm-3">
                                    <div class="form-group">
                                        <input type="number" name="cant" class="form-control" placeholder="">
                                    </div>
                                </div>
                                <div class="col-sm-3">
                                    <div class="form-group">
                                        <input type="text" name="stock" class="form-control" placeholder="Stock">
                                    </div>
                                </div>
                            </div>
                            <div class="d-flex form-group">
                                <input type="submit" name="accion" value="Agregar" class="btn btn-primary mt-4">
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
                                <tr>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                    <div class="card-footer">
                        <div class="d-flex">
                            <input type="submit" name="accion" value="Genear venta" class="btn btn-success me-2">
                            <input type="submit" name="accion" value="Cancelar" class="btn btn-danger">
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    </body>
</html>
