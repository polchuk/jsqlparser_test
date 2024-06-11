package org.tools;

import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.statement.select.PlainSelect;

public class Main {

    public static void main(String[] args) throws JSQLParserException {

        var query = """
            SELECT dst_qs_period, dst_metric_id, 'WHERE' as literal 
            FROM mkt_dwh.qs_dynamic_score_targets 
            WHERE dst_qs_period LIKE CONCAT('%', CONCAT('2024-01-01', '2024-03-31'))
            """;

        PlainSelect select = (PlainSelect) CCJSqlParserUtil.parse(query);

        // dst_qs_period LIKE CONCAT('%', CONCAT('2024-01-01', '2024-03-31'))
        System.out.println(select.getWhere().toString());

    }

}