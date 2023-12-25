package oncall.domain.model

import oncall.domain.utils.Error

enum class DutyDayOfWeek(
    private val info: String
) {

    WEEKDAY("평일"),
    WEEKEND("주말"),
    HOLIDAY("휴일");

    fun getInfo(): String = this.info

    fun isHoliday(): Boolean = this == HOLIDAY

    companion object {

        fun getDayOfWeekFromDutyDay(
            dutyDay: DutyDay?,
            isHoliday: Boolean
        ): DutyDayOfWeek {

            if (isHoliday) return HOLIDAY

            return when (dutyDay) {
                DutyDay.MONDAY, DutyDay.TUESDAY, DutyDay.WEDNESDAY,
                DutyDay.THURSDAY, DutyDay.FRIDAY -> WEEKDAY

                DutyDay.SATURDAY, DutyDay.SUNDAY -> WEEKEND

                else -> throw IllegalArgumentException(Error.ERR_DUTY_DAT_OF_WEEK)
            }


        }
    }
}