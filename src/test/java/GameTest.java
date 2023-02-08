import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GameTest {

    @Test // Побеждает первый

    public void testRoundThenFirstPlayerStrength() {
        Game game = new Game();
        Player sigurd = new Player(1, "Sigurd", 66);
        Player olaf = new Player(2, "Olaf", 56);

        game.register(sigurd);
        game.register(olaf);

        int actual = game.round("Sigurd", "Olaf");
        int expected = 1;

        Assertions.assertEquals(expected, actual);

    }

    @Test // Побеждает второй

    public void testRoundThenSecondPlayerStrength() {
        Game game = new Game();
        Player sigurd = new Player(1, "Sigurd", 56);
        Player olaf = new Player(2, "Olaf", 66);

        game.register(sigurd);
        game.register(olaf);

        int actual = game.round("Sigurd", "Olaf");
        int expected = 2;

        Assertions.assertEquals(expected, actual);

    }

    @Test // Ничья

    public void testRoundThenSimilarPlayerStrength() {
        Game game = new Game();
        Player sigurd = new Player(1, "Sigurd", 66);
        Player olaf = new Player(2, "Olaf", 66);

        game.register(sigurd);
        game.register(olaf);

        int actual = game.round("Sigurd", "Olaf");
        int expected = 0;

        Assertions.assertEquals(expected, actual);

    }

    @Test // Первый игрок не зарегестрирован

    public void testRoundThenFirstPlayerNotRegistred() {
        Game game = new Game();
        Player sigurd = new Player(1, "Sigurd", 66);
        Player olaf = new Player(2, "Olaf", 56);

        game.register(olaf);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Sigurd", "Olaf")
        );

    }

    @Test // Второй игрок не зарегестрирован

    public void testRoundThenSecondPlayerNotRegistred() {
        Game game = new Game();
        Player sigurd = new Player(1, "Sigurd", 66);
        Player olaf = new Player(2, "Olaf", 56);

        game.register(sigurd);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Sigurd", "Olaf")
        );

    }

    @Test // Без регистрации

    public void testRoundThenPlayersNotRegistred() {
        Game game = new Game();
        Player sigurd = new Player(1, "Sigurd", 66);
        Player olaf = new Player(2, "Olaf", 56);



        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Sigurd", "Olaf")
        );

    }



    }

