package ru.netology;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GameManagerTest {
    GameManager manager = new GameManager();
    PlayerData playerOne = new PlayerData(1, "Хабиб", 1000);
    PlayerData playerTwo = new PlayerData(2, "Макгрегор", 100);
    PlayerData playerThree = new PlayerData(3, "Тайсон", 100);

    @BeforeEach
    void setup() {
        manager.register(playerOne);
        manager.register(playerTwo);
        manager.register(playerThree);
    }

    @Test
    void shouldPlayerOneWin() {
        assertEquals(1, manager.round("Хабиб", "Макгрегор"));
    }

    @Test
    void shouldPlayerTwoWin() {
        assertEquals(2, manager.round("Тайсон", "Хабиб"));
    }

    @Test
    void shouldDraw() {
        assertEquals(0, manager.round("Тайсон", "Макгрегор"));
    }

    @Test
    void NoRegisteredOne() {
        assertThrows(NotRegisteredException.class, () -> {
            manager.round("Тайсон", "Холифилд");
        });
    }

    @Test
    void NoRegisteredTwo() {
        assertThrows(NotRegisteredException.class, () -> {
            manager.round("Холифилд", "Тайсон");
        });
    }
}