package oncall

import oncall.domain.DutyCalendar

fun main() {
    val calendar = DutyCalendar(5,"월")
    calendar.getDutyCalendar().forEach {
        println(it.day.toString()+","+it.dutyDay+","+it.dayOfWeek)
    }
}
