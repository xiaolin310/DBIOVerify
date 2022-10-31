package verifydb;


import java.sql.*;

public class DBConnection {

    private static final String dbClassName = "org.mariadb.jdbc.Driver";
//    private static final String connStr = "jdbc:mariadb://localhost:3306/emotherearth";

    public static Connection getConnection(ENVConfig config) {

        String connStr = String.format("jdbc:mariadb://%s:%d/%s", config.getDBHost(),
                                        config.getPort(), config.getDBName());
        try {
            Class.forName(dbClassName);
            Connection conn = DriverManager.getConnection(
                    connStr,
                    config.getUser(),
                    config.getPass()
            );
            return conn;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void close(Connection conn, Statement stat, ResultSet rs) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                conn = null;
            }
            if (stat != null) {
                try {
                    stat.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    stat = null;
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    rs = null;
                }
            }
        }
    }

}
