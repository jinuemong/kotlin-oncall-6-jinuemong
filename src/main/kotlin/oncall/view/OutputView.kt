package oncall.view

import oncall.domain.model.Calendar
import oncall.domain.utils.Rule

class OutputView {

    fun dayResult(
        month: Int,
        calendar: Calendar,
        worker: String,
    ) {
        val monthMessage = "$month${Rule.MONTH_UNIT}"
        val dayMessage = "${calendar.day}${Rule.DAY_UNIT}"
        val dayOfWeekMessage = calendar.dutyDay.getDayOfWeek()
        val holidayMessage = if (calendar.dayOfWeek.isHoliday()) "(${calendar.dayOfWeek.getInfo()})" else ""

        println("$monthMessage $dayMessage $dayOfWeekMessage$holidayMessage $worker")
    }

}