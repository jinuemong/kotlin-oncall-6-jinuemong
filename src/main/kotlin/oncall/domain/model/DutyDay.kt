package oncall.domain.model

enum class DutyDay(
    private val date: String,
    private val dutyIdx: Int
) {
    MONDAY("월",0),
    TUESDAY("화",1),
    WEDNESDAY("수",2),
    THURSDAY("목",3),
    FRIDAY("금",4),
    SATURDAY("토",5),
    SUNDAY("일",6);

    fun getDayOfWeek(): String = this.date

    companion object {

        fun getDutyDayFromDate(date:String): DutyDay{
            return entries.find { it.date == date }
                ?: throw IllegalArgumentException() // 여기에 에러 메시지 추가
        }

        fun getDutyDayFromIdx(idx: Int): DutyDay {
            return entries.find { it.dutyIdx == idx }
                ?: throw IllegalArgumentException() // 여기에 에러 메시지 추가
        }

        fun getDutyDays():List<DutyDay>{
            return entries.toList().sortedBy { it.dutyIdx }
        }

        fun getDutyIdx(date:String): Int{
            return entries.find { it.date == date }?.dutyIdx
                ?: throw IllegalArgumentException() // 여기에 에러 메시지 추가
        }

    }

}