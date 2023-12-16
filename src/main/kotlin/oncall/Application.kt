package oncall

import oncall.controller.WorkController
import oncall.view.InputView
import oncall.view.OutputView

fun main() {

    try {
        val workController = WorkController(
            inputView = InputView(),
            outputView = OutputView()
        )
        workController.userFlow()
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }

}
