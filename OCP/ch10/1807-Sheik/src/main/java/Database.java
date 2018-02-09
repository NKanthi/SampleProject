import java.sql.*;

public class Database {
    private String url = "jdbc:derby:apollo;";

    Database() {
        dropTable();
        createTable();
        populateTable();
    }

    private void dropTable() {
        try (Connection connection = DriverManager.getConnection(url);
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("DROP TABLE apollo");
        } catch (SQLException ignored) {
        }
    }

    private void createTable() {
        String url = this.url + "create=true";

        try (Connection connection = DriverManager.getConnection(url);
             Statement statement = connection.createStatement()) {

            statement.executeUpdate("CREATE TABLE apollo ("
                    + "id INTEGER GENERATED ALWAYS AS IDENTITY "
                    + "(START WITH 1, INCREMENT BY 1) PRIMARY KEY,"
                    + "name VARCHAR(24) NOT NULL)");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void populateTable() {
        String url = this.url + "create=true";

        try (Connection connection = DriverManager.getConnection(url);
             Statement statement = connection.createStatement()) {

            statement.executeUpdate("INSERT INTO apollo(name) VALUES ('Sheik'), ('Xander')");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insert(String input) {
        String query = "INSERT INTO apollo(name) VALUES ('" + input + "')";

        try (Connection connection = DriverManager.getConnection(url);
             Statement statement = connection.createStatement()) {

            statement.executeUpdate(query);
            System.out.println("Update succesfull.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void select(String input) {
        String query = "SELECT * FROM apollo WHERE name = '" + input + "'";

        try (Connection connection = DriverManager.getConnection(url);
             Statement statement = connection.createStatement()) {

            ResultSet result = statement.executeQuery(query);

            while (result.next()) {
                System.out.println("ID: " + result.getString("id"));
                System.out.println("Name: " + result.getString("name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void selectAll() {
        String query = "SELECT * FROM apollo";

        try (Connection connection = DriverManager.getConnection(url);
             Statement statement = connection.createStatement()) {

            ResultSet result = statement.executeQuery(query);

            while (result.next()) {
                System.out.println("ID: " + result.getString("id"));
                System.out.println("Name: " + result.getString("name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
