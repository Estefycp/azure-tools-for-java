package com.microsoft.azure.hdinsight.common.classifiedexception

class SparkUserException : ClassifiedException {
    constructor(exp: Throwable?) : super(exp)

    override val title: String = "SparkUserException"
}

object SparkUserExceptionFactory : ClassifiedExceptionFactory() {
    override fun createClassifiedException(exp: Throwable?): ClassifiedException? {
        return SparkUserException(exp)
    }
}