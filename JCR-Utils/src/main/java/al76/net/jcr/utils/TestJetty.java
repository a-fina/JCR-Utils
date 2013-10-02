/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package al76.net.jcr.utils;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.*;
/**
 *
 * @author afinamore
 */
public class TestJetty extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.getWriter().print("Hello from Java!\n");
    }

    public static void main(String[] args) throws Exception{
		int port = 8888;
		if (System.getenv("PORT") != null)
			port = Integer.valueOf(System.getenv("PORT"));

        Server server = new Server(port);
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);
        context.addServlet(new ServletHolder(new TestJetty()),"/*");
        server.start();
        server.join();   
    }
}
	
