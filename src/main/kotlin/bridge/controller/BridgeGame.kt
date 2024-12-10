package bridge.controller

import bridge.model.BridgeLocation
import bridge.model.BridgePassResult

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame {
    private val _bridge = mutableListOf<String>()
    val bridge get() = _bridge.toList()

    private val _gameResultUp = mutableListOf<BridgePassResult>()
    val gameResultUp get() = _gameResultUp.toList()
    private val _gameResultDown = mutableListOf<BridgePassResult>()
    val gameResultDown get() = _gameResultDown.toList()

    var retryCount = 1
        private set

    fun updateBridge(bridge: List<String>) {
        _bridge.clear()
        _bridge.addAll(bridge)
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
                _gameResultUp.add(BridgePassResult.PASS)
                _gameResultDown.add(BridgePassResult.NOT_PASS)
            }

            BridgeLocation.DOWN -> {
                _gameResultDown.add(BridgePassResult.PASS)
                _gameResultUp.add(BridgePassResult.NOT_PASS)
            }
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     *
     *
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun cantMove(location: String) {
        when (BridgeLocation.fromCode(location)) {
            BridgeLocation.UP -> {
                _gameResultUp.add(BridgePassResult.CANT_PASS)
                _gameResultDown.add(BridgePassResult.NOT_PASS)
            }

            BridgeLocation.DOWN -> {
                _gameResultDown.add(BridgePassResult.CANT_PASS)
                _gameResultUp.add(BridgePassResult.NOT_PASS)
            }
        }
    }

    fun restart() {
        _gameResultUp.clear()
        _gameResultDown.clear()
        retryCount++
    }
}
