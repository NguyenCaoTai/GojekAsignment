package com.example.myapplication.utilities

import java.nio.file.Files
import java.nio.file.Paths
import java.util.stream.Collectors

object TextUtils {
    fun getTextFromFile(file: String): String =
        Files.lines(Paths.get(ClassLoader.getSystemClassLoader().getResource(file).toURI()))
            .parallel()
            .collect(Collectors.joining())
}