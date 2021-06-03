package com.alaahossam.core.network

import android.content.Context
import android.content.res.Resources
import com.alaahossam.core.R
import es.dmoral.toasty.Toasty
import java.net.SocketTimeoutException

object NetworkException {

    fun exceptionsHandler(
        context: Context,
        exception: Exception?
    ) {
        when (exception) {
            is NoConnectivityException -> Toasty.error(
                context, context.getString(R.string.no_internet_connection)
            ).show()
            is InternalServerException,
            is SocketTimeoutException,
            is Resources.NotFoundException -> Toasty.error(
                context, context.getString(R.string.something_went_wrong)
            ).show()
            is ExpiredTokenException,
            is MissingTokenException -> {
                Toasty.error(context, R.string.expired_token).show()
            }
            else -> Toasty.error(
                context, exception?.localizedMessage
                    ?: context.getString(R.string.something_went_wrong)
            ).show()
        }
    }
}