package oncall.domain

import oncall.domain.model.*
import oncall.domain.utils.Rule

class DutyCalendar(
    private val month: Int,
    private val dayOfWeek: String,
    private val workCalendar: MutableList<WorkCalendar> = mutableListOf()
) {

    init {
        makeCalendar()
    }

    fun getDutyCalendar(): List<WorkCalendar> {
        return workCalendar
    }

    fun getCurrentMonth(): Int {
        return month
    }

    private fun makeCalendar() {
        var dutyIdx = DutyDay.getDutyIdx(dayOfWeek)
        repeat(DutyMonth.getMaxDayFromMonth(month)) { idx ->
            workCalendar.add(makeNewCalendar(idx + 1, dutyIdx % Rule.WEEK_LENGTH))
            dutyIdx += 1
        }
    }

    private fun makeNewCalendar(
        day: Int,
        idx: Int
    ): WorkCalendar {
        val dutyDay = DutyDay.getDutyDayFromIdx(idx)
        val isHoliday = Holiday.checkIsHoliday(month, day)
        val dutyDayOfWeek = DutyDayOfWeek.getDayOfWeekFromDutyDay(dutyDay, isHoliday)
        return WorkCalendar(
            day = day,
            dutyDay = dutyDay,
            dutyDayOfWeek = dutyDayOfWeek
        )
    }

}