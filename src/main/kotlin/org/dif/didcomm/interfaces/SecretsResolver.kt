package org.dif.didcomm.interfaces

interface SecretsResolver {
    fun getKey(kid: String): String

    fun getKeys(did: String): Array<String>

    fun findKeys(kids: Array<String>): Array<String>
}