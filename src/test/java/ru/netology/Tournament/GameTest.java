package ru.netology.Tournament;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    public void testFirstPlayerIsStrength() {

        Game game = new Game();
        Player vasy = new Player(1, "Вася", 100);
        Player fedy = new Player(2, "Федя", 80);
        game.register("Vasy",vasy);
        game.register("Fedy",fedy);
        int actual = game.round("Вася", "Федя");
        int expected = 1;
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testSecondPlayerIsStrength() {

        Game game = new Game();
        Player vasy = new Player(1, "Вася", 100);
        Player fedy = new Player(2, "Федя", 200);
        game.register("Vasa",vasy);
        game.register("Fedy",fedy);
        int actual = game.round("Вася", "Федя");
        int expected = 2;
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testFirstDrawSecondIsStrength() {

        Game game = new Game();
        Player vasy = new Player(1, "Вася", 100);
        Player fedy = new Player(2, "Федя", 100);
        game.register("Vasa",vasy);
        game.register("Fedy",fedy);
        int actual = game.round("Вася", "Федя");
        int expected = 0;
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldNotRegisterPlayer1() {
        Game game = new Game();
        Player vasy = new Player(1, "Вася", 100);
        Player fedy = new Player(2, "Федя", 100);
        game.register("Vasa",vasy);
        game.register("Fedy",fedy);
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Дима", "Вася");


        });
    }

    @Test
    public void shouldNotRegisterPlayer2() {
        Game game = new Game();
        Player vasy = new Player(1, "Вася", 200);
        Player fedy = new Player(2, "Федя", 100);
        game.register("Vasy",vasy);
        game.register("Fedy",fedy);
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Вася", "Дима");


        });
    }

    @Test
    public void shouldNotRegisterPlayers() {
        Game game = new Game();
        Player vasy = new Player(1, "Вася", 200);
        Player fedy = new Player(2, "Федя", 100);
        game.register("Vasy",vasy);
        game.register("Fedy",fedy);
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Дима", "Леон");


        });
    }

}