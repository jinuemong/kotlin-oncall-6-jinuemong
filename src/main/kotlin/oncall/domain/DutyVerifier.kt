package oncall.domain

import oncall.domain.model.DayOfWeek
import oncall.domain.model.DutyDay
import oncall.domain.utils.Error
import oncall.domain.utils.Rule

class DutyVerifier {

    fun checkDay(userInput: List<String>) {
        require(checkIsPair(userInput)) {
            Error.ERR_INPUT
        }

        val (month, date) = userInput
        checkInputMonth(month)
        checkInputDate(date)

    }

    fun checkWorkerDuplicate(
        weekDayWorkers: List<String>,
        holidayWorkers: List<String>,
    ) {
        require(checkDuplicate(weekDayWorkers) && checkDuplicate(holidayWorkers)){
            Error.ERR_INPUT
        }

        require(checkTotalWorker(weekDayWorkers.toSet(), holidayWorkers.toSet())){
            Error.ERR_INPUT
        }
    }

    fun checkWorkerComposition(
        weekDayWorkers: Set<String>,
        holidayWorkers: Set<String>,
    ){
        require(
            checkTotalWorker(weekDayWorkers, holidayWorkers) &&
            checkPairWork(weekDayWorkers,holidayWorkers)
        ){
            Error.ERR_INPUT
        }

    }

    fun checkWorkerNames(
        workers: List<String>,
    ) {
        workers.forEach { name ->
            require(checkNameLength(name) && checkNameValid(name)){
                Error.ERR_INPUT
            }
        }
    }

    private fun checkNameLength(name: String): Boolean {
        return name.length in Rule.MIN_NAME..Rule.MAX_NAME
    }

    // 이름 정규식 확인
    private fun checkNameValid(name: String): Boolean {
        return name.matches(Regex(Rule.NAME_RULE))
    }

    private fun checkDuplicate(names: List<String>): Boolean {
        return names.size == names.toSet().size
    }

    private fun checkTotalWorker(
        weekDayWorkers: Set<String>,
        holidayWorkers: Set<String>,
    ): Boolean {
        val joinWorker: MutableSet<String> = mutableSetOf()
        joinWorker.addAll(weekDayWorkers)
        joinWorker.addAll(holidayWorkers)
        return joinWorker.size in Rule.MIN_USER..Rule.MAX_USER

    }

    // 1일 1근무 확인
    private fun checkPairWork(
        weekDayWorkers: Set<String>,
        holidayWorkers: Set<String>,
    ): Boolean {
        return weekDayWorkers.size == holidayWorkers.size
    }

    private fun checkInputMonth(month: String) {
        require(checkIsNumber(month) && checkMonth(month.toInt())) {
            Error.ERR_INPUT
        }
    }


    private fun checkInputDate(date: String) {
        require(checkDutyDay(date) && checkDayOfWeek(date)) {
            Error.ERR_INPUT
        }
    }

    private fun checkIsPair(dayPair: List<String>): Boolean {
        return dayPair.size == 2
    }

    private fun checkMonth(month: Int): Boolean {
        return month in Rule.MIN_MONTH..Rule.MAX_MONTH
    }

    private fun checkDutyDay(date: String): Boolean {
        return try {
            DutyDay.getDutyDayFromDate(date)
            true
        } catch (e: IllegalArgumentException) {
            println(e.message)
            false
        }
    }

    private fun checkDayOfWeek(date: String): Boolean {
        return try {
            val dutyDay = DutyDay.getDutyDayFromDate(date)
            DayOfWeek.getDayOfWeekFromDutyDay(dutyDay, false)
            true
        } catch (e: IllegalArgumentException) {
            println(e.message)
            false
        }
    }

    // 숫자 확인
    private fun checkIsNumber(userInput: String): Boolean {
        return try {
            userInput.toInt()
            true
        } catch (e: NumberFormatException) {
            false
        }
    }
}