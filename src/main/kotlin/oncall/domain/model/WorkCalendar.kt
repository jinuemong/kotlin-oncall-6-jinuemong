package oncall.domain.model

import oncall.domain.utils.Rule

class WorkCalendar(
    private val day: Int,
    private val dutyDay: DutyDay,
    private val dayOfWeek: DayOfWeek,
) {

    fun getDayOfWeek(): DayOfWeek = dayOfWeek
    fun getMonthDayMessage(): String = "${day}${Rule.DAY_UNIT}"
    fun getDayOfWeekMessage(): String = dutyDay.getDayOfWeek()
    fun getHolidayMessage(): String {
        if (dayOfWeek.isHoliday()) return "(${dayOfWeek.getInfo()})"
        return ""
    }

}