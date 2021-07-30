package org.dif.didcomm.interfaces

interface DIDResolver {
    fun resolve(did: String): DIDDoc
}