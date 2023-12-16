package oncall.domain.model

import oncall.domain.utils.Error

enum class DutyMonth(
    private val month: Int,
    private val maxDay: Int
) {

    JAN(1, 31),
    FEB(2, 28),
    MAR(3, 31),
    APR(4, 30),
    MAY(5, 31),
    JUN(6, 30),
    JUL(7, 31),
    AUG(8, 31),
    SEP(9, 30),
    OCT(10, 31),
    NOV(11, 30),
    DEC(12, 31);

    companion object {
        fun getMaxDayFromMonth(month: Int): Int {
            return entries.find { it.month == month }?.maxDay
                ?: throw IllegalArgumentException(Error.ERR_DUTY_MONTH)
        }
    }

}