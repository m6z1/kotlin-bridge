package bridge.controller

import bridge.model.BridgeLocation
import bridge.model.BridgeMaker
import bridge.model.BridgePassResult
import bridge.model.GameRestartOrNot
import bridge.view.InputView
import bridge.view.OutputView

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame(
    private val inputView: InputView,
    private val outputView: OutputView,
    private val bridgeMaker: BridgeMaker,
) {
    private val bridge = mutableListOf<String>()
    private val gameResultUp = mutableListOf<BridgePassResult>()
    private val gameResultDown = mutableListOf<BridgePassResult>()

    fun start() {
        val bridgeSize = inputView.readBridgeSize()
        bridge.addAll(bridgeMaker.makeBridge(bridgeSize))
        bridge.forEach { oneSpace ->
            val playerLocation = inputView.readMoving()
            if (oneSpace == playerLocation) {
                move(playerLocation)
                return@forEach
            }
            retry(playerLocation)
        }
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     *
     *
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun move(location: String) {
        when (BridgeLocation.fromCode(location)) {
            BridgeLocation.UP -> {
                gameResultUp.add(BridgePassResult.PASS)
                gameResultDown.add(BridgePassResult.NOT_PASS)
            }

            BridgeLocation.DOWN -> {
                gameResultDown.add(BridgePassResult.PASS)
                gameResultUp.add(BridgePassResult.NOT_PASS)
            }
        }
        outputView.printMap(upBridge = gameResultUp, downBridge = gameResultDown)
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     *
     *
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun retry(location: String) {
        when (BridgeLocation.fromCode(location)) {
            BridgeLocation.UP -> {
                gameResultUp.add(BridgePassResult.CANT_PASS)
                gameResultDown.add(BridgePassResult.NOT_PASS)
            }

            BridgeLocation.DOWN -> {
                gameResultDown.add(BridgePassResult.CANT_PASS)
                gameResultUp.add(BridgePassResult.NOT_PASS)
            }
        }

        outputView.printMap(upBridge = gameResultUp, downBridge = gameResultDown)

        val retry = inputView.readGameCommand()
        when (GameRestartOrNot.from(retry)) {
            GameRestartOrNot.RETRY -> restart()
            GameRestartOrNot.QUIT -> return
        }
    }

    private fun restart() {
        gameResultUp.clear()
        gameResultDown.clear()
    }
}
