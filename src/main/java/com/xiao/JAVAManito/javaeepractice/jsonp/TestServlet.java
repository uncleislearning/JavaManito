package com.xiao.JAVAManito.javaeepractice.jsonp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.io.PipedReader;
import java.io.PrintWriter;

/**
 * Created by unclexiao on 2018/1/4.
 */
@WebServlet(urlPatterns = "/json")
public class TestServlet extends HttpServlet{

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>JAX-RS Reader/Writer w/ JSON</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>JAX-RS Reader/Writer w/ JSON</h1>");
        Client client = ClientBuilder.newClient();
        client.register(MyReader.class).register(MyWriter.class);

        WebTarget target = client.target("http://"
                + request.getServerName()
                + ":"
                + request.getServerPort()
                + request.getContextPath()
                + "/webresources/endpoint");
        System.out.println(target.toString());
        out.println("POST request");
        MyObject mo = target
                .request()
                .post(Entity.entity(new MyObject("xiao", 18), MediaType.APPLICATION_JSON), MyObject.class);
        out.println("Received response: " + mo.getName() + ", " + mo.getAge() + "<br><br>");
        out.println("Message exchanged using application/json type.");
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req,resp);
    }

    @Override
    public String getServletInfo() {
        return "info test";
    }
}
