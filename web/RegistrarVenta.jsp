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
        <div class="d-flex">
            <div class="col-sm-4">
                <div class="card">
                    <form>
                        <div class="card-body">
                            <div class="form-group">
                                <label>Datos del cliente</label>
                            </div>
                            <div class="form-group d-flex">
                                <div class="col-sm-6 d-felx">
                                    <input type="text" name="codigoCliente" class="form-control" placeholder="Código">
                                    <input type="submit" name="accion" value="Buscar" class="btn btn-outline-info">
                                </div>
                                <div class="col-sm-6">
                                    <input type="text" name="nombreCliente" class="form-control" placeholder="Datos cliente">
                                </div>
                            </div>
                            <div class="form-group">
                                <label>Datos Producto</label>
                            </div>
                            <div class="form-group d-flex">
                                <div class="col-sm-6 d-felx">
                                    <input type="text" name="codigoProducto" class="form-control" placeholder="Código">
                                    <input type="submit" name="accion" value="Buscar" class="btn btn-outline-info">
                                </div>
                                <div class="col-sm-6">
                                    <input type="text" name="nombreCliente" class="form-control" placeholder="Datos producto">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-6 d-felx">
                                    <input type="text" name="precio" class="form-control" placeholder="$/.0.00">
                                </div>
                                <div class="col-sm-3">
                                    <input type="number" name="cant" class="form-control" placeholder="">
                                </div>
                                <div class="col-sm-3">
                                    <input type="text" name="stock" class="form-control" placeholder="Stock">
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="col-sm-8">

            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    </body>
</html>
