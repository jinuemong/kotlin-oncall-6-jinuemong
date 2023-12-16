package oncall.domain.utils

object Error {

    private const val ERR_MSG = "[ERROR]"

    const val ERR_INPUT = "$ERR_MSG 유효하지 않은 입력 값입니다. 다시 입력해 주세요."
    const val ERR_DUTY_MONTH = "$ERR_MSG 유효하지 않은 달 입니다."
    const val ERR_DUTY_DAT_DATE ="$ERR_MSG 유효하지 않은 요일 입니다."
    const val ERR_DUTY_DAT_OF_WEEK ="$ERR_MSG 알 수 없는 요일 유형입니다. "
}