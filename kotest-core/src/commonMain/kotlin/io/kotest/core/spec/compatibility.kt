package io.kotest.core.spec

import io.kotest.core.SpecClass
import io.kotest.core.*
import io.kotest.core.test.*
import io.kotest.core.extensions.SpecLevelExtension
import io.kotest.core.extensions.TestListener
import kotlin.reflect.KClass

/**
 * Contains functions which can be overriden to set config in the same way that KotlinTest 3.x allowed.
 * This style of configuration is deprecated and this class exists purely to ease the migration from
 * KotlinTest 3.x to Kotest 4.0.
 */
@Deprecated("This is a compatibility class. It exists only to ease migration and will be removed in 4.1")
interface CompatibilitySpecConfiguration {

   fun defaultTestCaseConfig(): TestCaseConfig? = null

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

   // @Deprecated("Use the spec DSL", ReplaceWith("isolationMode = myIsolationMode"))
   fun isolationMode(): IsolationMode? = null

   fun assertionMode(): AssertionMode? = null

   @Deprecated("Use the spec DSL", ReplaceWith("beforeTest { test -> }"))
   fun beforeTest(description: Description) {
   }

   @Deprecated("Use the spec DSL", ReplaceWith("afterTest { test, result -> }"))
   fun afterTest(description: Description, result: TestResult) {
   }

   @Deprecated("Use the spec DSL", ReplaceWith("afterSpec {  }"))
   fun afterSpec(spec: SpecClass) {
   }

   fun afterSpec(spec: SpecConfiguration) {
   }

   fun afterTest(testCase: TestCase, result: TestResult) {
   }

   @Deprecated("Use the spec DSL", ReplaceWith("beforeSpec {  }"))
   fun beforeSpec(spec: SpecClass) {
   }

   // @Deprecated("Use the spec DSL", ReplaceWith("beforeSpec {  }"))
   fun beforeSpec(spec: SpecConfiguration) {
   }

   fun prepareSpec(kclass: KClass<out SpecConfiguration>) {
   }

   fun finalizeSpec(kclass: KClass<out SpecConfiguration>, results: Map<TestCase, TestResult>) {
   }

   fun beforeTest(testCase: TestCase) {
   }

   @Deprecated("Use the spec DSL", ReplaceWith("endSpec { }"))
   fun afterSpecClass(spec: SpecClass, results: Map<TestCase, TestResult>) {
   }

   @Deprecated("Use the spec DSL", ReplaceWith("beforeSpec { }"))
   fun beforeSpec(description: Description, spec: SpecConfiguration) {
   }
}
