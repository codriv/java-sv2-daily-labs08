package day04.withcomposition;

public class TableMain {

    public static void main(String[] args) {
        Filter filter = new Filter(
                new Table("football.dat"), new Skip(1, 0, "-------"),
                new Parse(new Position(4, 2), new Position(8, 16),
                        new Position(44, 2), new Position(51, 2))
        );

        System.out.println(filter.getNameOfMinDiff());

        Filter filter2 = new Filter(new Table("weather.dat"),
                new Skip(2, 1),
                new Parse(new Position(3, 2), new Position(7, 2), new Position(13, 2))
        );

        System.out.println(filter2.getIndexOfMinDiff());

        Filter filter3 = new Filter(
                new Table("football_2.dat"),
                new Skip(
                        2, 2, "----------", 8, 18),
                new Parse(
                        new Position(4, 2), new Position(8, 16),
                        new Position(44, 2), new Position(51, 2)
                )
            );

        System.out.println(filter3.getNameOfMinDiff());
    }
}