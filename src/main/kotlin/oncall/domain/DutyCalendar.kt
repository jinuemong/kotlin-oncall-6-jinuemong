package oncall.domain

import oncall.domain.model.*

class DutyCalendar(
    private val month: Int,
    private val dayOfWeek: String,
    private val calendar: MutableList<Calendar> =  mutableListOf()
) {

    init {
        makeCalendar()
    }

    fun getDutyCalendar(): List<Calendar>{
        return calendar
    }

    private fun makeCalendar() {
        var dutyIdx = DutyDay.getDutyIdx(dayOfWeek)
        repeat(DutyMonth.getMaxDayFromMonth(month)) { idx ->
            calendar.add(makeNewCalendar(idx+1,dutyIdx%7))
            dutyIdx+=1
        }
    }

    private fun makeNewCalendar(
        day: Int,
        idx: Int
    ): Calendar{
        val dutyDay  = DutyDay.getDutyDayFromIdx(idx)
        val isHoliday = Holiday.checkIsHoliday(month,day)
        val dayOfWeek = DayOfWeek.getDayOfWeekFromDutyDay(dutyDay,isHoliday)
        return Calendar(
            day = day,
            dutyDay = dutyDay,
            dayOfWeek = dayOfWeek
        )
    }

}