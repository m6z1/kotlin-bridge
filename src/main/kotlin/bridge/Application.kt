package bridge

import bridge.controller.BridgeGame
import bridge.model.BridgeMaker
import bridge.model.BridgeRandomNumberGenerator
import bridge.model.GameRestartOrNot
import bridge.view.InputView
import bridge.view.OutputView

fun main() {
    val inputView = InputView()
    val outputView = OutputView()
    val bridgeRandomNumberGenerator = BridgeRandomNumberGenerator()
    val bridgeMaker = BridgeMaker(bridgeRandomNumberGenerator)
    val bridgeGame = BridgeGame()

    val bridgeSize = inputView.readBridgeSize()
    val bridge = bridgeMaker.makeBridge(bridgeSize)
    bridgeGame.updateBridge(bridge)

    if (runBridgeGame(bridgeGame, inputView, outputView)) return
}

private fun runBridgeGame(
    bridgeGame: BridgeGame,
    inputView: InputView,
    outputView: OutputView,
): Boolean {
    bridgeGame.bridge.forEach { oneSpace ->
        val playerLocation = inputView.readMoving()
        if (oneSpace == playerLocation) {
            bridgeGame.move(playerLocation)
            outputView.printMap(bridgeGame.gameResultUp, bridgeGame.gameResultDown)
            return@forEach
        }
        bridgeGame.cantMove(playerLocation)
        outputView.printMap(bridgeGame.gameResultUp, bridgeGame.gameResultDown)

        return retry(inputView, outputView, bridgeGame)
    }
    return false
}

private fun retry(inputView: InputView, outputView: OutputView, bridgeGame: BridgeGame): Boolean {
    val retry = inputView.readGameCommand()
    when (GameRestartOrNot.from(retry)) {
        GameRestartOrNot.RETRY -> bridgeGame.restart()
        GameRestartOrNot.QUIT -> return true
    }
    return runBridgeGame(bridgeGame, inputView, outputView)
}
