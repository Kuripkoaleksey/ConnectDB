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

// 1. Создание таблицы
            String createQuery = """
                    create table Person (
                    	id int primary key auto_increment,
                        name varchar(20),
                        surname varchar(20),
                        age int
                    );
                    """;
            statement.executeUpdate(createQuery);
            System.out.println("Таблица Person создана");

// 2. Создание и заполнение полей
            String insertQuery = """
                    insert into person (name, surname, age) values ('Sasha', 'Sashin', 20),
                                                            ('Dima', 'Dimin', 22),
                                                            ('Olya', 'Olina', 15);
                    """;
            statement.executeUpdate(insertQuery);
            System.out.println("В таблицу Person добавлены строки");

// 3. Чтение
            String selectQuery = "select * from person";
            statement.executeQuery(selectQuery);

// 4. Обновление данных в таблице
            String updateQuery = """
                    UPDATE person SET age = 27, surname = 'Filippov'
                    WHERE ((surname = 'Dimin') & (id<=5));
                     """;
            statement.executeUpdate(updateQuery);
            System.out.println("В таблицу Person внесены изменения");

//5. Удаление значений в таблице
            String deleteQuery = """
                    DELETE FROM person WHERE ((name = 'Sasha') & (id<4));
                    """;
            statement.executeUpdate(deleteQuery);
            System.out.println("В таблице Person удалена строка соответсвующая запросу");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
