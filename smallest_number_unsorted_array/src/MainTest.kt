import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class MainTest {
    @Nested
    inner class InefficientSolution {
        @Test
        fun `returns smallest number when many negative numbers`() {
            val input = listOf(2, 3, 7, 6, 8, -1, -10, 15)
            assertEquals(1, example(input))
        }

        @Test
        fun `returns smallest number when many negative numbers version 2`() {
            val input = listOf(2, 3, -7, 6, 8, 1, -10, 15)
            assertEquals(4, example(input))
        }

        @Test
        fun `returns smallest number when zero in array`() {
            val input = listOf(1, 1, 0, -1, -2)
            assertEquals(2, example(input))
        }
    }

    @Nested
    inner class BucketsSolution {
        @Test
        fun `returns smallest number when many negative numbers`() {
            val input = listOf(2, 3, 7, 6, 8, -1, -10, 15)
            assertEquals(1, exampleWithBuckets(input))
        }

        @Test
        fun `returns smallest number when many negative numbers version 2`() {
            val input = listOf(2, 3, -7, 6, 8, 1, -10, 15)
            assertEquals(4, exampleWithBuckets(input))
        }

        @Test
        fun `returns smallest number when zero in array`() {
            val input = listOf(1, 1, 0, -1, -2)
            assertEquals(2, exampleWithBuckets(input))
        }
    }

    @Nested
    inner class FunctionalSolution {
        @Test
        fun `returns smallest number when many negative numbers`() {
            val input = listOf(2, 3, 7, 6, 8, -1, -10, 15)
            assertEquals(1, exampleFunctional(input))
        }

        @Test
        fun `returns smallest number when many negative numbers version 2`() {
            val input = listOf(2, 3, -7, 6, 8, 1, -10, 15)
            assertEquals(4, exampleFunctional(input))
        }

        @Test
        fun `returns smallest number when zero in array`() {
            val input = listOf(1, 1, 0, -1, -2)
            assertEquals(2, exampleFunctional(input))
        }
    }
}
