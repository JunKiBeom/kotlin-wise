import java.io.ByteArrayOutputStream
import java.io.PrintStream

class TestBot {

    companion object {

        val originalIn = System.`in` // 표준 입력 - 키보드
        val originalOut = System.out // 표준 출력 - 모니터

        fun run(input: String): String {

            val formattedInput = input
                .trimIndent()
                .plus("\n종료")

            val out = ByteArrayOutputStream()
            val testOut = PrintStream(out) // 커스텀 출력 - 배열

            System.setIn(formattedInput.byteInputStream()) // 커스텀 입력 - 매개변수 문자열
            System.setOut(testOut)

            val app = App() // 앱 테스트
            app.run()

            System.setIn(originalIn) // 표준 입력으로 원복
            System.setOut(originalOut) // 표준 출력으로 원복

            return out.toString().trim().replace("\\r\\n", "\\n")
        }
    }
}