package ru.itis.go_standup.listeners;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.itis.go_standup.repositories.UsersRepository;
import ru.itis.go_standup.repositories.impl.UsersRepositoryImpl;

import ru.itis.go_standup.services.AuthorizationService;
import ru.itis.go_standup.services.PasswordEncoder;
import ru.itis.go_standup.services.UserMapper;
import ru.itis.go_standup.services.impl.AuthorizationServiceImpl;
import ru.itis.go_standup.services.impl.PasswordEncoderImpl;
import ru.itis.go_standup.services.impl.UserMapperImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class InitListener implements ServletContextListener {
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "968683";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String DB_DRIVER = "org.postgresql.Driver";

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("Postgresql Driver not found.");
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

        ServletContext servletContext = sce.getServletContext();
        servletContext.setAttribute("usersRepository", usersRepository);
        servletContext.setAttribute("authorizationService", authorizationService);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {}
}
