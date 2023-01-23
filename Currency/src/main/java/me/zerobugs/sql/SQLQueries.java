package me.zerobugs.sql;

public enum SQLQueries {

    CREATE_TABLE("CREATE TABLE IF NOT EXISTS currency("
            + "id UUID PRIMARY KEY,"
            + "value DOUBLE"
            + ")"),

    ADD_OR_UPDATE_VALUE("INSERT INTO currency (id, value) VALUES (?, ?) "
            + "ON CONFLICT (id) DO UPDATE SET value = ?"),
    GET_VALUE("SELECT value FROM currency WHERE id = ?");

    private final String query;

    SQLQueries(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }

    @Override
    public String toString() {
        return this.query;
    }
}

