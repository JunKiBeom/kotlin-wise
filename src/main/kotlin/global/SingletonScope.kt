package global

import domain.system.controller.SystemController
import domain.wiseSaying.controller.WiseSayingController
import domain.wiseSaying.repository.WiseSayingRepository
import domain.wiseSaying.service.WiseSayingService

object SingletonScope {
    val wiseSayingRepository = WiseSayingRepository()
    val wiseSayingService = WiseSayingService()
    val wiseSayingController = WiseSayingController()
    val systemController = SystemController()
}