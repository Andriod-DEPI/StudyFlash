package com.example.studyflash.viewmodels

data class Quiz(
    var Question: String,
    var Answer: String,
    var Hints: List<Hint> = emptyList(),
    var IsDone: Boolean = false,
    var isCorrect: Boolean = false
)

var Questions = listOf(
    Quiz(
        Question = "What is the capital of Japan?",
        Answer = "Tokyo",
        Hints = listOf(
            Hint(id = 1, text = "It's one of the largest cities in the world."),
            Hint(id = 2, text = "This city hosted the 2020 Summer Olympics."),
            Hint(id = 3, text = "It starts with the letter 'T'.")
        )
    ),
    Quiz(
        Question = "Who wrote the play 'Romeo and Juliet'?",
        Answer = "William Shakespeare",
        Hints = listOf(
            Hint(id = 1, text = "He is a famous English playwright."),
            Hint(id = 2, text = "This person lived in the 16th century."),
            Hint(id = 3, text = "His last name starts with 'S'.")
        )
    ),
    Quiz(
        Question = "What is the chemical symbol for water?",
        Answer = "H2O",
        Hints = listOf(
            Hint(id = 1, text = "It consists of hydrogen and oxygen."),
            Hint(id = 2, text = "Two atoms of hydrogen, one of oxygen."),
            Hint(id = 3, text = "It's essential for life.")
        )
    ),
    Quiz(
        Question = "Which planet is known as the Red Planet?",
        Answer = "Mars",
        Hints = listOf(
            Hint(id = 1, text = "It's the fourth planet from the Sun."),
            Hint(id = 2, text = "This planet is named after the Roman god of war."),
            Hint(id = 3, text = "It's known for its reddish appearance.")
        )
    ),
    Quiz(
        Question = "What is the smallest prime number?",
        Answer = "2",
        Hints = listOf(
            Hint(id = 1, text = "It is an even number."),
            Hint(id = 2, text = "It's the only even prime number."),
            Hint(id = 3, text = "It's less than 3.")
        )
    ),
    Quiz(
        Question = "Who was the first President of the United States?",
        Answer = "George Washington",
        Hints = listOf(
            Hint(id = 1, text = "He led the American Revolutionary War."),
            Hint(id = 2, text = "He was the first leader of the newly formed United States."),
            Hint(id = 3, text = "His face is on the U.S. dollar bill.")
        )
    )
)

var TotalScore: Int = 30