package com.company;

import com.company.dao.impl.LocationDAOImpl;
import com.company.dao.impl.ProblemDAOImpl;
import com.company.dao.impl.RouteDAOImpl;
import com.company.dao.impl.SolutionDAOImpl;
import com.company.util.ConnectionManager;
import com.company.model.Location;
import com.company.model.Problem;
import com.company.model.Route;
import com.company.model.Solution;
import com.company.util.PathInGraph;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        try (Connection connection = ConnectionManager.getConnection()) {

            LocationDAOImpl locationDAOImpl = new LocationDAOImpl(connection);
            RouteDAOImpl routeDAOImpl = new RouteDAOImpl(connection);
            ProblemDAOImpl problemDAOImpl = new ProblemDAOImpl(connection);
            SolutionDAOImpl solutionDAOimpl = new SolutionDAOImpl(connection);

            List<Location> locations = locationDAOImpl.read();
            List<Route> routes = routeDAOImpl.read();
            List<Problem> problems = problemDAOImpl.read();

            PathInGraph pathInGraph = new PathInGraph(locations, routes);
            for (Problem problem : problems) {
                int cost = pathInGraph.determineShortestPath(problem.getIdFrom(), problem.getIdTo());
                Solution solution = new Solution(cost);
                solutionDAOimpl.update(problem.getId(), solution);
            }

        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }
}
