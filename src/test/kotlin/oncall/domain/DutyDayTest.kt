package oncall.domain

import oncall.domain.model.DutyDay
import oncall.domain.utils.Error
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.`in`
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class DutyDayTest {

    @Test
    fun `정상적인 요일 입력 테스트 `(){
        DutyDay.entries.forEach {
            assertThat(
                DutyDay.getDutyDayFromDate(it.getDayOfWeek()) == it
            )
        }

    }

    @Test
    fun `부정확한 요일 입력 예외 테스트 `(){
        assertThrows<IllegalArgumentException>(Error.ERR_DUTY_DAT_DATE) {
            DutyDay.getDutyDayFromDate("요일")
        }
    }

    @Test
    fun `정상적인 요일 인덱스 테스트 `(){
        DutyDay.entries.forEachIndexed { idx, day ->
            assertThat(
                DutyDay.getDutyDayFromIdx(idx) == day
            )
        }

    }

    @Test
    fun `부정확한 요일 인덱스 입력 예외 테스트 `(){
        assertThrows<IllegalArgumentException>(Error.ERR_DUTY_DAT_DATE) {
            DutyDay.getDutyDayFromIdx(7)
        }
    }

    @Test
    fun `정상적인 요일 인덱스 반환 테스트 `(){
        DutyDay.entries.forEachIndexed { index, dutyDay ->
            assertThat(
                DutyDay.getDutyIdx(dutyDay.getDayOfWeek()) == index
            )
        }

    }

    @Test
    fun `부정확한 요일 인덱스 반환 예외 테스트 `(){
        assertThrows<IllegalArgumentException>(Error.ERR_DUTY_DAT_DATE) {
            DutyDay.getDutyIdx("요일")
        }
    }
}