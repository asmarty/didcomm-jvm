package org.dif.didcomm

import org.dif.didcomm.interfaces.DIDResolver
import org.dif.didcomm.interfaces.SecretsResolver
import org.dif.didcomm.types.*

class DIDComm(val didResolver: DIDResolver? = null, val secretsResolver: SecretsResolver? = null) {
    fun sign(msg: Message, from: String): String
        = throw NotImplementedError()

    fun anonCrypt(msg: Message, from: String, to: List<String>, anonEncAlg: AnonEncAlg): String
            = throw NotImplementedError()

    fun authCrypt(msg: Message, from: String, to: List<String>, authEncAlg: AuthEncAlg): String
            = throw NotImplementedError()

    fun anonAuthCrypt(msg: Message, from: String, to: List<String>, anonEncAlg: AnonEncAlg, authEncAlg: AuthEncAlg): String
            = throw NotImplementedError()

    fun authCryptSigned(msg: Message, from: String, fromSign: String, to: List<String>, authEncAlg: AuthEncAlg): String
            = throw NotImplementedError()

    fun anonAuthCryptSigned(msg: Message, from: String, fromSign: String, to: List<String>, anonEncAlg: AnonEncAlg, authEncAlg: AuthEncAlg): String
            = throw NotImplementedError()

    fun parse(message: String): ParseResult
            = throw NotImplementedError()

    fun forward(message: String, to: String, anonEncAlg: AnonEncAlg): String
            = throw NotImplementedError()

    fun parseForward(forwardMessage: String): ForwardParseResult
            = throw NotImplementedError()
}