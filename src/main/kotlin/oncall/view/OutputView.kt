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
        val dayMessage = calendar.getMonthDayMessage()
        val dayOfWeekMessage = calendar.getDayOfWeekMessage()
        val holidayMessage = calendar.getHolidayMessage()

        println("$monthMessage $dayMessage $dayOfWeekMessage$holidayMessage $worker")
    }

}