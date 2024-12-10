package bridge.model

enum class GameRestartOrNot(private val code: String) {
    RETRY("R"),
    QUIT("Q");

    companion object {

        fun from(code: String): GameRestartOrNot {
            return GameRestartOrNot.entries.find {
                it.code == code
            } ?: throw IllegalArgumentException("[ERROR] 알 수 없는 입력입니다.")
        }
    }
}