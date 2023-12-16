package oncall.domain.model

enum class DutyDay(
    private val date: String
) {
    MONDAY("월"),
    TUESDAY("화"),
    WEDNESDAY("수"),
    THURSDAY("목"),
    FRIDAY("금"),
    SATURDAY("토"),
    SUNDAY("일");

    companion object {

        fun getDutyDayFromDate(date:String): DutyDay{
            return entries.find { it.date == date }
                ?: throw IllegalArgumentException() // 여기에 에러 메시지 추가
        }
    }

}