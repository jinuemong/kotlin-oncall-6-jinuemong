package oncall.domain.model

enum class Holiday(
    private val month: Int,
    private val day: Int,
    message: String,
) {
    THEOCRACY(1, 1, "신정"),
    INDEPENDENCE(3, 1, "삼일절"),
    CHILDREN(5, 5, "어린이날"),
    MEMORIAL(6, 6, "현충일"),
    LIBERATION(8, 15, "광복절"),
    NATIONAL(10, 3, "개천절"),
    HANGUL(10, 9, "한글날"),
    CHRISTMAS(12, 25, "성탄절");

    companion object {

        fun checkIsHoliday(month: Int, day: Int): Boolean {
            return entries.find { it.month == month && it.day == day } != null
        }
    }

}