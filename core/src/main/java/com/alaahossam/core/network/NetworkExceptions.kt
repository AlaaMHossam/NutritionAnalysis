package app.hatrick.core.network

import java.io.IOException

class NoConnectivityException : IOException()
class InternalServerException : IOException()
class NotFoundException : IOException()
class ExpiredTokenException : IOException()
class MissingTokenException : IOException()