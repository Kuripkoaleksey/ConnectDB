import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/idea", "root", "Skorost15");

            System.out.println("Success connect");
            Statement statement = connection.createStatement();
            System.out.println("Connect to database");

// 1. �������� �������
            String createQuery = """
                    create table Person (
                    	id int primary key auto_increment,
                        name varchar(20),
                        surname varchar(20),
                        age int
                    );
                    """;
            statement.executeUpdate(createQuery);
            System.out.println("������� Person �������");

// 2. �������� � ���������� �����
            String insertQuery = """
                    insert into person (name, surname, age) values ('Sasha', 'Sashin', 20),
                                                            ('Dima', 'Dimin', 22),
                                                            ('Olya', 'Olina', 15);
                    """;
            statement.executeUpdate(insertQuery);
            System.out.println("� ������� Person ��������� ������");

// 3. ������
            String selectQuery = "select * from person";
            statement.executeQuery(selectQuery);

// 4. ���������� ������ � �������
            String updateQuery = """
                    UPDATE person SET age = 27, surname = 'Filippov'
                    WHERE ((surname = 'Dimin') & (id<=5));
                     """;
            statement.executeUpdate(updateQuery);
            System.out.println("� ������� Person ������� ���������");

//5. �������� �������� � �������
            String deleteQuery = """
                    DELETE FROM person WHERE ((name = 'Sasha') & (id<4));
                    """;
            statement.executeUpdate(deleteQuery);
            System.out.println("� ������� Person ������� ������ �������������� �������");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
