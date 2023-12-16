package oncall.controller

import oncall.domain.DutyCalendar
import oncall.domain.DutyManager
import oncall.domain.DutyVerifier
import oncall.view.InputView
import oncall.view.OutputView

class WorkController(
    private val inputView: InputView,
    private val outputView: OutputView,
    private val dutyVerifier: DutyVerifier
) {
    private lateinit var dutyCalendar: DutyCalendar
    private lateinit var dutyManager: DutyManager

    fun userFlow() {
        makeCalendar()
        makeManager()
        result()
    }

    private fun makeCalendar() {
        while (!::dutyCalendar.isInitialized){
            try {
                val userInput = inputView.inputDay()
                dutyVerifier.checkDay(userInput)

                val (month,day) = userInput
                dutyCalendar = DutyCalendar(month.toInt(), day)
            } catch (e: IllegalArgumentException){
                println(e.message)
            }
        }
    }

    private fun makeManager() {
        while (!::dutyManager.isInitialized){
            try {
                val weekWorker = inputView.inputWeekDayWorker()
                val holidayWorker = inputView.inputHolliDayWorker()
                dutyVerifier.checkWorkerDuplicate(weekWorker,holidayWorker)
                dutyVerifier.checkWorkerComposition(weekWorker.toSet(),holidayWorker.toSet())
                dutyVerifier.checkWorkerNames(weekWorker)

                dutyManager = DutyManager(
                    weekWorker,
                    holidayWorker,
                    dutyCalendar
                )
            } catch (e: IllegalArgumentException){
                println(e.message)
            }
        }
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