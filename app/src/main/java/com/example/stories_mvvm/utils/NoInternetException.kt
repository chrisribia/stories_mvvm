package com.example.stories_mvvm.utils

import java.io.IOException


class ApiException(message: String) : IOException(message)
class NoInternetException(message: String) : IOException(message)