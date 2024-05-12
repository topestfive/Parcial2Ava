<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <title>Login</title>
    </head>
    <body>
        <div class="container mt-4 col-lg-4">
            <div class="card col-sm-10">
                <div class="card-body">
                    <form class="form-sign" action="Validar" method="POST">
                        <div class="form-group text-center">
                            <h3>Login</h3>
                            <img src="img/logo.jpg" alt="70" width="170"/>
                            <label>Bienvenido al Sistema</label>
                        </div>
                        <div class="form-group mt-3">
                            <label  for="txtuser" class="form-label">Usuario:</label>
                            <input type="text" name="txtuser" class="form-control mb-2" required>
                        </div>
                        <div class="form-group">
                            <label for="txtpass" class="form-label">Password:</label>
                            <input type="password" name="txtpass" class="form-control" required>
                        </div>
                        <div class="d-grid gap-2">
                            <input type="submit" name="accion" value="Ingresar" class="btn btn-primary mt-4">
                        </div
                    </form>
                </div>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    </body>
</html>
