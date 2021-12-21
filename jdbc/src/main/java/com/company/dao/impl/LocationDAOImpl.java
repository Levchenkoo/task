package com.company.dao.impl;

import com.company.dao.BaseEntityDAO;
import com.company.model.Location;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LocationDAOImpl implements BaseEntityDAO<Location> {
    private static final Logger log = LoggerFactory.getLogger(LocationDAOImpl.class);
    private final Connection connection;

    public LocationDAOImpl(Connection c) {
        connection = c;
    }

    @Override
    public List<Location> read() {
        log.info("Start reading all locations");
        List<Location> locations = new ArrayList<>();
        try (PreparedStatement readAll = connection.prepareStatement("SELECT * FROM location")) {
            ResultSet resultSet = readAll.executeQuery();
            while (resultSet.next()) {
                locations.add(new Location(resultSet.getInt("id"), resultSet.getString("name")));
            }
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
        log.info("Read all locations");
        return locations;
    }

    @Override
    public void update(int id, Location location) {
    }

}
