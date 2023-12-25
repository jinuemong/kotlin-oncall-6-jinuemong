package oncall.domain

import oncall.domain.model.Holiday
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class HolidayTest {

    @Test
    fun `검사 값이 휴일인 경우 테스트`(){
        assertThat(Holiday.checkIsHoliday(1,1))
        assertThat(Holiday.checkIsHoliday(3,1))
        assertThat(Holiday.checkIsHoliday(5,5))
        assertThat(Holiday.checkIsHoliday(6,6))
        assertThat(Holiday.checkIsHoliday(8,15))
        assertThat(Holiday.checkIsHoliday(10,3))
        assertThat(Holiday.checkIsHoliday(10,9))
        assertThat(Holiday.checkIsHoliday(12,25))
    }

    @Test
    fun `검사 값이 휴일이 아닌 경우 테스트`(){
        assertThat(Holiday.checkIsHoliday(1,2))
    }

}