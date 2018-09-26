package com.microsoft.azure.hdinsight.common.classifiedexception

import com.microsoft.azure.hdinsight.spark.common.YarnDiagnosticsException
import org.apache.commons.lang.exception.ExceptionUtils

const val ToolPackageSuffix: String = "com.microsoft.azure.hdinsight"

class SparkToolException : ClassifiedException {
    constructor(exp: Throwable?) : super(exp)

    override val title: String = "SparkToolException"
}

object SparkToolExceptionFactory : ClassifiedExceptionFactory() {
    override fun createClassifiedException(exp: Throwable?): ClassifiedException? {
        val stackTrace = if (exp != null) ExceptionUtils.getStackTrace(exp) else EmptyLog
        return if (!(exp is YarnDiagnosticsException) && stackTrace.contains(ToolPackageSuffix)) SparkToolException(exp) else null
    }
}