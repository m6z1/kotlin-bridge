package bridge.model

enum class BridgePassResult(val content: String) {
    PASS("O"),
    NOT_PASS(" "),
    CANT_PASS("X"),
}