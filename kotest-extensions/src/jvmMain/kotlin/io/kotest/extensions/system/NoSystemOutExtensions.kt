package io.kotest.extensions.system

import io.kotest.core.spec.SpecConfiguration
import io.kotest.core.extensions.TestListener
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class SystemOutWriteException(val str: String?) : RuntimeException()
class SystemErrWriteException(val str: String?) : RuntimeException()

object NoSystemOutListener : TestListener {
   private fun setup() {
      val out = ByteArrayOutputStream()
      System.setOut(object : PrintStream(out) {
         private fun error(a: Any?): Nothing = throw SystemOutWriteException(a?.toString())
         override fun print(b: Boolean) = error(b)
         override fun print(c: Char) = error(c)
         override fun print(i: Int) = error(i)
         override fun print(l: Long) = error(l)
         override fun print(s: String) = error(s)
         override fun print(o: Any) = error(o)
         override fun print(c: CharArray) = error(c)
         override fun print(d: Double) = error(d)
         override fun print(f: Float) = error(f)
      })
   }

   override fun beforeSpec(spec: SpecConfiguration) = setup()
}

object NoSystemErrListener : TestListener {
   private fun setup() {
      val out = ByteArrayOutputStream()
      System.setErr(object : PrintStream(out) {
         private fun error(a: Any?): Nothing = throw SystemErrWriteException(a?.toString())
         override fun print(b: Boolean) = error(b)
         override fun print(c: Char) = error(c)
         override fun print(i: Int) = error(i)
         override fun print(l: Long) = error(l)
         override fun print(s: String) = error(s)
         override fun print(o: Any) = error(o)
         override fun print(c: CharArray) = error(c)
         override fun print(d: Double) = error(d)
         override fun print(f: Float) = error(f)
      })
   }

   override fun beforeSpec(spec: SpecConfiguration) = setup()
}
