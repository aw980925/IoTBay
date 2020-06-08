/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.controller;

import java.io.IOException;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.isd.model.User;
import uts.isd.model.Product;
import uts.isd.dao.DBManager;
import uts.isd.dao.ProductDBManager;
/**
 *
 * @author heeseong
 */
public class AddProductServlet extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
        //current session
        HttpSession session = request.getSession();
        Validator validator = new Validator();
        
        String categoryID = request.getParameter("categoryId");
        String name = request.getParameter("productname");
        String type = request.getParameter("producttype");
        String description = request.getParameter("description");
        String price = request.getParameter("price");
        String status = request.getParameter("status");
        String quantity = request.getParameter("quantity");
        
        ProductDBManager productManager = (ProductDBManager)session.getAttribute("productManager");
        
        validator.clear(session);
        
        if (!validator.validateProductName(name)) {
            session.setAttribute("productNameErr", "Error: Product name format is incorrect");
            request.getRequestDispatcher("addProduct.jsp").include(request, response);
        } else if (!validator.validateProductType(type)) {
            session.setAttribute("productTypeErr", "Error: Product type format is incorrect");
            request.getRequestDispatcher("addProduct.jsp").include(request, response);
        } else if (!validator.validateProductDesc(description)) {
            session.setAttribute("productDescriptionErr", "Error: Product description format is incorrect");
            request.getRequestDispatcher("addProduct.jsp").include(request, response);
        } else if (!validator.validateProductQuantity(quantity)) {
            session.setAttribute("productQuantityErr", "Error: Product quantity format is incorrect");
            request.getRequestDispatcher("addProduct.jsp").include(request, response);
        } else if (!validator.validateProductPrice(price)) {
            session.setAttribute("productPriceErr", "Error: Product price format is incorrect");
            request.getRequestDispatcher("addProduct.jsp").include(request, response);
        } else {
            try {
                if (productManager != null) {
                    Product exist = productManager.findProduct(name, type);

                    if (exist != null) {
                        session.setAttribute("existDeviceErr", "Product already exists in database");
                        request.getRequestDispatcher("addProduct.jsp").include(request, response);
                    } else {
                        //productManager.addProduct(name, Double.parseDouble(price), description, status, Integer.parseInt(quantity) , type);
                        //Product product = new Product(name, Double.parseDouble(price), description, status, Integer.parseInt(quantity) , type);
                        //session.setAttribute("product", product);
                        request.getRequestDispatcher("main-admin.jsp").include(request, response);
                    }
                } else {
                    session.setAttribute("managerErr", "Cannot connect to database");
                    request.getRequestDispatcher("main-admin.jsp").include(request, response);
                }
            } catch (SQLException | NullPointerException ex) {
                ex.printStackTrace();
                //Logger.getLogger(addProductServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
