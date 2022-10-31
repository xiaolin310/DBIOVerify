package verifydb;

import org.apache.commons.lang3.StringUtils;

public class ENVConfig {
    private String DBHost;
    private int port;
    private String user;
    private String pass;
    private String DBName;
    private String DBTestTable;

    private ENVConfig(Builder builder) {
        this.DBHost = builder.DBHost;
        this.port = builder.port;
        this.user = builder.user;
        this.pass = builder.pass;
        this.DBName = builder.DBName;
        this.DBTestTable = builder.DBTestTable;
    }

    public String getDBHost() {
        return this.DBHost;
    }

    public int getPort() {
        return this.port;
    }

    public String getUser() {
        return this.user;
    }

    public String getPass() {
        return this.pass;
    }

    public String getDBName() {
        return this.DBName;
    }

    public String getDBTestTable() {
        return this.DBTestTable;
    }

    public static class Builder {
        private static final String DEFAULT_DB_HOST = "localhost";
        private static final int DEFAULT_DB_PORT = 3306;
        private static final String DEFAULT_CONN_USER = "mono";
        private static final String DEFAULT_CONN_PASS = "mono123";
        private static final String DEFAULT_DB_NAME = "test_db";
        private static final String DEFAULT_DB_TEST_TABLE = "t1";

        private String DBHost = DEFAULT_DB_HOST;
        private int port = DEFAULT_DB_PORT;
        private String user = DEFAULT_CONN_USER;
        private String pass = DEFAULT_CONN_PASS;
        private String DBName = DEFAULT_DB_NAME;
        private String DBTestTable = DEFAULT_DB_TEST_TABLE;


        public ENVConfig build() {
            return new ENVConfig(this);
        }

        public Builder setDBHost(String dbHostKey) {
            String dbHostVal = System.getenv(dbHostKey);
            if (StringUtils.isBlank(dbHostVal)) {
                System.out.println(String.format("Use default DEFAULT_DB_HOST=%s", this.DBHost));
            } else {
                this.DBHost = dbHostVal;
            }
            return this;
        }

        public Builder setPort(String dbPortKey) {
            String portVal = System.getenv(dbPortKey);
            if (StringUtils.isBlank(portVal)) {
                System.out.println(String.format("Use default DEFAULT_DB_PORT=%d", this.port));
            } else {
                this.port = Integer.parseInt(portVal);
            }
            return this;
        }

        public Builder setUser(String userKey) {
            String userVal = System.getenv(userKey);
            if (StringUtils.isBlank(userVal)) {
                System.out.println(String.format("Use default DEFAULT_CONN_USER=%s", this.user));
            } else {
                this.user = userVal;
            }
            return this;
        }

        public Builder setPass(String passKey) {
            String passVal = System.getenv(passKey);
            if (StringUtils.isBlank(passVal)) {
                System.out.println(String.format("Use default DEFAULT_CONN_PASS=%s", this.pass));
            } else {
                this.pass = passVal;
            }
            return this;
        }

        public Builder setDBName(String dbNameKey) {
            String dbNameVal = System.getenv(dbNameKey);
            if (StringUtils.isBlank(dbNameVal)) {
                System.out.println(String.format("Use default DEFAULT_DB_NAME=%s", this.DBName));
            } else {
                this.DBName = dbNameVal;
            }
            return this;
        }

        public Builder setDBTestTable(String dbTableKey) {
            String dbTestTableVal = System.getenv(dbTableKey);
            if (StringUtils.isBlank(dbTestTableVal)) {
                System.out.println(String.format("Use default DEFAULT_DB_TEST_TABLE=%s", this.DBTestTable));
            } else {
                this.DBTestTable = dbTestTableVal;
            }
            return this;
        }

    }
}
