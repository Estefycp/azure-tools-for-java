package com.microsoft.azure.hdinsight.common.classifiedexception

import java.io.IOException

class SparkServiceException : ClassifiedException {
    constructor(exp: Throwable?) : super(exp)

    override val title: String = "SparkServiceException"
}

object SparkServiceExceptionFactory : ClassifiedExceptionFactory() {
    override fun createClassifiedException(exp: Throwable?): ClassifiedException? {
        return if (exp is IOException) SparkServiceException(exp) else null
    }
}
