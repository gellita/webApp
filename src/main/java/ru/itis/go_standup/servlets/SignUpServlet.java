package ru.itis.go_standup.servlets;

import ru.itis.go_standup.dto.SignUpDTO;
import ru.itis.go_standup.dto.UserDTO;
import ru.itis.go_standup.exceptions.StandupException;
import ru.itis.go_standup.services.AuthorizationService;
import ru.itis.go_standup.services.impl.AuthorizationServiceImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/sign-up")
    public class SignUpServlet extends HttpServlet {

        private AuthorizationServiceImpl authorizationService;

        @Override
        public void init(ServletConfig config) throws ServletException {
            ServletContext servletContext = config.getServletContext();
            authorizationService = (AuthorizationServiceImpl) servletContext.getAttribute("authorizationService");
        }

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            req.getRequestDispatcher("sign-up.ftl").forward(req, resp);
        }

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            System.out.println("RAbOTAET");
            req.setCharacterEncoding("UTF-8");
            resp.setCharacterEncoding("UTF-8");
            SignUpDTO form = SignUpDTO.builder()
                    .firstName(req.getParameter("firstName"))
                    .lastName(req.getParameter("lastName"))
                    .email(req.getParameter("email"))
                    .password(req.getParameter("password"))
                    .build();
            UserDTO user;
            String email;
            try {
                user = authorizationService.signUp(form);
                email = user.getEmail();
            } catch (StandupException e) {
                req.setAttribute("errorMessage", e.getMessage());
                req.getRequestDispatcher("sign-up.ftl").forward(req, resp);
                return;
            }
            HttpSession session = req.getSession(true);
            session.setAttribute("user", user);
            session.setAttribute("email", email);
            resp.sendRedirect("profile");
        }

}
