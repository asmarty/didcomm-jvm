package org.dif.didcomm.types

enum class EncType {
    NO_ENC,
    AUTH,
    ANON,
    ANON_AUTH
}

class Metadata(
    val encFrom: String? = null,
    val encTo: List<String>? = null,
    val encType: EncType? = null,
    val singFrom: String? = null
)

class ParseResult(
    val message: Message,
    val metadata: Metadata,
    val signedPayload: String? = null
)

class ForwardParseResult(
    val forward: ParseResult,
    val payload: ParseResult,
)