package com.think.domain.wiseSaying.service

import domain.wiseSaying.entity.WiseSaying

class WiseSayingService {
    var lastId: Int = 0
    val wiseSayings = mutableListOf<WiseSaying>()

    fun write(saying: String, author: String): WiseSaying {
        val id = ++lastId
        val new = WiseSaying(id, saying, author)
        wiseSayings.add(new)

        return new
    }

    fun getItems(): List<WiseSaying> {
        return wiseSayings.toList()
    }

    fun delete(wiseSaying: WiseSaying) {
        val rst = wiseSayings.remove(wiseSaying)
    }

    fun getItem(id: Int): WiseSaying? {
        return wiseSayings.find { it.id == id }
    }

    fun modify(wiseSaying: WiseSaying, saying: String, author: String): WiseSaying {

        val index = wiseSayings.indexOfFirst { it.id == wiseSaying.id }
        val new = wiseSaying.copy(saying = saying, author = author)
        wiseSayings[index] = new

        return new
    }
}