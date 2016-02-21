package database;

import constants.Constants;
import models.Account;
import models.Price;
import models.Role;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Admin on 19.01.2016.
 */
public class DBConnection {
    private static final Logger LOGGER = Logger.getLogger(DBConnection.class);
    private Connection conn = null;
    private ResultSet rs = null;
    private static PreparedStatement loadAllPrices;
    private static PreparedStatement loadPrice;
    private static PreparedStatement loadAllNews;
    private static PreparedStatement insertPrice;
    private static PreparedStatement updatePrice;
    private static PreparedStatement loadAllRoles;
    private static PreparedStatement loadAllLogins;
    private static PreparedStatement loadAccountByLogin;
    private static PreparedStatement loadRolesById;
    private static PreparedStatement getIdAccountRoles;

    public DBConnection(String url) {
        try {
            String dbUrl = Constants.CONNECTING_URL;
            if (System.getenv("OPENSHIFT_MYSQL_DB_HOST") != null) {
                dbUrl = String.format("jdbc:mysql://%s:%s/%s?user=%s&password=%s&characterEncoding=UTF-8",
                        System.getenv("OPENSHIFT_MYSQL_DB_HOST"),
                        System.getenv("OPENSHIFT_MYSQL_DB_PORT"),
                        System.getenv("OPENSHIFT_GEAR_NAME"),
                        System.getenv("OPENSHIFT_MYSQL_DB_USERNAME"),
                        System.getenv("OPENSHIFT_MYSQL_DB_PASSWORD"));
            }
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(dbUrl);
            loadPreparedStatements();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void loadPreparedStatements() {
        try {

            loadAllPrices = conn.prepareStatement("SELECT * from NISSANV1.PRICES");
            loadPrice=conn.prepareStatement("SELECT * from NISSANV1.PRICES WHERE  MODEL=?");
            loadAllNews = conn.prepareStatement("SELECT * from NISSANV1.NEWS");
            insertPrice = conn.prepareStatement("INSERT INTO NISSANV1.PRICES(MODEL, PRICE) VALUES(?, ?)");
            updatePrice = conn.prepareStatement("UPDATE NISSANV1.PRICES SET PRICES.PRICE = ? WHERE PRICES.MODEL= ?");
            //accounts
            loadAllRoles = conn.prepareStatement("SELECT * FROM roles");
            loadAllLogins = conn.prepareStatement("SELECT login, id FROM accounts ");
            loadAccountByLogin = conn.prepareStatement("SELECT * FROM accounts WHERE login = ?");
            loadRolesById = conn.prepareStatement("SELECT * FROM roles WHERE id =?");
            getIdAccountRoles = conn.prepareStatement("SELECT id_role FROM accaunts_roles WHERE id_accaunt = ?");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void closePreparedStatements() {
        try {
            loadAllRoles.close();
            loadAllPrices.close();
            loadPrice.close();
            insertPrice.close();
            loadAllNews.close();
            updatePrice.close();
            loadAllLogins.close();
            loadAccountByLogin.close();
            loadRolesById.close();
            getIdAccountRoles.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /*-----------------------prices-------------------------*/
    public List<Price> getAllPrices() {
        rs = null;
        List<Price> result = new LinkedList<Price>();
        try {
            rs = loadAllPrices.executeQuery();
            while (rs.next()) {
                Price r = new Price();
                r.setId(rs.getInt("id"));
                r.setPrice(rs.getString("price"));
                r.setModel(rs.getString("model"));
                result.add(r);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    public Price getPrice(String model) {
        rs = null;
        Price result = new Price();
        try {
            loadPrice.setNString(1, model);
            rs = loadPrice.executeQuery();
            while (rs.next()) {
                result.setId(rs.getInt("id"));
                result.setPrice(rs.getString("price"));
                result.setModel(rs.getString("model"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    /*---------------end prices---------------------*/

    public List<Role> getAllRoles() {
        rs = null;
        List<Role> result = new LinkedList<Role>();
        try {
            rs = loadAllRoles.executeQuery();
            while (rs.next()) {
                Role r = new Role();
                r.setId(rs.getInt("id"));
                r.setName(rs.getString("role"));
                result.add(r);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;

    }

    public List<Account> getAllLogins() {
        rs = null;
        List<Account> result = new LinkedList<Account>();
        try {
            rs = loadAllLogins.executeQuery();

            while (rs.next()) {
                Account account = new Account();
                account.setUsername(rs.getString("login"));
                account.setId(rs.getInt("id"));
                //account.setPassword(rs.getString("password"));
                result.add(account);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;

    }

    public Account getAccountByLogin(String login) {
        rs = null;
        // SELECT * FROM account WHERE login = ?
        Account result = new Account();
        try {
            loadAccountByLogin.setNString(1, login);
            rs = loadAccountByLogin.executeQuery();

            while (rs.next()) {
                result.setId(rs.getInt("id"));
                result.setUsername(rs.getString("login"));
                result.setPassword(rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;

    }

    public List<Role> getRolesById(int id) {
        rs = null;
        List<Role> result = new LinkedList<Role>();
        try {
            loadRolesById.setInt(1, id);
            rs = loadRolesById.executeQuery();

            while (rs.next()) {
                Role role = new Role();
                role.setId(rs.getInt("id"));
                role.setName(rs.getString("role"));
                result.add(role);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void close() {
        closePreparedStatements();
        try {
            if (conn != null)
                conn.close();
        } catch (SQLException e) {
            LOGGER.info("close() exeption " + e.getMessage());
            e.printStackTrace();
        }
    }

    public List<Integer> getIdAccountRoles(int idAccount) {
        rs = null;
        List<Integer> idAccountRoles = new ArrayList<Integer>();
        try {
            getIdAccountRoles.setInt(1, idAccount);
            rs = getIdAccountRoles.executeQuery();

            while (rs.next()) {
                idAccountRoles.add(rs.getInt("id_role"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idAccountRoles;
    }

}