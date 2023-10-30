package racingcar;

import domain.Car;
import domain.Cars;
import domain.RaceResult;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CarTest {

    @Test
    void 자동차를_전진시키는_기능_테스트() {
        //given
        String userInput = "yoon,su";
        String[] carNames = userInput.split(",");
        Cars cars = new Cars(carNames);

        List<Car> getCars = cars.getCars();
        Car yoonCar = getCars.get(0);

        //when
        Car moveCar = yoonCar.moveAhead();

        //then
        Assertions.assertThat(moveCar.getProgress()).isEqualTo(1);
    }

    @Test
    void 실행_결과를_생성하는_기능_테스트() {
        //given
        String userInput = "yoon,su";
        String[] carNames = userInput.split(",");
        Cars cars = new Cars(carNames);
        List<Car> getCars = cars.getCars();
        Car yoonCar = getCars.get(0);
        Car moveCar = yoonCar.moveAhead();

        //when
        RaceResult raceResult = yoonCar.generateResult(moveCar);

        //then
        Assertions.assertThat(raceResult.name()).isEqualTo("yoon");
        Assertions.assertThat(raceResult.progress()).isEqualTo(1);
    }
}
