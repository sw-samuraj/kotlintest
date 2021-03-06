package io.kotest.core.spec

import io.kotest.core.test.TestCase
import io.kotest.core.test.isFocused

/**
 * Returns the focused root tests for this Spec. A focused test is one whose
 * name begins with "f:".
 *
 * Returns an empty list if no test is marked as focused.
 */
fun SpecConfiguration.focusTests(): List<TestCase> = rootTestCases.filter { it.isFocused() }
