package bridge.view

import bridge.model.BridgePassResult

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
class OutputView {
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printMap(
        upBridge: List<BridgePassResult>,
        downBridge: List<BridgePassResult>,
    ) {
        printUpBridge(upBridge)
        println()
        printDownBridge(downBridge)
        println()
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult(
        upBridge: List<BridgePassResult>,
        downBridge: List<BridgePassResult>,
        retryCount: Int,
    ) {
        println("최종 게임 결과")
        printUpBridge(upBridge)
        println()
        printDownBridge(downBridge)
        println()
        val result = (upBridge + downBridge).any { it.content == BridgePassResult.CANT_PASS.content }
        if (result) {
            println("게임 성공 여부: 실패")
            println("총 시도한 횟수: $retryCount")
            return
        }
        println("게임 성공 여부: 성공")
        println("총 시도한 횟수: $retryCount")
    }

    private fun printUpBridge(
        upBridge: List<BridgePassResult>,
    ) {
        print("[")
        upBridge.forEachIndexed { index, bridgePassResult ->
            print(" ${bridgePassResult.content} ")
            if (index < upBridge.size - 1) {
                print("|")
            }
        }
        print("]")
    }

    private fun printDownBridge(
        downBridge: List<BridgePassResult>,
    ) {
        print("[")
        downBridge.forEachIndexed { index, bridgePassResult ->
            print(" ${bridgePassResult.content} ")
            if (index < downBridge.size - 1) {
                print("|")
            }
        }
        print("]")
    }
}
