package domain.wiseSaying.repository

import domain.wiseSaying.entity.WiseSaying
import java.nio.file.Path

class WiseSayingFileRepository : WiseSayingRepository {

    private var lastId: Int = 0

    override fun save(wiseSaying: WiseSaying): WiseSaying {
        if (wiseSaying.isNew()) {
            val new = wiseSaying.copy(id = ++lastId)
            saveOnDisk(new)
            return new
        }

        saveOnDisk(wiseSaying)
        return wiseSaying
    }

    fun saveOnDisk(wiseSaying: WiseSaying) {
        Path.of("data/dev/wiseSaying").toFile().writeText(wiseSaying.jsonStr)
    }

    override fun findAll(): List<WiseSaying> {
        TODO("Not yet implemented")
    }

    override fun findById(id: Int): WiseSaying? {
        TODO("Not yet implemented")
    }

    override fun delete(wiseSaying: WiseSaying) {
        TODO("Not yet implemented")
    }

    override fun clear() {
        TODO("Not yet implemented")
    }

}