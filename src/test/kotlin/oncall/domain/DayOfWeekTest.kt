package oncall.domain

import oncall.domain.model.DayOfWeek
import oncall.domain.model.DutyDay
import oncall.domain.utils.Error
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class DayOfWeekTest {

    @Test
    fun `정확한 요일 입력과 휴일 시 테스트`(){
        assertThat(
            DayOfWeek.getDayOfWeekFromDutyDay(DutyDay.TUESDAY,true)==DayOfWeek.HOLIDAY
        )
    }

    @Test
    fun `정확한 요일 입력과 휴일이 아닌 경우 테스트`(){
        assertThat(
            DayOfWeek.getDayOfWeekFromDutyDay(DutyDay.TUESDAY,false)==DayOfWeek.WEEKDAY
        )
    }

    @Test
    fun `정확하지 않은 요일 시 테스트`() {
        assertThrows<IllegalArgumentException>(Error.ERR_DUTY_DAT_OF_WEEK) {
            DayOfWeek.getDayOfWeekFromDutyDay(null,false)
        }
    }
}