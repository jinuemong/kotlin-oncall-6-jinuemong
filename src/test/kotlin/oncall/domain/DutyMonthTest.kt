package oncall.domain

import oncall.domain.model.DutyMonth
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class DutyMonthTest {

    @Test
    fun `말일이 31일인 달 테스트`(){
        listOf(1,3,5,7,8,10,12).forEach{
            assertThat(DutyMonth.getMaxDayFromMonth(it)==31)
        }
    }

    @Test
    fun `말일이 30일인 달 테스트`(){
        listOf(4,6,9,11).forEach{
            assertThat(DutyMonth.getMaxDayFromMonth(it)==30)
        }
    }

    @Test
    fun `말일이 28일인 달 테스트`(){
        assertThat(DutyMonth.getMaxDayFromMonth(2)==28)
    }

    @Test
    fun `부정확한 달 입력 시 예외 테스트`(){
        assertThrows<IllegalArgumentException> {
            DutyMonth.getMaxDayFromMonth(0)
            DutyMonth.getMaxDayFromMonth(13)
        }
    }
}