package com.example.birthdaycard

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.util.*

class BirthdayCardDisplay : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_birthday_card_display)
        
        // GETTING INFORMATION FROM PREVIOUS ACTIVITY
        val name: String? = this.intent.getStringExtra("Name")
        val month: String? = this.intent.getStringExtra("Month")
        val day: String? = this.intent.getStringExtra("Day")
        val year: String? = this.intent.getStringExtra("Year")

        // PROCESSING
        val age = 2023 - year!!.toInt()

        val birthStone = when (month) {
            "01" -> "Garnet"
            "02" -> "Amethyst"
            "03" -> "Aquamarine"
            "04" -> "Diamond"
            "05" -> "Emerald"
            "06" -> "Pearl"
            "07" -> "Ruby"
            "08" -> "Peridot"
            "09" -> "Sapphire"
            "10" -> "Opal"
            "11" -> "Topaz"
            "12" -> "Turquoise"
            else -> "Unknown"
        }

        val zodiac = when (year) {
            "1948", "1960", "1972", "1984", "1996", "2008", "2020" -> "Rat"
            "1949", "1961", "1973", "1985", "1997", "2009", "2021" -> "Ox"
            "1950", "1962", "1974", "1986", "1998", "2010", "2022" -> "Tiger"
            "1951", "1963", "1975", "1987", "1999", "2011", "2023" -> "Rabbit"
            "1952", "1964", "1976", "1988", "2000", "2012", "2024" -> "Dragon"
            "1953", "1965", "1977", "1989", "2001", "2013", "2025" -> "Snake"
            "1954", "1966", "1978", "1990", "2002", "2014", "2026" -> "Horse"
            "1955", "1967", "1979", "1991", "2003", "2015", "2027" -> "Goat"
            "1956", "1968", "1980", "1992", "2004", "2016", "2028" -> "Monkey"
            "1957", "1969", "1981", "1993", "2005", "2017", "2029" -> "Rooster"
            "1958", "1970", "1982", "1994", "2006", "2018", "2030" -> "Dog"
            "1959", "1971", "1983", "1995", "2007", "2019", "2031" -> "Pig"
            else -> "Unknown"
        }

        // MAIN DISPLAY & FORMAT
        val textView = findViewById<TextView>(R.id.textView)
        textView.text = "Happy birthday \n$name!" +
                "\n\nYour age is: $age" +
                "\n\nYour birthstone is: $birthStone" +
                "\n\nYour Chinese Zodiac sign is: $zodiac"
    }
}