package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class DisplayAuthors {
	// static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private final static String DATABASE_URL = "jdbc:mysql://localhost/books";

	public static void main(String[] args) {
		String sqlStatement = "SELECT authorID, firstname, lastname FROM authors";

		//use java's new try with resources ability.
		// the only code that can go in here are ones that extends from autocloseable
		try (
		// create the connection
		Connection connection = DriverManager.getConnection(DATABASE_URL,
				"deitel", "deitel");

		// associate the statement to the connection
				Statement statement = connection.createStatement();

				// create a query statement to execute on the connection

				ResultSet resultSet = statement.executeQuery(sqlStatement);) {
			// process the result set
			ResultSetMetaData metaData = resultSet.getMetaData();
			int numCol = metaData.getColumnCount();
			System.out.println("Authors Table of Books Database:\n");

			// output the column name from the metadata
			for (int i = 1; i <= numCol; i++) {
				System.out.printf("%-8s\t", metaData.getColumnName(i));

			}
			System.out.println();
			while (resultSet.next()) {
				for (int i = 1; i <= numCol; i++) {
					System.out.printf("%-8s\t", resultSet.getObject(i));
				}
				System.out.println();
			}

		} // catch (ClassNotFoundException exc) {
			// exc.printStackTrace();
		catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
