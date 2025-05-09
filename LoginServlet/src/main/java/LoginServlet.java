
import jakarta.servlet.http.*;
import java.io.*;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if ("admin".equals(username) && "1234".equals(password)) {
            out.println("<h2>Login Successful</h2>");
        } else {
            out.println("<h2>Invalid Username or Password</h2>");
        }
    }
}
