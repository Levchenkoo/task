package com.company.dao.impl;

import com.company.dao.BaseEntityDAO;
import com.company.model.Problem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProblemDAOImpl implements BaseEntityDAO<Problem> {
    private static final Logger log = LoggerFactory.getLogger(LocationDAOImpl.class);
    private final Connection connection;

    public ProblemDAOImpl(Connection c) {
        connection = c;
    }

    @Override
    public List<Problem> read() {
        log.info("Start reading all problems");
        List<Problem> problems = new ArrayList<>();
        try (PreparedStatement readAll = connection.prepareStatement("SELECT * FROM problem")) {
            ResultSet resultSet = readAll.executeQuery();
            while (resultSet.next()) {
                problems.add(new Problem(resultSet.getInt("id"), resultSet.getInt("id_from"), resultSet.getInt("id_to")));
            }
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
        log.info("Read all problems");
        return problems;
    }


    @Override
    public void update(int id, Problem problem) {
    }
}
