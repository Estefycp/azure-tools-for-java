package com.microsoft.azure.hdinsight.common.classifiedexception

import com.microsoft.azure.hdinsight.common.logger.ILogger
import org.apache.commons.lang.exception.ExceptionUtils

abstract class ClassifiedException : Throwable, ILogger {
    final override val cause: Throwable?
    final override val message: String

    open val title: String = "ClassifiedException"

    constructor(exp: Throwable?) {
        cause = exp
        message = cause?.message ?: EmptyLog
    }

    fun getStackTrace(): String {
        return if (cause != null) ExceptionUtils.getStackTrace(cause) else message
    }

    fun logStackTrace() {
        log().warn(title + ": " + getStackTrace())
    }
}