package oncall.domain.model

import oncall.domain.utils.Rule

class WorkCalendar(
    private val day: Int,
    private val dutyDay: DutyDay,
    private val dutyDayOfWeek: DutyDayOfWeek,
) {

    fun getDayOfWeek(): DutyDayOfWeek = dutyDayOfWeek
    fun getMonthDayMessage(): String = "${day}${Rule.DAY_UNIT}"
    fun getDayOfWeekMessage(): String = dutyDay.getDayOfWeek()
    fun getHolidayMessage(): String {
        if (dutyDayOfWeek.isHoliday()) return "(${dutyDayOfWeek.getInfo()})"
        return ""
    }

}