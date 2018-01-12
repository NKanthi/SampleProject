import java.sql.*;
import java.util.Map;
import java.util.TreeMap;

public class Database {

    private Database(){}

    private  static Database instance;

    public static synchronized Database getInstance() {
        if(instance == null){
            instance = new Database();
        }
        return instance;
    }

    private void setupDataBase() throws SQLException {
        String url = "jdbc:derby:zoo";
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                                                    ResultSet.CONCUR_UPDATABLE)) {

            stmt.executeUpdate("DROP TABLE animal");
            stmt.executeUpdate("DROP TABLE species");

            stmt.executeUpdate("CREATE TABLE species ("
                    + "id INTEGER PRIMARY KEY, "
                    + "name VARCHAR(255), "
                    + "num_acres DECIMAL(4,1))");

            stmt.executeUpdate("CREATE TABLE animal ("
                    + "id INTEGER PRIMARY KEY, "
                    + "species_id integer REFERENCES species (id), "
                    + "name VARCHAR(255), "
                    + "age INTEGER)");

            stmt.executeUpdate("INSERT INTO species VALUES " +
                                        "(1, 'African Elephant', 7.5), " +
                                        "(2, 'Zebra', 1.2) ");

            stmt.executeUpdate("INSERT INTO animal VALUES (1, 1, 'Elsa', 2), " +
                                        "(2, 2, 'Zelda', 3), " +
                                        "(3, 1, 'Ester', 4)," +
                                        "(4, 1, 'Eddie', 1)," +
                                        "(5, 2, 'Zoe', 10)");


        }
    }

    public Map<Integer, Integer> getAnimalAge() throws SQLException{
        Map<Integer, Integer> ageMap = new TreeMap<>();
        setupDataBase();

        String url = "jdbc:derby:zoo";
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                     ResultSet.CONCUR_READ_ONLY)) {

            ResultSet resultSet = stmt.executeQuery("SELECT id, age FROM animal");

            while(resultSet.next()){
                ageMap.put(resultSet.getInt("id"), resultSet.getInt("age"));
            }
        }
        return ageMap;
    }

}
