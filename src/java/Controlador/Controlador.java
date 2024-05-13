package Controlador;

import Modelo.Cliente;
import Modelo.ClientesDAO;
import Modelo.Empleado;
import Modelo.EmpleadoDAO;
import Modelo.GenerarSerie;
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
    int id;

    Venta v = new Venta();
    List<Venta> lista = new ArrayList<>();
    int item;
    int cod;
    String descripcion;
    double precio;
    int cant;
    double subtotal;
    double totalPagar;

    String numeroserie;
    VentaDAO vdao = new VentaDAO();

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
                    id = Integer.parseInt(request.getParameter("id"));
                    Empleado e = edao.listarId(id);
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
                    em.setId(id);
                    edao.update(em);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=SELECT").forward(request, response);
                    break;
                case "Eliminar":
                    id = Integer.parseInt(request.getParameter("id"));
                    edao.delete(id);
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
                    id = Integer.parseInt(request.getParameter("id"));
                    Cliente c = cdao.listarId(id);
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
                    cl.setId(id);
                    cdao.update(cl);
                    request.getRequestDispatcher("Controlador?menu=Clientes&accion=SELECT").forward(request, response);
                    break;
                case "Eliminar":
                    id = Integer.parseInt(request.getParameter("id"));
                    cdao.delete(id);
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
                    id = Integer.parseInt(request.getParameter("id"));
                    Producto p = pdao.listarId(id);
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
                    pr.setId(id);
                    pdao.update(pr);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=SELECT").forward(request, response);
                    break;
                case "Eliminar":
                    id = Integer.parseInt(request.getParameter("id"));
                    pdao.delete(id);
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
                    String dni = request.getParameter("codigoCliente");
                    cl.setDni(dni);
                    cl = cdao.buscar(dni);
                    request.setAttribute("clien", cl);
                    break;
                case "BuscarProducto":
                    int id = Integer.parseInt(request.getParameter("codigoproducto"));
                    pr = pdao.listarId(id);
                    request.setAttribute("clien", cl);
                    request.setAttribute("producto", pr);
                    request.setAttribute("lista", lista);
                    request.setAttribute("totalpagar", totalPagar);
                    break;
                case "Agregar":
                    request.setAttribute("clien", cl);
                    totalPagar = 0.0;
                    item = item + 1;
                    cod = pr.getId();
                    descripcion = request.getParameter("nombreProducto");
                    precio = Double.parseDouble(request.getParameter("precio"));
                    cant = Integer.parseInt(request.getParameter("cant"));
                    subtotal = precio * cant;
                    v = new Venta();
                    v.setItem(item);
                    v.setId(cod);
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
                    break;
                default:
                    numeroserie = vdao.GenerarSerie();
                    if (numeroserie == null) {
                        numeroserie = "00000001";
                        request.setAttribute("nserie", numeroserie);
                    } else {
                        int incrementar = Integer.parseInt(numeroserie);
                        GenerarSerie gs = new GenerarSerie();
                        numeroserie = gs.NumeroSerie(incrementar);
                        request.setAttribute("nserie", numeroserie);
                    }
                    request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
            }
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
