package oncall.domain

import oncall.domain.model.DayOfWeek

class DutyManager(
    private val weekDayWorkers: List<String>,
    private val holidayWorkers: List<String>,
    private val calendar: DutyCalendar,
    val allocationTable: MutableList<String> = mutableListOf()
) {

    init {
        allocateWork()
    }

    fun allocateWork() {
        var weekDayIdx = 0
        var holidayIdx = 0

        val calendars = calendar.getDutyCalendar()
        calendars.forEach { calendar ->
            when (calendar.dayOfWeek) {
                DayOfWeek.WEEKDAY -> {
                    allocateWeekDay(weekDayIdx)
                    weekDayIdx+=1
                }

                DayOfWeek.HOLIDAY,DayOfWeek.WEEKEND -> {
                    allocateHoliday(holidayIdx)
                    holidayIdx+=1
                }

            }
        }
    }

    private fun allocateWeekDay(weekDayIdx: Int){
        if (checkDoubleWork(getWeekDayUserName(weekDayIdx))){
            changeAddUser(getWeekDayUserName(weekDayIdx))
        }else{
            addUser(getWeekDayUserName(weekDayIdx))
        }
    }

    private fun allocateHoliday(holidayIdx: Int){
        if (checkDoubleWork(getHolidayUserName(holidayIdx))){
            changeAddUser(getHolidayUserName(holidayIdx))
        }else {
            addUser(getHolidayUserName(holidayIdx))
        }
    }

    private fun getWeekDayUserName(idx:Int): String{
        return weekDayWorkers[idx%weekDayWorkers.size]
    }

    private fun getHolidayUserName(idx:Int): String {
        return holidayWorkers[idx%weekDayWorkers.size]
    }

    private fun changeAddUser(newName: String){
        val prev = getPrevName()
        allocationTable[allocationTable.size -1 ] = newName
        allocationTable.add(prev)
    }

    private fun addUser(newName: String){
        allocationTable.add(newName)
    }

    private fun checkDoubleWork(name:String): Boolean {
        if (checkTableSize()) {
            return getPrevName() == name
        }
        return false
    }


    private fun checkTableSize(): Boolean = allocationTable.size > 0

    private fun getPrevName(): String = allocationTable.last()


}