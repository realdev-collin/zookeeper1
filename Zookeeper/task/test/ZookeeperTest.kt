import org.hyperskill.hstest.dynamic.DynamicTest
import org.hyperskill.hstest.stage.StageTest
import org.hyperskill.hstest.testcase.CheckResult
import org.hyperskill.hstest.testing.TestedProgram


class ZookeeperTest : StageTest<String>() {

    private var theEndMessage = "---\nYou've reached the end of the program. To check another habitat, please restart the watcher."
    private var indexArray = arrayOf("0", "1", "2", "3", "4", "5")
    private var animalIndex = mapOf(
            "0" to arrayOf(camel, "camel"),
            "1" to arrayOf(lion, "lion"),
            "2" to arrayOf(deer, "deer"),
            "3" to arrayOf(goose, "goose"),
            "4" to arrayOf(bat, "bat"),
            "5" to arrayOf(rabbit, "rabbit")
    )

    @DynamicTest(data = "indexArray")
    fun test(index: String): CheckResult {

        val testedProgram = TestedProgram()
        testedProgram.start()

        val output = testedProgram.execute(index)

        val animalImage = animalIndex[index]?.get(0).toString()
        val animalName = animalIndex[index]?.get(1).toString()

        if (!output.contains(animalImage)) {
            return CheckResult.wrong("You should output a $animalName when the input is the number $index")
        }

        if (!output.contains(theEndMessage)) {
            return CheckResult.wrong("You should output the message about the end of the program!")
        }

        return CheckResult.correct()
    }
}