package ru.itis.go_standup.servlets;

import ru.itis.go_standup.dto.EventDTO;
import ru.itis.go_standup.services.EventService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/afisha")
public class AfishaServlet extends HttpServlet {

    private EventService eventService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.eventService=(EventService) config.getServletContext().getAttribute("eventService");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<EventDTO> events = eventService.getEventDTO();
        req.setAttribute("events",events);
        req.getRequestDispatcher("afisha.ftl").forward(req, resp);

    }
}

