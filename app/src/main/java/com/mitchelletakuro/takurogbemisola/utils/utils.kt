package com.mitchelletakuro.takurogbemisola.utils

import android.util.Log
import com.mitchelletakuro.takurogbemisola.data.models.CarOwner
import com.mitchelletakuro.takurogbemisola.data.models.FilterModel
import com.mitchelletakuro.takurogbemisola.utils.Constants.DEFAULT_QUOTE
import com.mitchelletakuro.takurogbemisola.utils.Constants.DEFAULT_SEPARATOR
import com.mitchelletakuro.takurogbemisola.utils.Constants.TAG
import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.io.IOException

fun readDataFromRaw(): ArrayList<CarOwner> {
    val carOwners = ArrayList<CarOwner>()
    try {
        val file = File(Constants.STORAGE_FILE_PATH)
        val reader = FileReader(file)
        val bufferedReader = BufferedReader(reader)
        var line: String?
        bufferedReader.readLine() //Step over the header
        line = bufferedReader.readLine()
        while (line != null) {
            val carOwnerTokens = csvDelimiter(line,  DEFAULT_SEPARATOR, DEFAULT_QUOTE)
            if (carOwnerTokens.isNotEmpty()) {
                val carOwner = CarOwner(
                    carOwnerTokens[0].toInt(),
                    carOwnerTokens[1],
                    carOwnerTokens[2],
                    carOwnerTokens[3],
                    carOwnerTokens[4],
                    carOwnerTokens[5],
                    carOwnerTokens[6].toInt(),
                    carOwnerTokens[7],
                    carOwnerTokens[8],
                    carOwnerTokens[9],
                    carOwnerTokens[10]
                )



                    carOwners.add(carOwner)
            }
            line = bufferedReader.readLine()
        }
    } catch (e: IOException) {
        Log.e(TAG, e.message, e)
        throw e
    }
    return carOwners
}


fun csvDelimiter(
        cvsLine: String,
        separators: Char,
        customQuote: Char
): List<String> {
    val result: MutableList<String> = ArrayList()

    if (cvsLine.isEmpty()) {
        return result
    }

    var curVal = StringBuffer()
    var inQuotes = false
    var startCollectChar = false
    var doubleQuotesInColumn = false
    val chars = cvsLine.toCharArray()
    for (ch in chars) {
        if (inQuotes) {
            startCollectChar = true
            if (ch == customQuote) {
                inQuotes = false
                doubleQuotesInColumn = false
            } else { //Fixed : allow "" in custom quote enclosed
                if (ch == '\"') {
                    if (!doubleQuotesInColumn) {
                        curVal.append(ch)
                        doubleQuotesInColumn = true
                    }
                } else {
                    curVal.append(ch)
                }
            }
        } else {
            if (ch == customQuote) {
                inQuotes = true
                //Fixed : allow "" in empty quote enclosed
                if (chars[0] != '"' && customQuote == '\"') {
                    curVal.append('"')
                }
                //double quotes in column will hit this!
                if (startCollectChar) {
                    curVal.append('"')
                }
            } else if (ch == separators) {
                result.add(curVal.toString())
                curVal = StringBuffer()
                startCollectChar = false
            } else if (ch == '\r') { //ignore LF characters
                continue
            } else if (ch == '\n') { //the end, break!
                break
            } else {
                curVal.append(ch)
            }
        }
    }
    result.add(curVal.toString())
    return result
}

fun filterCarOwners(filter: FilterModel, carOwners: List<CarOwner>): List<CarOwner> {

    return carOwners.filter { owner ->

        val containCountry = if (filter.countries.isNotEmpty()) {
            owner.country in filter.countries
        } else {
            true
        }

        val containsColor = if (filter.colors.isNotEmpty()) {
            owner.carColor in filter.colors
        } else {
            true
        }

        val containStartYear = if (filter.carModel_startYear != 0) {
            owner.carModelYear >= filter.carModel_startYear
        } else {
            true
        }

        val containEndYear = if (filter.carModel_endYear != 0) {
            owner.carModelYear <= filter.carModel_endYear
        } else {
            true
        }

        val containsGender = if (filter.gender.isNotEmpty()) {
            owner.gender.equals(filter.gender, true)
        } else {
            true
        }
        containCountry && containsColor && containStartYear && containEndYear && containsGender
    }
}



