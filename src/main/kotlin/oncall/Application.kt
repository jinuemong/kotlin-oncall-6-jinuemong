package oncall

import oncall.domain.DutyCalendar
import oncall.domain.DutyManager

fun main() {
    val calendar = DutyCalendar(5,"월")
    calendar.getDutyCalendar().forEach {
        println(it.day.toString()+","+it.dutyDay+","+it.dayOfWeek)
    }
    val dutyMutableList = DutyManager(
        weekDayWorkers = listOf("준팍","도밥","고니","수아","루루","글로","솔로스타","우코","슬링키","참새","도리"),
        holidayWorkers = listOf("수아","루루","글로","솔로스타","우코","슬링키","참새","도리","준팍","도밥","고니"),
        calendar = calendar
    )
    dutyMutableList.allocationTable.forEach{
        println(it)
    }
}
