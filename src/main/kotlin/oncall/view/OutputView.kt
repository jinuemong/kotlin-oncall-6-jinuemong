package oncall.view

import oncall.domain.model.WorkCalendar
import oncall.domain.utils.Rule

class OutputView {

    fun dayResult(
        month: Int,
        workCalendar: WorkCalendar,
        worker: String,
    ) {
        val monthMessage = "$month${Rule.MONTH_UNIT}"
        val dayMessage = workCalendar.getMonthDayMessage()
        val dayOfWeekMessage = workCalendar.getDayOfWeekMessage()
        val holidayMessage = workCalendar.getHolidayMessage()

        println("$monthMessage $dayMessage $dayOfWeekMessage$holidayMessage $worker")
    }

}