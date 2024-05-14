package Controlador;

import Modelo.Cliente;
import Modelo.ClientesDAO;
import Modelo.Empleado;
import Modelo.EmpleadoDAO;
import config.GenerarSerie;
import Modelo.Producto;
import Modelo.ProductoDAO;
import Modelo.Venta;
import Modelo.VentaDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class Controlador extends HttpServlet {

    Empleado em = new Empleado(); //DTO Empleado
    EmpleadoDAO edao = new EmpleadoDAO(); //DAO Empleado

    Cliente cl = new Cliente(); //DTO Clientes
    ClientesDAO cdao = new ClientesDAO(); //DAO Clientes

    Producto pr = new Producto(); //DTO Producto
    ProductoDAO pdao = new ProductoDAO(); //DAO Producto

    Venta v = new Venta(); //DTO Venta
    VentaDAO vdao = new VentaDAO(); //DAO Venta

    GenerarSerie gs = new GenerarSerie();

    int ide;
    int idc;
    int idp;
    int idrv;
    
    String dni;

    //Variables registrar venta
    List<Venta> lista = new ArrayList<>();
    int item;
    int cod;
    String descripcion;
    double precio;
    int cant;
    double subtotal;
    double totalPagar;
    String numeroserie;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        if (menu.equals("Principal")) {
            request.getRequestDispatcher("Principal.jsp").forward(request, response);
        }
        if (menu.equals("Empleado")) {
            switch (accion) {
                case "SELECT":
                    List lista = edao.select();
                    request.setAttribute("empleados", lista);
                    break;
                case "Agregar":
                    String dni = request.getParameter("txtDni");
                    String nom = request.getParameter("txtNombres");
                    String tel = request.getParameter("txtTel");
                    String est = request.getParameter("txtEstado");
                    String user = request.getParameter("txtUser");
                    em.setDni(dni);
                    em.setNom(nom);
                    em.setTel(tel);
                    em.setEstado(est);
                    em.setUser(user);
                    edao.insert(em);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=SELECT").forward(request, response);
                    break;
                case "Editar":
                    ide = Integer.parseInt(request.getParameter("id"));
                    Empleado e = edao.listarId(ide);
                    request.setAttribute("empleado", e);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=SELECT").forward(request, response);
                    break;
                case "Actualizar":
                    String dniU = request.getParameter("txtDni");
                    String nomU = request.getParameter("txtNombres");
                    String telU = request.getParameter("txtTel");
                    String estU = request.getParameter("txtEstado");
                    String userU = request.getParameter("txtUser");
                    em.setDni(dniU);
                    em.setNom(nomU);
                    em.setTel(telU);
                    em.setEstado(estU);
                    em.setUser(userU);
                    em.setId(ide);
                    edao.update(em);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=SELECT").forward(request, response);
                    break;
                case "Eliminar":
                    ide = Integer.parseInt(request.getParameter("id"));
                    edao.delete(ide);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=SELECT").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Empleado.jsp").forward(request, response);
        }
        if (menu.equals("Clientes")) {
            switch (accion) {
                case "SELECT":
                    List lista = cdao.select();
                    request.setAttribute("clientes", lista);
                    break;
                case "Agregar":
                    String dni = request.getParameter("txtDni");
                    String nom = request.getParameter("txtNombres");
                    String dir = request.getParameter("txtDir");
                    String est = request.getParameter("txtEstado");
                    cl.setDni(dni);
                    cl.setNom(nom);
                    cl.setDir(dir);
                    cl.setEstado(est);
                    cdao.insert(cl);
                    request.getRequestDispatcher("Controlador?menu=Clientes&accion=SELECT").forward(request, response);
                    break;
                case "Editar":
                    idc = Integer.parseInt(request.getParameter("id"));
                    Cliente c = cdao.listarId(idc);
                    request.setAttribute("cliente", c);
                    request.getRequestDispatcher("Controlador?menu=Clientes&accion=SELECT").forward(request, response);
                    break;
                case "Actualizar":
                    String dniU = request.getParameter("txtDni");
                    String nomU = request.getParameter("txtNombres");
                    String dirU = request.getParameter("txtDir");
                    String estU = request.getParameter("txtEstado");
                    cl.setDni(dniU);
                    cl.setNom(nomU);
                    cl.setDir(dirU);
                    cl.setEstado(estU);
                    cl.setId(idc);
                    cdao.update(cl);
                    request.getRequestDispatcher("Controlador?menu=Clientes&accion=SELECT").forward(request, response);
                    break;
                case "Eliminar":
                    idc = Integer.parseInt(request.getParameter("id"));
                    cdao.delete(idc);
                    request.getRequestDispatcher("Controlador?menu=Clientes&accion=SELECT").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Clientes.jsp").forward(request, response);
        }
        if (menu.equals("Producto")) {
            switch (accion) {
                case "SELECT":
                    List lista = pdao.select();
                    request.setAttribute("productos", lista);
                    break;
                case "Agregar":
                    String nom = request.getParameter("txtNombres");
                    String precio = request.getParameter("txtPrecio");
                    String stock = request.getParameter("txtStock");
                    String est = request.getParameter("txtEstado");
                    pr.setNom(nom);
                    pr.setPrecio(precio);
                    pr.setStock(stock);
                    pr.setEstado(est);
                    pdao.insert(pr);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=SELECT").forward(request, response);
                    break;
                case "Editar":
                    idp = Integer.parseInt(request.getParameter("id"));
                    Producto p = pdao.listarId(idp);
                    request.setAttribute("producto", p);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=SELECT").forward(request, response);
                    break;
                case "Actualizar":
                    String nomU = request.getParameter("txtNombres");
                    String precioU = request.getParameter("txtPrecio");
                    String stockU = request.getParameter("txtStock");
                    String estU = request.getParameter("txtEstado");
                    pr.setNom(nomU);
                    pr.setPrecio(precioU);
                    pr.setStock(stockU);
                    pr.setEstado(estU);
                    pr.setId(idp);
                    pdao.update(pr);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=SELECT").forward(request, response);
                    break;
                case "Eliminar":
                    idp = Integer.parseInt(request.getParameter("id"));
                    pdao.delete(idp);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=SELECT").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Producto.jsp").forward(request, response);
        }
        if (menu.equals("NuevaVenta")) {
            switch (accion) {
                case "BuscarCliente":
                    dni = null;
                    dni = request.getParameter("codigoCliente");
                    cl.setDni(dni);
                    cl = cdao.buscar(dni);
                    request.setAttribute("clien", cl);
                    break;
                case "BuscarProducto":
                    idrv = 0;
                    idrv = Integer.parseInt(request.getParameter("codigoproducto"));
                    pr = pdao.listarId(idrv);
                    request.setAttribute("clien", cl);
                    request.setAttribute("producto", pr);
                    request.setAttribute("lista", lista);
                    request.setAttribute("totalpagar", totalPagar);
                    break;
                case "Agregar":
                    System.out.println(dni+"   "+idrv);
                    if (idrv == 0 && dni == null) {
                        request.setAttribute("txtAlerta", "! No se puede agregar sin productos o cliente !");
                    } else {
                        request.setAttribute("clien", cl);
                        totalPagar = 0.0;
                        item = item + 1;
                        cod = pr.getId();
                        descripcion = pr.getNom();
                        precio = Double.parseDouble(pr.getPrecio());
                        cant = Integer.parseInt(request.getParameter("cant"));
                        subtotal = precio * cant;
                        v = new Venta();
                        v.setItem(item);
                        v.setIdproducto(cod);
                        v.setDescripcionP(descripcion);
                        v.setPrecio(precio);
                        v.setCantidad(cant);
                        v.setSubtotal(subtotal);
                        lista.add(v);
                        for (int i = 0; i < lista.size(); i++) {
                            totalPagar = totalPagar + lista.get(i).getSubtotal();
                        }
                        request.setAttribute("totalpagar", totalPagar);
                        request.setAttribute("lista", lista);
                        idrv = 0;
                    }
                    break;
                case "Editar":
                    idrv = Integer.parseInt(request.getParameter("item"));

                    break;
                case "Actualizar":
                    String nomU = request.getParameter("txtNombres");
                    String precioU = request.getParameter("txtPrecio");
                    String stockU = request.getParameter("txtStock");
                    String estU = request.getParameter("txtEstado");
                    pr.setNom(nomU);
                    pr.setPrecio(precioU);
                    pr.setStock(stockU);
                    pr.setEstado(estU);
                    pr.setId(idp);
                    pdao.update(pr);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=SELECT").forward(request, response);
                    break;
                case "Eliminar":
                    idrv = Integer.parseInt(request.getParameter("item"));
                    for (int i = 0; i < lista.size(); i++) {
                        if (lista.get(i).getItem() == idrv) {
                            lista.remove(i);
                        }
                    }
                    totalPagar = 0;
                    for (int i = 0; i < lista.size(); i++) {
                        totalPagar = totalPagar + lista.get(i).getSubtotal();
                    }
                    request.setAttribute("totalpagar", totalPagar);
                    request.setAttribute("lista", lista);
                    break;
                case "GenerarVenta":
                    if (lista.isEmpty()) {
                        request.setAttribute("txtAlerta", "! No se pueden generar ventas sin productos. Agregue al menos un producto antes de continuar !");
                    } else {
                        for (int i = 0; i < lista.size(); i++) {
                            Producto pr2 = new Producto();
                            int cantidad = lista.get(i).getCantidad();
                            int idproducto = lista.get(i).getIdproducto();
                            ProductoDAO aO = new ProductoDAO();
                            pr2 = aO.buscar(idproducto);
                            int sac = Integer.parseInt(pr.getStock()) - cantidad;
                            aO.actualizarStock(idproducto, sac);
                        }

                        v.setIdcliente(cl.getId());
                        v.setIdempleado(2);
                        v.setNumserie(numeroserie);
                        v.setFecha("2024-05-12");
                        v.setMonto(totalPagar);
                        v.setEstado("1");
                        vdao.guardarVenta(v);

                        int idv = Integer.parseInt(vdao.IdVentas());

                        for (int i = 0; i < lista.size(); i++) {
                            v = new Venta();
                            v.setId(idv);
                            v.setIdproducto(lista.get(i).getIdproducto());
                            v.setCantidad(lista.get(i).getCantidad());
                            v.setPrecio(lista.get(i).getPrecio());
                            vdao.guardarDetalleventas(v);
                        }
                        lista.clear();
                        numeroserie = gs.VerificarNumeroSerie(numeroserie);
                    }
                    break;
                case "Cancelar":
                    item = 0;
                    lista.clear();
                    request.setAttribute("lista", lista);
                    break;
                default:
                    numeroserie = gs.VerificarNumeroSerie(vdao.GenerarSerie());
                    request.setAttribute("nserie", numeroserie);
                    request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
            }
            request.setAttribute("nserie", numeroserie);
            request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
