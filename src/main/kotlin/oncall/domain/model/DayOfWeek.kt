package oncall.domain.model

enum class DayOfWeek(
    private val info: String
) {
    WEEKDAY("평일"),
    WEEKEND("주말"),
    HOLIDAY("휴일");

    fun getInfo(): String = this.info

    companion object {

        fun getDayOfWeekFromDutyDay(
            dutyDay: DutyDay?,
            isHoliday: Boolean
        ): DayOfWeek {

            if (isHoliday) return HOLIDAY

            return when (dutyDay) {
                DutyDay.MONDAY, DutyDay.TUESDAY, DutyDay.WEDNESDAY,
                DutyDay.THURSDAY, DutyDay.FRIDAY -> WEEKDAY

                DutyDay.SATURDAY, DutyDay.SUNDAY -> WEEKEND

                else -> throw IllegalArgumentException() // 예외상황 추가
            }


        }
    }
}