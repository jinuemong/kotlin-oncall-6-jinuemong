package oncall.controller

import oncall.domain.DutyCalendar
import oncall.domain.DutyManager
import oncall.domain.model.Calendar
import oncall.view.InputView

class WorkController(
    private val inputView: InputView,
) {
    lateinit var dutyCalendar: DutyCalendar
    lateinit var dutyManager: DutyManager

    fun userFlow(){
        makeCalendar()
    }

    private fun makeCalendar(){
        val (month,day) = inputView.inputDay()
        dutyCalendar = DutyCalendar(month.toInt(),day)
    }

    private fun makeManager(){
        val weekWorker = inputView.inputWeekDayWorker()
        val holidayWorker = inputView.inputHolliDayWorker()
        dutyManager = DutyManager(
            weekWorker,
            holidayWorker,
            dutyCalendar
        )
    }

}