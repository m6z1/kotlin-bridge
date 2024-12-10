package bridge.model

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
class BridgeMaker(private val bridgeNumberGenerator: BridgeNumberGenerator) {
    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    fun makeBridge(size: Int): List<String> {
        val bridge: MutableList<String> = mutableListOf()
        repeat(size) {
            val bridgeNumber = bridgeNumberGenerator.generate()
            if (bridgeNumber == 0) {
                bridge.add(BridgeLocation.from(bridgeNumber))
                return@repeat
            }
            bridge.add(BridgeLocation.from(bridgeNumber))
        }

        println(bridge)
        return bridge
    }
}
