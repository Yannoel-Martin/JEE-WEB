package utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class RequestBuilder {

    /**
     * Builds a select request
     *
     * @param tableName
     * @param post
     * @return request
     */
    public static String select(final String tableName, String post) {
        if (post == null) {
            post = "";
        }

        return String.format("SELECT * FROM %s %s", tableName, post);
    }

    /**
     * Builds an insert request.
     *
     * @param tableName
     * @param attr
     * @return request
     */
    public static String insert(final String tableName, final String[] attr) {

        String fields = "", values = "";
        final String separator = ", ";

        for (int i = 0; i < attr.length; i ++) {

            fields += attr[i];
            values += "?";

            if (i != attr.length - 1) {
                fields += separator;
                values += separator;
            }
        }

        return String.format("INSERT INTO %s(%s) VALUES(%s)", tableName, fields, values);
    }
}
