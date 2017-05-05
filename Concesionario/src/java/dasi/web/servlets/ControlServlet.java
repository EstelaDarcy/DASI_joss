/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dasi.web.servlets;


import dasi.web.exceptions.ConcesionarioException;
import dasi.web.forms.FormularioCoche;
import dasi.web.forms.FormularioModificarCoche;
import dasi.web.modelo.Coche;
import dasi.web.modelo.Dao;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Estela
 */
public class ControlServlet extends HttpServlet 
{
    private Dao getDao()
    {
        ServletContext servletContext = getServletContext();
        return (Dao) servletContext.getAttribute("dao");
    }  
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException 
    {
        String url = request.getServletPath();
        
        switch(url)
        {           
            case "/modificarCoche.do":
                doModificarCoche(request, response);
                break;
            case "/deleteCoche.do":
                
                break;
            case "/coche.do":
                
                break;
            case "/vender.do":
                
                break;
            case "/datosCoche.do":
                doDatosCoche(request, response);
                break;
            case "/formulario.do":
                doFormulario(request, response);
                break;
            case "/vendidos.do":
                
                break;
            case "/coches.do":
                
                break;
            case "/addCoche.do":
                doAddCoche(request, response);
                break;
            case "/concesionario.do":
                doConcesionario(request, response);
                break;
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

     private void doAddCoche(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        FormularioCoche formulario = new FormularioCoche();               
        
        formulario.setMatricula(request.getParameter("matricula"));
        formulario.setMarca(request.getParameter("marca"));
        formulario.setModelo(request.getParameter("modelo"));
        formulario.setColor(request.getParameter("color"));
        formulario.setAnno(request.getParameter("anno"));
        formulario.setCilindrada(request.getParameter("cilindrada"));
        formulario.setCaballos(request.getParameter("caballos"));
        
        Map<String, String> errores = formulario.correcto();
        
        if(errores.isEmpty())
        {
            try{
            Dao dao = getDao();
            dao.addCoche(formulario.getMatricula(), formulario.getMarca(), formulario.getModelo(), formulario.getColor(), Integer.parseInt(formulario.getAnno()), Integer.parseInt(formulario.getCilindrada()), Integer.parseInt(formulario.getCaballos()));
            request.getRequestDispatcher("/concesionario.jsp").forward(request, response);                
            } catch (ConcesionarioException ex) {
                Logger.getLogger(ControlServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{            
            request.setAttribute("errores", errores);
            request.setAttribute("old", formulario);
            request.getRequestDispatcher("/addCoche.jsp").forward(request, response);
        }
    }

    private void doModificarCoche(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        String matricula = request.getParameter("matricula");
        
        FormularioModificarCoche formulario = new FormularioModificarCoche();                     
        
        formulario.setMarca(request.getParameter("marca"));
        formulario.setModelo(request.getParameter("modelo"));
        formulario.setColor(request.getParameter("color"));
        formulario.setAnno(request.getParameter("anno"));
        formulario.setCilindrada(request.getParameter("cilindrada"));
        formulario.setCaballos(request.getParameter("caballos"));
        
        Map<String, String> errores = formulario.correcto();
        
        if(errores.isEmpty())
        {
            try{
            Dao dao = getDao();
            dao.modificarCoche(matricula, formulario.getMarca(), formulario.getModelo(), formulario.getColor(), Integer.parseInt(formulario.getAnno()), Integer.parseInt(formulario.getCilindrada()), Integer.parseInt(formulario.getCaballos()));
            request.getRequestDispatcher("/concesionario.jsp").forward(request, response);                
            } catch (ConcesionarioException ex) {
                Logger.getLogger(ControlServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{            
            request.setAttribute("errores", errores);
            request.setAttribute("old", formulario);
            request.getRequestDispatcher("/modificarCoche.jsp").forward(request, response);
        }
    }

    private void doFormulario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/addCoche.jsp").forward(request, response);
    }

    private void doConcesionario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/concesionario.jsp").forward(request, response);
    }

    private void doDatosCoche(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        String matricula = request.getParameter("matricula");
        try 
        {            
            Dao dao = getDao();
            Coche coche = dao.mostrarFormulario(matricula);            
                        
            request.setAttribute("coche", coche);           
            request.getRequestDispatcher("/modificarCoche.jsp").forward(request, response);
     
        } catch (ConcesionarioException ex) {
            Logger.getLogger(ControlServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
