package oncall

import oncall.controller.WorkController
import oncall.domain.DutyVerifier
import oncall.view.InputView
import oncall.view.OutputView

fun main() {

    try {
        val workController = WorkController(
            inputView = InputView(),
            outputView = OutputView(),
            dutyVerifier = DutyVerifier()
        )
        workController.userFlow()
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }

}
