package oncall.domain.model

import oncall.domain.utils.Error

enum class DutyDay(
    private val date: String,
    private val dutyIdx: Int
) {

    MONDAY("월", 0),
    TUESDAY("화", 1),
    WEDNESDAY("수", 2),
    THURSDAY("목", 3),
    FRIDAY("금", 4),
    SATURDAY("토", 5),
    SUNDAY("일", 6);

    fun getDayOfWeek(): String = this.date

    companion object {

        fun getDutyDayFromDate(date: String): DutyDay {
            return entries.find { it.date == date }
                ?: throw IllegalArgumentException(Error.ERR_DUTY_DAT_DATE)
        }

        fun getDutyDayFromIdx(idx: Int): DutyDay {
            return entries.find { it.dutyIdx == idx }
                ?: throw IllegalArgumentException(Error.ERR_DUTY_DAT_DATE)
        }

        fun getDutyIdx(date: String): Int {
            return entries.find { it.date == date }?.dutyIdx
                ?: throw IllegalArgumentException(Error.ERR_DUTY_DAT_DATE)
        }

    }

}