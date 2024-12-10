package bridge

import bridge.controller.BridgeGame
import bridge.view.InputView
import bridge.view.OutputView

fun main() {
    val inputView = InputView()
    val outputView = OutputView()
    val bridgeGame = BridgeGame(inputView, outputView)
    bridgeGame.start()
}
