package oncall.domain.utils

object Rule {

    const val SPLIT_SEPARATOR = ","

    const val WEEK_LENGTH = 7

    const val MIN_MONTH = 1
    const val MAX_MONTH = 7


    const val MONTH_UNIT = "월"
    const val DAY_UNIT = "일"

    const val MIN_NAME = 1
    const val MAX_NAME = 5

    const val MIN_USER = 5
    const val MAX_USER = 35

    // 이름 정규식
    const val NAME_RULE = "^[\\s가-힣a-zA-Z]{${MIN_NAME},${MAX_NAME}}\$"

}