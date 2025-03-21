package domain.wiseSaying.service

import domain.wiseSaying.entity.WiseSaying
import domain.wiseSaying.repository.WiseSayingRepository

class WiseSayingService {

    private val wiseSayingRepository = WiseSayingRepository()

    fun write(saying: String, author: String): WiseSaying {
        return wiseSayingRepository.save(WiseSaying(saying = saying, author = author))
    }

    fun getItems(): List<WiseSaying> {
        return wiseSayingRepository.findAll()
    }

    fun delete(wiseSaying: WiseSaying) {
        wiseSayingRepository.delete(wiseSaying)
    }

    fun getItem(id: Int): WiseSaying? {
        return wiseSayingRepository.findById(id)
    }

    fun modify(wiseSaying: WiseSaying, saying: String, author: String): WiseSaying {
        return wiseSayingRepository.save(wiseSaying.copy(saying = saying, author = author))
    }
}