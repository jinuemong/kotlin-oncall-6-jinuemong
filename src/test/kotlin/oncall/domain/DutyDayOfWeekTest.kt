package oncall.domain

import oncall.domain.model.DutyDayOfWeek
import oncall.domain.model.DutyDay
import oncall.domain.utils.Error
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class DutyDayOfWeekTest {

    @Test
    fun `정확한 요일 입력과 휴일 시 테스트`() {
        assertThat(
            DutyDayOfWeek.getDayOfWeekFromDutyDay(DutyDay.TUESDAY, true) == DutyDayOfWeek.HOLIDAY
        )
    }

    @Test
    fun `정확한 요일 입력과 휴일이 아닌 경우 테스트`() {
        assertThat(
            DutyDayOfWeek.getDayOfWeekFromDutyDay(DutyDay.TUESDAY, false) == DutyDayOfWeek.WEEKDAY
        )
    }

    @Test
    fun `정확하지 않은 요일 시 테스트`() {
        assertThrows<IllegalArgumentException>(Error.ERR_DUTY_DAT_OF_WEEK) {
            DutyDayOfWeek.getDayOfWeekFromDutyDay(null, false)
        }
    }

}