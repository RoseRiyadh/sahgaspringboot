package tech.enjaz.rose.sahga.configs.utils;

import org.hibernate.resource.jdbc.spi.StatementInspector;

import java.util.logging.Logger;


public class SqlStatementInspector implements StatementInspector {

    private static final long serialVersionUID = 1L;
    private static final Logger LOG = Logger.getLogger(String.valueOf(SqlStatementInspector.class));

    @Override
    public String inspect(String sql) {
        if (!sql.contains("escape \'\\'")) {
            return sql;
        }
        // OData JPA query correction -> current version (2.0.11) contains
        // the invalid 'escape "\"' statement that delivers no results
        LOG.info("Replacing invalid statement: escape \"\\\"");
        return sql.replace("escape \'\\'", "");
    }
}
