package Filter;

import DAO.Registration;

import javax.servlet.*;
import java.io.IOException;
import java.sql.SQLException;

public class UserFilter implements Filter {
    private Registration registration;
    @Override
    public void init(FilterConfig filterConfig)  {
        registration = new Registration();
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String uName = request.getParameter("name");
        try {
            if ( registration.uniqueName(uName)) {
            chain.doFilter(request, response);
        }else {request.getRequestDispatcher("/Pages/WrongName.jsp").forward(request, response);}
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void destroy() {
    }


}
