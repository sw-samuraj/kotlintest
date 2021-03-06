package io.kotest.core

import io.kotest.core.*
import io.kotest.core.spec.IsolationMode
import io.kotest.core.test.AssertionMode
import io.kotest.core.test.Description
import io.kotest.core.test.TestCase
import io.kotest.core.test.TestCaseOrder
import io.kotest.core.extensions.SpecLevelExtension
import io.kotest.core.extensions.TestListener

/**
 * A [SpecClass] is the top level component in Kotest.
 *
 * It contains the root [TestCase] instances which in turn
 * can contain nested [TestCase] instances.

 * For example, the FunSpec allows us to create tests using
 * the "test(name)" function, such as:
 *
 * fun test("this is a test") {
 *   // test code here
 * }
 *
 * The spec ultimately forms a tree, with the spec's root
 * container at the root, and nested containers forming
 * branches and test cases as the leaves. The actual hierarchy
 * will depend on the spec being used.
 *
 * A [SpecClass] is also a [TestListener] to allow for
 * convenience overloads here if you just want to listen
 * in a single place.
 */
interface SpecClass : TestListener {

   fun isolationMode(): IsolationMode? = null

   /**
    * Override this function to register extensions
    * which will be invoked during execution of this spec.
    *
    * If you wish to register an extension across the project
    * then use [AbstractProjectConfig.extensions].
    */
   fun extensions(): List<SpecLevelExtension> = listOf()

   /**
    * Override this function to register instances of
    * [TestListener] which will be notified of events during
    * execution of this spec.
    *
    * If you wish to register a listener that will be notified
    * for all specs, then use [AbstractProjectConfig.listeners].
    */
   fun listeners(): List<TestListener> = emptyList()

   /**
    *  These are the top level [TestCase] instances for this Spec.
    */
   fun testCases(): List<TestCase>

   fun closeResources()

   /**
    * Sets the order of top level [TestCase]s in this spec.
    * If this function returns a null value, then the value set in
    * the [AbstractProjectConfig] will be used.
    */
   fun testCaseOrder(): TestCaseOrder? = null

   /**
    * Any tags added here will be in applied to all [TestCase]s defined
    * in this [SpecClass] in addition to any defined on the individual
    * tests themselves.
    */
   fun tags(): Set<Tag> = emptySet()

   fun description(): Description = TODO()

   fun assertionMode(): AssertionMode? = null
}
