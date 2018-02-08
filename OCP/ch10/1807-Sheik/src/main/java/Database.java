import java.sql.*;

public class Database {

    private String url = "jdbc:derby:apollo;";

    public Database() {
        String url = this.url + "create=true";

        try (Connection connection = DriverManager.getConnection(url);
             Statement statement = connection.createStatement()) {

            statement.executeUpdate("DROP TABLE apollo");

            statement.executeUpdate("CREATE TABLE apollo ("
                                        + "id INTEGER PRIMARY KEY, "
                                        + "name VARCHAR(24) NOT NULL)");

            statement.executeUpdate("INSERT INTO apollo VALUES (1, 'Sheik')");
            statement.executeUpdate("INSERT INTO apollo VALUES (2, 'Xander')");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insert(String query) {

    }

    public void select(String input) {
        String query = "SELECT * FROM apollo WHERE name = '" + input + "'";
//        String query = "SELECT * FROM apollo";

        try (Connection connection = DriverManager.getConnection(url);
             Statement statement = connection.createStatement()) {

            ResultSet result = statement.executeQuery(query);

            while (result.next()) {
                System.out.println(result.getString("name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
