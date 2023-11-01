package racingcar.view;

import camp.nextstep.edu.missionutils.test.NsTest;
import domain.Car;
import domain.Cars;
import domain.RaceResult;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import view.OutputView;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;

public class OutputViewTest extends NsTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    private Cars cars;
    private Car yoonCar;
    private Car suCar;

    @BeforeEach
    void setUp(TestInfo testInfo) {
        if(testInfo.getDisplayName().contains("문구")) {
            return ;
        }

        String[] carNames = {"yoon", "su"};
        cars = new Cars(carNames);
        yoonCar = cars.getCars().get(0);
        suCar = cars.getCars().get(1);
    }

    @Test
    void 자동차_이름_입력_문구를_출력하는_기능_테스트() {
        assertSimpleTest(() -> {
            //when
            OutputView.printGetCarName();

            //then
            Assertions.assertThat(output()).contains("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        });
    }

    @Test
    void 경주_시도_횟수_입력_문구를_출력하는_기능_테스트() {
        assertSimpleTest(() -> {
            //when
            OutputView.printGetTryCount();

            //then
            Assertions.assertThat(output()).contains("시도할 회수는 몇회인가요?");
        });
    }

    @Test
    void 자동차_경주_실행_결과_도입부_문구를_출력하는_기능_테스트() {
        assertSimpleTest(() -> {
            //when
            OutputView.printRaceResultIntroduction();

            //then
            Assertions.assertThat(output()).contains("실행 결과");
        });
    }

    @Test
    void 자동차_경주_실행_결과를_출력하는_기능_테스트() {
        assertRandomNumberInRangeTest(() -> {
            //when
            cars.moveAheadCars();
            cars.moveAheadCars();
            RaceResult yoonRaceResult = yoonCar.generateResult();
            RaceResult suRaceResult = suCar.generateResult();

            OutputView.printRaceResult(yoonRaceResult);
            OutputView.printRaceResult(suRaceResult);

            //then
            Assertions.assertThat(output()).contains("yoon : --", "su : -");
            },
            MOVING_FORWARD, STOP,
            MOVING_FORWARD, MOVING_FORWARD
        );
    }


    @Override
    protected void runMain() {

    }
}
