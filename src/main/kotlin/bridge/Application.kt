package bridge

import bridge.controller.BridgeGame
import bridge.model.BridgeMaker
import bridge.model.BridgeRandomNumberGenerator
import bridge.view.InputView
import bridge.view.OutputView

fun main() {
    val inputView = InputView()
    val outputView = OutputView()
    val bridgeRandomNumberGenerator = BridgeRandomNumberGenerator()
    val bridgeMaker = BridgeMaker(bridgeRandomNumberGenerator)
    val bridgeGame = BridgeGame(inputView, outputView, bridgeMaker)
    bridgeGame.start()
}
