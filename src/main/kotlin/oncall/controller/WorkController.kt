package oncall.controller

import oncall.domain.DutyCalendar
import oncall.domain.DutyManager
import oncall.view.InputView
import oncall.view.OutputView

class WorkController(
    private val inputView: InputView,
    private val outputView: OutputView
) {
    private lateinit var dutyCalendar: DutyCalendar
    private lateinit var dutyManager: DutyManager

    fun userFlow() {
        makeCalendar()
        makeManager()
        result()
    }

    private fun makeCalendar() {
        val (month, day) = inputView.inputDay()
        dutyCalendar = DutyCalendar(month.toInt(), day)
    }

    private fun makeManager() {
        val weekWorker = inputView.inputWeekDayWorker()
        val holidayWorker = inputView.inputHolliDayWorker()
        dutyManager = DutyManager(
            weekWorker,
            holidayWorker,
            dutyCalendar
        )
    }

    private fun result() {
        val table = dutyManager.getTable()
        val calendar = dutyCalendar.getDutyCalendar()
        val currentMonth = dutyCalendar.getCurrentMonth()

        calendar.zip(table).forEach { (calendar, worker) ->
            outputView.dayResult(
                currentMonth,
                calendar,
                worker
            )
        }
    }

}