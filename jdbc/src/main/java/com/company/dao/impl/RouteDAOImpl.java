package com.company.dao.impl;

import com.company.dao.BaseEntityDAO;
import com.company.model.Route;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RouteDAOImpl implements BaseEntityDAO<Route> {
    private static final Logger log = LoggerFactory.getLogger(LocationDAOImpl.class);
    private final Connection connection;

    public RouteDAOImpl(Connection c) {
        connection = c;
    }

    @Override
    public List<Route> read() {
        log.info("Start reading all routes");
        List<Route> routes = new ArrayList<>();
        try (PreparedStatement readAll = connection.prepareStatement("SELECT * FROM route")) {
            ResultSet resultSet = readAll.executeQuery();
            while (resultSet.next()) {
                routes.add(new Route(resultSet.getInt("id"),
                        resultSet.getInt("id_from"),
                        resultSet.getInt("id_to"),
                        resultSet.getInt("cost")));
            }
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
        log.info("Read all routes");
        return routes;
    }

    @Override
    public void update(int id, Route route) {

    }

}
