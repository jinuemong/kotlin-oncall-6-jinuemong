package oncall.view

import oncall.domain.utils.Message
import camp.nextstep.edu.missionutils.Console
import oncall.domain.utils.Rule

class InputView {

    fun inputDay(): List<String>{
        print(Message.INPUT_DAY)
        return Console.readLine().split(Rule.SPLIT_SEPARATOR)
    }

    fun inputWeekDayWorker(): List<String>{
        print(Message.INPUT_WEEKDAY)
        return Console.readLine().split(Rule.SPLIT_SEPARATOR)
    }

    fun inputHolliDayWorker(): List<String> {
        print(Message.INPUT_HOLIDAY)
        return Console.readLine().split(Rule.SPLIT_SEPARATOR)
    }

}