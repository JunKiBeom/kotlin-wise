package domain.wiseSaying.repository

import domain.wiseSaying.entity.WiseSaying
import global.AppConfig
import java.nio.file.Path

class WiseSayingFileRepository : WiseSayingRepository {

    private var lastId: Int = 0

    val tableDirPath: Path
        get() = AppConfig.tableDirPath.resolve("wiseSaying")

    override fun save(wiseSaying: WiseSaying): WiseSaying {
        if (wiseSaying.isNew()) {
            val new = wiseSaying.copy(id = ++lastId)
            saveOnDisk(new)
            return new
        }

        saveOnDisk(wiseSaying)
        return wiseSaying
    }

    // data/test/wiseSaying/*.json
    fun saveOnDisk(wiseSaying: WiseSaying) {
        tableDirPath.resolve("${wiseSaying.id}.json").toFile().writeText(wiseSaying.jsonStr)
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

    fun initTable() {
        tableDirPath.toFile().run {
            if (!exists()) {
                mkdirs()
            }
        }
    }

}