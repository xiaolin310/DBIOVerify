package verifydb;

import java.sql.*;
import java.util.UUID;

public final class Main {
    private static final String dbHostKey = "DB_HOST";
    private static final String dbPortKey = "DB_PORT";
    private static final String userKey = "DB_CONN_USER";
    private static final String passKey = "DB_USER_PASS";
    private static final String dbNameKey = "DB_TEST_DATABASE";
    private static final String dbTableNameKey = "DB_TEST_TABLE";
    private static String uuid;

    private static ENVConfig config = new ENVConfig.Builder()
            .setDBHost(dbHostKey)
            .setPort(dbPortKey)
            .setUser(userKey)
            .setPass(passKey)
            .setDBName(dbNameKey)
            .setDBTestTable(dbTableNameKey)
            .build();

    public static void Insert() {
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.getConnection(config);
            stat = conn.createStatement();
            uuid = UUID.randomUUID().toString();
            String sql = String.format("Insert into %s values(null, \"%s\")", config.getDBTestTable(),
                    uuid);
            System.out.println("The Insert sql: " + sql);
            int rows = stat.executeUpdate(sql);
            System.out.println("Affected rows: " + rows);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(conn, stat, rs);
        }
    }

    public static void Select(String uuidStr) {
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.getConnection(config);
            stat = conn.createStatement();
            String sql = String.format("select * from %s where uuid=\"%s\"", config.getDBTestTable(),
                    uuidStr);
            System.out.println("The Select sql: " + sql);
            rs = stat.executeQuery(sql);
            assert rs != null;
            while (rs.next()) {
                int id = rs.getInt("id");
                String uuidRes = rs.getString("uuid");
                System.out.println("fetch the row: " + id + ":" + uuidRes);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(conn, stat, rs);
        }

    }

    public static void main(String[] args) {
        while (true) {
            try {
                Insert();
                Thread.sleep(2000);
                Select(uuid);
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }




}
