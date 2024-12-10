package bridge.view

import camp.nextstep.edu.missionutils.Console

class InputView {

    fun readBridgeSize(): Int {
        println("다리 건너기 게임을 시작합니다.")
        println()
        println("다리의 길이를 입력해주세요.")
        val readLine = Console.readLine()
        val bridgeSize = readLine.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] 다리 길이는 숫자만 입력할 수 있습니다.")
        require(bridgeSize in 3..20) { "[ERROR] 다리 길이는 3 이상 20 이하로만 만들 수 있습니다." }
        return bridgeSize
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        println()
        println("이동할 칸을 선택해주세요. (위: U, 아래: D)")
        val moving = Console.readLine()
        require(moving == "U" || moving == "D") { "[ERROR] 이동할 칸은 U(위 칸) / D(아래 칸) 만 입력할 수 있습니다." }
        return moving
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        println()
        println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)")
        val retryCommand = Console.readLine()
        require(retryCommand == "R" || retryCommand == "Q") { "[ERROR] 재시작 여부는 R(재시작) / Q(종료) 만 입력할 수 있습니다." }
        return retryCommand
    }
}
