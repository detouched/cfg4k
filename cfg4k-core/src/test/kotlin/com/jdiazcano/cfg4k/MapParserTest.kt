package com.jdiazcano.cfg4k

import com.jdiazcano.cfg4k.core.ListConfigObject
import com.jdiazcano.cfg4k.core.MapConfigObject
import com.jdiazcano.cfg4k.core.toConfig
import com.winterbe.expekt.should
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe

class MapParserTest : Spek({
    val mapTests = mapOf(
            mapOf("a" to 1) to MapConfigObject(mapOf("a" to 1.toConfig()))
    )
    val listTests = mapOf(
            listOf("a", "b") to ListConfigObject(listOf("a".toConfig(), "b".toConfig()))
    )
    describe("a map to be parsed") {
        mapTests.forEach { key, value ->
            val converted = key.toConfig()
            converted.should.be.equal(value)
        }
        listTests.forEach { key, value ->
            val converted = key.toConfig()
            converted.should.be.equal(value)
        }
    }
})