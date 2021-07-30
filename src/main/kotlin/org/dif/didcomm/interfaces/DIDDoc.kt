package org.dif.didcomm.interfaces

interface DIDDocKeyAgreement {
    fun asJWK(): String
}

interface DIDDocAuthentication {
    fun asJWK(): String
}

interface DIDDocRoutingKey {
    fun asJWK(): String
}

interface DIDDoc {
    fun keyAgreement(): DIDDocKeyAgreement

    fun keyAgreements(): Array<DIDDocKeyAgreement>

    fun authentication(): DIDDocAuthentication

    fun authentications(): Array<DIDDocAuthentication>

    fun routingKeys(): Array<DIDDocRoutingKey>
}