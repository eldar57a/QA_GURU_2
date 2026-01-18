package newTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestStructure {
    void verify2x3is6test() {
        assertEquals(2 + 3, 6);
    }

    void verify2x3is6test1() {
        //Arrange
        int a = 2;
        int b = 3;
        int expectedResult = 6;
        int actualResult;

        //Act
        actualResult = a * b;

        //Assert
        assertEquals(expectedResult, actualResult);
    }
}
