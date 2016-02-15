package database;

import constants.Constants;
import models.Account;
import models.Precence;
import models.Role;
import models.WriteOff;
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
    private static PreparedStatement loadAllRoles;
    private static PreparedStatement addPrecence;
    private static PreparedStatement getIDMat;
    private static PreparedStatement sreachPrecence;
    private static PreparedStatement sreachPrecenceIf;
    private static PreparedStatement getLength;
    private static PreparedStatement updateLength;
    private static PreparedStatement addMat;
    private static PreparedStatement insertWriteOf;
    private static PreparedStatement getWriteOf;
    private static PreparedStatement updateWriteOf;
    private static PreparedStatement addWriteOf;
    private static PreparedStatement updateWriteOfPrecence;
    private static PreparedStatement deleteWriteOfPrecence;
    private static PreparedStatement loadAllLogins;
    private static PreparedStatement loadAccountByLogin;
    private static PreparedStatement loadRolesById;
    private static PreparedStatement getIdAccountRoles;
    public DBConnection(String url) {
        try {
            String dbUrl = Constants.CONNECTING_URL;
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(dbUrl);
            loadPreparedStatements();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    private void loadPreparedStatements() {
        try {
            addMat=conn.prepareStatement("INSERT INTO STORAGE.MAT (`codename`, `sizerol`) VALUES (?, ?)");
            //add materials
            getIDMat=conn.prepareStatement("SELECT ID from STORAGE.MAT WHERE CODENAME=? AND SIZEROL=?");
            addPrecence=conn.prepareStatement("INSERT INTO STORAGE.PRECENCE (`name`, `len`, `stat`) VALUES (?, ?, 1)");
            //send maket
            sreachPrecence = conn.prepareStatement("SELECT * from STORAGE.PRECENCE LEFT Join MAT ON PRECENCE.NAME=MAT.ID WHERE MAT.CODENAME=? AND MAT.SIZEROL=? AND PRECENCE.STAT=?");
            sreachPrecenceIf = conn.prepareStatement("SELECT * from STORAGE.PRECENCE LEFT Join MAT ON PRECENCE.NAME=MAT.ID WHERE MAT.CODENAME=? AND MAT.SIZEROL>? AND PRECENCE.STAT=?");
            getLength = conn.prepareStatement("SELECT LEN from STORAGE.PRECENCE WHERE ID=?");
            updateLength = conn.prepareStatement("UPDATE STORAGE.PRECENCE SET LEN = ?,STAT = 1 WHERE ID = ?");
            insertWriteOf= conn.prepareStatement("INSERT INTO STORAGE.WRITEOF(PRECENCE, LEN, TYPEWRITEOF, COMMENT) VALUES(?, ?, 5, ?)");
           //inspect deffect
            getWriteOf= conn.prepareStatement("SELECT ID FROM WRITEOF WHERE TYPEWRITEOF=1");
            updateWriteOf=conn.prepareStatement("UPDATE STORAGE.writeof SET writeof.typewriteof = ? WHERE writeof.id= ?");
            //add deffect
            addWriteOf=conn.prepareStatement("INSERT INTO STORAGE.WRITEOF (PRECENCE, LEN, TYPEWRITEOF, COMMENT) VALUES (?, ?, ?, ?)");
            //reAdd roll
            updateWriteOfPrecence= conn.prepareStatement("UPDATE STORAGE.WRITEOF SET PRECENCE=? WHERE ID=?");
            deleteWriteOfPrecence= conn.prepareStatement("DELETE FROM STORAGE.WRITEOF WHERE id=?");
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
            addPrecence.close();
            getIDMat.close();
            sreachPrecence.close();
            sreachPrecenceIf.close();
            getLength.close();
            updateLength.close();
            addMat.close();
            insertWriteOf.close();
            getWriteOf.close();
            updateWriteOf.close();
            addWriteOf.close();
            updateWriteOfPrecence.close();
            deleteWriteOfPrecence.close();
            loadAllLogins.close();
            loadAccountByLogin.close();
            loadRolesById.close();
            getIdAccountRoles.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<Role> getAllRoles(){
        rs = null;
        List<Role> result = new LinkedList<Role>();
        try {
            rs = loadAllRoles.executeQuery();
            while (rs.next()){
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
    public List<Account> getAllLogins(){
        rs = null;
        List<Account> result = new LinkedList<Account>();
        try {
            rs = loadAllLogins.executeQuery();

            while (rs.next()){
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

    public Account getAccountByLogin(String login){
        rs = null;
        // SELECT * FROM account WHERE login = ?
        Account result = new Account();
        try {
            loadAccountByLogin.setNString(1, login);
            rs = loadAccountByLogin.executeQuery();

            while (rs.next()){
                result.setId(rs.getInt("id"));
                result.setUsername(rs.getString("login"));
                result.setPassword(rs.getString("password"));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return result;

    }
    public List<Role> getRolesById(int id){
        rs = null;
        List<Role> result = new LinkedList<Role>();
        try {
            loadRolesById.setInt(1, id);
            rs = loadRolesById.executeQuery();

            while (rs.next()){
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

            while (rs.next()){
                idAccountRoles.add(rs.getInt("id_role"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idAccountRoles;
    }
    public Integer getIdMat(String codeName, int sizeRoll)throws SQLException{
        rs = null;
        int id=0;
        try {
            getIDMat.setString(1, codeName);
            getIDMat.setInt(2, sizeRoll);
            rs = getIDMat.executeQuery();
            while (rs.next()){
                id=rs.getInt("id");
            }
        } catch (SQLException e) {
            throw new SQLException("SQL exception");
        }
        return id;
    }
   public void addPrecence(Precence precence)throws SQLException{
       try {
           addPrecence.setInt(1,precence.getName());
           addPrecence.setInt(2,precence.getLen());
           addPrecence.executeUpdate();
       }catch (SQLException e) {
           throw new SQLException("SQL exception");
       }
   }
    public List<Precence> getPrecence(String codeName,int sizeRol, int stat)throws SQLException{
        rs = null;
        List<Precence> prec=new ArrayList<Precence>();
        try {
            sreachPrecence.setString(1,codeName);
            sreachPrecence.setInt(2,sizeRol);
            sreachPrecence.setInt(3,stat);
            rs=sreachPrecence.executeQuery();
            while (rs.next()){
                Precence p=new Precence();
                p.setId(rs.getInt("ID"));
                p.setLen(rs.getInt("LEN"));
                p.setName(rs.getInt("NAME"));
                p.setStat(rs.getInt("STAT"));
                prec.add(p);
            }
        }catch (SQLException e) {
            throw new SQLException("SQL exception");
        }
        return prec;
    }
    public List<Precence> getPrecenceIf(String codeName,int sizeRol, int stat)throws SQLException{
        rs = null;
        List<Precence> prec1=new ArrayList<Precence>();
        try {
            sreachPrecenceIf.setString(1,codeName);
            sreachPrecenceIf.setInt(2,sizeRol);
            sreachPrecenceIf.setInt(3,stat);
            rs=sreachPrecenceIf.executeQuery();
            while (rs.next()){
                Precence p=new Precence();
                p.setId(rs.getInt("ID"));
                p.setLen(rs.getInt("LEN"));
                p.setName(rs.getInt("NAME"));
                p.setStat(rs.getInt("STAT"));
                prec1.add(p);
            }
        }catch (SQLException e) {
            throw new SQLException("SQL exception");
        }
        return prec1;
    }
    public Integer getLen(int id)throws SQLException{
        rs = null;
        int len=0;
        try {
            getLength.setInt(1, id);
            rs = getLength.executeQuery();
            while (rs.next()){
                len=rs.getInt("LEN");
            }
        } catch (SQLException e) {
            throw new SQLException("SQL exception");
        }
        return len;
    }
    public void updateLen(int len, int id)throws SQLException{
        try {
            updateLength.setInt(1, len);
            updateLength.setInt(2, id);
            updateLength.executeUpdate();
        }catch (SQLException e) {
            throw new SQLException("SQL exception");
        }
    }
        public void setWriteOf (int prec, int len, String comment)throws SQLException{
            try {
                insertWriteOf.setInt(1, prec);
                insertWriteOf.setInt(2, len);
                insertWriteOf.setString(3,comment);
                insertWriteOf.executeUpdate();
            }catch (SQLException e) {
                throw new SQLException("SQL exception");
            }
    }
    public Integer getWriteOf()throws SQLException{
        int id=0;
        try {
        rs = getWriteOf.executeQuery();
            while (rs.next()){
                id=rs.getInt("ID");
            }
        }catch (SQLException e) {
            throw new SQLException("SQL exception");
        }
        return id;
    }
    public void updateWriteOf(int type, int id)throws SQLException{
        try {
            updateWriteOf.setInt(1, type);
            updateWriteOf.setInt(2, id);
            updateWriteOf.executeUpdate();
        }catch (SQLException e) {
            throw new SQLException("SQL exception");
        }
    }
    public void addWriteOf(WriteOff writeOf)throws SQLException{
        try {
        addWriteOf.setInt(1, writeOf.getPrecence());
            addWriteOf.setInt(2, writeOf.getLen());
            addWriteOf.setInt(3, writeOf.getTypeWriteOf());
            addWriteOf.setString(4, writeOf.getComment());
            addWriteOf.executeUpdate();
        }catch (SQLException e) {
            throw new SQLException("SQL exception");
        }
    }
public void updateWriteOfPrecence(int prec, int id)throws SQLException{
    try{
        updateWriteOfPrecence.setInt(1,prec);
        updateWriteOfPrecence.setInt(2, id);
        updateWriteOfPrecence.executeUpdate();
    }catch (SQLException e) {
        throw new SQLException("SQL exception");
    }
    }
    public void deleteWriteOf(int id) throws SQLException{
        try{
            deleteWriteOfPrecence.setInt(1,id);
            deleteWriteOfPrecence.execute();
        }catch (SQLException e) {
            throw new SQLException("SQL exception");
        }
    }
}
