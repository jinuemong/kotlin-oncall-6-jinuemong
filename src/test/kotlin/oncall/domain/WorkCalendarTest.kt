package oncall.domain

import oncall.domain.model.DutyDayOfWeek
import oncall.domain.model.DutyDay
import oncall.domain.model.WorkCalendar
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class WorkCalendarTest {

    @Test
    fun `주말인 경우 정확한 값 반환 테스트`(){
        val workCalendar = WorkCalendar(
            day = 7,
            dutyDay  = DutyDay.SATURDAY,
            dutyDayOfWeek = DutyDayOfWeek.WEEKEND
        )
        assertThat(workCalendar.getHolidayMessage()=="")
    }

    @Test
    fun `휴일인 경우 정확한 값 반환 테스트`(){
        val workCalendar = WorkCalendar(
            day = 5,
            dutyDay  = DutyDay.FRIDAY,
            dutyDayOfWeek = DutyDayOfWeek.HOLIDAY
        )
        assertThat(workCalendar.getHolidayMessage()=="(휴일)")
    }

    @Test
    fun `평일인 경우 정확한 값 반환 테스트`(){
        val workCalendar = WorkCalendar(
            day = 1,
            dutyDay  = DutyDay.MONDAY,
            dutyDayOfWeek = DutyDayOfWeek.WEEKDAY
        )
        assertThat(workCalendar.getHolidayMessage()=="")
    }

}