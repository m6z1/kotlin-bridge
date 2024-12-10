package bridge.view

import camp.nextstep.edu.missionutils.Console

class InputView {

    fun readBridgeSize(): Int {
        val readLine = Console.readLine()
        val bridgeSize = readLine.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] 다리 길이는 숫자만 입력할 수 있습니다.")
        require(bridgeSize in 3..20) { "[ERROR] 다리 길이는 3 이상 20 이하로만 만들 수 있습니다." }
        return bridgeSize
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        val readLine = Console.readLine()
        require(readLine == "U" || readLine == "D") { "[ERROR] 이동할 칸은 U(위 칸) / D(아래 칸) 만 입력할 수 있습니다." }
        return readLine
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        return ""
    }
}
