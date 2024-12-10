package bridge.model

enum class BridgeLocation(private val title: String, private val code: String, private val number: Int) {
    UP("위 칸", "U", 1),
    DOWN("아래 칸", "D", 0);

    companion object {

        fun from(number: Int): String {
            return BridgeLocation.entries.find {
                it.number == number
            }?.code ?: throw IllegalArgumentException("[ERROR] 없는 숫자입니다.")
        }

        fun fromCode(code: String): BridgeLocation {
            return BridgeLocation.entries.find {
                it.code == code
            } ?: throw IllegalArgumentException("[ERROR] 없는 코드입니다.")
        }
    }
}