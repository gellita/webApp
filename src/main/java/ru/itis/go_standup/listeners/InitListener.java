package ru.itis.go_standup.listeners;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.itis.go_standup.repositories.EventsRepository;
import ru.itis.go_standup.repositories.UsersRepository;
import ru.itis.go_standup.repositories.impl.EventsRepositoryImpl;
import ru.itis.go_standup.repositories.impl.UsersRepositoryImpl;

import ru.itis.go_standup.services.AuthorizationService;
import ru.itis.go_standup.services.EventService;
import ru.itis.go_standup.services.PasswordEncoder;
import ru.itis.go_standup.services.UserMapper;
import ru.itis.go_standup.services.impl.AuthorizationServiceImpl;
import ru.itis.go_standup.services.impl.EventServiceImpl;
import ru.itis.go_standup.services.impl.PasswordEncoderImpl;
import ru.itis.go_standup.services.impl.UserMapperImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebListener
public class InitListener implements ServletContextListener {
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "968683";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/standup";
    private static final String DB_DRIVER = "org.postgresql.Driver";

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("Postgresql Driver not found.");
        }
        Connection connection;
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME,
                    DB_PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(DB_DRIVER);
        dataSource.setUsername(DB_USERNAME);
        dataSource.setPassword(DB_PASSWORD);
        dataSource.setUrl(DB_URL);

        PasswordEncoder passwordEncoder = new PasswordEncoderImpl();
        UserMapper userMapper = new UserMapperImpl();
        UsersRepository usersRepository = new UsersRepositoryImpl(dataSource);
        AuthorizationService authorizationService = new AuthorizationServiceImpl(usersRepository, userMapper, passwordEncoder);
        EventsRepository eventRepository = new EventsRepositoryImpl(connection);
        EventService eventService = new EventServiceImpl(eventRepository);

        ServletContext servletContext = sce.getServletContext();

        servletContext.setAttribute("usersRepository", usersRepository);
        servletContext.setAttribute("authorizationService", authorizationService);
        servletContext.setAttribute("eventService", eventService);

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {}
}
